package Repositories;
import Models.Employee;
import Repositories.RepositoriesInterfaces.EmployeeRepositoryInterface;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class EmployeeRepository implements EmployeeRepositoryInterface {

    @Override
    public void save(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Saving the employee with a reference to its Departement
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, id);
            // Initialize the department association
            if (employee != null) {
                employee.getDepartement().getName();
            }
            return employee;
        }
    }

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select e from Employee e join fetch e.departement").list();
        }
    }

    @Override
    public void update(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
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
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchEmployees(String keyword) {
        List<Employee> employees = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Eagerly load the 'departement' with join fetch
            String hql = "select e from Employee e join fetch e.departement " +
                    "WHERE e.name LIKE :keyword OR e.email LIKE :keyword OR e.post LIKE :keyword";

            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("keyword", "%" + keyword + "%");
            employees = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employees;
    }


}
