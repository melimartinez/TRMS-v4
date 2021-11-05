package dev.martinez.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "department_head")
public class DepartmentHeadCopy {

    @Id
    @Column(name = "dept_head_id", columnDefinition = "int")
    private int deptHeadId;

    @Column(name = "d_id", columnDefinition = "int")
    private int dID;

    public DepartmentHeadCopy() {
    }

    public DepartmentHeadCopy(int deptHeadId, int dID) {
        this.deptHeadId = deptHeadId;
        this.dID = dID;
    }

    public int getDeptHeadId() {
        return deptHeadId;
    }

    public void setDeptHeadId(int deptHeadId) {
        this.deptHeadId = deptHeadId;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentHeadCopy that = (DepartmentHeadCopy) o;
        return getDeptHeadId() == that.getDeptHeadId() && getdID() == that.getdID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeptHeadId(), getdID());
    }

    @Override
    public String toString() {
        return "DepartmentHead{" +
                "deptHeadId=" + deptHeadId +
                ", dID=" + dID +
                '}';
    }
}
