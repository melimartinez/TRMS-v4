package dev.martinez.repositorytesting;

import dev.martinez.models.Approval;
import dev.martinez.repositories.ApprovalRepo;
import dev.martinez.repositories.ApprovalRepoImpl;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

public class ApprovalRepoTest {

    ApprovalRepo ar = new ApprovalRepoImpl();

    Approval approval = new Approval("waiting for Direct Supervisor approval");

//    @Test
//    public void addApproval() {
//
//        approval = ar.addApproval(approval);
//
//        assertNotNull(approval);
//
//    }
//
//    @Test
//    public void getApproval() {
//
//        approval = ar.getApproval(approval.getaID());
//
//        assertNotNull(approval);
//
//    }
//
//    @Test
//    public void getAllApprovals() {
//
//        List<Approval> approvalList = new ArrayList<Approval>();
//
//        approvalList = ar.getAllApprovals();
//
//        assertNotNull(approval);
//
//    }
//
//    @Test
//    public void updateApproval() {
//
//        Approval temp = new Approval(approval);
//
//        temp.setStatus("Denied");
//
//        temp = ar.updateApproval(temp);
//
//        assertNotEquals(temp, approval);
//
//    }
//
//    @Test
//    public void deleteApproval() {
//
//        approval = ar.deleteAccount(approval.getaID());
//
//        assertNull(approval);
//
//    }
}
