package dev.martinez.repositories;

import dev.martinez.models.Approval;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ApprovalRepoImpl implements ApprovalRepo{

    @Override
    public Approval addApproval(Approval a) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            a.setaID((int)session.save(a));

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            a = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return a;
    }

    @Override
    public List<Approval> getAllApprovals() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<Approval> approvals = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            approvals = session.createQuery("FROM Approval").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return approvals;
    }

    @Override
    public Approval getApproval(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Approval a = null;

        try {
            a = session.get(Approval.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Approval getApproval(String status) {

        Approval a = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(Approval.class);
            crit.add(Restrictions.eq("status", status));

            a = (Approval) crit.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return a;
    }

    @Override
    public Approval updateApproval(Approval change) {

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
    public Approval deleteAccount(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        Approval a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(Approval.class, id);
            session.delete(a);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return a;
    }
}
