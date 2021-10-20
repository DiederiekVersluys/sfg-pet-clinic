package sfgpetclinic.services.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Owner;

import sfgpetclinic.model.Pet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.Petservice;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final Petservice petservice;

    public OwnerServiceMap(PetTypeService petTypeService, Petservice petservice) {
        this.petTypeService = petTypeService;
        this.petservice = petservice;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner save(Owner object) throws Exception {

        if(object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            try {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = null;
                        try {
                            savedPet = petservice.save(pet);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
