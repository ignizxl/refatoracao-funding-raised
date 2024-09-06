package com.checkr.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundingMapper {
  public List<Map<String, String>> mapToOutputFormat(List<String[]> csvData) {
    List<Map<String, String>> output = new ArrayList<>();
    for (String[] row : csvData) {
      Map<String, String> mapped = new HashMap<>();
      mapped.put("permalink", row[0]);
      mapped.put("company_name", row[1]);
      mapped.put("number_employees", row[2]);
      mapped.put("category", row[3]);
      mapped.put("city", row[4]);
      mapped.put("state", row[5]);
      mapped.put("funded_date", row[6]);
      mapped.put("raised_amount", row[7]);
      mapped.put("raised_currency", row[8]);
      mapped.put("round", row[9]);
      output.add(mapped);
    }
    return output;
  }
}
