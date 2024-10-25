class lc_10 {
    public boolean isMatch(String s, String p) {
        int strLen = s.length();
        int patLen = p.length();

        boolean[][] dp = new boolean[strLen + 1][patLen + 1];

        dp[0][0] = true;

        for(int i = 1; i <= patLen; i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i = 1; i <= strLen; i++){
            for(int j = 1; j <= patLen; j++){
                char currCharS = s.charAt(i - 1);
                char currCharP = p.charAt(j - 1);

                if(currCharP == '.' || currCharP == currCharS){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else if(currCharP == '*'){
                    char precedingCharP = p.charAt(j - 2);
                    dp[i][j] = dp[i][j-2];
                    if(precedingCharP == '.' || precedingCharP == currCharS){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }                
            }
        }
        return dp[strLen][patLen];
    }
    public static void main(String[] args) {
        lc_10 obj = new lc_10();
        System.out.println(obj.isMatch("aa", "a."));
    }
}
