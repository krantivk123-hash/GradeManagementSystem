import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeManagementSystem {

    private static final int SUBJECT_COUNT = 5;
    private static Scanner scanner = new Scanner(System.in);
    private static List<StudentGrade> students = new ArrayList<StudentGrade>();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = getValidInt(1, 5);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    ReportGenerator.generateSummary(students);
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    private static void addStudent() {

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        double[] marks = new double[SUBJECT_COUNT];

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print("Enter mark for Subject " + (i + 1) + ": ");
            marks[i] = getValidMark();
        }

        students.add(new StudentGrade(name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (StudentGrade student : students) {
            System.out.println("----------------------------------");
            System.out.println("Name: " + student.getName());
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.println("Grade: " + student.getGrade());
        }
    }

    private static void searchStudent() {

        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();

        for (StudentGrade student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student Found!");
                System.out.printf("Average: %.2f\n", student.getAverage());
                System.out.println("Grade: " + student.getGrade());
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static int getValidInt(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) return value;
                else System.out.print("Enter number between " + min + " and " + max + ": ");
            } catch (Exception e) {
                System.out.print("Invalid input! Enter number: ");
            }
        }
    }

    private static double getValidMark() {
        while (true) {
            try {
                double mark = Double.parseDouble(scanner.nextLine());
                if (mark >= 0 && mark <= 100) return mark;
                else System.out.print("Marks must be 0-100. Re-enter: ");
            } catch (Exception e) {
                System.out.print("Invalid input! Enter numeric value: ");
            }
        }
    }
}
