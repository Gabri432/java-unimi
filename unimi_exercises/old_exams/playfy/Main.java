import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        LinkedList<Album> albums = new LinkedList<>();
        Playlist fusa = new Playlist("Fusa");
        System.out.println("PlayFy running...");
        while (myObj.hasNextLine()) {
            String inputLine = myObj.nextLine();
            if (inputLine.contains("ALBUM")) {
                LinkedList<Song> songs = new LinkedList<>();
                String albumTitle = inputLine.split(" ", 2)[1];
                System.out.println("CREATION OF ALBUM '"+albumTitle+"': Insert songs");
                Scanner albumScanner = new Scanner(System.in);
                while (albumScanner.hasNextLine()) { //Getting album details
                    String albumLine = albumScanner.nextLine();
                    if (albumLine.contains("-")) {
                        String[] songsDetails = albumLine.split("-");
                        Song currentSong = new Song(songsDetails[1], fromFormatToSeconds(songsDetails[0]), albumTitle);
                        songs.add(currentSong);
                        System.out.println("Song inserted");
                    }
                    if (albumLine.length() == 1) break;
                }
                System.out.println("Exiting loop");
                albumScanner.close();
                Album myAlbum = new Album(albumTitle, songs);
                System.out.println(myAlbum);
                albums.add(myAlbum);
            }
            if (inputLine.contains("PLAYLIST")) {
                System.out.println("PLAYLIST CREATION: Insert songs");
                String playlistTitle = inputLine.split(" ", 2)[1];
                Playlist myPlaylist = new Playlist(playlistTitle);
                Scanner playlistScanner = new Scanner(System.in);
                while (playlistScanner.hasNextLine()) { //Getting playlist details
                    String playlistLine = playlistScanner.nextLine();
                    if (playlistLine.contains("-")) {
                        String[] songDetails = playlistLine.split(" ");
                        int albumPosition = Integer.parseInt(songDetails[0]);
                        int songPosition = Integer.parseInt(songDetails[1]);
                        Song currentSong = albums.get(albumPosition).songs.get(songPosition);
                        myPlaylist.addSong(currentSong);
                        fusa.addSong(currentSong);
                    }
                    if (playlistLine.length() == 1) break;
                }
                System.out.println("Exiting loop");
                playlistScanner.close();
                System.out.println(myPlaylist);
            }
        }
        myObj.close();
        System.out.println(fusa);
        System.out.println(albums);
    }

    public static int fromFormatToSeconds(String time) {
        String[] timeDetails = time.trim().split(":");
        if (timeDetails.length == 2) {
            int seconds = Integer.parseInt(timeDetails[1]);
            int minutesInSeconds = Integer.parseInt(timeDetails[0]) * 60;
            return seconds+minutesInSeconds;
        }
        int seconds = Integer.parseInt(timeDetails[2]);
        int minutesInSeconds = Integer.parseInt(timeDetails[1]) * 60;
        int hoursInSeconds = Integer.parseInt(timeDetails[1]) * 3600;
        return seconds + minutesInSeconds + hoursInSeconds;
    }
}
