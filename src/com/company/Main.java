package com.company;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=axiosdb;integratedSecurity=true;";
        List<Track> tracks;
        Track track = new Track();

        List<Vehicle> vehicles;
        Vehicle vehicle = new Vehicle();

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
                String trSQL = "SELECT id, track_sequence, track_identifier FROM tracks";
                ResultSet trRs = stmt.executeQuery(trSQL);
                tracks = track.addTracks(trRs);
                trRs.close();

                String vehSQL = "SELECT DISTINCT id, acceleration, top_speed, braking, cornering_ability FROM vehicles";
                ResultSet vehRs = stmt.executeQuery(vehSQL);
                vehicles = vehicle.addVehicles(vehRs);
                vehRs.close();

                vehicle.vehicleScores(tracks, vehicles);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
