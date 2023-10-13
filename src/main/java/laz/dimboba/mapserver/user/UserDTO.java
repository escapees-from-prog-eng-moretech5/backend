package laz.dimboba.mapserver.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private UUID id;
    private String number;
    private String name;
//    private double addressLatitude;
//    private double addressLongitude;

    public UserDTO(User user) {
        this.id = user.getId();
//        this.addressLatitude = user.getAddressLatitude();
//        this.addressLongitude = user.getAddressLongitude();
        this.name = user.getName();
        this.number = user.getNumber();
    }
}
