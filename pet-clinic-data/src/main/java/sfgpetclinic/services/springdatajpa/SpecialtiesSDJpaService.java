package sfgpetclinic.services.springdatajpa;

import sfgpetclinic.model.Specialty;
import sfgpetclinic.repositories.SpecialtyRepository;
import sfgpetclinic.services.SpecialtiesService;

import java.util.HashSet;
import java.util.Set;

public class SpecialtiesSDJpaService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtiesSDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
    specialtyRepository.deleteById(aLong);
    }
}
