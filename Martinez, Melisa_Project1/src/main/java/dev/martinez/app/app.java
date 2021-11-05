package dev.martinez.app;

import dev.martinez.controllers.ApprovalController;
import dev.martinez.controllers.EmployeeDBController;
import dev.martinez.controllers.SupervisorEmployeeController;
import dev.martinez.repositories.*;
import dev.martinez.service.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class app {

    public static void main(String[] args) {

        // establish Javalin obj
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        // establish routes / endpoints
        establishRoutes(app);

        app.start();
    }

    private static void establishRoutes(Javalin app) {

        EmployeeDBRepo eDBr = new EmployeeDBRepoImpl();
        EmployeeDBService eDBs = new EmployeeDBServiceImpl(eDBr);
        EmployeeDBController eDBc = new EmployeeDBController(eDBs);

        app.get("/employees", eDBc.getAllEmployeeDB);
        // app.get("/employees/:id", eDBc.getEmployeeDBById);
        app.post("/employees", eDBc.addEmployeeDB);
        app.put("/employees/:id", eDBc.updateEmployeeDB);
        app.delete("/employees/:id", eDBc.deleteEmployeeDB);

        app.get("/employees/:username", eDBc.getEmployeeDBByUsername);

        // Supervisor Enployee
        SupervisorEmployeeRepo ser = new SupervisorEmployeeRepoImpl();
        SupervisorEmployeeService ses = new SupervisorEmployeeServiceImpl(ser);
        SupervisorEmployeeController sec = new SupervisorEmployeeController(ses);

        app.get("/supervisoremployees", sec.getAllSupervisorEmployees);
        app.get("/supervisoremployees/:id", sec.getSupervisorEmployeeById);
        app.post("/supervisoremployees", sec.addSupervisorEmployee);
        app.put("/supervisoremployees/:id", sec.updateSupervisorEmployee);
        app.delete("/supervisoremployees/:id", sec.deleteSupervisorEmployee);

    }

}
