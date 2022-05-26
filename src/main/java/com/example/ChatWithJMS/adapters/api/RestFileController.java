package com.example.ChatWithJMS.adapters.api;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.FileDTO;
import com.example.ChatWithJMS.adapters.api.mappers.FileMapper;
import com.example.ChatWithJMS.domain.File;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.FIleNotFoundException;
import com.example.ChatWithJMS.domain.exception.FilePeopleNotExistInTheDuctException;
import com.example.ChatWithJMS.domain.exception.PeopleNotFoundException;
import com.example.ChatWithJMS.ports.FileService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("file")
public class RestFileController {

    @Inject
    FileService fileService;
    @Inject
    FileMapper fileMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendFile(FileDTO fileDTO){
        try{
            fileService.save(fileMapper.toDomain(fileDTO));
        }catch (PeopleNotFoundException | DuctNotFoundException e){
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("{ductName}/{fileName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response pickUpFile(@PathParam("ductName") String ductName,
                               @QueryParam("peopleName") String peopleName,
                               @PathParam("fileName") String fileName){
        File file;
        try{
            file = fileService.getFileByName(fileName, peopleName, ductName);
        }catch (FIleNotFoundException | PeopleNotFoundException | FilePeopleNotExistInTheDuctException | DuctNotFoundException e){
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        var filee = fileMapper.toDto(file);
        return Response.status(Response.Status.OK).entity(filee).build();
    }

}
