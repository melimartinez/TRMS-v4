package dev.martinez.repositories;

import dev.martinez.models.GradingFormat;

import java.util.List;

public interface GradingFormatRepo {

    public GradingFormat addGradingFormat(GradingFormat gf);
    public List<GradingFormat> getAllGradingFormats();
    public GradingFormat getGradingFormat(int id);
    public GradingFormat getGradingFormat(String requirement);
    public GradingFormat updateGradingFormat(GradingFormat change);
    public GradingFormat deleteGradingFormat(int id);

}
