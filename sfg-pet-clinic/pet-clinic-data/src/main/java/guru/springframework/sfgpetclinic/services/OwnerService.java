package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Locale;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastname(String lastname);

}
