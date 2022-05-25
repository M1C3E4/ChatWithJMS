package com.example.ChatWithJMS.adapters.api;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.PeopleDuctDTO;
import com.example.ChatWithJMS.adapters.api.mappers.InformationMapper;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.PeopleNotExistInDuctException;
import com.example.ChatWithJMS.domain.exception.PeopleNotFoundException;
import com.example.ChatWithJMS.ports.DuctService;
import lombok.var;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("duct")
public class RestDuctController {

    @Inject
    private DuctService ductService;
    @Inject
    private InformationMapper informationMapper;

    @Path("people")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPeopleDuct(PeopleDuctDTO peopleDuctDTO){
        try{
            ductService.addPeopleFromDuctIntoDuct(peopleDuctDTO.getPeopleName(), peopleDuctDTO.getDuctName());
        }catch (DuctNotFoundException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    public Response deletePeopleFromDuct(@QueryParam("nameDuct") String peopleName,
                                         @QueryParam("nameDuct") String ductName){
        try {
            ductService.deleteDuctPeople(peopleName, ductName);
        }catch (DuctNotFoundException | PeopleNotExistInDuctException | PeopleNotFoundException e){
            return  Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).build();

    }

    @Path("pullHistory/{nameDuct}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response pullHistory(@PathParam("nameDuct") String ductName,
                                @QueryParam("namePeople") String peopleName) {
        List<Information> informationList;
        try{
            informationList = ductService.historyDownloading(ductName, peopleName);
        }catch (DuctNotFoundException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        var informationDtoList = informationList.stream().map(information -> informationMapper.toDto(information)).toList();
        return Response.status(Response.Status.OK).entity(informationDtoList).build();
    }

}
