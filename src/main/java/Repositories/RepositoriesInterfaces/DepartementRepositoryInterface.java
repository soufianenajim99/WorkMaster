package Repositories.RepositoriesInterfaces;

import Models.Departement;

import java.util.List;

public interface DepartementRepositoryInterface {
    void save(Departement departement);
    Departement findById(Long id);
    List<Departement> findAll();
    void update(Departement departement);
    void delete(int id);
}
