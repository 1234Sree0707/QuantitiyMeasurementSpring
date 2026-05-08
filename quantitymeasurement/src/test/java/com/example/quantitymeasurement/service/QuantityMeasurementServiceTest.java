package com.example.quantitymeasurement.service;

import com.example.quantitymeasurement.dto.QuantityDTO;
import com.example.quantitymeasurement.dto.QuantityInputDTO;
import com.example.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.example.quantitymeasurement.repository.QuantityMeasurementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuantityMeasurementServiceTest {

    @Mock
    private QuantityMeasurementRepository repository;

    @InjectMocks
    private QuantityMeasurementService service;

    private QuantityInputDTO createInput(double v1, double v2) {
        QuantityDTO q1 = new QuantityDTO(v1, "m", "Meter", "length");
        QuantityDTO q2 = new QuantityDTO(v2, "m", "Meter", "length");

        QuantityInputDTO input = new QuantityInputDTO();
        input.setThisQuantity(q1);
        input.setThatQuantity(q2);

        return input;
    }

    @Test
    void shouldAddQuantitiesSuccessfully() {

        QuantityInputDTO input = createInput(10, 5);

        when(repository.save(any(QuantityMeasurementEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var result = service.add(input);

        assertEquals("ADD", result.getAction());
        assertEquals(15.0, result.getResult());

        verify(repository, times(1))
                .save(any(QuantityMeasurementEntity.class));
    }

    @Test
    void shouldSubtractQuantitiesSuccessfully() {

        QuantityInputDTO input = createInput(10, 3);

        when(repository.save(any(QuantityMeasurementEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var result = service.subtract(input);

        assertEquals("SUBTRACT", result.getAction());
        assertEquals(7.0, result.getResult());
    }

    @Test
    void shouldDivideQuantitiesSuccessfully() {

        QuantityInputDTO input = createInput(20, 4);

        when(repository.save(any(QuantityMeasurementEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var result = service.divide(input);

        assertEquals("DIVIDE", result.getAction());
        assertEquals(5.0, result.getResult());
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {

        QuantityInputDTO input = createInput(10, 0);

        assertThrows(RuntimeException.class,
                () -> service.divide(input));
    }

    @Test
    void shouldCompareQuantities() {

        QuantityInputDTO input = createInput(10, 10);

        when(repository.save(any(QuantityMeasurementEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var result = service.compare(input);

        assertEquals("COMPARE", result.getAction());
        assertEquals("Equal", result.getResultString());
    }
}



