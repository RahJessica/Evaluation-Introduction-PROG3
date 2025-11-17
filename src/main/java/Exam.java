import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class Exam {
    private Integer id;
    private String title;
    private Subject subject;
    private Instant dateTime;
    private Integer coefficient;
    private List<Grade> grades;

    public Exam(Integer id, String title, Subject subject, Instant dateTime, Integer coefficient, List<Grade> grades) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.dateTime = dateTime;
        this.coefficient = coefficient;
        this.grades = grades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
