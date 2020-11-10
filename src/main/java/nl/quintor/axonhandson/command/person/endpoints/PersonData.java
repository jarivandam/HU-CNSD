package nl.quintor.axonhandson.command.person.endpoints;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonData {
    LocalDate dateOfBirth;
}
