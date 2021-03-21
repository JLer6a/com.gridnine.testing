package ru.budkin;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final int id;
    private final List<Segment> segments;

    public int getId() {
        return id;
    }

    Flight(int id, final List<Segment> segs) {
        this.id = id;
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}