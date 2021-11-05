package dev.martinez.repositories;

import dev.martinez.models.GradingFormat;
import dev.martinez.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GradingFormatRepoImpl implements GradingFormatRepo{

    @Override
    public GradingFormat addGradingFormat(GradingFormat gf) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var

        try {
            tx = session.beginTransaction();

            // session.save(obj) returns a SERIALIZABLE that we
            // can cast into an int and set as the id of the current
            // object we are working with
            gf.setgID((int)session.save(gf));

            tx.commit();
        } catch (HibernateException error) {
            error.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
            gf = null;  // signals that there has been an error
        } finally {
            session.close();    // always close out the session
        }

        return gf;
    }

    @Override
    public List<GradingFormat> getAllGradingFormats() {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        List<GradingFormat> gradingFormatList = null;

        try {
            // SQL -> SELECT * FROM approval
            // HQL -> Hibernate Query Language
            // 1.) only have to reference your Java Classes
            // 2.) do NOT have to adjust your code per each RDBMS
            gradingFormatList = session.createQuery("FROM GradingFormat").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return gradingFormatList;
    }

    @Override
    public GradingFormat getGradingFormat(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        GradingFormat gf = null;

        try {
            gf = session.get(GradingFormat.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return gf;
    }

    @Override
    public GradingFormat getGradingFormat(String requirement) {

        GradingFormat gf = null;

        try (Session session = HibernateUtil.getSession()) {
            Criteria crit = session.createCriteria(GradingFormat.class);
            crit.add(Restrictions.eq("requirement", requirement));

            // eDB = (EmployeeDB) crit.uniqueResult();

            // in case there are various names that match
            // we create a list instead since we cannot
            // guarantee it will be a unique result
            List<GradingFormat> gradingFormatList = crit.list();

            // if the size of the list is larger than 0
            if (gradingFormatList.size() > 0) {
                gf = (GradingFormat) gradingFormatList.get(0);   // add the firs found instance to our object
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return gf;
    }

    @Override
    public GradingFormat updateGradingFormat(GradingFormat change) {

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
    public GradingFormat deleteGradingFormat(int id) {

        // open communication with our database
        Session session = HibernateUtil.getSession();
        Transaction tx = null;  // because it is a DML, we declare a Transaction var
        GradingFormat gf = null;

        try {
            tx = session.beginTransaction();
            gf = session.get(GradingFormat.class, id);
            session.delete(gf);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                { tx.rollback(); }
        } finally {
            session.close();
        }

        return gf;
    }
}
