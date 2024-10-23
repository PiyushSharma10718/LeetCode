class lc_8 {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i = 0, num = 0, sign = 1;
        int len = s.length();
        while (i<len && s.charAt(i) == ' ') {
            i++;
        }
        if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1: 1;
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if(num > (Integer.MAX_VALUE - digit)/10){
                return (sign ==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            num = num*10 + digit;
            i++;
        }
        return num*sign;
    }

    public static void main(String[] args) {
        lc_8 obj = new lc_8();
        int res = obj.myAtoi("     -042");
        System.out.println(res);
    }
}
