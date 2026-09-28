// WAP to Reverse a given String using Two Pointer

public class P12_ReverseStringUsingTwoPointer344 {

    public static void main(String[] args) {

        String str = "hello";

        char[] s = str.toCharArray();

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];

            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        System.out.println(s);
    }
}