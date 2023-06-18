import java.util.HashSet;
import java.util.LinkedList;

public class Playlist {
    public int duration;
    public LinkedList<Song> songs;
    public final String title;

    public Playlist(final String title) {
        this.title = title;
    }

    public Playlist(final String title, LinkedList<Song> songs) {
        this.title = title;
        LinkedList<Song> myList = new LinkedList<>();
        while (songs.iterator().hasNext()) {
            myList.add(songs.iterator().next());
        }
    }

    public void addSong() {}
    public void removeSong() {}
    public void printSongs(String albumTitle) {
        while (songs.iterator().hasNext()) {
            Song currentSong = songs.iterator().next();
            if (currentSong.albumTitle.equals(albumTitle)) {
                System.out.println(currentSong);
            }
        }
    }
    
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
