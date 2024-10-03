package Services;

import Models.Employee;
import Repositories.RepositoriesInterfaces.EmployeeRepositoryInterface;
import Services.ServicesInterfaces.EmployeeServiceInterface;

import java.util.List;

public class EmployeeService implements EmployeeServiceInterface {
    private final EmployeeRepositoryInterface employeeRepository;

    public EmployeeService(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeRepository.delete(id);
    }
}
