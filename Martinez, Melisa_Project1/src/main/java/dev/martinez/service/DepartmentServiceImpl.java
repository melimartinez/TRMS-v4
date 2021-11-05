package dev.martinez.service;

import dev.martinez.models.Department;
import dev.martinez.repositories.DepartmentRepo;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepo dr;

    public DepartmentServiceImpl(DepartmentRepo dr) {
        this.dr = dr;
    }

    @Override
    public Department addDepartment(Department d) {
        return dr.addDepartment(d);
    }

    @Override
    public List<Department> getAllDepartments() {
        return dr.getAllDepartments();
    }

    @Override
    public Department getDepartment(int id) {
        return dr.getDepartment(id);
    }

    // why am i passing in an entire object?
    @Override
    public Department getDepartment(Department dID) {
        return dr.getDepartment(dID);
    }

    @Override
    public Department updateDepartment(Department change) {
        return dr.updateDepartment(change);
    }

    @Override
    public Department deleteDepartment(int id) {
        return dr.deleteDepartment(id);
    }
}
