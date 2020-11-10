package nl.quintor.axonhandson.query.person.endpoints;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.quintor.axonhandson.query.person.PersonRegistry;
import nl.quintor.axonhandson.query.person.queries.FindPerson;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("queryPersonsEndpoint")
@RequestMapping(path="persons",method= GET)
@Slf4j
@AllArgsConstructor
public class Persons {
    PersonRegistry registry;
    QueryGateway gateway;
    @GetMapping("/{id}")
    public CompletableFuture<PersonData> findPerson(@PathVariable UUID id){
        log.info("Person query endpoint called with id: {}",id);
        return gateway.query(new FindPerson(id),PersonData.class);

    }
}
