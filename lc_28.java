class lc_28 {
    public int divide(int dividend, int divisor) {
        // Edge case: if divisor is 1 or -1
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // overflow case
            return -dividend;
        }

        // Use absolute values for easier handling
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        // Perform bitwise division
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            int multiple = 1;
            // Double the divisor value until it exceeds the dividend
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            // Subtract the largest found multiple from dividend
            absDividend -= temp;
            result += multiple;
        }

        // Determine if the result should be positive or negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        lc_28 solution = new lc_28();
        System.out.println(solution.divide(10, 3));  // Output: 3
        System.out.println(solution.divide(7, -3));  // Output: -2
        System.out.println(solution.divide(-2147483648, -1)); // Output: 2147483647 (Integer.MAX_VALUE due to overflow)
    }
}

/*

class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;  // Handle overflow case
        } else {
            int c = dividend / divisor;
            return c;
        }
    }
}

*/
