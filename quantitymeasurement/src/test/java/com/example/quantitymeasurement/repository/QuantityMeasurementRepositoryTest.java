package com.example.quantitymeasurement.repository;

import com.example.quantitymeasurement.entity.QuantityMeasurementEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QuantityMeasurementRepositoryTest {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Test
    void shouldSaveEntitySuccessfully() {

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setType("length");
        entity.setAction("ADD");
        entity.setExpression("10 + 5");
        entity.setResult(15.0);
        entity.setResultString("15.0");

        QuantityMeasurementEntity saved = repository.save(entity);

        assertNotNull(saved.getId());
        assertEquals("ADD", saved.getAction());
    }

    @Test
    void shouldFindByAction() {

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setType("length");
        entity.setAction("ADD");
        entity.setExpression("10 + 5");
        entity.setResult(15.0);
        entity.setResultString("15.0");

        repository.save(entity);

        List<QuantityMeasurementEntity> list =
                repository.findByAction("ADD");

        assertFalse(list.isEmpty());
    }
}
