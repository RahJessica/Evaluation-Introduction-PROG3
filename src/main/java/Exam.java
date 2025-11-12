import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Exam {
    private Integer id;
    private String title;
    private Subject subject;
    private LocalDateTime dateTime;
    private Integer coefficient;

    public Exam(Integer id, String title, Subject subject, LocalDateTime dateTime, Integer coefficient) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.dateTime = dateTime;
        this.coefficient = coefficient;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }
}
