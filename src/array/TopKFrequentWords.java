package array;

import java.util.*;


public class TopKFrequentWords {

    public static HashMap<String, Integer> sortByValueAndName(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                int valueCompareDesc = m2.getValue().compareTo(m1.getValue());
                int nameCompareAsc = m1.getKey().compareTo(m2.getKey());

                // If value is same
                if(valueCompareDesc == 0) {
                    // Check if nameCompare is also 0 then both enteries are identical
                    return (nameCompareAsc == 0) ? valueCompareDesc : nameCompareAsc;
                } else {
                    return valueCompareDesc;
                }
            }
        });

        // Create a new Map
        HashMap<String, Integer> tempMap = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> m: list) {
            tempMap.put(m.getKey(), m.getValue());
        }

        return tempMap;
    }

    public HashMap<String, Integer> createFrequencyMap(String[] list) {
        HashMap<String, Integer> hm = new HashMap<>();

        for(String strKey: list) {
            if(!hm.containsKey(strKey)) {
                hm.put(strKey, 1);
            } else {
                int oldFrequency = hm.get(strKey);
                hm.replace(strKey, oldFrequency, oldFrequency + 1);
            }
        }

        return hm;
    }

    public static void printMap(String msg, HashMap<String, Integer> hm) {
        System.out.println(msg);
        for(Map.Entry<String, Integer> en : hm.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordFreqHashMap = createFrequencyMap(words);
        List<String> mostFrequentKWords = new ArrayList<>();
        HashMap<String, Integer> sortedHashMap = sortByValueAndName(wordFreqHashMap);

        // print the Initial hash Map
        printMap("Initial Hash Map", wordFreqHashMap);

        // print the sorted Hash map
        printMap("Sorted Hash Map", sortedHashMap);

        int count = 0;
        for (Map.Entry<String, Integer> en : sortedHashMap.entrySet()) {
            if(count < k) {
                mostFrequentKWords.add(en.getKey());
            } else {
                break;
            }
            count++;
        }

        return mostFrequentKWords;
    }

    public static void main(String[] args) {
        String[] list = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> words = new TopKFrequentWords().topKFrequent(list, k);
        System.out.println(words);
    }
}