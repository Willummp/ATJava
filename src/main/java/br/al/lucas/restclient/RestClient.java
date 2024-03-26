package br.al.lucas.restclient;

import br.al.lucas.services.SongsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    // Instância do Retrofit para realizar chamadas de rede
    private Retrofit retrofit = null;
    private static RestClient instance = null;

    // Construtor privado para evitar a criação de instâncias externas
    private RestClient() {
        // Configuração do Retrofit com a URL base e o conversor Gson
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080") // URL base par as requisições
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Método estático para obter a instância única da classe RestClient
    public static RestClient getInstance() {
        // Se a instância ainda não foi criada, cria uma nova
        if (instance == null)
            instance = new RestClient();
        return instance; // Retorna a instância existente ou recém-criada
    }

    // Método para obter o serviço de músicas
    public SongsService getSongsService() {
        // Cria e retorna uma instância do serviço SongsService utilizando o Retrofit
        return this.retrofit.create(SongsService.class);
    }

}

