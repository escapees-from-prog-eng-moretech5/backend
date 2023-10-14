package laz.dimboba.mapserver.atm;

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
@Table(name = "atm_services")
@IdClass(AtmServiceData.AtmServiceID.class)
public class AtmServiceData {

    @Id
    @Column(name = "atm_id")
    private UUID atmId;

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

    @AllArgsConstructor
    @Data
    static class AtmServiceID implements Serializable {
        private UUID atmId;
        private String service;
    }
}
