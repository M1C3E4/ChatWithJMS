package com.example.ChatWithJMS.adapters.api;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.PeopleDTO;
import com.example.ChatWithJMS.adapters.api.mappers.PeopleMapper;
import com.example.ChatWithJMS.domain.exception.PeopleAlreadyExistException;
import com.example.ChatWithJMS.domain.exception.PeopleNotFoundException;
import com.example.ChatWithJMS.ports.PeopleService;
import lombok.var;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("people")
public class RestPeopleController {

    @Inject
    private PeopleService peopleService;
    @Inject
    private PeopleMapper peopleMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPeople(PeopleDTO peopleDTO){
        try{
            peopleService.addPeople(peopleMapper.toDomain(peopleDTO));
        }catch (PeopleAlreadyExistException e){
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("ducts/{name}")
    public Response getPeopleDuct(@PathParam("name") String peopleName){
        String ducts;
        try{
            var ductsListNames = peopleService.getPeopleDucts(peopleName);
            ducts = String.join(",", ductsListNames);
        }catch (PeopleNotFoundException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(ducts).build();
    }

    @GET
    @Path("{name}")
    public Response ifPeopleExist(@PathParam("name") String peopleName){
        try{
            peopleService.ifPeopleAlreadyExists(peopleName);
        }catch (PeopleNotFoundException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{name}")
    public Response removeByName(@PathParam("name") String peopleName){
        peopleService.removePeopleByName(peopleName);
        return Response.status(Response.Status.OK).build();
    }

}
