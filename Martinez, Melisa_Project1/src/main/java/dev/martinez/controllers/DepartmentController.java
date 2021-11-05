package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.models.Department;
import dev.martinez.repositories.DepartmentRepo;
import dev.martinez.service.DepartmentService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class DepartmentController {

    DepartmentService ds;
    Gson gson = new Gson();

    public DepartmentController(DepartmentService ds) {

        this.ds = ds;

    }

    public Handler getDepartmentById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Department d = ds.getDepartment(id);

        populateResult(context, d);

    };

    public Handler getAllDepartments = (context) -> {

        List<Department> departments = ds.getAllDepartments();

        if (departments != null) {
            context.result(gson.toJson(departments));
        } else {
            context.result("[]");
        }

    };

    public Handler addDepartment = (context) -> {

        Department d = gson.fromJson(context.body(), Department.class);

        d = ds.addDepartment(d);

        populateResult(context, d);

    };

    public Handler updateDepartment = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        Department d = gson.fromJson(context.body(), Department.class);

        if (d != null) {

            d.setdID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            d = ds.updateDepartment(d);

            // there has to be a better way to do this
            if (d != null) {
                context.result(gson.toJson(d));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteDepartment = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Department d = ds.deleteDepartment(id);

        if (d != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(d));
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
    private void populateResult(Context context, Department d) {

        if (d != null) {
            context.result(gson.toJson(d));
        } else {
            context.result("{}");
        }
    }

}
