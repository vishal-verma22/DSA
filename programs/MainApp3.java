// insertion
public class MainApp3
{
    static void main()
    {
        // insertion 2
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        int pos = 4;
        int element = 111;

        int n = arr.length;

        int[] arr2 = new int[n+1];

        for(int i=0; i<pos; i++)
        {
            arr2[i] = arr[i];
        }

        arr2[pos] = element;

        for(int i=pos; i<n; i++)
        {
            arr2[i+1] = arr[i];
        }

        for(int no : arr2)
        {
            System.out.print(no+" ");
        }
    }
}
