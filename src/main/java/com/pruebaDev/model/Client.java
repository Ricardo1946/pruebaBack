package com.pruebaDev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phone;
    private String address;
    private String cityOfResidence;

}
