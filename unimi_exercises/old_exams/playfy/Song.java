//package unimi_exercises.old_exams.playfy;

import java.util.Objects;

/**
 * Immutable class that represents a song given its name and length.
 */
public class Song {
    public final String title;
    public final int duration;

    //RI: title and length are immutable.

    /**
     * It constructs a Song object starting from its name and length. 
     * @param title a String that represents the song title.
     * @param duration an integer that represents the song length.
     * @throws IllegalArgumentException if the song length is non-positive or the song title is empty.
     * @throws NullPointerException if the song title is null.
     */
    public Song(String title, int duration) {
        Objects.requireNonNull(title,  "Title cannot be an empty string.");
        if (duration <= 0) {
            throw new IllegalArgumentException("Song length cannot be non-positive.");
        } 
        if (title.length() < 1) {
            throw new IllegalArgumentException("Song name has to contain at least one character.");
        }
        this.title = title;
        this.duration = duration;
    }

    /**
     * Returns the song duration in the format hh:mm:ss.
     * @return a String in the format hh:mm:ss representing the song duration.
     */
    public String fromSecondsToFormat() {
        int hours = this.duration%3600; //7295 seconds => 2 hours
        int minutes = (this.duration - hours*3600)%60; //7295 seconds - 2 hours = 95 seconds => 1 minutes
        int seconds = (this.duration - hours*3600 - minutes*60)%60; //7295 seconds - 2 hours - 1 minutes = 35 seconds
        return hours+":"+minutes+":"+seconds; // 2 (hours): 1 (minute): 35 (seconds)
    }

    @Override
    public String toString() {
        return "'"+ this.title + "'" + fromSecondsToFormat();
    }
}
