class NimGame {
    final int DP_SIZE = 4;
    public boolean canWinNim(int n) {
        return n % DP_SIZE == 0 ? false : true;
    }    
}