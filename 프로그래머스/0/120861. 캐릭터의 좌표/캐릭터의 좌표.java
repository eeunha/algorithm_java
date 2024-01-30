class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("left")) {
                if (isOutOfBounds(board, x, y, -1, 0)) {
                    continue;
                }
                
                x--;
            } else if (keyinput[i].equals("right")) {
                if (isOutOfBounds(board, x, y, 1, 0)) {
                    continue;
                }
                x++;
            } else if (keyinput[i].equals("up")) {
                if (isOutOfBounds(board, x, y, 0, 1)) {
                    continue;
                }
                y++;
            } else {
                if (isOutOfBounds(board, x, y, 0, -1)) {
                    continue;
                }
                y--;
            }   
        }
        
        return new int[]{x, y};
    }
    
    public boolean isOutOfBounds(int[] board, int x, int y, int dx, int dy) {
        if (dy == 0 && (x + dx) >= - (board[0] / 2) && (x + dx) <= board[0] / 2) {
            return false;
        } else if (dx == 0 && (y + dy) >= - (board[1] / 2) && (y + dy) <= board[1] / 2) {
            return false;
        }
        return true;
    }
}