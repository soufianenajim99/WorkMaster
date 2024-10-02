package Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table(name = "departements")
public class Departement {
    private int id;
    private String name;
    private Set<Employee> employees;

    public Departement() {

    }
    public Departement(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public Departement(String name) {
        this();


        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
