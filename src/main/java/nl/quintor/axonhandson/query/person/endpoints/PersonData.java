package nl.quintor.axonhandson.query.person.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class PersonData {
    @Id
    UUID id;
    @Column(nullable = false)
    LocalDate dateOfBirth;
}
