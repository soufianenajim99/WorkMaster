package Repositories.RepositoriesInterfaces;

import Models.Employee;

import java.util.List;
public interface EmployeeRepositoryInterface {
    void save(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(int id);
}
