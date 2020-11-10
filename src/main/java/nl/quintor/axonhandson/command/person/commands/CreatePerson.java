package nl.quintor.axonhandson.command.person.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CreatePerson {
    @TargetAggregateIdentifier
    UUID id;
    LocalDate dateOfBirth;
}
