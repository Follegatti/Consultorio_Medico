package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;
    @Column(nullable = false, length = 60, unique = true)
    private String userName;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false)
    private boolean enable;
}
