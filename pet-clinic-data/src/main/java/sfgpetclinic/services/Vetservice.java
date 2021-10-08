package sfgpetclinic.services;

import sfgpetclinic.model.Vet;

import java.util.Set;

public interface Vetservice {
    Vet findById(Long id);

    Vet save(Vet pet);

    Set<Vet> findAll();
}
