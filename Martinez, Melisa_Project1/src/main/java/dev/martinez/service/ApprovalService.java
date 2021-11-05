package dev.martinez.service;

import dev.martinez.models.Approval;

import java.util.List;

public interface ApprovalService {

    public Approval addApproval(Approval a);
    public List<Approval> getAllApprovals();
    public Approval getApproval(int id);
    public Approval getApproval(String status);
    public  Approval updateApproval(Approval change);
    public Approval deleteAccount(int id);

    // methods unique to service layer

}
