package dev.martinez.service;

import dev.martinez.models.ReimbursementEvent;

import java.util.List;

public interface ReimbursementEventService {

    public ReimbursementEvent addReimbursementEvent(ReimbursementEvent re);
    public List<ReimbursementEvent> getAllReimbursementEvents();
    public ReimbursementEvent getReimbursementEvent(int id);
    public ReimbursementEvent getReimbursementEvent(String typeOf);
    public ReimbursementEvent updateReimbursementEvent(ReimbursementEvent change);
    public ReimbursementEvent deleteReimbursementEvent(int id);

    // methods unique to service layer
    public ReimbursementEvent getReimbursementEvent(String typeOf, long startDate);


}
