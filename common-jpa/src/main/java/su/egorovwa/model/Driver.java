package su.egorovwa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String phone;
    private String fistName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime registredAt;
    private LocalDateTime updatedAt;
    @OneToMany
    private List<Car> cars;
    @ManyToOne
    private Car currentCat;
    private Boolean isAvalible;

    public Driver(String phone, String fistName, String lastName, String password) {
        this.phone = phone;
        this.fistName = fistName;
        this.lastName = lastName;
        this.password = password;
    }
}
