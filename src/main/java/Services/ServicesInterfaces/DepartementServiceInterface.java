package Services.ServicesInterfaces;

import Models.Departement;

import java.util.List;
public interface DepartementServiceInterface {
    void addDepartement(Departement departement);
    Departement getDepartementById(Long id);
    List<Departement> getAllDepartements();
    void updateDepartement(Departement departement);
    void removeDepartement(int id);
}
