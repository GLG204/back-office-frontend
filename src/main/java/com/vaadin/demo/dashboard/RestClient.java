package com.vaadin.demo.dashboard;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
    ClientConfig config;
    Client client;
    WebTarget webtarget;

    public RestClient() {
        config = new ClientConfig();
        client = ClientBuilder.newClient((Configuration) config);
        webtarget = client.target("http://localhost:8080/JaxRestHello");
    }

    public String getResponse() {
        return webtarget.path("server")
                        .path("restServer")
                        .request()
                        .accept(MediaType.TEXT_PLAIN)
                        .get(Response.class)
                        .toString();
    }

    public String getAnswerText() {
        return webtarget.path("server")
                        .path("restServer")
                        .request()
                        .accept(MediaType.TEXT_PLAIN)
                        .get(String.class);
    }

    public String getAnswerXML() {
        return webtarget.path("server")
                        .path("restServer")
                        .request()
                        .accept(MediaType.TEXT_XML)
                        .get(String.class);
    }

    public String getAnswerJSON() {
        return webtarget.path("server")
                        .path("restServer")
                        .request()
                        .accept(MediaType.APPLICATION_JSON)
                        .get(String.class);
    }
}
