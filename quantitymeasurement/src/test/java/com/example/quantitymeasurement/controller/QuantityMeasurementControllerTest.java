package com.example.quantitymeasurement.controller;

import com.example.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.example.quantitymeasurement.service.IQuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuantityMeasurementController.class)
class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService service;

    private final String requestBody = """
            {
              "thisQuantity": {
                "value": 10,
                "symbol": "m",
                "label": "Meter",
                "type": "length"
              },
              "thatQuantity": {
                "value": 5,
                "symbol": "m",
                "label": "Meter",
                "type": "length"
              }
            }
            """;

    @Test
    void shouldCallAddEndpointSuccessfully() throws Exception {

        QuantityMeasurementDTO response = new QuantityMeasurementDTO();
        response.setAction("ADD");
        response.setResult(15.0);

        when(service.add(org.mockito.ArgumentMatchers.any()))
                .thenReturn(response);

        mockMvc.perform(post("/api/quantities/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCallSubtractEndpointSuccessfully() throws Exception {

        QuantityMeasurementDTO response = new QuantityMeasurementDTO();
        response.setAction("SUBTRACT");
        response.setResult(5.0);

        when(service.subtract(org.mockito.ArgumentMatchers.any()))
                .thenReturn(response);

        mockMvc.perform(post("/api/quantities/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetCountSuccessfully() throws Exception {

        when(service.getCount("ADD"))
                .thenReturn(3L);

        mockMvc.perform(get("/api/quantities/count/ADD"))
                .andExpect(status().isOk());
    }
}


