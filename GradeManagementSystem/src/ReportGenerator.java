import java.util.List;

public class ReportGenerator {

    public static void generateSummary(List<StudentGrade> students) {

        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("\n===== PERFORMANCE REPORT =====");
        System.out.println("Total Students: " + students.size());

        double totalAverage = 0;
        int a=0,b=0,c=0,d=0,f=0;

        for (StudentGrade student : students) {
            totalAverage += student.getAverage();

            String grade = student.getGrade();

            if (grade.equals("A+") || grade.equals("A")) a++;
            else if (grade.equals("B")) b++;
            else if (grade.equals("C")) c++;
            else if (grade.equals("D")) d++;
            else if (grade.equals("F")) f++;
        }

        System.out.printf("Class Average: %.2f\n", totalAverage / students.size());

        System.out.println("\nGrade Distribution:");
        System.out.println("A Grade: " + a);
        System.out.println("B Grade: " + b);
        System.out.println("C Grade: " + c);
        System.out.println("D Grade: " + d);
        System.out.println("F Grade: " + f);
    }
}
