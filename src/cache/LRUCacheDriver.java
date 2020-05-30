package cache;

import util.Util;

public class LRUCacheDriver {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);

    /*
        ["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        * */
    Util.println(cache.get(2));
    cache.put(2, 6);
    Util.println(cache.get(1));
    cache.put(1, 5);
    cache.put(1, 2);

    Util.println(cache.get(1));

    Util.println(cache.get(2));
  }
}
