import java.util.*;

public class TotalFruit {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit to map
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if more than 2 types
            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            // Update max window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3, 2, 2, 1};
        int result = totalFruit(fruits);
        System.out.println("Maximum number of fruits you can collect: " + result);
    }
}
