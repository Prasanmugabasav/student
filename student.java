import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Student {

    private String name;
    private LocalDate dob;
    private int age;

    public Student(String name, String dob) {
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.dob = LocalDate.parse(dob, formatter);
        this.age = calculateAge();
    }

    private int calculateAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Student student = new Student("Alice", "15-08-2002");
        student.displayStudentDetails();
    }
}
