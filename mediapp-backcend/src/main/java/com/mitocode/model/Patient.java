package com.mitocode.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
public class Patient {
    private Integer idPatient;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String phone;
    private String email;
}
