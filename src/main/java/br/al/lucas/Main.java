package br.al.lucas;

import br.al.lucas.models.Song;
import br.al.lucas.models.SpotifySongsResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Call<SpotifySongsResponse> call = SpotifyClient.getSongsService().list();
            Response<SpotifySongsResponse> resp = call.execute(); //await
            SpotifySongsResponse spotifySongsResponse = resp.body();

            if (spotifySongsResponse != null) {
                List<Song> songs = spotifySongsResponse.songs;
                for( Song song : songs){
                    System.out.println(song.name);
                }
                System.out.println(songs.size());
            }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }