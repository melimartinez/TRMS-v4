package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "form")
public class FormDBCopy2 {

    @Id
    @Column(name = "f_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fID;

    @ManyToOne(targetEntity = EmployeeDB.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "e_id")
    private Employee employee;

    @Column(name = "date_time_completed", columnDefinition = "bigint")
    private long dateTimeCompleted;

    @ManyToOne(targetEntity = ReimbursementEvent.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_id")
    private ReimbursementEvent rEvent;

    @OneToOne(targetEntity = GradingFormat.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "g_id")
    private GradingFormat gFormat;

    @Column(name = "work_justification", columnDefinition = "varchar(200)")
    private String workJustification;

    @Column(name = "earned_grade", columnDefinition = "varchar(1)")
    private String earnedGrade;

    public FormDBCopy2() {
    }

    public FormDBCopy2(int fID, Employee employee, long dateTimeCompleted, ReimbursementEvent rEvent, GradingFormat gFormat, String workJustification, String earnedGrade) {
        this.fID = fID;
        this.employee = employee;
        this.dateTimeCompleted = dateTimeCompleted;
        this.rEvent = rEvent;
        this.gFormat = gFormat;
        this.workJustification = workJustification;
        this.earnedGrade = earnedGrade;
    }

    public FormDBCopy2(Employee employee, long dateTimeCompleted, ReimbursementEvent rEvent, GradingFormat gFormat, String workJustification, String earnedGrade) {
        this.employee = employee;
        this.dateTimeCompleted = dateTimeCompleted;
        this.rEvent = rEvent;
        this.gFormat = gFormat;
        this.workJustification = workJustification;
        this.earnedGrade = earnedGrade;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getDateTimeCompleted() {
        return dateTimeCompleted;
    }

    public void setDateTimeCompleted(long dateTimeCompleted) {
        this.dateTimeCompleted = dateTimeCompleted;
    }

    public ReimbursementEvent getrEvent() {
        return rEvent;
    }

    public void setrEvent(ReimbursementEvent rEvent) {
        this.rEvent = rEvent;
    }

    public GradingFormat getgFormat() {
        return gFormat;
    }

    public void setgFormat(GradingFormat gFormat) {
        this.gFormat = gFormat;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormDBCopy2 formDB = (FormDBCopy2) o;
        return getfID() == formDB.getfID() && getEmployee() == formDB.getEmployee() && getDateTimeCompleted() == formDB.getDateTimeCompleted() && getrEvent() == formDB.getrEvent() && getgFormat() == formDB.getgFormat() && getEarnedGrade() == formDB.getEarnedGrade() && Objects.equals(getWorkJustification(), formDB.getWorkJustification());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getfID(), getEmployee(), getDateTimeCompleted(), getrEvent(), getgFormat(), getWorkJustification(), getEarnedGrade());
    }

    @Override
    public String toString() {
        return "FormDB{" +
                "fID=" + fID +
                ", eID=" + employee +
                ", dateCompleted=" + dateTimeCompleted +
                ", rID=" + rEvent +
                ", gID=" + gFormat +
                ", workJustification='" + workJustification + '\'' +
                ", earnedGrade=" + earnedGrade +
                '}';
    }
}
