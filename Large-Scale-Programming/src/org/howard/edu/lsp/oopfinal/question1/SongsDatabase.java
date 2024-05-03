package org.howard.edu.lsp.oopfinal.question1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    private Map<String, Set<String>> genreToSongs = new HashMap<>();

    // Adds a song under its genre in the database
    public void addSong(String genre, String songTitle) {
        genreToSongs.computeIfAbsent(genre, k -> new HashSet<>()).add(songTitle);
    }

    // Retrieves the genre of a specific song title
    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, Set<String>> entry : genreToSongs.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;  // Return null if no genre is found
    }

    // Gets all songs associated with a genre
    public Set<String> getSongs(String genre) {
        return genreToSongs.getOrDefault(genre, new HashSet<>());
    }

    // Main to run the program
    public static void main(String[] args) {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rock", "Bohemian Rhapsody");
        db.addSong("Jazz", "What a Wonderful World");
        db.addSong("Rock", "Stairway to Heaven");

        System.out.println("Songs in Rock: " + db.getSongs("Rock"));
        System.out.println("Genre of 'What a Wonderful World': " + db.getGenreOfSong("What a Wonderful World"));
    }
}

