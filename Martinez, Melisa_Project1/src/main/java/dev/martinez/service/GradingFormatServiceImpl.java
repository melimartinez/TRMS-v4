package dev.martinez.service;

import dev.martinez.models.GradingFormat;
import dev.martinez.repositories.GradingFormatRepo;

import java.util.List;

public class GradingFormatServiceImpl implements GradingFormatService {

    GradingFormatRepo gfr;

    public GradingFormatServiceImpl(GradingFormatRepo gfr) {
        this.gfr = gfr;
    }
    @Override
    public GradingFormat addGradingFormat(GradingFormat gf) {
        return gfr.addGradingFormat(gf);
    }

    @Override
    public List<GradingFormat> getAllGradingFormats() {
        return gfr.getAllGradingFormats();
    }

    @Override
    public GradingFormat getGradingFormat(int id) {
        return gfr.getGradingFormat(id);
    }

    @Override
    public GradingFormat getGradingFormat(String requirement) {
        return gfr.getGradingFormat(requirement);
    }

    @Override
    public GradingFormat updateGradingFormat(GradingFormat change) {
        return gfr.updateGradingFormat(change);
    }

    @Override
    public GradingFormat deleteGradingFormat(int id) {
        return gfr.deleteGradingFormat(id);
    }
}
