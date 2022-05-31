package com.tnc.apigatewayas.service;

import com.tnc.apigatewayas.service.interfaces.ImageAnimal;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class AnimalImpl implements ImageAnimal {
    @Override
    public String getAnimals() {

        var httpClient = HttpClient.newHttpClient();
        var httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8093/animals"))
                .build();

        try {
            var httpResponse = httpClient.send(httpGet, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
