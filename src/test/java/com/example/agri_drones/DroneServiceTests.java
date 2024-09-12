package com.example.agri_drones;

import com.example.agri_drones.model.Drone;
import com.example.agri_drones.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DroneServiceTests {

    @Autowired
    private DroneService droneService;

    @Test
    void testCreateAndRetrieveDrone() {
        Drone drone = new Drone();
        drone.setModel("DJI Agras T20");
        drone.setStatus("Actif");
        drone.setLocation("Champ 1");
        drone.setAutonomy("20 minutes");
        drone.setCapacity("20 litres");
        drone.setSensors("GPS, Radar");

        List<Drone> droneList = List.of(drone);
        List<Drone> savedDrones = droneService.saveall(droneList);
        assertThat(savedDrones).isNotEmpty();
        Drone savedDrone = savedDrones.get(0);

        Drone foundDrone = droneService.getDroneById(savedDrone.getId());
        assertThat(foundDrone).isNotNull();
        assertThat(foundDrone.getModel()).isEqualTo("DJI Agras T20");
        assertThat(foundDrone.getAutonomy()).isEqualTo("20 minutes");
        assertThat(foundDrone.getCapacity()).isEqualTo("20 litres");
        assertThat(foundDrone.getSensors()).isEqualTo("GPS, Radar");
    }

}

