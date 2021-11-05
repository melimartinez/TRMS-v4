package dev.martinez.service;

import dev.martinez.models.Department;

import java.util.List;

public interface DepartmentService {

    public Department addDepartment(Department d);
    public List<Department> getAllDepartments();
    public Department getDepartment(int id);
    public Department getDepartment(Department dID);
    public Department updateDepartment(Department change);
    public Department deleteDepartment(int id);

    // methods unique to service layer

}
