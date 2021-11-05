package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Employee;
import dev.martinez.models.EmployeeDB;
import dev.martinez.service.EmployeeDBService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeDBController {

    EmployeeDBService eDBs;
    Gson gson = new Gson();

    public EmployeeDBController(EmployeeDBService eDBs) {

        this.eDBs = eDBs;

    }

    public Handler getEmployeeDBById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        EmployeeDB eDB = eDBs.getEmployee(id);

        populateResult(context, eDB);

    };

    public Handler getEmployeeDBByUsername = (context) -> {

        String username = context.pathParam("username");

        EmployeeDB eDB = eDBs.getEmployee(username);

        populateResult(context, eDB);

    };

    public Handler getAllEmployeeDB = (context) -> {

        List<EmployeeDB> employeeDBList = eDBs.getAllEmployees();

        if (employeeDBList != null) {
            context.result(gson.toJson(employeeDBList));
        } else {
            context.result("[]");
        }

    };

    public Handler addEmployeeDB = (context) -> {

        EmployeeDB eDB = gson.fromJson(context.body(), EmployeeDB.class);

        eDB = eDBs.addEmployee(eDB);

        populateResult(context, eDB);

    };

    public Handler updateEmployeeDB = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        EmployeeDB eDB = gson.fromJson(context.body(), EmployeeDB.class);

        if (eDB != null) {

            eDB.seteID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            eDB = eDBs.updateEmployee(eDB);

            // there has to be a better way to do this
            if (eDB != null) {
                context.result(gson.toJson(eDB));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteEmployeeDB = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        EmployeeDB eDB = eDBs.deleteEmployee(id);

        if (eDB != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(eDB));
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
    private void populateResult(Context context, EmployeeDB eDB) {

        if (eDB != null) {
            context.result(gson.toJson(eDB));
        } else {
            context.result("{}");
        }
    }

}
