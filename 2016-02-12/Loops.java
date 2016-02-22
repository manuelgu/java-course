public class Loops {
    private static final String OUTPUT = "Ich darf nicht laut sein!";

    public static void main(String[] args) {

        /* for */
        for (int i = 0; i <= 100; i++) {
            System.out.println(OUTPUT);
        }

        /* while */
        int whileIndex = 0;
        while (whileIndex <= 100) {
            System.out.println(OUTPUT);
            whileIndex++;
        }

        /* do-while */
        int doWhileIndex = 0;
        do {
            System.out.println(OUTPUT);
            doWhileIndex++;
        } while (doWhileIndex <= 100);

    }

}
