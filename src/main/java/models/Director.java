package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // dostarczy gettery, settery, toString
@AllArgsConstructor //dostarczy konstruktor z wszystkimi argumentami
public class Director {
    private String firstName;
    private String lastName;
}
