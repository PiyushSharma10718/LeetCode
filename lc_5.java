class lc_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        // Main loop to check all possible centers
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome (centered at i)
            int len1 = 0, left1 = i, right1 = i;
            while (left1 >= 0 && right1 < s.length() && s.charAt(left1) == s.charAt(right1)) {
                len1 = right1 - left1 + 1;
                left1--;
                right1++;
            }

            // Even-length palindrome (center between i and i+1)
            int len2 = 0, left2 = i, right2 = i + 1;
            while (left2 >= 0 && right2 < s.length() && s.charAt(left2) == s.charAt(right2)) {
                len2 = right2 - left2 + 1;
                left2--;
                right2++;
            }

            // Find the maximum length and update start and end indices
            int len = Math.max(len1, len2);
            if (len > end - start) {
                if (len == len1) {
                    start = left1 + 1;
                    end = right1 - 1;
                } else {
                    start = left2 + 1;
                    end = right2 - 1;
                }
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        lc_5 obj = new lc_5();
        String res = obj.longestPalindrome("abcsbsa");
        System.out.println(res);
    }
}
