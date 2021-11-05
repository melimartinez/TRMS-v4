package dev.martinez.service;

import dev.martinez.models.FormDB;

import java.util.List;

public interface FormDBService {

    public FormDB addForm(FormDB fDB);
    public List<FormDB> getAllForms();
    public FormDB getForm(int id);
    public FormDB getForm(FormDB eID);
    public FormDB updateForm(FormDB change);
    public FormDB deleteForm(int id);

    // methods unique to service layer
    public List<FormDB> getAllEmployeeForms(int eID);

}
