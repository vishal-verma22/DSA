public class MainApp1
{
    static void main()
    {
        int[] arr = {10, 20, 30, 40, 50};

        // way 1
        for(int i=0; i<arr.length; i++)
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
        for(int i=arr.length-1; i>=0; i--)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
