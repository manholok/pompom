package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response createHenk(Henk henk) {
        // TEMP: return a Henk, later return a Response, but response is abstract, so I should create a new class with Response implementation
        return Response.status(200)
                .entity(henk)
                .build();
    }
}
