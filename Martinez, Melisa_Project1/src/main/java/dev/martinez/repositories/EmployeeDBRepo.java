package dev.martinez.repositories;

import dev.martinez.models.EmployeeDB;

import java.util.List;

public interface EmployeeDBRepo {

    public EmployeeDB addEmployee(EmployeeDB eDB);
    public List<EmployeeDB> getAllEmployees();
    public EmployeeDB getEmployee(int id);
    public EmployeeDB getEmployee(String username);
    public EmployeeDB updateEmployee(EmployeeDB change);
    public EmployeeDB deleteEmployee(int id);

}
