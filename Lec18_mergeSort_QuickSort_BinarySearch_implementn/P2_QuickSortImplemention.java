
package Lec18_mergeSort_QuickSort_BinarySearch_implementn;

/*
============================================================
Problem Statement:
Write a Java program to sort an array in ascending order
using the Quick Sort algorithm.

Main Logic:
1. Last element ko pivot element select karna.
2. Partition method ka use karke pivot ko uski correct position
   par place karna.
3. Pivot se smaller ya equal elements ko left side mein rakhna.
4. Pivot se greater elements ko right side mein rakhna.
5. Recursion ka use karke left subarray ko sort karna.
6. Recursion ka use karke right subarray ko sort karna.

Data Structures:
1. Original Array:
   Original elements ko store karta hai aur isi array mein
   swapping karke sorting perform hoti hai.

2. Pivot:
   Pivot ek selected element hota hai jiske basis par array
   ko two parts mein divide kiya jata hai.

Example Input:
arr = {100, 70, 80, 10, 90, 20, 60, 50}

Example Output:
10 20 50 60 70 80 90 100

Time Complexity:
Best Case    : O(n log n)
Average Case : O(n log n)
Worst Case   : O(n^2)

Space Complexity:
Average Case : O(log n)
Worst Case   : O(n)
============================================================
*/

public class P2_QuickSortImplemention {

    //============================================================
    // Quick Sort Method: Array ko recursively sort karne ke liye
    //============================================================
    static void quickSort(int[] arr, int low, int high) {

        // Base Condition: Jab subarray mein zero ya one element ho
        if(low >= high) {
            return;
        }

        // Partition method se pivot ki correct position find karna
        int pivotIndex = partition(arr, low, high);

        // Pivot ke left subarray ko recursively sort karna
        quickSort(arr, low, pivotIndex - 1);

        // Pivot ke right subarray ko recursively sort karna
        quickSort(arr, pivotIndex + 1, high);
    }

    //============================================================
    // Partition Method: Pivot ko uski correct position par rakhna
    // Time Complexity: O(n)
    //============================================================
    static int partition(int[] arr, int low, int high) {

        // Last element ko pivot select karna
        int pivotElement = arr[high];

        // Next smaller element ki position track karna
        int pivotIndex = low;

        // Low se high-1 tak elements ko check karna
        for(int i = low; i < high; i++) {

            if(arr[i] <= pivotElement) {

                // Smaller ya equal element ko left side mein place karna
                swap(arr, i, pivotIndex);

                // Next smaller element ke liye index increase karna
                pivotIndex++;
            }
        }

        // Pivot ko uski correct position par place karna
        swap(arr, pivotIndex, high);

        // Pivot ka correct index return karna
        return pivotIndex;
    }

    //============================================================
    // Swap Method: Array ke two elements ki positions exchange karna
    //============================================================
    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }

    //============================================================
    // Main Method: Program execution yahan se start hota hai
    //============================================================
    public static void main(String[] args) {

        int[] arr = {100, 70, 80, 10, 90, 20, 60, 50};

        // Quick Sort method call karna
        quickSort(arr, 0, arr.length - 1);

        // Sorted array ke elements print karna
        for(int no : arr) {
            System.out.print(no + " ");
        }
    }
}
