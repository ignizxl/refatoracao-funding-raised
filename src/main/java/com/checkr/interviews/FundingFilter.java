package com.checkr.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FundingFilter {
  public List<String[]> filter(List<String[]> csvData, Map<String, String> options) {
    if (options.containsKey("company_name")) {
      csvData = filterByCompanyName(csvData, options.get("company_name"));
    }
    if (options.containsKey("city")) {
      csvData = filterByCity(csvData, options.get("city"));
    }
    if (options.containsKey("state")) {
      csvData = filterByState(csvData, options.get("state"));
    }
    if (options.containsKey("round")) {
      csvData = filterByRound(csvData, options.get("round"));
    }
    return csvData;
  }

  private List<String[]> filterByCompanyName(List<String[]> csvData, String companyName) {
    List<String[]> results = new ArrayList<>();
    for (String[] row : csvData) {
      if (row[1].equals(companyName)) {
        results.add(row);
      }
    }
    return results;
  }

  private List<String[]> filterByCity(List<String[]> csvData, String city) {
    List<String[]> results = new ArrayList<>();
    for (String[] row : csvData) {
      if (row[4].equals(city)) {
        results.add(row);
      }
    }
    return results;
  }

  private List<String[]> filterByState(List<String[]> csvData, String state) {
    List<String[]> results = new ArrayList<>();
    for (String[] row : csvData) {
      if (row[5].equals(state)) {
        results.add(row);
      }
    }
    return results;
  }

  private List<String[]> filterByRound(List<String[]> csvData, String round) {
    List<String[]> results = new ArrayList<>();
    for (String[] row : csvData) {
      if (row[9].equals(round)) {
        results.add(row);
      }
    }
    return results;
  }
}
