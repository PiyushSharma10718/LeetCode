class lc_36 {
    public boolean isValidSudoku(char[][] board) {
        // Boolean arrays to track digits (1-9) for rows, columns, and sub-grids
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        // Loop through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                // Ignore empty cells
                if (current == '.') continue;

                int num = current - '1'; // Convert character '1'-'9' to index 0-8
                int gridIndex = (i / 3) * 3 + (j / 3); // Calculate the sub-grid index

                // Check if the number is already used in the row, column, or grid
                if (rows[i][num] || cols[j][num] || grids[gridIndex][num]) {
                    return false;
                }

                // Mark the number as seen
                rows[i][num] = true;
                cols[j][num] = true;
                grids[gridIndex][num] = true;
            }
        }
        return true; // No conflicts found
    }

    public static void main(String[] args) {
        lc_36 solution = new lc_36();

        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board1)); // Output: true

        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board2)); // Output: false
    }
}




// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         //length is 13 because of '.'=46 and '9'=58
//         boolean[] visited = new boolean[13];

//         //1st part 
//         for(int i=0;i<9;i++){
//             for(int j=0;j<9;j++){
//                 if(visited[board[i][j]-46]){
//                     return false;
//                 }else if(board[i][j]!='.'){
//                     visited[board[i][j]-46]=true;
//                 }
//             }
//             visited = new boolean[13];
//         }

//         //2nd part
//         for(int i=0;i<9;i++){
//             for(int j=0;j<9;j++){
//                 if(visited[board[j][i]-46]){
//                     return false;
//                 }else if(board[j][i]!='.'){
//                     visited[board[j][i]-46]=true;
//                 }
//             }
//             visited = new boolean[13];
//         }

//         //3rd part
//         int m=0,n=0;
//         while(true){
//             for(int i=0;i<3;i++){
//                 for(int j=0;j<3;j++){
//                     if(visited[board[m+i][n+j]-46]){
//                         return false;
//                     }else if(board[m+i][n+j]!='.'){
//                         visited[board[m+i][n+j]-46]=true;
//                     }
//                 }
//             }
//             if(n==6 && m==6) break;

//             if(m==6){
//                 n+=3;
//                 m=0;
//             }else{
//                 m+=3;
//             }
//             visited = new boolean[13];
//         }
//         return true;
//     }
// }