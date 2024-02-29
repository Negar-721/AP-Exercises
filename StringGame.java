import java.util.Scanner;

public class StringGame{

    public static int findCommonSubstrings(String str1, String str2){
        StringBuilder commonSubstrings = new StringBuilder();

        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                int similar = 0;
                while(i + similar < str1.length() && j + similar < str2.length() && str1.charAt(i + similar) == str2.charAt(j + similar)) {
                    similar++;
                }
                if(similar > 0 && similar > commonSubstrings.length()) {
                    commonSubstrings.setLength(0);
                    commonSubstrings.append(str1, i, i + similar);
                }
            }
        }
        int length = commonSubstrings.length();
        return length;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] strings = new String[n];
        for(int i = 0; i < n; i++){
            strings[i] = in.nextLine();
        }
        int min = 0, length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                    length = findCommonSubstrings(strings[i], strings[j]);
                    if(length > min){
                        min = length;
                    }
            }
        }
        System.out.println(min);
    }
}
