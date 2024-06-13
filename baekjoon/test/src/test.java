import java.util.Arrays;

public class test {

    private static int[] combine(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int index = 0;
        for (int i = 0; i < left.length; i++) {
            arr[index++] = left[i];
        }
        for (int i = 0; i < right.length; i++) {
            arr[index++] = right[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 4, 5
        };

        int[] left = Arrays.copyOfRange(a, 0, 2+1);
        int[] b = Arrays.copyOfRange(a, 2, a.length);

        left[2] = 6;

        a = combine(left, b);


        System.out.println(a.length);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(b));

        System.out.println("copy: " + Arrays.toString(a));
    }
}
