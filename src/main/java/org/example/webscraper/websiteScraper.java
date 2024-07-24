package org.example.webscraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Future implementation
 * Additonal implementaion would be wrapping this project into cli
 * just showing the cli to enter the details and creating a log file or running the program in their own system.
 */
public class websiteScraper {

    private static final Scanner scanner = new Scanner(System.in);
    private static scraperResult lastResult;

    public static void main(String[] args){
        while (true){
            printmenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    scrapeWebsite();
                    break;
                case 2:
                    analyzeScrapedData();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Pleas try again.");
            }
        }
    }

    private static void printmenu() {

        System.out.println("\n---- WebSite Scrapper Menu----");
        System.out.println("1. Scrape the Website");
        System.out.println("2. Analyze scrapped data");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void scrapeWebsite() {

        System.out.println("Enter the URL to scrape: ");
        String url = scanner.nextLine();

        List<String> selectors = new ArrayList<>();
        while (true){
            System.out.println("Enter a CSS/HTML selector (or press enter to finish): ");
            String selector = scanner.nextLine();
            if (selector.isEmpty()) break;
            selectors.add(selector);
        }

        try{
            lastResult = scraperUtil.scrape(url,selectors);
            System.out.println("Scrapping completd. Results: ");
            System.out.println(lastResult);

        } catch (IOException e) {
            System.err.println("Error Scraping website: "+e.getMessage());
        }

    }

    private static void analyzeScrapedData() {

        if (lastResult==null){
            System.out.println("No data avialbe. please scrape a website first");
            return;
        }
        System.out.println("Enter the selector to analyze: ");
        String selector = scanner.nextLine();

        List<String> dataToAnalyze = lastResult.getScrappedData().get(selector);
        if (dataToAnalyze == null){
            System.out.println("No data found for the given selector");
            return;
        }

        Map<String,Integer> wordcounts = analysisUtil.wordCount(dataToAnalyze);
        System.out.println("WordCount analysis: ");
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


}
