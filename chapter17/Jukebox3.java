import java.util.*;
import java.io.*;

public class Jukebox3 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox3().go();
    }

    public <T> void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort((List<T>) songList);
        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File("country.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
            reader.close(); // Close the BufferedReader after reading
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        if (tokens.length >= 4) { // Check if the line contains enough tokens
            String title = tokens[0];
            String artist = tokens[1];
            String album = tokens[2];
            String year = tokens[3];
            Song nextSong = new Song(title, artist, album, year);
            songList.add(nextSong);
        }
    }
}
