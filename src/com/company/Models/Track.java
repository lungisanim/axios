package com.company.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private String Id;
    private String TrackSequence;
    private int TrackIdentifier;
    public List<Track> TrackList;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTrackSequence() {
        return TrackSequence;
    }

    public void setTrackSequence(String trackSequence) {
        TrackSequence = trackSequence;
    }

    public int getTrackIdentifier() {
        return TrackIdentifier;
    }

    public void setTrackIdentifier(int trackIdentifier) {
        TrackIdentifier = trackIdentifier;
    }

    public List<Track> addTracks(ResultSet rs) throws SQLException {
        Track track = new Track();
        List<Track> tracks = new ArrayList<>();

        while (rs.next())
        {
            track.setId(rs.getString("id"));
            track.setTrackSequence(rs.getString("track_sequence"));
            track.setTrackIdentifier(rs.getInt("track_identifier"));

            tracks.add(track);
        }

        return tracks;
    }
}
