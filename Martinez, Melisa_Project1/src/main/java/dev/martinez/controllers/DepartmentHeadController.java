package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.DepartmentHead;
import dev.martinez.service.DepartmentHeadService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class DepartmentHeadController {

    DepartmentHeadService dhs;
    Gson gson = new Gson();

    public DepartmentHeadController(DepartmentHeadService dhs) {

        this.dhs = dhs;

    }

    public Handler getDepartmentHeadById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        DepartmentHead dh = dhs.getDepartmentHead(id);

        populateResult(context, dh);

    };

    public Handler getAllDepartmentHeads = (context) -> {

        List<DepartmentHead> departmentHeads = dhs.getAllDepartmentHeads();

        if (departmentHeads != null) {
            context.result(gson.toJson(departmentHeads));
        } else {
            context.result("[]");
        }

    };

    public Handler addDepartmentHead = (context) -> {

        DepartmentHead dh = gson.fromJson(context.body(), DepartmentHead.class);

        dh = dhs.addDepartmentHead(dh);

        populateResult(context, dh);

    };

    public Handler updateDepartmentHead = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        DepartmentHead dh = gson.fromJson(context.body(), DepartmentHead.class);

        if (dh != null) {

            dh.setDeptHeadId(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            dh = dhs.updateDepartmentHead(dh);

            // there has to be a better way to do this
            if (dh != null) {
                context.result(gson.toJson(dh));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteDepartmentHead = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        DepartmentHead dh = dhs.deleteDepartmentHead(id);

        if (dh != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(dh));
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
    private void populateResult(Context context, DepartmentHead dh) {

        if (dh != null) {
            context.result(gson.toJson(dh));
        } else {
            context.result("{}");
        }
    }

}
