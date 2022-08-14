package com.starAndShadow.may.sakila.cucumber.filmcommons;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("cucumber-glue")
public class FilmHttpClient {
    private final String SERVER_URL = "http://sample-env.eba-c2xqepzb.us-east-1.elasticbeanstalk.com/";
    private final String FILM = "/films";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String filmSearchEndpoint;
}
