import java.util.HashSet;
import java.util.LinkedList;

/**
 * Mutable class that represents a Playlist given its name and a list of songs. 
 * A playlist can be empty and songs can be added and removed after its creation.
 */
public class Playlist {
    public int duration;
    public LinkedList<Song> songs;
    public final String title;

    //RI: title cannot be or empty null.
    //title must be at least one character long.

    //AB: a list of song objects will represent the list of songs of a playlist.
    //The ith item of the list is the ith song of the playlist.  

    /**
     * It constructs a Playlist object given its title.
     * @param title a String representing the Playlist title.
     * @throws NullPointerException if the title is null.
     * @throws IllegalArgumentException if the title is not at least 1 character long.
     */
    public Playlist(final String title) {
        this.title = title;
    }

    /**
     * It constructs a Playlist object given its title and an initial list of songs.
     * @param title a String representing the Playlist title.
     * @param songs a LinkedList of Song objects representing the songs of the playlist.
     * @throws NullPointerException if the title is null or the list of songs is null.
     * @throws IllegalArgumentException if the title is not at least 1 character long.
     */
    public Playlist(final String title, LinkedList<Song> songs) {
        this.title = title;
        LinkedList<Song> myList = new LinkedList<>();
        while (songs.iterator().hasNext()) {
            myList.add(songs.iterator().next());
        }
        this.songs = myList;
    }

    /**
     * Adds a new song to the playlist, if it is not already in it.
     * @param song a Song object that represents the song to add to the playlist.
     * @throws NullPointerException if the song is null.
     */
    public void addSong(Song song) {
        if (!this.songs.contains(song)) this.songs.add(song);
    }

    /**
     * Removes a song from the playlist, if found in the playlist.
     * @param song a Song object that represents the song to remove from the playlist.
     * @throws NullPointerException if the song is null.
     */
    public void removeSong(Song song) {
        if (this.songs.contains(song)) this.songs.remove(song);
    }

    /**
     * Prints all the songs belonging to an album.
     * @param albumTitle a String representing the title of the album of the desired songs.
     * @throws NullPointerException if the album title is a null string.
     * @throws IllegalArgumentException if the album is a empty string.
     */
    public void printSongs(String albumTitle) {
        while (songs.iterator().hasNext()) {
            Song currentSong = songs.iterator().next();
            if (currentSong.albumTitle.equals(albumTitle)) {
                System.out.println(currentSong);
            }
        }
    }
    
    /**
     * Prints all the different albums that are present in the playlist.
     */
    public void printAlbums() {
        HashSet<String> setOfAlbumTitles = new HashSet<>();
        while (songs.iterator().hasNext()) {
            if (!setOfAlbumTitles.contains(songs.iterator().next().albumTitle)) {
                setOfAlbumTitles.add(songs.iterator().next().albumTitle);
                System.out.println(songs.iterator().next().albumTitle);
            }
        }
    }

    @Override
    public String toString() {
        String text = "Playlist name: " + title + "\n";
        int index = 1;
        while (songs.iterator().hasNext()) {
            Song currentSong = songs.iterator().next();
            text =+ index +" - \"" + currentSong.title + "\" (" + currentSong.duration + "), (from"+ currentSong.albumTitle + ") \n";
        }
        return text + "Total duration: " + duration;
    }
}
