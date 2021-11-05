package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "form")
public class FormDBCopy {

    @Id
    @Column(name = "f_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fID;

    @ManyToOne(targetEntity = EmployeeDB.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "e_id")
    private EmployeeDB employee;

    @Column(name = "date_time_completed", columnDefinition = "bigint")
    private long dateTimeCompleted;

    @ManyToOne(targetEntity = ReimbursementEvent.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "r_id")
    private ReimbursementEvent event;

    @OneToOne(targetEntity = GradingFormat.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "g_id")
    private GradingFormat gradingFormat;

    @Column(name = "work_justification", columnDefinition = "varchar(200)")
    private String workJustification;

    @Column(name = "earned_grade", columnDefinition = "varchar(1)")
    private String earnedGrade;

    @OneToOne(targetEntity = Approval.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "a_id")
    private Approval approval;

    public FormDBCopy() {
    }

    public FormDBCopy(int fID, EmployeeDB employee, long dateTimeCompleted, ReimbursementEvent event, GradingFormat gradingFormat, String workJustification, String earnedGrade, Approval approval) {
        this.fID = fID;
        this.employee = employee;
        this.dateTimeCompleted = dateTimeCompleted;
        this.event = event;
        this.gradingFormat = gradingFormat;
        this.workJustification = workJustification;
        this.earnedGrade = earnedGrade;
        this.approval = approval;
    }

    public FormDBCopy(EmployeeDB employee, long dateTimeCompleted, ReimbursementEvent event, GradingFormat gradingFormat, String workJustification, String earnedGrade, Approval approval) {
        this.employee = employee;
        this.dateTimeCompleted = dateTimeCompleted;
        this.event = event;
        this.gradingFormat = gradingFormat;
        this.workJustification = workJustification;
        this.earnedGrade = earnedGrade;
        this.approval = approval;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public EmployeeDB getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDB employee) {
        this.employee = employee;
    }

    public long getDateTimeCompleted() {
        return dateTimeCompleted;
    }

    public void setDateTimeCompleted(long dateTimeCompleted) {
        this.dateTimeCompleted = dateTimeCompleted;
    }

    public ReimbursementEvent getEvent() {
        return event;
    }

    public void setEvent(ReimbursementEvent event) {
        this.event = event;
    }

    public GradingFormat getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(GradingFormat gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getWorkJustification() {
        return workJustification;
    }

    public void setWorkJustification(String workJustification) {
        this.workJustification = workJustification;
    }

    public String getEarnedGrade() {
        return earnedGrade;
    }

    public void setEarnedGrade(String earnedGrade) {
        this.earnedGrade = earnedGrade;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormDBCopy formDB = (FormDBCopy) o;
        return getfID() == formDB.getfID() && getDateTimeCompleted() == formDB.getDateTimeCompleted() && Objects.equals(getEmployee(), formDB.getEmployee()) && Objects.equals(getEvent(), formDB.getEvent()) && Objects.equals(getGradingFormat(), formDB.getGradingFormat()) && Objects.equals(getWorkJustification(), formDB.getWorkJustification()) && Objects.equals(getEarnedGrade(), formDB.getEarnedGrade()) && Objects.equals(getApproval(), formDB.getApproval());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getfID(), getEmployee(), getDateTimeCompleted(), getEvent(), getGradingFormat(), getWorkJustification(), getEarnedGrade(), getApproval());
    }

    @Override
    public String toString() {
        return "FormDB{" +
                "fID=" + fID +
                ", employee=" + employee +
                ", dateTimeCompleted=" + dateTimeCompleted +
                ", event=" + event +
                ", gradingFormat=" + gradingFormat +
                ", workJustification='" + workJustification + '\'' +
                ", earnedGrade='" + earnedGrade + '\'' +
                ", approval=" + approval +
                '}';
    }
}
