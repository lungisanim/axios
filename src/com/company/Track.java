package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private String Id;
    private String TrackSequence;
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

    public List<Track> addTracks(ResultSet rs) throws SQLException {
        Track track = new Track();
        List<Track> tracks = new ArrayList<>();

        while (rs.next())
        {
            track.setId(rs.getString("id"));
            track.setTrackSequence(rs.getString("track_sequence"));

            tracks.add(track);
        }

        return tracks;
    }
}
