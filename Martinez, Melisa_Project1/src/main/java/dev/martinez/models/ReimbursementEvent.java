package dev.martinez.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reimbursement_event")
public class ReimbursementEvent {

    @Id
    @Column(name = "r_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rID;

    @Column(name = "type_of", columnDefinition = "varchar(50) check")
    private String typeOf;

    @Column(name = "start_date", columnDefinition = "bigint")
    private long startDate;

    @Column(name = "address_line_1", columnDefinition = "varchar(50)")
    private String addressLine1;

    @Column(name = "address_line_2", columnDefinition = "varchar(50)")
    private String addressLine2;

    @Column(name = "city", columnDefinition = "varchar(50)")
    private String city;

    @Column(name = "state", columnDefinition = "varchar(2)")
    private String state;

    @Column(name = "zipcode", columnDefinition = "int")
    private int zipcode;

    @Column(name = "r_cost", columnDefinition = "numeric(7, 2)")
    private double rCost;

    public ReimbursementEvent() {
    }

    public ReimbursementEvent(int rID, String typeOf, long startDate, String addressLine1, String addressLine2, String city, String state, int zipcode) {
        this.rID = rID;
        this.typeOf = typeOf;
        this.startDate = startDate;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public ReimbursementEvent(String typeOf, long startDate, String addressLine1, String addressLine2, String city, String state, int zipcode) {
        this.typeOf = typeOf;
        this.startDate = startDate;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public double getrCost() {
        return rCost;
    }

    public void setrCost(double rCost) {
        this.rCost = rCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementEvent that = (ReimbursementEvent) o;
        return getrID() == that.getrID() && getStartDate() == that.getStartDate() && getZipcode() == that.getZipcode() && Double.compare(that.getrCost(), getrCost()) == 0 && Objects.equals(getTypeOf(), that.getTypeOf()) && Objects.equals(getAddressLine1(), that.getAddressLine1()) && Objects.equals(getAddressLine2(), that.getAddressLine2()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getrID(), getTypeOf(), getStartDate(), getAddressLine1(), getAddressLine2(), getCity(), getState(), getZipcode(), getrCost());
    }

    @Override
    public String toString() {
        return "ReimbursementEvent{" +
                "rID=" + rID +
                ", typeOf='" + typeOf + '\'' +
                ", startDate=" + startDate +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", rCost=" + rCost +
                '}';
    }
}
