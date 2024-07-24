package org.example.webscraper;

import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class scraperUtil {

    private static final Logger logger = LogManager.getLogger(scraperUtil.class);

    public static scraperResult scrape(String url, List<String> selectors) throws IOException{
        Document doc = Jsoup.connect(url).get();
        Map<String,List<String>> scrappedData = new HashMap<>();

        for (String selector : selectors){
            Elements elements = doc.select(selector);
            List<String> data = new ArrayList<>();
            elements.forEach(element -> data.add(element.text()));
            scrappedData.put(selector,data);
        }
        logger.info("Scraping Completed for url: "+url);
        return new scraperResult(url,scrappedData);
    }


}
