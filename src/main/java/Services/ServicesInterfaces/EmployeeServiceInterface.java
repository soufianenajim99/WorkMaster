package Services.ServicesInterfaces;

import Models.Employee;

import java.util.List;
public interface EmployeeServiceInterface {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void removeEmployee(int id);
}
