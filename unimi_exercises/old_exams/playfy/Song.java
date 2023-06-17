//package unimi_exercises.old_exams.playfy;

import java.util.Objects;

/**
 * Immutable class that represents a song given its title and duration.
 */
public class Song {
    public String title;
    public final int duration;
    public final String albumTitle; 

    //RI: title and duration are immutable and not null.
    //title must be at least one character long.
    //duration must be at least 1 second long.

    //AB: represents an object with two properties: title and duration.

    /**
     * It constructs a Song object starting from its title and duration. 
     * @param title a String that represents the song title.
     * @param duration an integer that represents the song duration.
     * @throws IllegalArgumentException if the song duration is non-positive or the song title is empty.
     * @throws NullPointerException if the song title is null.
     */
    public Song(String title, int duration, String albumTitle) {
        Objects.requireNonNull(title,  "Title cannot be an empty string.");
        Objects.requireNonNull(albumTitle,  "Album title cannot be an empty string.");
        if (duration <= 0) {
            throw new IllegalArgumentException("Song duration cannot be non-positive.");
        } 
        if (title.length() < 1) {
            throw new IllegalArgumentException("Song title has to contain at least one character.");
        }
        if (albumTitle.length() < 1) {
            throw new IllegalArgumentException("Album title has to contain at least one character.");
        }
        this.title = title;
        this.duration = duration;
        this.albumTitle = albumTitle;
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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Song)) {
            return false;
        }
        Song song = (Song) obj;
        if (song.duration != this.duration) return false;
        if (song.title != this.title) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration);
    }

    @Override
    public String toString() {
        return "'"+ this.title + "'" + fromSecondsToFormat();
    }
}
