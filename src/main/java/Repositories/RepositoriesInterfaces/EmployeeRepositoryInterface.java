package Repositories.RepositoriesInterfaces;

import Models.Employee;

import java.util.List;
public interface EmployeeRepositoryInterface {
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(int id);
    List<Employee> searchEmployees(String keyword);
}
