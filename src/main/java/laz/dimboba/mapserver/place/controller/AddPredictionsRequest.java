package laz.dimboba.mapserver.place.controller;

import laz.dimboba.mapserver.office.data.OfficeData;
import laz.dimboba.mapserver.prediction.Prediction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddPredictionsRequest implements Serializable {
    private String password;
    private List<OfficeData> officeData;
}
