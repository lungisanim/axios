package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Vehicle {

    private String Id;
    private int Acceleration;
    private int Braking;
    private int CorneringAbility;
    private int TopSpeed;
    private int Score;

    public int getScore(Vehicle vehicle, Track track){
        char[] trackSeq = track.getTrackSequence().toCharArray();
        int Score = 0;
        for (char seq: trackSeq) {
            int intSeq = Integer.valueOf(seq);
            if (intSeq > 1 || intSeq <= -1)
                return 0;

            if (intSeq == 0)
                Score += vehicle.Braking + vehicle.CorneringAbility;

            if (intSeq == 1)
                Score += vehicle.Acceleration + vehicle.TopSpeed;
        }

        return Score;
    }

    public void setScore(Vehicle vehicle){
        Score = vehicle.Score;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getAcceleration() {
        return Acceleration;
    }

    public void setAcceleration(int acceleration) {
        Acceleration = acceleration;
    }

    public int getBraking() {
        return Braking;
    }

    public void setBraking(int braking) {
        Braking = braking;
    }

    public int getCorneringAbility() {
        return CorneringAbility;
    }

    public void setCorneringAbility(int corneringAbility) {
        CorneringAbility = corneringAbility;
    }

    public int getTopSpeed() {
        return TopSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        TopSpeed = topSpeed;
    }

    public List<Vehicle> addVehicles(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle();
        List<Vehicle> vehicles  = new ArrayList<>();

        while (rs.next())
        {
            vehicle.setId(rs.getString("id"));
            vehicle.setAcceleration(rs.getInt("acceleration"));
            vehicle.setTopSpeed(rs.getInt("top_speed"));
            vehicle.setBraking(rs.getInt("braking"));
            vehicle.setCorneringAbility(rs.getInt("cornering_ability"));

            vehicles.add(vehicle);
        }

        return vehicles;
    }

    public void vehicleScores(List<Track> tracks, List<Vehicle> vehicles) {
        Track track = tracks.get(1);
        availableVehicles(vehicles, track);
    }

    private void availableVehicles(List<Vehicle> vehicles, Track track) {
        //vehicles.sort(Comparator.naturalOrder());
        for (Vehicle vehicle: vehicles) {
            System.out.printf("%s => acceleration: %s, top speed: %s, braking: %s, cornering ability: %s\n",
                    vehicle.Id, vehicle.Acceleration, vehicle.TopSpeed, vehicle.Braking, vehicle.CorneringAbility);
        }
    }
}
