import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // newline clear karto

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    service.addStudent(new Student(id, name, course));
                    break;
                case 2:
                    service.showAll();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    Student found = service.findById(sc.nextInt());
                    System.out.println(found != null ? found : "Student not found.");
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    boolean deleted = service.deleteById(sc.nextInt());
                    System.out.println(deleted ? "Deleted." : "Student not found.");
                    break;
                case 5:
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}