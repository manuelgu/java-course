import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

/**
 * Erstelle ein Programm, das eine Highscorteliste (10 Personen, Werte bliebig) unter Verwendung von
 * INSERTIONSORT sortiert.
 *
 * @author Manuel
 */
public class Highscore {
    private static String highscores[][];
    private static List<String> words;

    public static void main(String[] args) {
        // Declare size of array
        highscores = new String[10][1];
        // Instantiate list of words
        words = new ArrayList<>();

        // Fill the list of words with names
        fillRandomNames(words);

        // Fill the array with random names and scores
        fillRandomValues(highscores, words);

        // Sort using the Insertion Sort algorithm
        insertSort(highscores, 1);

        // Dump the list
        dump(highscores);
    }

    /**
     * Randomly fill an array with names and scores
     * <br>
     *  Random numbers are taken from the {@link ThreadLocalRandom} and
     *  go from 1 to 150
     *
     * @param a     The array to fill
     * @param names List of names
     */
    public static void fillRandomValues(String[][] a, List<String> names) {
        for (int i = 0; i < a.length; i++) {
            a[i] = new String[]{names.get(ThreadLocalRandom.current().nextInt(0, names.size())), String.valueOf(ThreadLocalRandom.current().nextInt(1, 150))};
        }
    }

    /**
     * Fill a list with with random human names
     *
     * @param list List to fill
     */
    public static void fillRandomNames(List<String> list) {
        list.addAll(asList("Kemberly", "Ebonie", "Brock", "Maxima", "Janel", "Minnie",
                "Manie", "Serafina", "Duane", "Suzie", "Shannan", "Lashunda", "Frida",
                "Jefferey", "Nancie", "Oretha", "Rex", "Stacie", "Eboni", "Tifany", "Delia",
                "Nathalie", "Esperanza", "Felice", "Ranee", "Jenni", "Rayna", "Shirleen",
                "Corrine", "Marianna", "Tyisha", "Chuck", "Emilio", "Kaley", "Zella", "Tanisha",
                "Jacinto", "Ruthie", "Allen", "Brandie", "Ladawn", "Elicia", "Jadwiga",
                "Katelynn", "Osvaldo", "Cira", "Golda", "Barrett", "Tierra", "Johana"));
    }

    /**
     * Sort a two-dimensional string array by the numbers in one of the columns.
     * <br>
     * Sorting is done using the Insertion sort algorithm
     *
     * @param a      The array to sort
     * @param column Column to sort by, either 1 or 2
     */
    public static void insertSort(String[][] a, int column) {
        for (int i = 1; i < a.length; i++) {
            String value[] = a[i];
            int j = i - 1;
            while (j >= 0 && Integer.valueOf(a[j][column]) > Integer.valueOf(value[column])) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = value;
        }

        // This would have been much easier
//        Arrays.sort(highscores, (o1, o2) -> {
//            Integer a1 = Integer.valueOf(o1[1]);
//            Integer bb = Integer.valueOf(o2[1]);
//            return a1.compareTo(b1);
//        });
    }

    /**
     * Dumps an array in reverse order to STDOUT
     *
     * @param a Array to dump
     */
    public static void dump(String[][] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("Name: '" + a[i][0] + "' Score: " + a[i][1]);
        }
    }
}

