package br.al.lucas.models;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Song {

    public long id;
    public String title;
    public String artist;
    public String album;

public Song( String title, String artist, String album){
    this.title = title;
    this.artist = artist;
    this.album = album;

}
@Override
    public String toString() {
        return "Song" +
                " id: " + id +
                " Título: " + title +
                ", Artista: " + artist +
                ", Album: " + album ;
    }
}