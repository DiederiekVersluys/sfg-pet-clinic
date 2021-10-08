package sfgpetclinic.services;

import sfgpetclinic.model.Pet;

import java.util.Set;

public interface Petservice {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
