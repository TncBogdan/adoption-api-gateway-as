package com.tnc.apigatewayas.service;

import com.tnc.apigatewayas.service.interfaces.ImageUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserImpl implements ImageUser {
    @Override
    public String getUsers() {

        var httpClient = HttpClient.newHttpClient();
        var httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8091/users"))
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
