package dev.martinez.controllers;

import com.google.gson.Gson;
import dev.martinez.models.Approval;
import dev.martinez.models.GradingFormat;
import dev.martinez.service.GradingFormatService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class GradingFormatController {

    GradingFormatService gfs;
    Gson gson = new Gson();

    public GradingFormatController(GradingFormatService gfs) {

        this.gfs = gfs;

    }

    public Handler getGradingFormatById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        GradingFormat gf = gfs.getGradingFormat(id);

        populateResult(context, gf);

    };

    public Handler getAllGradingFormats = (context) -> {

        List<GradingFormat> gradingFormatList = gfs.getAllGradingFormats();

        if (gradingFormatList != null) {
            context.result(gson.toJson(gradingFormatList));
        } else {
            context.result("[]");
        }

    };

    public Handler addGradingFormat = (context) -> {

        GradingFormat gf = gson.fromJson(context.body(), GradingFormat.class);

        gf = gfs.addGradingFormat(gf);

        populateResult(context, gf);

    };

    public Handler updateGradingFormat = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        // create object from the JSON object received
        GradingFormat gf = gson.fromJson(context.body(), GradingFormat.class);

        if (gf != null) {

            gf.setgID(id);

            // invoke the method to actually update the client in the database
            // and store the value in our current client object
            gf = gfs.updateGradingFormat(gf);

            // there has to be a better way to do this
            if (gf != null) {
                context.result(gson.toJson(gf));
                context.status(200);
            } else {
                // MyLogger.logger.warn("Controller: 404 Not Found");
                context.status(404);
                // 404 Not Found
                // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404
            }
        }

    };

    public Handler deleteGradingFormat = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        GradingFormat gf = gfs.deleteGradingFormat(id);

        if (gf != null) {

            // MyLogger.logger.info("Controller: Approval deleted successfully");
            context.result(gson.toJson(gf));
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
    private void populateResult(Context context, GradingFormat gf) {

        if (gf != null) {
            context.result(gson.toJson(gf));
        } else {
            context.result("{}");
        }
    }

}
