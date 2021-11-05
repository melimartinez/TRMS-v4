package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.models.EmployeeDB;
import dev.martinez.models.ReimbursementEvent;
import dev.martinez.service.ReimbursementEventService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class ReimbursementEventController {

    ReimbursementEventService res;
    Gson gson = new Gson();

    public ReimbursementEventController(ReimbursementEventService res) {

        this.res = res;

    }

    public Handler getReimbursementEventById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        ReimbursementEvent re = res.getReimbursementEvent(id);

        populateResult(context, re);

    };

    public Handler getAllReimbursementEvents = (context) -> {

        List<ReimbursementEvent> reimbursementEvents = res.getAllReimbursementEvents();

        if (reimbursementEvents != null) {
            context.result(gson.toJson(reimbursementEvents));
        } else {
            context.result("[]");
        }

    };

    public Handler getGetReimbursementEventByType = (context) -> {

        String typeOf = context.pathParam("typeOf");

        ReimbursementEvent re = res.getReimbursementEvent(typeOf);

        populateResult(context, re);

    };

    public Handler addReimbursementEvent = (context) -> {

        ReimbursementEvent re = gson.fromJson(context.body(), ReimbursementEvent.class);

        re = res.addReimbursementEvent(re);

        populateResult(context, re);

    };

    public Handler updateReimbursementEvent = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        ReimbursementEvent re = gson.fromJson(context.body(), ReimbursementEvent.class);

        if (re != null) {

            re.setrID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            re = res.updateReimbursementEvent(re);

            // there has to be a better way to do this
            if (re != null) {
                context.result(gson.toJson(re));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteReimbursementEvent = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        ReimbursementEvent re = res.deleteReimbursementEvent(id);

        if (re != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(re));
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
    private void populateResult(Context context, ReimbursementEvent re) {

        if (re != null) {
            context.result(gson.toJson(re));
        } else {
            context.result("{}");
        }
    }

}
