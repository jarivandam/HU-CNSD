package nl.quintor.axonhandson.query.person;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.quintor.axonhandson.command.person.events.PersonCreated;
import nl.quintor.axonhandson.query.person.endpoints.PersonData;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class PersonProjector {
    PersonRegistry registry;

    @EventHandler
    public void handleEventCreated(PersonCreated event){
        PersonData personData = new PersonData(event.getId(),event.getDateOfBirth());
        registry.save(personData);
        log.info("Stored data in registry data:{}",personData);
    }
}
