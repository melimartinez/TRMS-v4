package dev.martinez.service;

import dev.martinez.models.GradingFormat;

import java.util.List;

public interface GradingFormatService {

    public GradingFormat addGradingFormat(GradingFormat gf);
    public List<GradingFormat> getAllGradingFormats();
    public GradingFormat getGradingFormat(int id);
    public GradingFormat getGradingFormat(String requirement);
    public GradingFormat updateGradingFormat(GradingFormat change);
    public GradingFormat deleteGradingFormat(int id);

    // methods unique to service layer

}
