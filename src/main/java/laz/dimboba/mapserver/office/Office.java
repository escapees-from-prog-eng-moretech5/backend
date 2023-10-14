package laz.dimboba.mapserver.office;

import jakarta.persistence.*;
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
@Table(name = "offices")
public class Office implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "sale_point_name")
    private String salePointName;

    @Column(name = "address")
    private String address;

    @Column(name = "sale_point_code")
    private String salePointCode;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "rko")
    private boolean rko;

    @Column(name = "network")
    private String network;

    @Column(name = "office_type")
    private String officeType;

    @Column(name = "suo_availability")
    private boolean suoAvailability;

    @Column(name = "has_ramp")
    private boolean hasRamp;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "metroStation")
    private String metroStation;

    @Column(name = "distance")
    private double precision;

    @Column(name = "kep")
    private boolean kep;

    @Column(name = "my_branch")
    private boolean myBranch;
}
