package org.example.webscraper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class analysisUtil {

    public  static Map<String,Integer> wordCount(List<String> texts){

        Map<String,Integer> wordcount = new HashMap<>();
        for (String text:texts){
            String[] words = text.toLowerCase().split("\\s+");
            for (String word:words){
                wordcount.put(word,wordcount.getOrDefault(word,0)+1);
            }
        }
        return wordcount;
    }
}
