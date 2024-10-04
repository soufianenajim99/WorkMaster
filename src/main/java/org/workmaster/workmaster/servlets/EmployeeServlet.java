package org.workmaster.workmaster.servlets;

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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "employee",value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceInterface employeeService;
    private EmployeeRepositoryInterface employeeRepository;

    private DepartementServiceInterface departementService;
    private DepartementRepositoryInterface departementRepository;

    @Override
    public void init() throws ServletException {
        // Initialize the EmployeeService
        employeeRepository = new EmployeeRepository();
        employeeService = new EmployeeService(employeeRepository);
        departementRepository = new DepartementRepository();
        departementService = new DepartementService(departementRepository);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out;
        int employeeId;
        switch (action != null ? action : "") {
            case "create":
                // Display form to create a new employee
                request.getRequestDispatcher("/views/create_employee.jsp").forward(request, response);
                break;

            case "edit":
                // Retrieve employee by ID for editing
                employeeId = Integer.parseInt(request.getParameter("id"));
                Employee employee = employeeService.getEmployeeById(employeeId);

                // Set employee details in the request
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("/views/edit_employee.jsp").forward(request, response);
                break;

            case "delete":
                // Delete employee by ID
                employeeId = Integer.parseInt(request.getParameter("id"));
                employeeService.removeEmployee(employeeId);

                // Redirect to the list page after deletion
                response.sendRedirect(request.getContextPath() + "/employee");
                break;

            case "search":
                // Search employees based on a keyword (name, email, or post)
//                String searchTerm = request.getParameter("keyword");
//                List<Employee> filteredEmployees = employeeService.getEmployees(searchTerm);
                List<Employee> employeees = employeeService.getAllEmployees();

//                 Set filtered list in the request
                request.setAttribute("employees", employeees);
                request.getRequestDispatcher("/views/employees.jsp").forward(request, response);
                break;

            default:
                // Default case: Display the list of all employees
                List<Employee> employees = employeeService.getAllEmployees();
                request.setAttribute("employees", employees);
                request.getRequestDispatcher("/views/employees.jsp").forward(request, response);
                break;
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String post = request.getParameter("post");
//        int departmentId = Integer.parseInt(request.getParameter("department_id"));
//        Departement depat = this.departementService.getDepartementById(departmentId);
//        Employee employee = new Employee(name, email, phone, post, depat);
//        this.employeeService.addEmployee(employee);
//        response.sendRedirect("employee");
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Handle creating a new employee
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String post = request.getParameter("post");
            int departementId = Integer.parseInt(request.getParameter("department_id"));
            Departement depat = this.departementService.getDepartementById(departementId);

            // Create and save a new employee
            Employee newEmployee = new Employee(name, email, phone, post, depat);
            employeeService.addEmployee(newEmployee);

            // Redirect to the employee list
            response.sendRedirect("employee");

        } else if ("update".equals(action)) {
            // Handle updating an existing employee
            int employeeId = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String post = request.getParameter("post");
            int departementId = Integer.parseInt(request.getParameter("department_id"));
            Departement depat = this.departementService.getDepartementById(departementId);


            Employee employeeToUpdate = employeeService.getEmployeeById(employeeId);
            employeeToUpdate.setName(name);
            employeeToUpdate.setEmail(email);
            employeeToUpdate.setPhone(phone);
            employeeToUpdate.setPost(post);
            employeeToUpdate.setDepartement(depat);
            employeeService.updateEmployee(employeeToUpdate);
            response.sendRedirect("employee");

        }
    }
}
