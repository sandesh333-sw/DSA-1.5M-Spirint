import java.util.*;

public class BalancedString {

    public static int balancedStr(String str){
        int n = str.length();
        int target = n / 4;

        int[] freq = new int[26];
        for(char c: str.toCharArray()){
            freq[c - 'A']++;
        }

        if(freq['Q'-'A'] == target && freq['W'-'A'] == target && freq['E'-'A'] == target && freq['R'-'A'] == target){
            return 0;
        }

        int left = 0;
        int minLen = n;

        for(int right=0; right<n; right++){
            freq[str.charAt(right)-'A']--;

            while(freq['Q'-'A'] <= target && freq['W'-'A'] <= target && freq['E'-'A'] <= target && freq['R'-'A'] <= target){
                minLen = Math.min(minLen, right - left  +1);
                freq[str.charAt(left)-'A']++;
                left++;
            }
        }
        return minLen;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a capital string");
        String str = sc.nextLine();

        int result = balancedStr(str);
        System.out.println("The number of minimum balanced strings is :" + result);
    }
}
