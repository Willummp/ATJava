package br.al.lucas.services;

import br.al.lucas.models.SpotifySongResponse;
import br.al.lucas.models.SpotifySongsResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface SongsService {
    // LISTAR TODAS AS MÚSICAS
        @GET("/songs")
        Call<SpotifySongsResponse> list();
    // LISTAR MUSICA PELO ID
        @GET("/songs/{id}")
        Call<SpotifySongResponse> show(@Path("id") int id);

    // ADICIONAR MÚSICA
        @POST("/songs")
        Call<SpotifySongResponse> create(@Body SpotifySongResponse song);

    // ATUALIZAR MÚSICA
       @PUT("/songs/{id}")
       Call<SpotifySongResponse> update(@Path("id") int id, @Body SpotifySongResponse song);

    // DELETAR MÚSICA
        @DELETE("/songs/{id}")
        Call<SpotifySongResponse> delete(@Path("id") int id);
}
