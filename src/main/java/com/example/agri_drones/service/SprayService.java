package com.example.agri_drones.service;

import com.example.agri_drones.model.SprayTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SprayService {

    private final double SPRAY_DIAMETER = 1.5;  // diamètre de pulvérisation
    private final double DISTANCE_BETWEEN_SPRAYS = 1.45;  // distance entre les pulvérisations

    public void startSpraying(SprayTask sprayTask, double startLat, double startLng, double endLat, double endLng) {
        // Calculer le nombre de points de pulvérisation dans la zone définie
        List<double[]> sprayPoints = calculateSprayPoints(startLat, startLng, endLat, endLng);

        // Pour chaque point de pulvérisation, lancer la pulvérisation
        for (double[] point : sprayPoints) {
            System.out.println("Pulvérisation en cours au point : Latitude " + point[0] + ", Longitude " + point[1]);
            // Logique de pulvérisation (simulée ici)
        }

        System.out.println("Pulvérisation terminée pour la zone : " + sprayTask.getAreaName());
    }

    // Méthode pour calculer les points de pulvérisation
    private List<double[]> calculateSprayPoints(double startLat, double startLng, double endLat, double endLng) {
        List<double[]> points = new ArrayList<>();

        // Calculer le nombre de pulvérisations en fonction de la distance et du diamètre de pulvérisation
        double latDistance = Math.abs(endLat - startLat);
        double lngDistance = Math.abs(endLng - startLng);

        int numLatPoints = (int) Math.ceil(latDistance / DISTANCE_BETWEEN_SPRAYS);
        int numLngPoints = (int) Math.ceil(lngDistance / DISTANCE_BETWEEN_SPRAYS);

        for (int i = 0; i <= numLatPoints; i++) {
            for (int j = 0; j <= numLngPoints; j++) {
                double lat = startLat + i * DISTANCE_BETWEEN_SPRAYS;
                double lng = startLng + j * DISTANCE_BETWEEN_SPRAYS;
                points.add(new double[]{lat, lng});
            }
        }

        return points;
    }

    public boolean isSprayingCompleted(Long taskId) {
        // Simuler l'achèvement de la tâche de pulvérisation
        return true;
    }
}
