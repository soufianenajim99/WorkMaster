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

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}
