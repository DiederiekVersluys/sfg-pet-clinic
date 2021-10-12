package sfgpetclinic.services.Map;

import sfgpetclinic.model.Vet;
import sfgpetclinic.services.CrudService;
import sfgpetclinic.services.Vetservice;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements Vetservice {
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
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
