public class StudyProgramme {

    private final String name;
    private final String description;
    private final Integer semesters;
    private final Integer itns;

    public StudyProgramme(String name, String description, Integer semesters, Integer itns) {
        this.name = name;
        this.description = description;
        this.semesters = semesters;
        this.itns = itns;
    }

    public Integer getSemesters() {
        return semesters;
    }

    public Integer getItns() {
        return itns;
    }
}

