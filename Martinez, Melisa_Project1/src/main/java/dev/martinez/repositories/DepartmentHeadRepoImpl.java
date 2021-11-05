package dev.martinez.repositories;

import dev.martinez.models.DepartmentHead;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DepartmentHeadRepoImpl implements DepartmentHeadRepo{

    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead dh) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            // dh.setDeptHead((int)session.save(dh));

            dh.setDeptHeadId((int)session.save(dh));

            // dh.setDeptHead(dh.getDeptHead().geteID(int)session.save(dh)));

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            dh = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return dh;
    }

    @Override
    public List<DepartmentHead> getAllDepartmentHeads() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<DepartmentHead> departmentHeadFails = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            departmentHeadFails = session.createQuery("FROM DepartmentHead").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return departmentHeadFails;
    }

    @Override
    public DepartmentHead getDepartmentHead(int id)  {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        DepartmentHead dh = null;

        try {
            dh = session.get(DepartmentHead.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dh;
    }

    @Override
    public DepartmentHead getDepartmentHead(DepartmentHead dID) {

        DepartmentHead dh = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(DepartmentHead.class);
            crit.add(Restrictions.eq("dID", dID));

            dh = (DepartmentHead) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return dh;
    }

    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead change) {

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
    public DepartmentHead deleteDepartmentHead(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        DepartmentHead dh = null;

        try {
            tx = session.beginTransaction();
            dh = session.get(DepartmentHead.class, id);
            session.delete(dh);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return dh;
    }
}
