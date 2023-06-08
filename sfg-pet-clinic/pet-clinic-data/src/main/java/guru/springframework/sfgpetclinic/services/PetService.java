package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(long id);
    Pet Save(Pet owner);
    Set<Pet> findAll();
}
