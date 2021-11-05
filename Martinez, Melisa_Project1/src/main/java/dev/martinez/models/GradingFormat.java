package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grading_format")
public class GradingFormat {

    @Id
    @Column(name = "g_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gID;

    @Column(name = "requirement", columnDefinition = "varchar(50)")
    private String requirement;

    public GradingFormat() {
    }

    public GradingFormat(int gID, String requirement) {
        this.gID = gID;
        this.requirement = requirement;
    }

    public GradingFormat(String requirement) {
        this.requirement = requirement;
    }

    public int getgID() {
        return gID;
    }

    public void setgID(int gID) {
        this.gID = gID;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradingFormat that = (GradingFormat) o;
        return getgID() == that.getgID() && Objects.equals(getRequirement(), that.getRequirement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getgID(), getRequirement());
    }

    @Override
    public String toString() {
        return "GradingFormat{" +
                "gID=" + gID +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}
