package dev.martinez.service;

import dev.martinez.models.FormDB;
import dev.martinez.repositories.FormDBRepo;

import java.util.List;

public class FormDBServiceImpl implements FormDBService {

    FormDBRepo fDBr;

    public FormDBServiceImpl(FormDBRepo fDBr) {
        this.fDBr = fDBr;
    }

    @Override
    public FormDB addForm(FormDB fDB) {
        return fDBr.addForm(fDB);
    }

    @Override
    public List<FormDB> getAllForms() {
        return fDBr.getAllForms();
    }

    @Override
    public FormDB getForm(int id) {
        return fDBr.getForm(id);
    }

    // why am i passing in an object?
    // maybe last name would be better
    @Override
    public FormDB getForm(FormDB eID) {
        return fDBr.getForm(eID);
    }

    @Override
    public FormDB updateForm(FormDB change) {
        return fDBr.updateForm(change);
    }

    @Override
    public FormDB deleteForm(int id) {
        return fDBr.deleteForm(id);
    }

    @Override
    public List<FormDB> getAllEmployeeForms(int eID) {
        return fDBr.getAllEmployeeForms(eID);
    }
}
