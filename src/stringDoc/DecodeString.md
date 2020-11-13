# [Most Common Word](https://leetcode.com/problems/most-common-word/)

<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
</p>

<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
</p>

## Solution 

Example

```java
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
```

- First we need to process input string in order to extract only lowercase words array
- Replace all the punctuation characters with space and transform the input string to lower case
- split the given string by spaces
- Now create a **HashSet** of badWords so that finding a given word is bad would take ~O(1).
- Now take a variable for **maxWordCount** = 0 and **maxWord** = null;

- Now iterate over the processed array.
  if word not in badWordHashSet:
        if word in present in wordMap we would increase the previous count by 1
        else 
            add word to wordMap and set its count to 1.

        check if current word count > maxWorkCount:
            maxWordCount = wordCount;
            maxWord = words[i]
- return maxWord;


```java

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

```


