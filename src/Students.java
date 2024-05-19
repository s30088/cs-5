import java.util.ArrayList;
import java.util.List;

public class Students {
    private List<Student> students = new ArrayList<>();

    public Students() {
    }

    public void promoteAllStudents() {
        students.forEach(Student::promoteToNextSemester);
    }

    public void displayInfoAboutAllStudents() {
        students.forEach(s -> System.out.printf("name: %s, last name: %s, index: %s, current semester: %s%n",
                s.getName(), s.getLastName(), s.getIndexNumber(), s.getSemester()));
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
