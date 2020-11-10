package nl.quintor.axonhandson.command.person;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.quintor.axonhandson.command.person.commands.CreatePerson;
import nl.quintor.axonhandson.command.person.events.PersonCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Slf4j
public class Person {
    @AggregateIdentifier
    UUID id;
    @CommandHandler
    public Person(CreatePerson person) {
        log.info("PersonConstructor called with data={}",person);
        PersonCreated personCreated = new PersonCreated(person.getId(),person.getDateOfBirth());
        AggregateLifecycle.apply(personCreated);
    }
    @EventSourcingHandler
    public void handlePersonCreated(PersonCreated event){
        log.info("Handling event event: {}",event);
        this.id = event.getId();
    }
}
