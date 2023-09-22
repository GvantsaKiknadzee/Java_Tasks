import java.util.HashSet;

public class Tasks {
    public static void main(String[] args) {
        singleNumber(new int[]{1, 2, 3, 4, 2, 3, 4});
        minSplit(141);
        notContains(new int[]{5, 4, 3, 2, 1});
        sumBinaryString("111", "101");
        System.out.println(countVariants(4));
    }


    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int minSplit(int amount) {
        if (amount < 0) throw new IllegalArgumentException();
        int count = 0;
        int[] nums = {50, 20, 10, 5, 1};
        for (int i : nums) {
            if (amount >= i)
                count += amount / i;
            amount %= i;
        }
        return count;
    }


    public static int notContains(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            if (num > 0) {
                set.add(num);
            }
        }
        int min = 1;
        while (set.contains(min)) {
            min++;
        }
        return min;
    }


    public static String sumBinaryString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) == '1' ? 1 : 0;
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) == '1' ? 1 : 0;
                j--;
            }

            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }

    public static int countVariants(int stairsCount) {
        if (stairsCount <= 1) {
            return 1;
        }
        int[] ways = new int[stairsCount + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= stairsCount; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[stairsCount];
    }

}









