package com.example.demo.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class User {
    @Id
    private final UUID id;
    private final String name;
    private final Permissions permissions;

    public static enum Permissions {
        READ, WRITE
    }
}
