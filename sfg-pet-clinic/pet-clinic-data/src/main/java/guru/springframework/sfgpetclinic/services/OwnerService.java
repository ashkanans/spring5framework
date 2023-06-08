package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastname(String lastname);
    Owner findById(long id);
    Owner Save(Owner owner);
    Set<Owner> findAll();
}
