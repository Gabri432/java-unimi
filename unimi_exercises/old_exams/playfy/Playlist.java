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
    public void printSongs() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
