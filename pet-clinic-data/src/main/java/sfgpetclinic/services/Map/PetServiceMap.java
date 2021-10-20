package sfgpetclinic.services.Map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Pet;

import sfgpetclinic.services.Petservice;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements Petservice {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Pet object) {
        super.delete(object);

    }

    @Override
    public Pet save(Pet object) throws Exception {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
