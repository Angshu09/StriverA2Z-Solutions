package III_Arrays.II_Medium;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class V_BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(findBestProfitBrute(arr));
        System.out.println(findBestProfitOptimal(arr));
    }

    // Function to find the maximum profit from a single buy and sell operation
    // This is an optimal solution with O(n) time and O(1) space complexity
    private static int findBestProfitOptimal(int[] arr) {
        int n = arr.length;

        // If there's only one price, no profit can be made
        if (n == 1) return arr[0];

        // Initialize minPrice to the first element (buy price)
        int minPrice = arr[0];

        // Initialize maxProfit to 0 (no transaction has been made yet)
        int maxProfit = 0;

        // Traverse the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Update minPrice if a lower price is found
            minPrice = Math.min(minPrice, arr[i]);

            // Calculate profit if bought at minPrice and sold at current price
            int profit = arr[i] - minPrice;

            // Update maxProfit if this profit is higher than previous max
            maxProfit = Math.max(maxProfit, profit);
        }

        // Return the maximum profit found
        return maxProfit;
    }




    // Function to find the maximum profit that can be made by buying and selling stock
    // where you can only buy once and sell later.
    // It uses a brute-force inspired approach with auxiliary array to track future max values.
    private static int findBestProfitBrute(int[] arr) {
        int n = arr.length;

        // If there's only one price, no profit can be made
        if (n == 1) return arr[0];

        // Step 1: Create an auxiliary array where aux[i] will store the maximum price
        // from day i to the last day (i.e., max price in the future starting from i)
        int[] aux = new int[n];
        aux[n - 1] = arr[n - 1]; // Last element is same as original

        // Fill aux[] from right to left
        for (int i = n - 2; i >= 0; i--) {
            // For each day, store the max of today's price or the future max price
            aux[i] = Math.max(arr[i], aux[i + 1]);
        }

        // Step 2: Calculate maximum profit by checking difference between aux[i] (sell price)
        // and arr[i] (buy price at day i)
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            // Profit if we buy at arr[i] and sell at aux[i] (max future price)
            maxProfit = Math.max(maxProfit, aux[i] - arr[i]);
        }

        // Return the maximum profit found
        return maxProfit;
    }
}
