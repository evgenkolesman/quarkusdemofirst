package com.kolesnikov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolesnikov.entity.QuarkusEntity;
import com.kolesnikov.repository.QRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/")
public class ExampleResource {

    @Inject
    QRepository repository;

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloPost() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new MyEntity("New"));
    }


    @POST
    @Path("/helloNew")
    @Produces(MediaType.APPLICATION_JSON)
    public MyEntity checkMap(MyEntity field) {
        return new MyEntity(field.field);
    }

    @PUT
    @Path("/resp")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public NewResponse checkResp(MyEntity field) {
        repository.persistAndFlush(new QuarkusEntity().name(field.field));
        Set<QuarkusEntity> collect = repository.streamAll().collect(Collectors.toSet());
        return new NewResponse(new MyEntity(String.format("%s %s 12", collect, "new")));
    }


}
