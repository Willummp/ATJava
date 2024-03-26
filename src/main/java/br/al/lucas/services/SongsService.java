package br.al.lucas.services;

import br.al.lucas.models.Song;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SongsService {
    // LISTAR TODAS AS MÚSICAS
        @GET("/songs")
        Call<List<Song>> listAll();

    // LISTAR MUSICA PELO ID
        @GET("/songs/{id}")
        Call<Song> listById(@Path("id") int id);

    // ADICIONAR MÚSICA
        @POST("/songs")
        Call<Song> insert(@Body Song song);

    // ATUALIZAR MÚSICA
       @PUT("/songs/{id}")
       Call<Song> update(@Path("id") int id, @Body Song song);

    // DELETAR MÚSICA
        @DELETE("/songs/{id}")
        Call<Song> delete(@Path("id") int id);
}
