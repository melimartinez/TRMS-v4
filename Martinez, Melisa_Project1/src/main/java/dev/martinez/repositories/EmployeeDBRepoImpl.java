package dev.martinez.repositories;

import dev.martinez.models.EmployeeDB;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EmployeeDBRepoImpl implements EmployeeDBRepo{

    @Override
    public EmployeeDB addEmployee(EmployeeDB eDB) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            eDB.seteID((int)session.save(eDB));

            tx.commit();
        } catch (HibernateException error) {
            error.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            eDB = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return eDB;
    }

    @Override
    public List<EmployeeDB> getAllEmployees() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<EmployeeDB> employeeDBList = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            employeeDBList = session.createQuery("FROM EmployeeDB").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeDBList;
    }

    @Override
    public EmployeeDB getEmployee(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        EmployeeDB eDB = null;

        try {
            eDB = session.get(EmployeeDB.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return eDB;
    }

    @Override
    public EmployeeDB getEmployee(String username) {

        EmployeeDB eDB = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(EmployeeDB.class);
            crit.add(Restrictions.eq("username", username));

            // eDB = (EmployeeDB) crit.uniqueResult();

            // in case there are various names that match
            // we create a list instead since we cannot
            // guarantee it will be a unique result
            List<EmployeeDB> employeeDBList = crit.list();

            // if the size of the list is larger than 0
            if (employeeDBList.size() > 0) {
                eDB = (EmployeeDB) employeeDBList.get(0);   // add the firs found instance to our object
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return eDB;
    }

    @Override
    public EmployeeDB updateEmployee(EmployeeDB change) {

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
    public EmployeeDB deleteEmployee(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        EmployeeDB eDB = null;

        try {
            tx = session.beginTransaction();
            eDB = session.get(EmployeeDB.class, id);
            session.delete(eDB);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return eDB;
    }
}
