package dev.martinez.repositories;

import dev.martinez.models.ReimbursementEvent;

import java.util.List;

public interface ReimbursementEventRepo {

    public ReimbursementEvent addReimbursementEvent(ReimbursementEvent re);
    public List<ReimbursementEvent> getAllReimbursementEvents();
    public ReimbursementEvent getReimbursementEvent(int id);
    public ReimbursementEvent getReimbursementEvent(String typeOf);
    public ReimbursementEvent updateReimbursementEvent(ReimbursementEvent change);
    public ReimbursementEvent deleteReimbursementEvent(int id);

    public ReimbursementEvent getReimbursementEvent(String typeOf, long startDate);

}
