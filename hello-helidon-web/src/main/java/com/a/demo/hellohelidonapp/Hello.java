package com.a.demo.hellohelidonapp;

import io.helidon.media.jackson.server.JacksonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.WebServer;

public class Hello {

    public static void main(String... args) {

    	Routing routing = Routing
                .builder()
                .register(JacksonSupport.create())
                .get("/api/hello", Hello::sayHi)
                .build();

    	ServerConfiguration config = ServerConfiguration
                .builder()
                .port(8080)
                .build();

        WebServer
                .create(config, routing)
                .start();
    }

    private static void sayHi(ServerRequest serverRequest, ServerResponse serverResponse) {
        serverResponse.send(new HelloResponse("Hello !!!"));
    }
    
}
