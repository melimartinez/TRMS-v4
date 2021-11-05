package dev.martinez.service;

import dev.martinez.models.EmployeeDB;

import java.util.List;

public interface EmployeeDBService {

    public EmployeeDB addEmployee(EmployeeDB eDB);
    public List<EmployeeDB> getAllEmployees();
    public EmployeeDB getEmployee(int id);
    public EmployeeDB getEmployee(String username);
    public EmployeeDB updateEmployee(EmployeeDB change);
    public EmployeeDB deleteEmployee(int id);

    // methods unique to service layer
    // public double availableReimbursement();

}
