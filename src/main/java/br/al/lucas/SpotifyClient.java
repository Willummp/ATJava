package br.al.lucas;

import br.al.lucas.services.SongsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpotifyClient {
    private final Retrofit retrofit;
    private static SpotifyClient instance = null;

    private SpotifyClient(){
        String baseUrl = "https://api.spotify.com/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static SpotifyClient getInstance(){
        if(instance == null){
            instance = new SpotifyClient();
        }
        return instance;
    }

    public static SongsService getSongsService(){
        return getInstance().retrofit.create(SongsService.class);
    }

}
