import Models.Departement;
import Models.Employee;
import Repositories.DepartementRepository;
import Repositories.EmployeeRepository;
import Repositories.RepositoriesInterfaces.DepartementRepositoryInterface;
import Repositories.RepositoriesInterfaces.EmployeeRepositoryInterface;
import Services.DepartementService;
import Services.EmployeeService;
import Services.ServicesInterfaces.DepartementServiceInterface;
import Services.ServicesInterfaces.EmployeeServiceInterface;
import Utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartementRepositoryInterface departementRepository = new DepartementRepository();
        EmployeeRepositoryInterface employeeRepository = new EmployeeRepository();

        DepartementServiceInterface departementService = new DepartementService(departementRepository);
        EmployeeServiceInterface employeeService = new EmployeeService(employeeRepository);
        Departement newDepartement = new Departement("Human Resources");
//        departementService.addDepartement(newDepartement);

        List<Departement> departements = departementService.getAllDepartements();
        System.out.println("All Departements:");
        for (Departement d : departements) {
            System.out.println("Departement ID: " + d.getId() + ", Name: " + d.getName());
        }

        Departement hrDepartement = departementService.getDepartementById(2);


        Employee newEmployee1 = new Employee("Alice Johnsons", "alice@exasmple.com", "55515234", "HR Specialsist",hrDepartement);
//        employeeService.addEmployee(newEmployee1);

//
//        List<Employee> employees = employeeService.getAllEmployees();
//        System.out.println("All Employees:");
//        for (Employee e : employees) {
//            System.out.println("Employee ID: " + e.getId() + ", Name: " + e.getName() + ", Department: " + e.getDepartement().getName());
//        }

        // 5. Test DepartementService: Update department name
//        hrDepartement.setName("HR Department");
//        departementService.updateDepartement(hrDepartement);
//        System.out.println("Updated Departement Name: " + hrDepartement.getName());


        // 6. Test EmployeeService: Update employee details
        Employee existingEmployee = employeeService.getEmployeeById(1);
        employeeService.removeEmployee(existingEmployee.getId());
        System.out.println("Deleted Employee with ID: " + existingEmployee.getId());

    }
}
