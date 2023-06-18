import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        LinkedList<Album> albums = new LinkedList<>();
        Playlist fusa = new Playlist("Fusa");
        while (myObj.hasNextLine()) {
            String inputLine = myObj.nextLine();
            if (inputLine.contains("ALBUM")) {
                LinkedList<Song> songs = new LinkedList<>();
                String albumTitle = inputLine.split(" ", 2)[1];
                while (myObj.hasNextLine()) {
                    if (inputLine.contains("-")) {
                        String[] songsDetails = inputLine.split("-");
                        Song currentSong = new Song(songsDetails[1], fromFormatToSeconds(songsDetails[0]), albumTitle);
                        songs.add(currentSong);
                    }
                    if (inputLine.equals(".")) break;
                }
                Album myAlbum = new Album(albumTitle, songs);
                System.out.println(myAlbum);
                albums.add(myAlbum);
            }
            if (inputLine.contains("PLAYLIST")) {
                String playlistTitle = inputLine.split(" ", 2)[1];
                Playlist myPlaylist = new Playlist(playlistTitle);
                while (myObj.hasNextLine()) {
                    if (inputLine.contains("-")) {
                        String[] songDetails = inputLine.split(" ");
                        int albumPosition = Integer.parseInt(songDetails[0]);
                        int songPosition = Integer.parseInt(songDetails[1]);
                        Song currentSong = albums.get(albumPosition).songs.get(songPosition);
                        myPlaylist.addSong(currentSong);
                        fusa.addSong(currentSong);
                    }
                    if (inputLine.equals(".")) break;
                }
                System.out.println(myPlaylist);
            }
        }
        System.out.println(fusa);
        System.out.println(albums);
        myObj.close();
    }

    public static int fromFormatToSeconds(String time) {
        String[] timeDetails = time.split(":");
        int seconds = Integer.parseInt(timeDetails[2]);
        int minutesInSeconds = Integer.parseInt(timeDetails[1]) * 60;
        int hoursInSeconds = Integer.parseInt(timeDetails[1]) * 3600;
        return seconds + minutesInSeconds + hoursInSeconds;
    }
}
