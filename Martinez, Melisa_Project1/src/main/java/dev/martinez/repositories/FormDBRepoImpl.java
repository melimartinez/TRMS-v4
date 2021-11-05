package dev.martinez.repositories;

import dev.martinez.models.Department;
import dev.martinez.models.EmployeeDB;
import dev.martinez.models.Form;
import dev.martinez.models.FormDB;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.util.List;

public class FormDBRepoImpl implements FormDBRepo{
    @Override
    public FormDB addForm(FormDB fDB) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            fDB.setfID((int)session.save(fDB));

            tx.commit();
        } catch (HibernateException error) {
            error.printStackTrace();
            if (tx != null)
            { tx.rollback(); }
            fDB = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return fDB;
    }

    @Override
    public List<FormDB> getAllForms() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<FormDB> formDBList = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            formDBList = session.createQuery("FROM FormDB").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return formDBList;
    }

    @Override
    public FormDB getForm(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        FormDB fDB = null;

        try {
            fDB = session.get(FormDB.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return fDB;
    }

    @Override
    public FormDB getForm(FormDB eID) {

        FormDB fDB = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(Department.class);
            crit.add(Restrictions.eq("e_id", eID));

            fDB = (FormDB) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return fDB;
    }

    @Override
    public FormDB updateForm(FormDB change) {

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
    public FormDB deleteForm(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        FormDB fDB = null;

        try {
            tx = session.beginTransaction();
            fDB = session.get(FormDB.class, id);
            session.delete(fDB);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return fDB;
    }

    @Override
    public List<FormDB> getAllEmployeeForms(int eID) {

        List<FormDB> formList = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(FormDB.class);
            crit.add(Restrictions.eq("eID", eID));

           formList = crit.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return formList;

    }
}
