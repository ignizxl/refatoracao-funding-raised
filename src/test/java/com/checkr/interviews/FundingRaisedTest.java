package com.checkr.interviews;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

/**
 * Unit test for simple App.
 */

public class FundingRaisedTest {

    /**
     * Rigourous Test :-)
     */
    private static final String CSV_FILE_PATH = "startup_funding.csv";

    @Test
    public void testWhereGivenCompany() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            assertEquals(fundingRaised.where(options).size(), 7);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testWhereGivenCity() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("city", "Tempe");
            assertEquals(fundingRaised.where(options).size(), 3);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testWhereGivenState() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("state", "CA");
            assertEquals(fundingRaised.where(options).size(), 873);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testWhereGivenRound() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("round", "a");
            assertEquals(fundingRaised.where(options).size(), 582);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testMultipleOptions() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("round", "a");
            options.put("company_name", "Facebook");
            assertEquals(fundingRaised.where(options).size(), 1);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testWhereNotExists() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "NotFacebook");
            assertEquals(fundingRaised.where(options).size(), 0);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testWhereCorrectKeys() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            Map<String, String> row = fundingRaised.where(options).get(0);

            assertEquals(row.get("permalink"), "facebook");
            assertEquals(row.get("company_name"), "Facebook");
            assertEquals(row.get("number_employees"), "450");
            assertEquals(row.get("category"), "web");
            assertEquals(row.get("city"), "Palo Alto");
            assertEquals(row.get("state"), "CA");
            assertEquals(row.get("funded_date"), "1-Sep-04");
            assertEquals(row.get("raised_amount"), "500000");
            assertEquals(row.get("round"), "angel");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testFindByGivenCompanyName() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            Map<String, String> row = fundingRaised.findBy(options);

            assertEquals(row.get("permalink"), "facebook");
            assertEquals(row.get("company_name"), "Facebook");
            assertEquals(row.get("number_employees"), "450");
            assertEquals(row.get("category"), "web");
            assertEquals(row.get("city"), "Palo Alto");
            assertEquals(row.get("state"), "CA");
            assertEquals(row.get("funded_date"), "1-Sep-04");
            assertEquals(row.get("raised_amount"), "500000");
            assertEquals(row.get("round"), "angel");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testFindByGivenState() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("state", "CA");
            Map<String, String> row = fundingRaised.findBy(options);

            assertEquals(row.get("permalink"), "digg");
            assertEquals(row.get("company_name"), "Digg");
            assertEquals(row.get("number_employees"), "60");
            assertEquals(row.get("category"), "web");
            assertEquals(row.get("city"), "San Francisco");
            assertEquals(row.get("state"), "CA");
            assertEquals(row.get("funded_date"), "1-Dec-06");
            assertEquals(row.get("raised_amount"), "8500000");
            assertEquals(row.get("round"), "b");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testFindByMultipleOptions() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "c");
            Map<String, String> row = fundingRaised.findBy(options);

            assertEquals(row.get("permalink"), "facebook");
            assertEquals(row.get("company_name"), "Facebook");
            assertEquals(row.get("number_employees"), "450");
            assertEquals(row.get("category"), "web");
            assertEquals(row.get("city"), "Palo Alto");
            assertEquals(row.get("state"), "CA");
            assertEquals(row.get("funded_date"), "1-Oct-07");
            assertEquals(row.get("raised_amount"), "300000000");
            assertEquals(row.get("round"), "c");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    @Test
    public void testFindByNotExists() {
        try {
            FundingRaised fundingRaised = new FundingRaised(CSV_FILE_PATH);
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "NotFacebook");
            options.put("round", "c");
            Map<String, String> row = fundingRaised.findBy(options);
            fail("findBy should throw exception");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            // Exception esperada
        }
    }
}
