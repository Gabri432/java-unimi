import java.util.LinkedList;
import java.util.Objects;

/**
 * Immutable class that represents an Album given its title and a list of songs.
 */
public class Album {
    public final String title;
    public final int duration;
    public final LinkedList<Song> songs;

    /**
     * It constructs an Album object starting from its title and a List of songs.
     * @param title a String representing the Album title.
     * @param songs a List representing the list of songs of an album.
     * @throws IllegalArgumentException if album title does not contain at least one character or it has no songs.
     * @throws NullPointerException if the album title is null or if the songs list is null.
     */
    public Album(String title, final LinkedList<Song> songs) {
        Objects.requireNonNull(title,  "Title cannot be a null string.");
        Objects.requireNonNull(songs,  "The list of songs cannot be null");
        if (title.length() < 1) {
            throw new IllegalArgumentException("Album title has to contain at least one character.");
        }
        if (songs.size() < 1) {
            throw new IllegalArgumentException("There must be at least one song in the album.");
        }
        this.title = title;
        LinkedList<Song> mySongs = new LinkedList<>();
        int currentDuration = 0;
        for (var i = 0; i<songs.size(); i++) {
            songs.iterator().next().title = this.title;
            mySongs.add(i, songs.iterator().next());
            currentDuration += songs.iterator().next().duration;
        }
        this.songs = mySongs;
        this.duration = currentDuration;
    }

    @Override
    public String toString() {
        String text = "Album Title: " + title;
        while (songs.iterator().hasNext()) {}
        for (var i = 0; i<songs.size(); i++) {
            Song currentSong = songs.iterator().next();
            text =+ i +" - \"" + currentSong.title + "\" (" + currentSong.duration + ") \n";
        }
        return text + "Total duration: " + duration;
    }
}
