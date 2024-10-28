// class lc_13 {
//     public int romanToInt(String s) {
//         String[] Symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//         int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//         int res = 0;
//         int i = 0;
//         while (i < s.length()) {
//             boolean foundTwoCharSymbol = false;
//             for(int j = 0; j < Symbols.length; j++){
//                 String symbol = Symbols[j];
//                 int value = values[j];
//                 if(i + symbol.length() <= s.length() && s.substring(i, i+symbol.length()).equals(symbol)){
//                     res += value;
//                     i += symbol.length();
//                     foundTwoCharSymbol = true;
//                     break;
//                 }
//             }
//             if (!foundTwoCharSymbol) {
//                 i++;
//             }
//         }
//         return res;
//     }
//     public static void main(String[] args) {
//         lc_13 obj = new lc_13();
//         int res = obj.romanToInt("III");
//         System.out.println(res);
//     }
// }

class lc_13 {
    public int romanToInt(String s) {
        int answer = 0, number = 0, prev = 0;
        for(int i = s.length()-1; i >= 0; i--){
            switch(s.charAt(i)){
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if(number < prev) {
                answer -= number;
            }else{
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
    public static void main(String[] args) {
        lc_13 obj = new lc_13();
        int res = obj.romanToInt("VM");
        System.out.println(res);
    }
}
