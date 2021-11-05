package dev.martinez.service;

import dev.martinez.models.SupervisorEmployee;

import java.util.List;

public interface SupervisorEmployeeService {

    public SupervisorEmployee addSupervisorEmployee(SupervisorEmployee se);
    public List<SupervisorEmployee> getAllSupervisorEmployees();
    public SupervisorEmployee getSupervisorEmployee(int eID);
    public SupervisorEmployee updateSupervisorEmployee(SupervisorEmployee change);
    public SupervisorEmployee deleteSupervisorEmployee(int eID);

    // methods unique to service layer

}
