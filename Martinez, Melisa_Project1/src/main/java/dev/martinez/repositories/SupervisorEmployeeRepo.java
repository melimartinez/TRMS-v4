package dev.martinez.repositories;

import dev.martinez.models.SupervisorEmployee;

import java.util.List;

public interface SupervisorEmployeeRepo {

    public SupervisorEmployee addSupervisorEmployee(SupervisorEmployee se);
    public List<SupervisorEmployee> getAllSupervisorEmployees();
    public SupervisorEmployee getSupervisorEmployee(int eID);
    // public SupervisorEmployee getReimbursementEvent(int sID);
    public SupervisorEmployee updateSupervisorEmployee(SupervisorEmployee change);
    public SupervisorEmployee deleteSupervisorEmployee(int eID);

}
