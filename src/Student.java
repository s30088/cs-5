import java.time.LocalDate;
import java.util.*;

public class Student {
    private final String name;
    private final String lastName;
    private final LocalDate birthDate;
    private final String email;
    private final String address;
    private final String indexNumber;
    private StudyProgramme studyProgramme;
    private Integer semester;
    private State state = State.CANDIDATE;
    private HashMap<String, List<Double>> grades = new HashMap<>();

    public Student(String name, String lastName, LocalDate birthDate, String email, String address) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        Random random = new Random();
        this.indexNumber = String.format("s%s", random.nextInt(10 - 1) + 1);
    }


    public void enrollStudent(StudyProgramme studyProgramme) {
        this.semester = 1;
        this.studyProgramme = studyProgramme;
        this.state = State.STUDENT;
    }

    public void promoteToNextSemester() {
        var itns = countItns();
        var maxSemesters = this.studyProgramme.getSemesters();
        var maxItns = this.studyProgramme.getItns();
        if (maxItns >= itns) {
            if (this.semester + 1 <= maxSemesters) {
                this.semester++;
                System.out.printf("Student %s %s moved to %s semester with %s ITNs!%n", this.name, this.lastName, this.semester, itns);
            } else {
                System.out.printf("Student %s %s graduated!%n", this.name, this.lastName);
                this.state = State.GRADUATE;
            }
        } else {
            System.out.printf("Student %s %s was not moved to the next semester because he exceeded number of ITNs!%n", this.name, this.lastName);
        }
    }

    public void addGrade(String subject, Double grade) {
        this.grades.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public Integer getSemester() {
        return semester;
    }

    private int countItns() {
        int count = 0;
        for (Map.Entry<String, List<Double>> entry : grades.entrySet()) {
            List<Double> values = entry.getValue();
            double sum = 0.0;
            for (double value : values) {
                sum += value;
            }
            double mean = sum / values.size();
            if (mean < 3) {
                count++;
            }
        }
        return count;
    }
}
