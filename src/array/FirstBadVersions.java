public class FirstBadVersions extends VersionControl {

  public int firstBadVersion(int n) {
    // 1 is added since array indexing start from 0
    long start = 0;
    long end = n - 1;
    return (int) firstBadVersionBinarySearch(start, end);
  }

  private long firstBadVersionBinarySearch(long start, long end) {
    long mid = (start + end) / 2;

    System.out.println("Start: " + start + " End: " + end + " Mid: " + mid);

    if (isBad(mid)) {
      if (!isBad(mid - 1)) {
        return mid;
      } else {
        // Move to the left
        return firstBadVersionBinarySearch(start, mid - 1);
      }
    } else {
      if (isBad(mid + 1)) {
        return mid + 1;
      } else {
        // Move to the Right
        return firstBadVersionBinarySearch(mid + 1, end);
      }
    }
  }

  private boolean isBad(long version) {
    boolean result = isBadVersion((int) version);
    // System.out.println("Version : " + version + " is bad: " + result);
    return result;
  }
}
