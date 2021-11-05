package dev.martinez.service;

import dev.martinez.models.DepartmentHead;

import java.util.List;

public interface DepartmentHeadService {

    public DepartmentHead addDepartmentHead(DepartmentHead dh);
    public List<DepartmentHead> getAllDepartmentHeads();
    public DepartmentHead getDepartmentHead(int id);
    public DepartmentHead getDepartmentHead(DepartmentHead dID);
    public DepartmentHead updateDepartmentHead(DepartmentHead change);
    public DepartmentHead deleteDepartmentHead(int id);

    // methods unique to service layer

}
