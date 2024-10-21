class lc_6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown = false;
        for (char ch : s.toCharArray()) {
            rows[currRow].append(ch);
            if (currRow == 0) {
                goingDown = true;
            } else if (currRow == numRows - 1) {
                goingDown = false;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        lc_6 obj = new lc_6();
        String res = obj.convert("Piyush", 2);
        System.out.println(res);
    }
}
