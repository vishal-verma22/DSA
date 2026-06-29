// Traversal Operation

public class MainApp1
{
    static void main()
    {
        int[] arr = {10, 20, 30, 40, 50};

        int n = arr.length;

        // way 1
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        System.out.println("-------------------");

        // way 2
        for(int no : arr)
        {
            System.out.print(no+" ");
        }
        System.out.println();

        System.out.println("-------------------");

        // traversing in reverse order
        for(int i=n-1; i>=0; i--)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
