package string;

import java.util.HashMap;
import java.util.Map;

class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        // Create array of words
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        int maxFreq = 0;
        String mostFrequentWord = null;

        Map<String, Integer> bannedWordMap = new HashMap<>();
        for(int i=0; i<banned.length; i++) {
            bannedWordMap.put(banned[i], 1);
        }


        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {

            if(!bannedWordMap.containsKey(words[i])) {
                int wordFreq  = 1 + wordFreqMap.getOrDefault(words[i], 0);

                if(wordFreq > maxFreq) {
                    mostFrequentWord = words[i];
                    maxFreq = wordFreq;
                }
                wordFreqMap.put(words[i], wordFreq);
            }

        }
        return mostFrequentWord;
    }

    public static void main(String[] args) {
        String paragraph = "My tea's gone cold I'm wondering why I. got out of bed at all The morning rain clouds up my window and I can't see at all And even if I could it'd all be gray put your picture on my wall It reminds me, that it's not so bad it's not so bad. My tea's gone cold I'm wondering why I. got out of bed at all The morning rain clouds up my window. and I can't see at all And even if I could it'd all be gray put your picture on my wall It reminds me, that it's not so bad";
        MostCommonWord mcw = new MostCommonWord();
        String[] bannedWord = {"hit", "i"};
        String commonGoodWord = mcw.mostCommonWord(paragraph, bannedWord);
        System.out.println(commonGoodWord);
    }
}