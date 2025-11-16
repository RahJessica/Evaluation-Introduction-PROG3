import java.util.List;

public class Grade {
    private Student student;
    private double initialGrade;
    private List<GradeHistory> gradeHistoryList;

    public Grade(Student student, double initialGrade, List<GradeHistory> gradeHistoryList) {
        this.student = student;
        this.initialGrade = initialGrade;
        this.gradeHistoryList = gradeHistoryList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getInitialGrade() {
        return initialGrade;
    }

    public void setInitialGrade(double initialGrade) {
        this.initialGrade = initialGrade;
    }

    public List<GradeHistory> getGradeHistoryList() {
        return gradeHistoryList;
    }

    public void setGradeHistoryList(List<GradeHistory> gradeHistoryList) {
        this.gradeHistoryList = gradeHistoryList;
    }
}
