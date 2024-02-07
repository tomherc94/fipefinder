package br.com.alura.fipefinder.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumidorApi {

    public String obterDados(String url){


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("OPÇÃO INVÁLIDA!");
            throw new RuntimeException();
        } catch (InterruptedException e) {
            System.out.println("OPÇÃO INVÁLIDA!");
            throw new RuntimeException();
        }

        String json = response.body();
        return json;
    }

}
