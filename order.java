import java.io.*;

class order {
    static int maxFreq(int []arr, int n) {

            // using moore's voting algorithm
            int res = 0;
            int count = 1;
            for(int i = 1; i < n; i++) {
                if(arr[i] == arr[res]) {
                    count++;
                } else {
                    count--;
                }
                if(count == 0) {
                    res = i;
                    count = 1;
                }
            }
            return arr[res];
        }

        // Driver code for the count
        public static void main (String[] args) {
            int menuItem[] = {4, 5, 3, 4, 5, 3, 3, 10, 10};
            int n = menuItem.length;
            int freq = maxFreq(menuItem, n);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (menuItem[i] == freq) {
                    count++;
                }
            }
            System.out.println("The most popular item is no. " + maxFreq(menuItem, n) +
                    ". Ordered a total of " + count + " times.");
    }
 }