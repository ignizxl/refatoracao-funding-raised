package com.checkr.interviews;

import java.util.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FundingRaised {
    private CSVDataLoader dataLoader;
    private FundingFilter filter;
    private FundingMapper mapper;

    public FundingRaised(String csvFilePath) {
        this.dataLoader = new CSVDataLoader(csvFilePath);
        this.filter = new FundingFilter();
        this.mapper = new FundingMapper();
    }

    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = dataLoader.loadCSV();
        List<String[]> filteredData = filter.filter(csvData, options);
        return mapper.mapToOutputFormat(filteredData);
    }

    public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<Map<String, String>> results = where(options);
        if (results.isEmpty()) {
            throw new NoSuchEntryException();
        }
        return results.get(0);
    }

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            FundingRaised fundingRaised = new FundingRaised("startup_funding.csv");
            System.out.print(fundingRaised.where(options).size());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

class NoSuchEntryException extends Exception {
}
