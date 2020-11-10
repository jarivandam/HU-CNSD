package nl.quintor.axonhandson.query.person;

import nl.quintor.axonhandson.query.person.endpoints.PersonData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRegistry extends CrudRepository<PersonData, UUID> {

}
