package laz.dimboba.mapserver.atm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import laz.dimboba.mapserver.office.Office;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "atm_services")
public class AtmServiceData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "atm_id")
    @JsonIgnore
    private Atm atm;

    @Id
    @Column(name = "service")
    @Enumerated(value = EnumType.STRING)
    private Service service;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "capability")
    private Capability capability;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "activity")
    private Activity activity;

}
