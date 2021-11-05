package dev.martinez.service;

import dev.martinez.models.DepartmentHead;
import dev.martinez.repositories.DepartmentHeadRepo;

import java.util.List;

public class DepartmentHeadServiceImpl implements DepartmentHeadService {

    DepartmentHeadRepo dhr;

    public DepartmentHeadServiceImpl(DepartmentHeadRepo dhr) {
        this.dhr = dhr;
    }

    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead dh) {
        return dhr.addDepartmentHead(dh);
    }

    @Override
    public List<DepartmentHead> getAllDepartmentHeads() {
        return dhr.getAllDepartmentHeads();
    }

    @Override
    public DepartmentHead getDepartmentHead(int id) {
        return dhr.getDepartmentHead(id);
    }

    @Override
    public DepartmentHead getDepartmentHead(DepartmentHead dID) {
        return dhr.getDepartmentHead(dID);
    }

    // why am I sending in an entire object into this method?
    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead change) {
        return dhr.updateDepartmentHead(change);
    }

    @Override
    public DepartmentHead deleteDepartmentHead(int id) {
        return dhr.deleteDepartmentHead(id);
    }
}
