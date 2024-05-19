import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", "Doe", LocalDate.of(1980, 1, 1), "doe@wp.pl",
                "Warsaw, Zlota 12");

        StudyProgramme studyProgramme = new StudyProgramme("IT", "AAA", 7, 5);
        student.addGrade("PGO", 5.0);
        student.addGrade("APBD", 2.0);
        Students students = new Students();
        students.addStudent(student);
        student.enrollStudent(studyProgramme);
        students.promoteAllStudents();
        students.displayInfoAboutAllStudents();
        System.out.println("===========================");
        students.promoteAllStudents();
        students.displayInfoAboutAllStudents();
        System.out.println("===========================");
        student.addGrade("APBD1", 2.0);
        student.addGrade("APBD2", 2.0);
        student.addGrade("APBD3", 2.0);
        student.addGrade("APBD4", 2.0);
        students.promoteAllStudents();
        students.displayInfoAboutAllStudents();
        System.out.println("===========================");
        student.addGrade("APBD5", 2.0);
        students.promoteAllStudents();
        students.displayInfoAboutAllStudents();
        System.out.println("===========================");
    }
}