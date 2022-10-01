package org.example.controller;

import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.beans.SampleService;
import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalTime;
import java.util.Timer;

@Path("/jackson")
@Slf4j
public class ReactiveJackson {

    @Inject
    SampleService sampleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(HttpServerRequest request) {
        log.info("Time : {}, URI: {}", LocalTime.now(), request.absoluteURI());
        return Response.ok(sampleService.getResponse()).build();
    }
}
