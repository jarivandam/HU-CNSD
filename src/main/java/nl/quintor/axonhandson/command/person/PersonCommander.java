package nl.quintor.axonhandson.command.person;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.quintor.axonhandson.command.person.commands.CreatePerson;
import nl.quintor.axonhandson.command.person.endpoints.PersonData;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class PersonCommander {
    CommandGateway commandGateway;

    public UUID createPerson(PersonData personData){
        UUID id = UUID.randomUUID();
        var command = new CreatePerson(id,personData.getDateOfBirth());
        log.info("Sending command....");
        commandGateway.send(command);
        return id;
    }


}
