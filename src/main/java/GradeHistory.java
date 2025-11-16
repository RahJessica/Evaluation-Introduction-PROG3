import java.time.Instant;

public class GradeHistory {
    private Instant startChange;
    private double newGrade;
    private String reason;

    public GradeHistory(Instant startChange, double newGrade, String reason) {
        this.startChange = startChange;
        this.newGrade = newGrade;
        this.reason = reason;
    }

    public Instant getStartChange() {
        return startChange;
    }

    public void setStartChange(Instant startChange) {
        this.startChange = startChange;
    }

    public double getNewGrade() {
        return newGrade;
    }

    public void setNewGrade(double newGrade) {
        this.newGrade = newGrade;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
