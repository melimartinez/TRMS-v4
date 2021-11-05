package dev.martinez.service;

import dev.martinez.models.ReimbursementEvent;
import dev.martinez.repositories.ReimbursementEventRepo;

import java.util.List;

public class ReimbursementEventServiceImpl implements ReimbursementEventService {

    ReimbursementEventRepo rer;

    public ReimbursementEventServiceImpl(ReimbursementEventRepo rer) {
        this.rer = rer;
    }
    @Override
    public ReimbursementEvent addReimbursementEvent(ReimbursementEvent re) {
        return rer.addReimbursementEvent(re);
    }

    @Override
    public List<ReimbursementEvent> getAllReimbursementEvents() {
        return rer.getAllReimbursementEvents();
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(int id) {
        return rer.getReimbursementEvent(id);
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(String startDate) {
        return rer.getReimbursementEvent(startDate);
    }

    @Override
    public ReimbursementEvent updateReimbursementEvent(ReimbursementEvent change) {
        return rer.updateReimbursementEvent(change);
    }

    @Override
    public ReimbursementEvent deleteReimbursementEvent(int id) {
        return rer.deleteReimbursementEvent(id);
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(String typeOf, long startDate) {
        return rer.getReimbursementEvent(typeOf, startDate);
    }
}
