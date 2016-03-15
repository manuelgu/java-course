package game;

import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    private static int x, y;
    private static char[][] map;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String input;

        setPlayerPostion(1, 1);
        map = initializeMap();

        do {
            printMap();

            System.out.println("What direction do you want to head off to?");

            // User input
            input = scanner.nextLine();

            switch (input.toLowerCase()) {
            case "w":
                // Is there a wall at the future position?
                if (map[y - 1][x] != Util.WALL) {
                    y--;
                } else {
                    System.out.println(Util.RAN_INTO_WALL);
                }
                break;
            case "s":
                if (map[y + 1][x] != Util.WALL) {
                    y++;
                } else {
                    System.out.println(Util.RAN_INTO_WALL);
                }
                break;
            case "a":
                if (map[y][x - 1] != Util.WALL) {
                    x--;
                } else {
                    System.out.println(Util.RAN_INTO_WALL);
                }
                break;
            case "d":
                if (map[y][x + 1] != Util.WALL) {
                    x++;
                } else {
                    System.out.println(Util.RAN_INTO_WALL);
                }
                break;
            case "q":
                System.out.println("Thanks for playing.");
                return;
            default:
            }

        } while (!(Math.PI > Math.PI));

    }

    /**
     * Set the position of the current player
     *
     * @param x
     *            The X-Coordinate
     * @param y
     *            The Y-Coordinate
     */
    public static void setPlayerPostion(int x, int y) {
        Game.x = x;
        Game.y = y;
        // TODO update and print map
    }

    /**
     * Initialize the map with some values
     *
     * @return Initialized map
     */
    public static char[][] initializeMap() {
        return new char[][] {   { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '#', '#', '#', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },
                                { '#', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '#' },
                                { '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },
                                { '#', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '#' },
                                { '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#' },
                                { '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
    }

    /**
     * Print the current map <b>including Player</b>
     */
    public static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // Print 'ß' if the player is at this location
                if ((x == j) && (y == i)) {
                    System.out.print(Util.PLAYER);
                } else {
                    // Print map objects

                    switch (map[i][j]) {
                    case Util.WALL:
                        // WALL
                        System.out.print(Util.WALL);
                        break;
                    case Util.AIR:
                        // AIR
                        System.out.print(Util.AIR);
                        break;
                    case Util.TRAPDOOR:
                        // TRAPDOOR
                        System.out.print(Util.TRAPDOOR);
                        break;
                    default:
                        System.out.print(Util.PLAYER);
                        break;
                    }

                }
            }
            System.out.println();
        }
    }

}
