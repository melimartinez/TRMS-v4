package dev.martinez.repositories;

import dev.martinez.models.ReimbursementEvent;
import dev.martinez.models.SupervisorEmployee;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SupervisorEmployeeRepoImpl implements SupervisorEmployeeRepo{

    @Override
    public SupervisorEmployee addSupervisorEmployee(SupervisorEmployee se) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            se.setsID((int)session.save(se));

            tx.commit();
        } catch (HibernateException error) {
            error.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            se = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return se;
    }

    @Override
    public List<SupervisorEmployee> getAllSupervisorEmployees() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<SupervisorEmployee> supervisorEmployeeList = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            supervisorEmployeeList = session.createQuery("FROM SupervisorEmployee").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return supervisorEmployeeList;
    }

    @Override
    public SupervisorEmployee getSupervisorEmployee(int eID) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        SupervisorEmployee se = null;

        try {
            se = session.get(SupervisorEmployee.class, eID);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return se;
    }

    @Override
    public SupervisorEmployee updateSupervisorEmployee(SupervisorEmployee change) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
            { tx.rollback(); }
            return null;    // signals that there has been an error
        } finally {
            session.close();
        }

        return change;
    }

    @Override
    public SupervisorEmployee deleteSupervisorEmployee(int eID) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        SupervisorEmployee se = null;

        try {
            tx = session.beginTransaction();
            se = session.get(SupervisorEmployee.class, eID);
            session.delete(se);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return se;
    }
}
