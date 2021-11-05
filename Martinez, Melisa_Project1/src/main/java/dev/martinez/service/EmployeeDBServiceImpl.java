package dev.martinez.service;

import dev.martinez.models.Employee;
import dev.martinez.models.EmployeeDB;
import dev.martinez.repositories.EmployeeDBRepo;

import java.util.List;

public class EmployeeDBServiceImpl implements EmployeeDBService {

    EmployeeDBRepo eDBr;

    public EmployeeDBServiceImpl(EmployeeDBRepo eDBr) {
        this.eDBr = eDBr;
    }

    @Override
    public EmployeeDB addEmployee(EmployeeDB eDB) {
        return eDBr.addEmployee(eDB);
    }

    @Override
    public List<EmployeeDB> getAllEmployees() {
        return eDBr.getAllEmployees();
    }

    @Override
    public EmployeeDB getEmployee(int id) {
        return eDBr.getEmployee(id);
    }

    @Override
    public EmployeeDB getEmployee(String username) {
        return eDBr.getEmployee(username);
    }

    @Override
    public EmployeeDB updateEmployee(EmployeeDB change) {
        return eDBr.updateEmployee(change);
    }

    @Override
    public EmployeeDB deleteEmployee(int id) {
        return eDBr.deleteEmployee(id);
    }
}
