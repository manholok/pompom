package com.example;

import com.sun.media.jfxmedia.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "henkies" path)
 */
@Path("henkies")
public class Henkies {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Henk getIt() {
        Henk henk = new Henk();
        henk.setName("jan");
        henk.setAge(33);
        henk.setLocation("Leiden");
        return henk;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHenk(@Context HttpHeaders headers, Henk henk) {
        // TEMP: return a Henk, later return a Response, but response is abstract, so I should create a new class with Response implementation
        String xtoken = headers.getRequestHeader("x-token").get(0);
        return Response.status(200)
                .entity(xtoken)
                .build();
    }
}
