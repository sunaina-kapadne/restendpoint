package com.backendcodingexercises.quarkus.controller;

import com.backendcodingexercises.quarkus.service.GreetingService;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/greet")
@Consumes(MediaType.TEXT_PLAIN)
public class GreetingController {

    @Inject
    GreetingService greetingService;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetUser(
            @PathParam("name") String name,
            @QueryParam("suffix") String suffix) {

        String greeting = greetingService.greet(name, suffix);
        return Response.ok(Map.of("message", greeting)).build();

    }

}

