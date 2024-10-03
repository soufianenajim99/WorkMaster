package Repositories;

import Models.Departement;
import Repositories.RepositoriesInterfaces.DepartementRepositoryInterface;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartementRepository implements DepartementRepositoryInterface {
    @Override
    public void save(Departement departement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Persisting the Departement entity with its employees
            session.save(departement);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Departement findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Departement departement = session.get(Departement.class, id);
            // Initializing the employees collection (avoiding lazy loading issues)
            if (departement != null) {
                departement.getEmployees().size();
            }
            return departement;
        }
    }

    @Override
    public List<Departement> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Departement", Departement.class).list();
        }
    }

    @Override
    public void update(Departement departement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(departement);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Departement departement = session.get(Departement.class, id);
            if (departement != null) {
                session.delete(departement);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
