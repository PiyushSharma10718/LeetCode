class lc_3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] charSet = new boolean[256];
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (charSet[ch]) {
                charSet[s.charAt(left)] = false;
                left++;
            }
            charSet[ch] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        lc_3 obj = new lc_3();
        int res = obj.lengthOfLongestSubstring("abcabcbb");
        System.out.println("The Longest Substring in Number is : " + res);
    }
}
