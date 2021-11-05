package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supervisor_employee")
public class SupervisorEmployee {

    @Id
    @Column(name = "e_id", columnDefinition = "int")
    private int eID;

    @Column(name = "s_id", columnDefinition = "int")
    private int sID;

    public SupervisorEmployee() {
    }

    public SupervisorEmployee(int eID, int sID) {
        this.eID = eID;
        this.sID = sID;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupervisorEmployee that = (SupervisorEmployee) o;
        return geteID() == that.geteID() && getsID() == that.getsID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(geteID(), getsID());
    }

    @Override
    public String toString() {
        return "SupervisorEmployee{" +
                "e_id=" + eID +
                ", d_id=" + sID +
                '}';
    }
}
