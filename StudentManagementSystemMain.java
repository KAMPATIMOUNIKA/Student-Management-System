import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private Map<Integer, Student> students = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (students.containsKey(rollNumber)) {
            System.out.println("Student already exists.");
        } else {
            students.put(rollNumber, new Student(name, rollNumber, grade));
            System.out.println("Student added successfully!");
        }
    }

    public void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        if (students.remove(rollNumber) != null) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void editStudent() {
        System.out.print("Enter roll number to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new grade: ");
            String newGrade = scanner.nextLine();
            student.setName(newName);
            student.setGrade(newGrade);
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students.values()) {
                System.out.println(s);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> searchStudent();
                case 4 -> editStudent();
                case 5 -> displayAllStudents();
                case 6 -> {
                    System.out.println("Exiting system.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

public class StudentManagementSystemMain {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}
