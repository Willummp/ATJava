package br.al.lucas.repositories;

import br.al.lucas.models.Song;

import java.util.ArrayList;
import java.util.List;

public class SongsRepository {
    private List<Song> songs = new ArrayList<>();

    public SongsRepository() {
        songs.add(new Song(1, "FANCY", "TWICE", "FANCY YOU EP"));
        songs.add(new Song(2, "Special Affair", "The Internet", "Ego Death"));
        songs.add(new Song(3, "That Funny Feeling", "Bo Burnham", "INSIDE (The Songs)"));
        songs.add(new Song(4, "November", "Tyler, The Creator", "Flower Boy"));
        songs.add(new Song(5, "Crave", "Paramore", "This is Why"));
    }

    public List<Song> list(int limit, int offset) {
        if (offset > songs.size() - 1) {
            return new ArrayList<>();
        }
        if (limit > songs.size() && offset == 0) {
            return songs;
        } else {
            List<Song> responseList = new ArrayList<Song>();
            for (int i = offset; i < offset + limit; i++) {
                responseList.add(songs.get(i));
            }
            return responseList;
        }
    }

    public Song read(long id) {
        for (Song song : songs)
            if (song.getId() == id)
                return song;
        return null;
    }

    public Song insert(Song song) {
        song.setId(songs.size() + 1);
        songs.add(song);
        return song;
    }

    public Song update(long id, Song song) {
        Song newSong = null;
        for (Song oldSong : songs)
            if (oldSong.getId() == id) {
                oldSong.setTitle(song.getTitle());
                oldSong.setArtist(song.getArtist());
                oldSong.setAlbum(song.getAlbum());
                newSong = oldSong;
                break;
            }
        return newSong;
    }

    public Song upgrade(long id, Song song) {
        Song newSong = null;
        for (Song oldSong : songs)
            if (oldSong.getId() == id) {
                if (song.getTitle() != null) oldSong.setTitle(song.getTitle());
                if (song.getArtist() != null) oldSong.setArtist(song.getArtist());
                if (song.getAlbum() != null) oldSong.setAlbum(song.getAlbum());
                newSong = oldSong;
                break;
            }
        return newSong;
    }

    public Song delete(long id) {
        Song deletedSong = null;
        for (Song song : songs)
            if (song.getId() == id) {
                deletedSong = song;
                songs.remove(song);
                break;
            }
        return deletedSong;
    }
}
