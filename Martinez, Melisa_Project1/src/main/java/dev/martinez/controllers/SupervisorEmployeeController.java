package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.models.SupervisorEmployee;
import dev.martinez.service.SupervisorEmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class SupervisorEmployeeController {

    SupervisorEmployeeService ses;
    Gson gson = new Gson();

    public SupervisorEmployeeController(SupervisorEmployeeService ses) {

        this.ses = ses;

    }

    public Handler getSupervisorEmployeeById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // we are passing employee id to find supervisor's id
        SupervisorEmployee se = ses.getSupervisorEmployee(id);

        populateResult(context, se);

    };

    public Handler getAllSupervisorEmployees = (context) -> {

        List<SupervisorEmployee> supervisorEmployeeList = ses.getAllSupervisorEmployees();

        if (supervisorEmployeeList != null) {
            context.result(gson.toJson(supervisorEmployeeList));
        } else {
            context.result("[]");
        }

    };

    public Handler addSupervisorEmployee = (context) -> {

        SupervisorEmployee se = gson.fromJson(context.body(), SupervisorEmployee.class);

        se = ses.addSupervisorEmployee(se);

        populateResult(context, se);

    };

    public Handler updateSupervisorEmployee = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        SupervisorEmployee se = gson.fromJson(context.body(), SupervisorEmployee.class);

        if (se != null) {

            se.seteID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            se = ses.updateSupervisorEmployee(se);

            // there has to be a better way to do this
            if (se != null) {
                context.result(gson.toJson(se));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteSupervisorEmployee = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        SupervisorEmployee se = ses.deleteSupervisorEmployee(id);

        if (se != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(se));
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
    private void populateResult(Context context, SupervisorEmployee se) {

        if (se != null) {
            context.result(gson.toJson(se));
        } else {
            context.result("{}");
        }
    }

}
