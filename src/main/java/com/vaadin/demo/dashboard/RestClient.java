package com.vaadin.demo.dashboard;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class RestClient {
    ClientConfig config;
    Client client;
    WebTarget webtarget;

    public RestClient() {
        config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        webtarget = client.target("http://localhost:8080/JaxRestHello");
    }

    public String getResponse() {
        String response = webtarget.path("server")
                                   .
                                           path("restserver")
                                   .
                                           request()
                                   .
                                           accept(MediaType.TEXT_PLAIN)
                                   .
                                           get(Response.class)
                                   .toString();
        return response;
    }

    public String getAnswerText() {
        String answer =
                webtarget.path("server")
                         .
                                 path("restserver")
                         .
                                 request()
                         .
                                 accept(MediaType.TEXT_PLAIN)
                         .
                                 get(String.class);
        return answer;
    }

    public String getAnswerXML() {
        String answer =
                webtarget.path("server")
                         .
                                 path("restserver")
                         .
                                 request()
                         .
                                 accept(MediaType.TEXT_XML)
                         .
                                 get(String.class);
        return answer;
    }

    public String getAnswerJSON() {
        String answer =
                webtarget.path("server")
                         .
                                 path("restserver")
                         .
                                 request()
                         .
                                 accept(MediaType.APPLICATION_JSON)
                         .
                                 get(String.class);
        return answer;
    }
}
