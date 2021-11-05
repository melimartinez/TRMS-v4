package dev.martinez.service;

import dev.martinez.models.SupervisorEmployee;
import dev.martinez.repositories.SupervisorEmployeeRepo;
import dev.martinez.repositories.SupervisorEmployeeRepoImpl;

import java.util.List;

public class SupervisorEmployeeServiceImpl implements SupervisorEmployeeService {

    SupervisorEmployeeRepo ser;

    public SupervisorEmployeeServiceImpl(SupervisorEmployeeRepo ser) {
        this.ser = ser;
    }

    @Override
    public SupervisorEmployee addSupervisorEmployee(SupervisorEmployee se) {
        return ser.addSupervisorEmployee(se);
    }

    @Override
    public List<SupervisorEmployee> getAllSupervisorEmployees() {
        return ser.getAllSupervisorEmployees();
    }

    @Override
    public SupervisorEmployee getSupervisorEmployee(int eID) {
        return ser.getSupervisorEmployee(eID);
    }

    @Override
    public SupervisorEmployee updateSupervisorEmployee(SupervisorEmployee change) {
        return ser.updateSupervisorEmployee(change);
    }

    @Override
    public SupervisorEmployee deleteSupervisorEmployee(int eID) {
        return ser.deleteSupervisorEmployee(eID);
    }
}
