package com.example.agri_drones;

import com.example.agri_drones.model.SprayTask;
import com.example.agri_drones.service.SprayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SprayServiceTests {

    @Autowired
    private SprayService sprayService;

    @Test
    void testStartSprayingWithinGeofence() {
        SprayTask sprayTask = new SprayTask();
        sprayTask.setAreaName("Champ 1");

        // Coordonnées pour deux points
        Double droneLat1 = 40.7128;
        Double droneLng1 = -74.0060;
        Double droneLat2 = 40.7138;  // Deuxième point
        Double droneLng2 = -74.0050;  // Deuxième point

        // Appel à la méthode avec 4 paramètres
        sprayService.startSpraying(sprayTask, droneLat1, droneLng1, droneLat2, droneLng2);
    }
}

