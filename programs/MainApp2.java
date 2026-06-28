// insertion
public class MainApp2
{
    static void main()
    {
        // insertion 1
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        int pos = 3;
        int element = 111;

        int leng = arr.length;

        for(int i=leng-1; i>pos; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[pos] = element;

        for(int no : arr)
        {
            System.out.print(no+" ");
        }
    }
}
