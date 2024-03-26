package br.al.lucas.callbacks;

import br.al.lucas.models.Song;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class CallBackSongs implements Callback<List<Song>>{

    // Lista de músicas inicianula
    List<Song> songs = null;

    // Método chamado quando a chamada ao servidor é bem-sucedida
    @Override
    public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
        // Obtém o body da resposta (lista de músicas)
        songs = response.body();

        // Verifica se a lista de músicas não é nula
        if (songs != null) {
            //Se nao for nula itera sobre a lista de músicas e imprime cada uma
            for (Song song : songs) {
                System.out.println(song);
            }
        } else {
            // Se a lista de músicas for nula, imprime "Lista vazia"
            System.out.println("Lista vazia");
        }
    }

    // Método chamado quando a chamada ao servidor falha
    @Override
    public void onFailure(Call<List<Song>> call, Throwable t) {
        // Imprime a mensagem de erro associada à exceção
        System.out.println(t.getMessage());
    }
}