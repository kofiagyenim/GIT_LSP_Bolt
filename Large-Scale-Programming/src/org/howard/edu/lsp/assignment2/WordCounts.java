package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounts {
	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new FileReader("src/org/howard/edu/lsp/assignment2/words.txt"))){
			String line;
			Map<String, Integer> wordCount = new HashMap<String, Integer>();
			while((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				
				for (String word:words) {
					word = word.replaceAll("[^a-zA-Z']", "").toLowerCase();
					
					if (word.length() >3) {
						wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
					}
				}
			}
			for(Map.Entry<String, Integer> entry:wordCount.entrySet()) {
				System.out.println(entry.getKey()+ " "+ entry.getValue());
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}