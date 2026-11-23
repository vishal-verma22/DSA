
package Lec18_mergeSort_QuickSort_BinarySearch_implementn;

/*
============================================================
Problem Statement:
Write a Java program to sort an array in ascending order
using the Merge Sort algorithm.

Main Logic:
1. Find the middle index of the array using mid.
2. Divide the array into two halves.
3. Recursively divide the left half until single elements remain.
4. Recursively divide the right half until single elements remain.
5. Merge both sorted halves by comparing their elements.
6. Store sorted elements in a temporary array.
7. Copy the sorted elements back into the original array.

Data Structures:
1. Original Array:
   Original array mein saare input elements store hote hain.
   Is array ko divide aur sort kiya jata hai.

2. Temporary Array:
   Merging ke time sorted elements ko temporarily store karta hai.
   Baad mein elements original array mein copy kar diye jate hain.

Example Input:
arr = {32, 25, 48, 5, 12, 65, 18}

Example Output:
5 12 18 25 32 48 65

Time Complexity:
Best Case    : O(n log n)
Average Case : O(n log n)
Worst Case   : O(n log n)

Space Complexity: O(n)
============================================================
*/

public class P1_MergeSortImplemention {

    //============================================================
    // Merge Sort Method: Array ko two halves mein divide karne ke liye
    //============================================================
    static void mergeSort(int[] arr, int low, int high) {

        // Base Condition: Jab subarray mein zero ya one element ho
        if(low >= high) {
            return;
        }

        // Array ka middle index find karna
        int mid = (high + low) / 2;

        // Left half ko recursively divide aur sort karna
        mergeSort(arr, low, mid);

        // Right half ko recursively divide aur sort karna
        mergeSort(arr, mid + 1, high);

        // Dono sorted halves ko merge karna
        merge(arr, low, mid, high);
    }

    //============================================================
    // Merge Method: Dono sorted subarrays ko merge karne ke liye
    // Time Complexity: O(n)
    //============================================================
    static void merge(int[] arr, int low, int mid, int high) {

        // Sorted elements store karne ke liye temporary array
        int[] temp = new int[high - low + 1];

        // Left subarray ka starting index
        int i = low;

        // Right subarray ka starting index
        int j = mid + 1;

        // Temporary array ka starting index
        int ti = 0;

        // Dono halves ke elements compare karna
        while(i <= mid && j <= high) {

            if(arr[i] <= arr[j]) {

                // Left element chhota ya equal hai toh copy karo
                temp[ti] = arr[i];
                i++;
            }
            else {

                // Right element chhota hai toh copy karo
                temp[ti] = arr[j];
                j++;
            }

            ti++;
        }

        // Left subarray ke remaining elements copy karna
        while(i <= mid) {
            temp[ti] = arr[i];
            ti++;
            i++;
        }

        // Right subarray ke remaining elements copy karna
        while(j <= high) {
            temp[ti] = arr[j];
            ti++;
            j++;
        }

        // Sorted elements ko wapas original array mein copy karna
        for(int x = 0; x < temp.length; x++) {
            arr[x + low] = temp[x];
        }
    }

    //============================================================
    // Main Method: Program execution yahan se start hota hai
    //============================================================
    public static void main(String[] args) {

        int[] arr = {32, 25, 48, 5, 12, 65, 18};

        // Merge Sort method call karna
        mergeSort(arr, 0, arr.length - 1);

        // Sorted array ke elements print karna
        for(int no : arr) {
            System.out.print(no + " ");
        }
    }
}
