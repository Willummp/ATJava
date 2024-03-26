package br.al.lucas;

import br.al.lucas.models.Song;
import br.al.lucas.restclient.RestClient;
import br.al.lucas.services.SongsService;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criando instância do serviço de músicas
        SongsService songsService = RestClient.getInstance().getSongsService();

        // LISTAR MÚSICA PELO ID
        // Faz uma call para listar uma música pelo ID
        Call<Song> callListById = songsService.listById(1);
        // Chama o método para listar uma música pelo ID e exibe o resultado
        listSongById(callListById);

        // ADICIONAR MÚSICA
        // Criamos uma nova música
        Song song1 = new Song("Música 1", "Artista 1", "Álbum 1");
        // Fazemos uma chamada para inserir a música
        Call<Song> callInsert = songsService.insert(song1);
        // Chama o método para inserir a música e exibe o resultado
        insertSong(callInsert);

        // ATUALIZAR MÚSICA
        // Criamos uma nova instância de música com novos dados
        Song song2 = new Song("AAAAA", "ArAAAA", "ÁlbAA 2");
        // Fazemos uma chamada para atualizar a música com ID 2
        Call<Song> callUpdate = songsService.update(2, song2);
        // Chama o método para atualizar a música e exibe o resultado
        updateSong(callUpdate);

        // DELETAR MÚSICA
        // Fazemos uma chamada para deletar a música com ID 2
        Call<Song> callDelete = songsService.delete(2);
        // Chama o método para deletar a música e exibe o resultado
        deleteSong(callDelete);

        // LISTAR TODAS AS MÚSICAS
        // Faz uma chamada para listar todas as músicas
        Call<List<Song>> callListAll = songsService.listAll();
        // Chama o método para listar todas as músicas e exibe o resultado
        listAllSongs(callListAll);
    }

    // Método para listar uma música pelo ID
    private static void listSongById(Call<Song> call) {
        try {
            // Executa a chamada e obtém a resposta
            Response<Song> response = call.execute();
            // Verifica se a chamada foi bem-sucedida
            if (response.isSuccessful()) {
                // Obtém a música da resposta
                Song song = response.body();
                // Verifica se a música não é nula e a exibe
                if (song != null) {
                    System.out.println(song);
                }
            } else {
                // Exibe uma mensagem de erro se a chamada não foi bem-sucedida
                System.out.println("Failed to list song by ID: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir uma música
    private static void insertSong(Call<Song> call) {
        try {
            // Executa a chamada e obtém a resposta
            Response<Song> response = call.execute();
            // Verifica se a chamada foi bem-sucedida e exibe uma mensagem adequada
            if (response.isSuccessful()) {
                System.out.println("Song inserted successfully: " + response.body());
            } else {
                System.out.println("Failed to insert song: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar uma música
    private static void updateSong(Call<Song> call) {
        try {
            // Executa a chamada e obtém a resposta
            Response<Song> response = call.execute();
            // Verifica se a chamada foi bem-sucedida e exibe uma mensagem adequada
            if (response.isSuccessful()) {
                System.out.println("Song updated successfully: " + response.body());
            } else {
                System.out.println("Failed to update song: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar uma música
    private static void deleteSong(Call<Song> call) {
        try {
            // Executa a chamada e obtém a resposta
            Response<Song> response = call.execute();
            // Verifica se a chamada foi bem-sucedida e exibe uma mensagem adequada
            if (response.isSuccessful()) {
                System.out.println("Song deleted successfully");
            } else {
                System.out.println("Failed to delete song: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas as músicas
    private static void listAllSongs(Call<List<Song>> call) {
        try {
            // Executa a chamada e obtém a resposta
            Response<List<Song>> response = call.execute();
            // Verifica se a chamada foi bem-sucedida
            if (response.isSuccessful()) {
                // Obtém a lista de músicas da resposta
                List<Song> songs = response.body();
                // Verifica se a lista de músicas não é nula e a exibe
                if (songs != null) {
                    for (Song song : songs) {
                        System.out.println(song);
                    }
                }
            } else {
                // Exibe uma mensagem de erro se a chamada não foi bem-sucedida
                System.out.println("Failed to list all songs: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}