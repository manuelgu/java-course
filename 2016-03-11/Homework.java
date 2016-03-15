import java.util.Scanner;

public class Homework {
    private static Scanner sc;
    // Position des Spielers
    static int x=2;
    static int y=2;

    static int randomX = 0;
    static int randomY = 0;

    // Lebensenergie des Spieler
    static int lebensenergie=3;

    static boolean teleportiert = false;

    static boolean schadenerlitten = false;

    // Abbruchmöglichkeiten
    static boolean schleife=true;
    static boolean zielerreicht=false;
    static boolean bintot=false;

    public static void main(String[] args) {

        // Scanner zum Auslesen der Eingabe (in Textform)
        sc = new Scanner(System.in);
        // Variable eingabe zum "Speichern" der Texteingabe
        String eingabe;
        // Karte
        // Erste eckige Klammer für die Zeilen Y
        // Zweite eckige Klammer für die Zeilen X
        int map[][]  = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,2,0,1,0,0,1,0,0,0,0,0,1},
                {1,0,0,1,5,0,0,0,1,1,1,0,1},
                {1,0,1,0,0,1,0,0,1,0,0,0,1},
                {1,4,0,0,3,1,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1}
                };

        do {

        System.out.println("--------------------------------");
        System.out.println("Lebensenergie: " + lebensenergie);
        if (teleportiert) { System.out.println("Du wurdest teleportiert"); teleportiert=false; }
        System.out.println("--------------------------------");

        // Schleife in Schleife für die ganze Karte zum Ausgeben
        // i entspricht Y
        for (int i=0;i<map.length;i++) {
            // X
            for (int j=0;j<map[i].length;j++) {

                // Wenn der Spieler an der aktuellen Position
                // ist wird ein @ ausgegeben (als Spieler)
                if ((y==i) && (x==j)) {
                    System.out.print("@");

                    // Wenn ich auf E stehe (Also Ende!)
                    if (map[i][j]==3) {
                        schleife=false;
                        zielerreicht=true;
                    }

                    // Wenn ich auf eine Falltür trete
                    if (map[i][j]==4) {
                        schadenerlitten=true;
                        lebensenergie--;
                        if (lebensenergie<1) {
                            schleife=false;
                            bintot=true;
                        }
                    }
                }
                // ansonsten die Karte ausgeben
                else
                    switch (map[i][j]) {
                        // NIX
                        case 0:    System.out.print(" ");
                                break;
                        // WAND
                        case 1:    System.out.print("#");
                                break;
                        // START
                        case 2:    System.out.print("S");
                                break;
                        // ENDE
                        case 3:    System.out.print("E");
                                break;
                        // PIT/FALLTÜR
                        case 4:    System.out.print("P");
                                break;
                        // TELEPORTER
                        case 5:    System.out.print("T");
                                break;
                        default: System.out.print("@");
                    }
            }
            System.out.println();
        }

        if (schadenerlitten) {
            System.out.println("Dickes AUA Lebensenergie -1");
            schadenerlitten=false;
        }

        // wenn ich noch in der Schleife sein darf!
        if (schleife) {
            System.out.println("Wohin mein Meister?");
            // Eingabe des Spielers!
            eingabe = sc.next();

            // Was wurde eingegeben ?
            switch (eingabe) {
            // Eingabe von w (also nach oben gehen)
            case "w" :
                // Befindet sich an der zukünftigen Position eine Wand ?
                // Wenn nein dann gehe eins nach oben (y=y-1)
                if (map[y-1][x]!=1) {
                    y--;
                }
                // Ansonsten vor die Wand rennen!
                else {
                    System.out.println("AUA!");
                }
                break;
            case "s" :
                if (map[y+1][x]!=1) {
                    y++;
                } else {
                    System.out.println("AUA!");
                }
                break;
            case "a" :
                if (map[y][x-1]!=1) {
                    x--;
                } else {
                    System.out.println("AUA!");
                }
                break;
            case "d" :
                if (map[y][x+1]!=1) {
                    x++;
                } else {
                    System.out.println("AUA!");
                }
                break;
            case "q" :
                schleife=false;
                break;
            default:
            }

            // Wenn ich auf einen Teleporter gehe
            if (map[y][x]==5) {

                do {
                    randomY = (int)(Math.random() * (map.length));
                    randomX = (int)(Math.random() * (map[0].length));

                } while (map[randomY][randomX] != 0);

                x = randomX;
                y = randomY;
                teleportiert=true;
            }
        }

        } while (schleife);

        if (zielerreicht) {
            System.out.println("Zitat Hancook: Gut gemacht!");
        }

        if (bintot) {
            System.out.println("Du Opfer!");
        }
     }
}
