import java.util.Arrays;

public class Main {

    public static int[] A_sort(int[] input) { //sort method using a nested for loop, the exterior for loop has an intentional bug where it goes to input.length - 2 which sometimes causes bugs.
        for (int i = 0; i < input.length - 2; i++) {
            for (int j = 0; j <input.length - 1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public static void randTest() { //creates 10 random arrays from size 2-10 with random values ranging from 1-20.
        for (int i = 0; i < 10; i++) {
            int[] c = new int[(int)(Math.random()*10) + 2];
            for (int j = 0; j < c.length; j++) {
                c[j] = (int)(Math.random()*20) + 1;
            }
            System.out.println(Arrays.toString(c));
            int[] temp = A_sort(c).clone();
            System.out.println(Arrays.toString(temp));
            Arrays.sort(c); //correct answer to compare with possible error results from my flawed sorting method.
            System.out.println(Arrays.toString(c));

            boolean same = true;
            for (int k = 0; k < temp.length; k++) { //a for loop to compare the resulted array with the correctly sorted array.
                int result = temp[k];
                int expected = c[k];
                if (result != expected) {//returns false if the results do not match what should be returned.
                    same = false;
                }
            }
            System.out.println(same);
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        randTest();
    }
}