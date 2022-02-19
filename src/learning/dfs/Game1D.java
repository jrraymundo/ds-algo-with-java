package learning.dfs;

import java.io.*;
import java.util.*;

// Site: https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true

public class Game1D {
    static int cases;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;

        cases = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < cases; caseNum++) {
            st = new StringTokenizer(br.readLine());
            int[] game = new int[Integer.parseInt(st.nextToken())];
            int leap = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < game.length; i++) {
                game[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(Arrays.toString(game));

            boolean result = canWin(leap, game);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        br.close();
    }

    public static boolean canWin(int leap, int[] game) {
        int startPos = 0;
        return find_path(leap, game, startPos);
    }

    public static boolean find_path(int leap, int[] game, int x) {
        if (x < 0) return false;
        if (x > game.length - 1) return true;
        if (game[x] != 0) return false;

        game[x] = 1;

        if (find_path(leap, game, x + 1)) return true;
        if (find_path(leap, game, x + leap)) return true;
        if (find_path(leap, game, x - 1)) return true;

        game[x] = 0;

        return false;
    }

    // Not working for all cases
    public static boolean traversal(int pos, int leap, int[] game) {
        if (pos + 1 > game.length - 1) return true;
        if (pos + leap > game.length - 1) return true;
        if (pos == game.length - 1 && game[pos] == 0) return true;

        if (game[pos + leap] == 0) {
            return traversal(pos + leap, leap, game);
        }
        else if (game[pos + 1] == 0) {
            return traversal(pos + 1, leap, game);
        }
        else if (pos > 0 && game[pos - 1] == 0) {
            game[pos] = 1;
            return traversal(pos - 1, leap, game);
        }
        else {
            return false;
        }
    }
}

/*
Case 1:
3
6 2
0 1 0 1 0 1
10 6
0 0 1 1 0 0 1 1 0 0
10 3
0 0 1 1 0 0 1 1 0 0

Output 1:
YES
NO
YES

Case 2:
4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0

Output 2:
YES
YES
NO
NO
*/
