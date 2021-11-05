package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Approval {

    @Id
    @Column(name = "a_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aID;

    @Column(name = "status", columnDefinition = "varchar(50)")
    private String status;

    public Approval() {
    }

    public Approval(int aID, String status) {
        this.aID = aID;
        this.status = status;
    }

    public Approval(String status) {
        this.status = status;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approval approval = (Approval) o;
        return getaID() == approval.getaID() && Objects.equals(getStatus(), approval.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getaID(), getStatus());
    }

    @Override
    public String toString() {
        return "Approval{" +
                "aID=" + aID +
                ", status='" + status + '\'' +
                '}';
    }
}
