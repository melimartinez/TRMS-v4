package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.models.FormDB;
import dev.martinez.service.FormDBService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class FormDBController {

    FormDBService fDBs;
    Gson gson = new Gson();

    public FormDBController(FormDBService fDBs) {

        this.fDBs = fDBs;

    }

    public Handler getFormDBById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        FormDB fDB = fDBs.getForm(id);

        populateResult(context, fDB);

    };

    public Handler getAllFormDBs = (context) -> {

        List<FormDB> formDBList = fDBs.getAllForms();

        if (formDBList != null) {
            context.result(gson.toJson(formDBList));
        } else {
            context.result("[]");
        }

    };

    public Handler addFormDB = (context) -> {

        FormDB fDB = gson.fromJson(context.body(), FormDB.class);

        fDB = fDBs.addForm(fDB);

        populateResult(context, fDB);

    };

    public Handler updateFormDB = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        FormDB fDB = gson.fromJson(context.body(), FormDB.class);

        if (fDB != null) {

            fDB.setfID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            fDB = fDBs.updateForm(fDB);

            // there has to be a better way to do this
            if (fDB != null) {
                context.result(gson.toJson(fDB));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteFormDB = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        FormDB fDB = fDBs.deleteForm(id);

        if (fDB != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(fDB));
            context.status(204);
        } else {
            // MyLogger.logger.warn("Controller: 404 Not Found");
            context.status(404);
            // 404 Not Found
            // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
        }

    };

    // extra Handlers here
    public Handler getEmployeeForms = (context) -> {

        // app.get("/:employees/:id/forms", fDBc.getEmployeeForms);
        int id = Integer.parseInt(context.pathParam("id"));

        List<FormDB> formList = fDBs.getAllEmployeeForms(id);

        context.result(gson.toJson(formList));

    };

    // --------------------

    // helper method
    private void populateResult(Context context, FormDB fDB) {

        if (fDB != null) {
            context.result(gson.toJson(fDB));
        } else {
            context.result("{}");
        }
    }

}
