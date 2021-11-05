package dev.martinez.repositories;

import dev.martinez.models.GradingFormat;
import dev.martinez.models.ReimbursementEvent;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ReimbursementEventRepoImpl implements ReimbursementEventRepo{
    @Override
    public ReimbursementEvent addReimbursementEvent(ReimbursementEvent re) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            re.setrID((int)session.save(re));

            tx.commit();
        } catch (HibernateException error) {
            error.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            re = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return re;
    }

    @Override
    public List<ReimbursementEvent> getAllReimbursementEvents() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<ReimbursementEvent> reimbursementEventList = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            reimbursementEventList = session.createQuery("FROM ReimbursementEvent").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return reimbursementEventList;
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        ReimbursementEvent re = null;

        try {
            re = session.get(ReimbursementEvent.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return re;
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(String typeOf) {

        ReimbursementEvent re = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(ReimbursementEvent.class);
            crit.add(Restrictions.eq("typeOf", typeOf));

            // eDB = (EmployeeDB) crit.uniqueResult();

            // in case there are various names that match
            // we create a list instead since we cannot
            // guarantee it will be a unique result
            List<ReimbursementEvent> reimbursementEventList = crit.list();

            // if the size of the list is larger than 0
            if (reimbursementEventList.size() > 0) {
                re = (ReimbursementEvent) reimbursementEventList.get(0);   // add the firs found instance to our object
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return re;
    }

    @Override
    public ReimbursementEvent updateReimbursementEvent(ReimbursementEvent change) {

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
    public ReimbursementEvent deleteReimbursementEvent(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        ReimbursementEvent re = null;

        try {
            tx = session.beginTransaction();
            re = session.get(ReimbursementEvent.class, id);
            session.delete(re);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return re;
    }

    @Override
    public ReimbursementEvent getReimbursementEvent(String typeOf, long startDate) {

        ReimbursementEvent re = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(ReimbursementEvent.class);

            crit.add(Restrictions.eq("type_of", typeOf));
            crit.add(Restrictions.eq("start_date", startDate));

            // eDB = (EmployeeDB) crit.uniqueResult();

            // in case there are various names that match
            // we create a list instead since we cannot
            // guarantee it will be a unique result
            List<ReimbursementEvent> reimbursementEventList = crit.list();

            // if the size of the list is larger than 0
            if (reimbursementEventList.size() > 0) {
                re = (ReimbursementEvent) reimbursementEventList.get(0);   // add the firs found instance to our object
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return re;

    }
}
