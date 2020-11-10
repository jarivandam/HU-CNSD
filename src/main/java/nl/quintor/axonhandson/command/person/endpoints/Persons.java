package nl.quintor.axonhandson.command.person.endpoints;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.quintor.axonhandson.command.person.PersonCommander;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("commandPersonsEndpoint")
@RequestMapping(path="persons")
@Slf4j
@AllArgsConstructor
public class Persons {
    private PersonCommander commander;

    @PostMapping
    public UUID createPerson(@RequestBody PersonData data) {
        log.info("Entered createPerson endpoint: data={}", data);
        var res = commander.createPerson(data);
        return res;
    }
}
