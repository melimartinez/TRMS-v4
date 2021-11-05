package dev.martinez.app;

import dev.martinez.controllers.*;
import dev.martinez.models.EmployeeDB;
import dev.martinez.repositories.*;
import dev.martinez.service.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class AppTest {

    public static void main(String[] args) {

        // establish Javalin obj
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        
        // establish routes / endpoints
        establishRoutes(app);

        establishApprovalRoutes(app);
        establishDepartmentRoutes(app);
        establishDepartmentHeadRoutes(app);

        establishEmployeeDBRoutes(app);
        establishFormDBRoutes(app);
        establishGradingFormatRoutes(app);
        establishReimbursementEventRoutes(app);
        establishSupervisorEmployeeRoutes(app);
        
        app.start();
    }

    private static void establishRoutes(Javalin app) {

        // test
        app.get("/hello", (context) -> context.result("Hello World!"));

    }

    private static void establishApprovalRoutes(Javalin app) {

        ApprovalRepo ar = new ApprovalRepoImpl();
        ApprovalService as = new ApprovalServiceImpl(ar);
        ApprovalController ac = new ApprovalController(as);

        app.get("/approvals", ac.getAllApprovals);
        app.get("/approvals/:id", ac.getApprovalById);
        app.post("/approvals", ac.addApproval);
        app.put("/approvals/:id", ac.updateApproval);
        app.delete("/approvals/:id", ac.deleteApproval);

    }

    private static void establishDepartmentRoutes(Javalin app) {

        DepartmentRepo dr = new DepartmentRepoImpl();
        DepartmentService ds = new DepartmentServiceImpl(dr);
        DepartmentController dc = new DepartmentController(ds);

        app.get("/departments", dc.getAllDepartments);
        app.get("/departments/:id", dc.getDepartmentById);
        app.post("/departments", dc.addDepartment);
        app.put("/departments/:id", dc.updateDepartment);
        app.delete("/departments/:id", dc.deleteDepartment);

    }

    private static void establishDepartmentHeadRoutes(Javalin app) {

        DepartmentHeadRepo dhr = new DepartmentHeadRepoImpl();
        DepartmentHeadService dhs = new DepartmentHeadServiceImpl(dhr);
        DepartmentHeadController dhc = new DepartmentHeadController(dhs);

        app.get("/departmentheads", dhc.getAllDepartmentHeads);
        app.get("/departmentheads/:id", dhc.getDepartmentHeadById);
        app.post("/departmentheads", dhc.addDepartmentHead);
        app.put("/departmentheads/:id", dhc.updateDepartmentHead);
        app.delete("/departmentheads/:id", dhc.deleteDepartmentHead);

    }

    private static void establishEmployeeDBRoutes(Javalin app) {

        EmployeeDBRepo eDBr = new EmployeeDBRepoImpl();
        EmployeeDBService eDBs = new EmployeeDBServiceImpl(eDBr);
        EmployeeDBController eDBc = new EmployeeDBController(eDBs);

        app.get("/employees", eDBc.getAllEmployeeDB);
        app.get("/employee/:id", eDBc.getEmployeeDBById);
        app.post("/employees", eDBc.addEmployeeDB);
        app.put("/employees/:id", eDBc.updateEmployeeDB);
        app.delete("/employees/:id", eDBc.deleteEmployeeDB);

        app.get("/employees/:username", eDBc.getEmployeeDBByUsername);

    }

    private static void establishFormDBRoutes(Javalin app) {

        FormDBRepo fDBr = new FormDBRepoImpl();
        FormDBService fDBs = new FormDBServiceImpl(fDBr);
        FormDBController fDBc = new FormDBController(fDBs);

        app.get("/forms", fDBc.getAllFormDBs);
        app.get("/forms/:id", fDBc.getFormDBById);
        app.post("/forms", fDBc.addFormDB);
        app.put("/forms/:id", fDBc.updateFormDB);
        app.delete("/forms/:id", fDBc.deleteFormDB);

        app.get("/:employees/:id/forms", fDBc.getEmployeeForms);

    }

    private static void establishGradingFormatRoutes(Javalin app) {

        GradingFormatRepo gfr = new GradingFormatRepoImpl();
        GradingFormatService gfs = new GradingFormatServiceImpl(gfr);
        GradingFormatController gfc = new GradingFormatController(gfs);

        app.get("/gradingformats", gfc.getAllGradingFormats);
        app.get("/gradingformats/:id", gfc.getGradingFormatById);
        app.post("/gradingformats", gfc.addGradingFormat);
        app.put("/gradingformats/:id", gfc.updateGradingFormat);
        app.delete("/gradingformats/:id", gfc.deleteGradingFormat);

    }

    private static void establishReimbursementEventRoutes(Javalin app) {

        ReimbursementEventRepo rer = new ReimbursementEventRepoImpl();
        ReimbursementEventService res = new ReimbursementEventServiceImpl(rer);
        ReimbursementEventController rec = new ReimbursementEventController(res);

        app.get("/events", rec.getAllReimbursementEvents);
        app.get("/events/:id", rec.getReimbursementEventById);
        app.post("/events", rec.addReimbursementEvent);
        app.put("/events/:id", rec.updateReimbursementEvent);
        app.delete("/events/:id", rec.deleteReimbursementEvent);

        app.get("/event/:typeOf", rec.getGetReimbursementEventByType);

    }

    private static void establishSupervisorEmployeeRoutes(Javalin app) {

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
