// Deletion operation

public class MainApp5
{
    static void main()
    {
        int[] arr = {10, 20, 30, 40, 50};

        int pos = 2;

        int n = arr.length;

        for(int i=pos; i<n-1; i++)
        {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;

        for(int no : arr)
        {
            System.out.print(no+" ");
        }
    }
}
