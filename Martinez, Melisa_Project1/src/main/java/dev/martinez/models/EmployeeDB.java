package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class EmployeeDB {

    @Id
    @Column(name = "e_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eID;

    @Column(name = "first_name", columnDefinition = "varchar(25)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(25)")
    private String lastName;

    @Column(name = "job_position", columnDefinition = "varchar(25)")
    private String jobPosition;

    @Column(name = "username", columnDefinition = "varchar(7)")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(8)")
    private String password;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;

    @OneToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "d_id")
    private Department department;

    public EmployeeDB() {
    }

    public EmployeeDB(int eID, String firstName, String lastName, String jobPosition, String username, String password, String email, Department department) {
        this.eID = eID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
        this.username = username;
        this.password = password;
        this.email = email;
        this.department = department;
    }

    public EmployeeDB(String firstName, String lastName, String jobPosition, String username, String password, String email, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
        this.username = username;
        this.password = password;
        this.email = email;
        this.department = department;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDB that = (EmployeeDB) o;
        return geteID() == that.geteID() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getJobPosition(), that.getJobPosition()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getDepartment(), that.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(geteID(), getFirstName(), getLastName(), getJobPosition(), getUsername(), getPassword(), getEmail(), getDepartment());
    }

    @Override
    public String toString() {
        return "EmployeeDB{" +
                "eID=" + eID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}
