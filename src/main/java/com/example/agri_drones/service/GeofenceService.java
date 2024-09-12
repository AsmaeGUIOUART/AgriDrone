package com.example.agri_drones.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeofenceService {

    private final double predefinedRadius = 1.5; // Exemple d'une valeur par défaut de 1.5 mètres

    public boolean isDroneWithinGeofence(Double droneLat, Double droneLng, List<Double> geoLat, List<Double> geoLng) {
        // Here you could implement the logic using algorithms like ray-casting or point-in-polygon
        // For simplicity, let's assume you check whether the drone is within a circular area.
        double distance = calculateDistance(droneLat, droneLng, geoLat.get(0), geoLng.get(0)); // Assuming a circular geofence for now.
        return distance <= predefinedRadius;// predefinedRadius could be a configuration


    }

    private double calculateDistance(Double lat1, Double lng1, Double lat2, Double lng2) {
        // Implementation of Haversine formula to calculate distance
        double earthRadius = 6371; // radius in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return earthRadius * c;
    }
}

