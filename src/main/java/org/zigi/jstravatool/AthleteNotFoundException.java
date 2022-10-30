package org.zigi.jstravatool;

public class AthleteNotFoundException extends RuntimeException {
    public AthleteNotFoundException(Long id) {
        super("Could not find athlete " + id);
    }
}
