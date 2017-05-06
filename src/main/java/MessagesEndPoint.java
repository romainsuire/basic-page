package com.romainsuire.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("/hostname")
@Produces(MediaType.APPLICATION_JSON)
public class MessagesEndPoint {

    @GET
    public Response getMessage() {

        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }

        return Response.ok(hostname).build();
    }
}