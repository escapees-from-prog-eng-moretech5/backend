package laz.dimboba.mapserver.atm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "atms")
public class Atm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany
    @JoinColumn(name = "atm_id")
    private List<AtmServiceData> services;

    @Column(name = "code")
    private String code;

    @Column(name = "bnkcd")
    private String bnkcd;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "all_day")
    private boolean allday;
}
