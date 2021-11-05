package dev.martinez.repositories;

import dev.martinez.models.FormDB;

import java.util.List;

public interface FormDBRepo {

    public FormDB addForm(FormDB fDB);
    public List<FormDB> getAllForms();
    public FormDB getForm(int id);
    public FormDB getForm(FormDB eID);
    public FormDB updateForm(FormDB change);
    public FormDB deleteForm(int id);

    public List<FormDB> getAllEmployeeForms(int eID);

}
