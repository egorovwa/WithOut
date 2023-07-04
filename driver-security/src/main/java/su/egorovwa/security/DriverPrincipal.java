package su.egorovwa.security;

import lombok.Data;

import java.security.Principal;
@Data
public class DriverPrincipal implements Principal {
    private Long id;

    /**
     * Аутефикация по номеру телефона "name = driver phone number"
     */
    private String name; //phone  number

    public DriverPrincipal(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
