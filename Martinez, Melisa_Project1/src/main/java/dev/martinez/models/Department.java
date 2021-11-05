package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "d_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dID;

    @Column(name = "dept_name", columnDefinition = "varchar(50)")
    private String deptName;

    public Department() {
    }

    public Department(int dID, String deptName) {
        this.dID = dID;
        this.deptName = deptName;
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getdID() == that.getdID() && Objects.equals(getDeptName(), that.getDeptName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getdID(), getDeptName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "dID=" + dID +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
