import java.util.Arrays;
import java.util.Scanner;

public class Soduko {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] chart = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                chart[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                for(int k = 0; k < 9; k++){
                    if(chart[i][j] == chart[i][k] && j != k){
                        System.out.println("false");
                        return;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 0; i++){
                for(int k = 0; k < 9; k++){
                    if(chart[k][j] == chart[i][j] && i != k){
                        System.out.println("false");
                        return;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        int[][][] blocks = new int[9][3][3];
        for(int block = 0; block < 9; block++){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                    blocks[block][i][j] = chart[(block / 3) * 3 + i][(block % 3) * 3 + j];
                }
            }
        }

        for(int block = 0; block < 9; block++){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        for(int l = 0; l < 3; l++){
                            if(k != i || l != j){
                                if(blocks[block][i][j] == blocks[block][k][l]){
                                    System.out.println("false");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("true");
    }
}
