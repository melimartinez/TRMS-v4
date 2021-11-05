package dev.martinez.repositories;

import dev.martinez.models.DepartmentHead;

import java.util.List;

public interface DepartmentHeadRepo {

    // CRUD
    public DepartmentHead addDepartmentHead(DepartmentHead dh);
    public List<DepartmentHead> getAllDepartmentHeads();
    public DepartmentHead getDepartmentHead(int id);
    public DepartmentHead getDepartmentHead(DepartmentHead dID);
    public DepartmentHead updateDepartmentHead(DepartmentHead change);
    public DepartmentHead deleteDepartmentHead(int id);

}
