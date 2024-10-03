package Services;

import Models.Departement;
import Repositories.RepositoriesInterfaces.DepartementRepositoryInterface;
import Services.ServicesInterfaces.DepartementServiceInterface;

import java.util.List;

public class DepartementService implements DepartementServiceInterface {
    private final DepartementRepositoryInterface departementRepository;

    public DepartementService(DepartementRepositoryInterface departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public void addDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public void updateDepartement(Departement departement) {
        departementRepository.update(departement);
    }

    @Override
    public void removeDepartement(int id) {
        departementRepository.delete(id);
    }
}
