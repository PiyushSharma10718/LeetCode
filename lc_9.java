class lc_9 {
    public boolean isPalindrome(int x) {
        int originalNumber = x;
        int reversedNum = 0;
        if(x == 0){
            return true;
        }
        while (x > 0) {
            int reminder = x % 10;
            reversedNum = reversedNum * 10 + reminder;
            x = x / 10;
            if (reversedNum == originalNumber) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        lc_9 obj = new lc_9();
        System.out.println(obj.isPalindrome(121));
    }
}
