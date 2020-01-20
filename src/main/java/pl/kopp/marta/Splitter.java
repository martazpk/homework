package pl.kopp.marta;

import java.util.*;

public class Splitter {

    public Map<Character, Set<String>> groupByLetter(String inputText) {
        if(inputText == null){
            throw new IllegalArgumentException();
        }
        Map<Character, Set<String>> result = new HashMap<>();
        String[] words = inputText.split(" ");
        for (String word : words) {
            String lower = word.toLowerCase();
            String onlyAlphanumeric = lower.replaceAll("[^a-z0-9]", "");
            addToMap(result, onlyAlphanumeric);
        }
        return result;
    }

    private void addToMap(Map<Character, Set<String>> map, String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (existsInKeySet(c, map.keySet())) {
                Set<String> strings = map.get(c);
                strings.add(word);
            } else {
                map.put(c, new TreeSet<>(Comparator.naturalOrder()));
                Set<String> strings = map.get(c);
                strings.add(word);
            }
        }
    }

    private boolean existsInKeySet(char c, Set<Character> set) {
        return set.contains(c);
    }
}
