package org.example.webscraper;

import java.util.List;
import java.util.Map;

public class scraperResult {

    private String url;
    private Map<String, List<String>> scrappedData;

    public scraperResult(String url,Map<String,List<String>> scrappedData){
        this.url = url;
        this.scrappedData =scrappedData;
    }
    //getters
    public String getUrl() {
        return url;
    }

    //here return type is map
    public Map<String , List<String>> getScrappedData(){
        return scrappedData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScrapperResult for ").append(url).append(":\n");

        for (Map.Entry<String,List<String>> entry : scrappedData.entrySet()){
            sb.append("Selector: ").append(entry.getKey()).append("\n");
            sb.append("Data: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
