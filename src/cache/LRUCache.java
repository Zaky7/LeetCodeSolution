package cache;

import java.util.*;

class CacheValue {
  private int lookupNumber;
  private int value;

  CacheValue(int value, int lookupNumber) {
    this.lookupNumber = lookupNumber;
    this.value = value;
  }

  public int getLookupNumber() {
    return this.lookupNumber;
  }

  public int getValue() {
    return this.value;
  }
}

class LookUpNumberMap {
  private SortedMap<Integer, Integer> lookUpNumberMap;

  LookUpNumberMap() {
    lookUpNumberMap = new TreeMap<>();
  }

  public void update(int oldKey, int newKey) {
    Integer oldValue = lookUpNumberMap.remove(oldKey);
    lookUpNumberMap.put(newKey, oldValue);
  }

  public void add(int key, int value) {
    lookUpNumberMap.put(key, value);
  }

  public Integer removeLeastUsedKey() {
    Integer leastUsedKey = lookUpNumberMap.firstKey();
    return lookUpNumberMap.remove(leastUsedKey);
  }
}

class KeyValueMap {
  private Map<Integer, CacheValue> keyValueMap;

  KeyValueMap(int capacity) {
    keyValueMap = new HashMap<>(capacity);
  }

  public void update(int key, int value, int lookupNumber) {
    CacheValue newCacheValue = new CacheValue(value, lookupNumber);
    keyValueMap.replace(key, newCacheValue);
  }

  public void add(int key, int value, int lookupNumber) {
    CacheValue newCacheValue = new CacheValue(value, lookupNumber);
    keyValueMap.put(key, newCacheValue);
  }

  public CacheValue remove(int key) {
    return keyValueMap.remove(key);
  }

  public CacheValue get(int key) {
    return keyValueMap.get(key);
  }

  public int size() {
    return keyValueMap.size();
  }

  public boolean contains(int key) {
    return keyValueMap.containsKey(key);
  }
}

public class LRUCache {
  private int capacity;
  private int lookUpNumber;
  private KeyValueMap keyValueMap;
  private LookUpNumberMap lookUpNumberMap;

  LRUCache(int capacity) {
    this.capacity = capacity;
    this.lookUpNumber = 0;
    keyValueMap = new KeyValueMap(this.capacity);
    lookUpNumberMap = new LookUpNumberMap();
  }

  private int getCurrentLookupNumber() {
    return this.lookUpNumber;
  }

  private void incrementLookupNumberByOne() {
    ++this.lookUpNumber;
  }

  public int get(int key) {
    CacheValue cacheValue = keyValueMap.get(key);

    // If key not found return -1;
    if (cacheValue == null) {
      return -1;
    }

    incrementLookupNumberByOne();
    Integer oldValue = cacheValue.getValue();
    updateInLRUCache(cacheValue, key, oldValue);
    return oldValue;
  }

  public void put(int newKey, int newValue) {
    // Update the lookupCount
    incrementLookupNumberByOne();

    // If key present in Cache update else add
    CacheValue cacheValue = keyValueMap.get(newKey);
    if (cacheValue != null) {
      updateInLRUCache(cacheValue, newKey, newValue);
    } else {
      // Map is full then remove least used Entry
      if (keyValueMap.size() == this.capacity) {
        removeFromLRUCache();
      }

      // Add the value in LRU Cache
      addInLRUCache(newKey, newValue);
    }
  }

  private void addInLRUCache(int newKey, int newValue) {
    lookUpNumberMap.add(getCurrentLookupNumber(), newKey);
    keyValueMap.add(newKey, newValue, getCurrentLookupNumber());
  }

  private void removeFromLRUCache() {
    Integer leastUsedKey = lookUpNumberMap.removeLeastUsedKey();
    keyValueMap.remove(leastUsedKey);
  }

  public void updateInLRUCache(CacheValue cacheValue, int key, int value) {
    // Update value in both maps
    Integer previousLookUpNumber = cacheValue.getLookupNumber();
    lookUpNumberMap.update(previousLookUpNumber, getCurrentLookupNumber());
    keyValueMap.update(key, value, getCurrentLookupNumber());
  }
}
