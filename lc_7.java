class lc_7 {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        int reversedNum = 0;
        int originalNum = x;
        while (originalNum != 0) {
            int lastDigit = originalNum % 10;
            originalNum /= 10;

            if (reversedNum > Integer.MAX_VALUE / 10 || (reversedNum == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0; // Overflow case
            }
            if (reversedNum < Integer.MIN_VALUE / 10 || (reversedNum == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0; // Underflow case
            }

            reversedNum = reversedNum * 10 + lastDigit;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        lc_7 obj = new lc_7();
        int ans = obj.reverse(9000);
        System.out.println(ans);
    }
}
