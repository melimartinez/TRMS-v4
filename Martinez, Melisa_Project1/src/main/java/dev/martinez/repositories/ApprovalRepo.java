package dev.martinez.repositories;

import dev.martinez.models.Approval;

import java.util.List;

public interface ApprovalRepo {

    // CRUD
    public Approval addApproval(Approval a);
    public List<Approval> getAllApprovals();
    public Approval getApproval(int id);
    public Approval getApproval(String status);
    // public List<Approval> getApproval(String status);
    public  Approval updateApproval(Approval change);
    public Approval deleteAccount(int id);
}
