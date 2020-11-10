package nl.quintor.axonhandson.query.person.queries;

import lombok.AllArgsConstructor;
import nl.quintor.axonhandson.query.person.PersonRegistry;
import nl.quintor.axonhandson.query.person.endpoints.PersonData;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PersonInvestigator {
    PersonRegistry registry;

    @QueryHandler
    public PersonData findPerson(FindPerson query){
        return registry.findById(query.id).orElseThrow();
    }
}
