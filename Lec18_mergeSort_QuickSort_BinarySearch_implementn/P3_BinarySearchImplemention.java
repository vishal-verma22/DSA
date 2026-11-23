
package Lec18_mergeSort_QuickSort_BinarySearch_implementn;

/*
============================================================
Problem Statement:
Write a Java program to search an element in a sorted array
using the Binary Search algorithm.

Main Logic:
1. Low ko 0 aur high ko arr.length - 1 initialize karna.
2. Low aur high ka use karke middle index find karna.
3. Middle element ko searchElement ke saath compare karna.
4. Agar dono equal hain toh element found hai.
5. Agar middle element chhota hai toh right half mein search karna.
6. Agar middle element bada hai toh left half mein search karna.
7. Jab tak element mil nahi jata ya low > high nahi hota,
   tab tak searching continue karna.

Data Structures:
1. Original Array:
   Sorted elements ko store karta hai jisme searching perform
   ki jati hai.

2. Variables:
   low  : Search range ka starting index.
   high : Search range ka ending index.
   mid  : Search range ka middle index.

Example Input:
arr = {10, 20, 30, 40, 50, 60, 70, 80, 90}
searchElement = 60

Example Output:
Element found at 5 index position

Time Complexity:
Best Case    : O(1)
Average Case : O(log n)
Worst Case   : O(log n)

Space Complexity: O(1)
============================================================
*/

public class P3_BinarySearchImplemention {

    //============================================================
    // Binary Search Method: Sorted array mein element search karna
    //============================================================
    static void binarySearch(int[] arr, int searchElement) {

        boolean isFound = false;

        // Search range ka starting index
        int low = 0;

        // Search range ka ending index
        int high = arr.length - 1;

        // Jab tak searching range valid hai
        while(low <= high) {

            // Middle index find karna
            int mid = low + (high - low) / 2;

            if(arr[mid] == searchElement) {

                // Element mil gaya toh uska index print karna
                System.out.println("Element found at " + mid + " index position");

                isFound = true;

                // Element milne ke baad loop stop karna
                break;
            }
            else if(arr[mid] < searchElement) {

                // Middle element chhota hai toh right half mein search karna
                low = mid + 1;
            }
            else {

                // Middle element bada hai toh left half mein search karna
                high = mid - 1;
            }
        }

        // Agar element nahi mila toh not found print karna
        if(!isFound) {
            System.out.println("Element not found");
        }
    }

    //============================================================
    // Main Method: Program execution yahan se start hota hai
    //============================================================
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        int searchElement = 60;

        // Binary Search method call karna
        binarySearch(arr, searchElement);
    }
}
