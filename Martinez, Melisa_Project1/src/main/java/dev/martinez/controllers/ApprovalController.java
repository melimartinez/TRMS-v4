package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.service.ApprovalService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class ApprovalController {

    ApprovalService as;
    Gson gson = new Gson();

    public ApprovalController(ApprovalService as) {

        this.as = as;

    }

    public Handler getApprovalById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Approval a = as.getApproval(id);

        populateResult(context, a);

    };

    public Handler getAllApprovals = (context) -> {

        List<Approval> approvals = as.getAllApprovals();

        if (approvals != null) {
            context.result(gson.toJson(approvals));
        } else {
            context.result("[]");
        }

    };

    public Handler addApproval = (context) -> {

        Approval a = gson.fromJson(context.body(), Approval.class);

        a = as.addApproval(a);

        populateResult(context, a);

    };

    public Handler updateApproval = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        Approval a = gson.fromJson(context.body(), Approval.class);

        if (a != null) {

            a.setaID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            a = as.updateApproval(a);

            // there has to be a better way to do this
            if (a != null) {
                context.result(gson.toJson(a));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteApproval = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Approval approval = as.deleteAccount(id);

        if (approval != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(approval));
            context.status(204);
        } else {
            // MyLogger.logger.warn("Controller: 404 Not Found");
            context.status(404);
            // 404 Not Found
            // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
        }

    };

    // extra Handlers here


    // --------------------

    // helper method
    private void populateResult(Context context, Approval a) {

        if (a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }
    }

}
