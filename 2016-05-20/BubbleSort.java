/**
 * Bubblesort mit den Zahlen 3, 112, 987, 365,2 222, 1111 und 7 programmieren
 *
 * @author Manuel
 */
public class BubbleSort {
    private static int[] numbers;

    public static void main(String[] args) {
        // Assign numbers
        numbers = new int[] {
                3, 112, 987, 365, 2222, 1111, 7
        };

        // Dump the array
        dump(numbers, "Before");

        // Sort the array using bubble sort algorithm
        bubbleSort(numbers);

        // Dump the array
        dump(numbers, "After");
    }

    /**
     * Sort an array using the bubble sort algorithm
     *
     * @param a The array to sort
     */
    public static void bubbleSort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * Dumps an array to STDOUT
     *
     * @param a Array to dump
     */
    public static void dump(int[] a, String before) {
        System.out.println(before);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }
}

