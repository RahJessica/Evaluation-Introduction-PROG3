public class Subject {
    private Integer id;
    private String label;
    private Integer credits;
    private Teacher teacher;

    public enum label {
        PROG1, PROG2, PROG3, PROG4,
        WEB1, WEB2, WEB3,
        SYS1, SYS2, SYS3,
        MGT1, MGT2,
        LV11, LV12,
        THEORIES1, THEORIES2
    }

    public Subject(Integer id, String label, Integer credits, Teacher teacher) {
        this.id = id;
        this.label = label;
        this.credits = credits;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
