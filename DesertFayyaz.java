import java.util.Scanner;

public class DesertFayyaz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        String[][] map = new String[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
                if (map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        String moves = scanner.nextLine();
        int x = start[0];
        int y = start[1];

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            int[] nextMove = getNextMove(x, y, move, map, n, m);
            x = nextMove[0];
            y = nextMove[1];

            if (Character.isDigit(map[x][y].charAt(0))) {
                int preX = x;
                int preY = y;
                int[] portalDestination = findPortalDestination(map, n, m, map[x][y], x, y);
                if(i != moves.length() - 1){
                    x = portalDestination[0];
                    y = portalDestination[1];
                    if(i < moves.length() - 1){
                        if(portalMove(x, y, moves.charAt(i+1), map)){
                            x = preX;
                            y = preY;
                            i = i + 1;
                        }
                    }
                }

            }
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
    private static boolean portalMove(int x, int y, char move, String[][] map){
        int newX = x;
        int newY = y;

        switch (move) {
            case 'D': newX = x + 1; break;
            case 'R': newY = y + 1; break;
            case 'L': newY = y - 1; break;
            case 'U': newX = x - 1; break;
        }
        if(map[newX][newY].equals("#")){
            return true;
        }
        return false;
    }
    private static int[] getNextMove(int x, int y, char move, String[][] map, int n, int m) {
        int newX = x, newY = y;

        switch (move) {
            case 'D': newX = x + 1; break;
            case 'R': newY = y + 1; break;
            case 'L': newY = y - 1; break;
            case 'U': newX = x - 1; break;
        }

        if (newX >= 0 && newX < n && newY >= 0 && newY < m && !map[newX][newY].equals("#")) {
            return new int[]{newX, newY};
        }

        return new int[]{x, y};
    }
    private static int[] findPortalDestination(String[][] map, int n, int m, String portalValue, int excludeX, int excludeY) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals(portalValue) && (i != excludeX || j != excludeY)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{excludeX, excludeY};
    }
}