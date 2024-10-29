class lc_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for(int i = 0; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        lc_14 obj = new lc_14();
        String[] arr = {"Piyush", "piyu", "Priyanshu"};
        System.out.println(obj.longestCommonPrefix(arr));
    }
}


// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         Arrays.sort(strs);
//         String a = strs[0];
//         String b = strs[strs.length - 1];
//         int i = 0;
//         while(i<a.length() && i<b.length()){
//             if(a.charAt(i) == b.charAt(i)){
//                 i++;
//             }
//             else{
//                 break;
//             }
//         }
//         return a.substring(0,i);
//     }
// }
