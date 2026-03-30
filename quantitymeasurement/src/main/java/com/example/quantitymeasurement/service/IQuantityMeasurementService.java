package com.example.quantitymeasurement.service;


import com.example.quantitymeasurement.dto.QuantityInputDTO;
import com.example.quantitymeasurement.dto.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO add(QuantityInputDTO input);

    QuantityMeasurementDTO subtract(QuantityInputDTO input);

    QuantityMeasurementDTO divide(QuantityInputDTO input);

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO convert(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getByAction(String action);

    List<QuantityMeasurementDTO> getByType(String type);

    long getCount(String action);
}