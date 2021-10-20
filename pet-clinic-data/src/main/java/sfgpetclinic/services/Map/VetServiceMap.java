package sfgpetclinic.services.Map;

import org.springframework.stereotype.Service;
import sfgpetclinic.model.Specialty;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.SpecialtiesService;
import sfgpetclinic.services.Vetservice;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements Vetservice {
    private final SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
