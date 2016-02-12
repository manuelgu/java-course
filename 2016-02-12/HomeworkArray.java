import java.util.Arrays;

public class Students {
    public static String[] students;

    public static void main(String[] args) {
        // Create students array and insert some names
        students = new String[] {
                "Odin", "Eberhard", "Yannick", "Siegfried",
                "Josia", "Nevin", "Konstantin", "Liam", "Thorben", "Alexander",
                "Sebastian" };

        // Print current students
        System.out.println("Students:");
        for (String studentName : students) {
            System.out.println("- " + studentName);
        }

        // Add a new student
        System.out.println("We got a new student called Maria!");
        addStudent("Maria");

        System.out.println("Students:");
        for (String studentName : students) {
            System.out.println("- " + studentName);
        }

    }

    /**
     * Adds a student to the current database of students
     *
     * @param name
     *            The Students name
     * @return New instance of the students array
     */
    public static void addStudent(String name) {
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = name;
    }

}

