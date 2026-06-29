// Sorting Operation

public class MainApp8
{
    static void main()
    {
        int[] arr = {40, 10, 30, 50, 20};

        int n = arr.length;

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<n-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int no: arr)
        {
            System.out.print(no+" ");
        }
    }
}
