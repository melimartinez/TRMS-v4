package dev.martinez.repositories;

import dev.martinez.models.Department;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DepartmentRepoImpl implements DepartmentRepo {

    @Override
    public Department addDepartment(Department d) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            d.setdID((int)session.save(d));

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
            { tx.rollback(); }
            d = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return d;
    }

    @Override
    public List<Department> getAllDepartments() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<Department> departments = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            departments = session.createQuery("FROM Department").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return departments;
    }

    @Override
    public Department getDepartment(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Department d = null;

        try {
            d = session.get(Department.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return d;
    }

    @Override
    public Department getDepartment(Department dID) {

        Department d = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(Department.class);
            crit.add(Restrictions.eq("d_id", dID));

            d = (Department) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return d;
    }

    @Override
    public Department updateDepartment(Department change) {

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
    public Department deleteDepartment(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        Department d = null;

        try {
            tx = session.beginTransaction();
            d = session.get(Department.class, id);
            session.delete(d);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
            { tx.rollback(); }
        } finally {
            session.close();
        }

        return d;
    }
}
