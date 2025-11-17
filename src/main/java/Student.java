import java.time.Instant;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String email;
    private String telephone;
    private String group;
    private Tutor tutor;

    public Student(Integer id, String firstname, String lastname, LocalDate dateOfBirth, String email, String telephone, String group, Tutor tutor) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.group = group;
        this.tutor = tutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Tutor getGuardian() {
        return tutor;
    }

    public void setGuardian(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(email, student.email) && Objects.equals(telephone, student.telephone) && Objects.equals(group, student.group) && Objects.equals(tutor, student.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, dateOfBirth, email, telephone, group, tutor);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", group='" + group + '\'' +
                ", guardian=" + tutor +
                '}';
    }

    double getExamGrade(Exam exam, Student student, Instant t) {
        return exam.getGrades()
                .stream()
                .filter(grade -> grade.getStudent().equals(student))
                .findFirst() // pour récupérer le Grade dans le stream de filter et retourner un Optional Grade
                // flatMap pour aplatir car map retourne un Optional dans un autre Oprional
                .flatMap(grade -> grade.getGradeHistoryList()
                    .stream()
                    .filter(gradeHistory -> gradeHistory.getStartChange().isBefore(t))
                        .max(Comparator.comparing(GradeHistory::getStartChange))
                        .map(GradeHistory::getNewGrade)
                )
                .orElse(0.0);
    }



    public static void main(String[] args) {

        Tutor tutor1 = new Tutor(
                1,
                "Jeanne",
                "Randria",
                LocalDate.of(2004, 8, 11),
                "jeanne@gmail.com",
                "0331178906",
                "Tante de Liam"
        );

        Student Liam = new Student(
                1,
                "Liam",
                "Rafalimanana",
                LocalDate.of(1998, 12, 1),
                "liam@gmail.com",
                "0345690833",
                "K3",
                tutor1
        );

        Teacher teacher1 = new Teacher(
                1,
                "Ryan",
                "Ryan",
                LocalDate.of(1985, 3, 2),
                "ryan@mail.hei.school",
                "0341122334",
                "POO"
        );

        Subject subjectProg3 = new Subject(
                1,
                "PROG3",
                5,
                teacher1
        );

        GradeHistory gradeHistory_1 = new GradeHistory(
                Instant.parse("2025-01-01T08:00:00Z"),
                12.0,
                "Correction de l'enseignant"
        );

        GradeHistory gradeHistory_2 = new GradeHistory(
                Instant.parse("2025-01-05T10:00:00Z"),
                14.5,
                "Rattrapage"
        );

        GradeHistory gradeHistory_3 = new GradeHistory(
                Instant.parse("2025-01-10T09:30:00Z"),
                16.0,
                "BONUS projet"
        );

        Grade grade1 = new Grade(
                Liam,
                10.0,
                List.of(gradeHistory_1, gradeHistory_2, gradeHistory_3)
        );

        Exam exam1 = new Exam(
                1,
                "Examen PROG3 - Session 1",
                subjectProg3,
                Instant.parse("2025-01-02T08:00:00Z"),
                2,
                List.of(grade1)
        );

        System.out.println(Liam.getExamGrade(exam1, Liam, Instant.parse("2025-01-03T00:00:00Z")));
        System.out.println(Liam.getExamGrade(exam1, Liam, Instant.parse("2025-01-07T00:00:00Z")));
        System.out.println(Liam.getExamGrade(exam1, Liam, Instant.parse("2025-01-11T00:00:00Z")));
    }

}
