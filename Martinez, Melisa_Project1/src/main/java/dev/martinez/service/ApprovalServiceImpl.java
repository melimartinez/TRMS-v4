package dev.martinez.service;

import dev.martinez.models.Approval;
import dev.martinez.repositories.ApprovalRepo;

import java.util.List;

public class ApprovalServiceImpl implements ApprovalService {

    ApprovalRepo ar;

    public ApprovalServiceImpl(ApprovalRepo ar) {
        this.ar = ar;
    }

    @Override
    public Approval addApproval(Approval a) {
        return ar.addApproval(a);
    }

    @Override
    public List<Approval> getAllApprovals() {
        return ar.getAllApprovals();
    }

    @Override
    public Approval getApproval(int id) {
        return ar.getApproval(id);
    }

    @Override
    public Approval getApproval(String status) {
        return ar.getApproval(status);
    }

    @Override
    public Approval updateApproval(Approval change) {
        return ar.updateApproval(change);
    }

    @Override
    public Approval deleteAccount(int id) {
        return ar.deleteAccount(id);
    }
}
