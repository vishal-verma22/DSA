// Deletion operation

public class MainApp6
{
    static void main()
    {
        int[] arr = {10, 20, 30, 40, 50};

        int element = 70;

        int pos = -1;

        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            if(arr[i] == element)
            {
                pos = i;
                break;
            }
        }

        if(pos != -1)
        {
            for(int i=pos; i<n-1; i++)
            {
                arr[i] = arr[i+1];
            }
            arr[n-1] = 0;

            for(int no : arr)
            {
                System.out.print(no+" ");
            }
        }
        else
        {
            System.out.println("Element not found");
        }
    }
}
