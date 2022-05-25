package com.example.ChatWithJMS.adapters.api;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.DuctDTO;
import com.example.ChatWithJMS.adapters.api.mappers.DuctMapper;
import com.example.ChatWithJMS.domain.exception.DuctAlreadyExistException;
import com.example.ChatWithJMS.ports.DuctsService;
import lombok.var;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("ducts")
public class RestDuctsController {

    @Inject
    private DuctsService ductsService;
    @Inject
    private DuctMapper ductMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDuctList(){
        var ducts = ductsService.getDuctList();
        List<DuctDTO> ductDTOList = ducts.stream().map(ductMapper::toDto).toList();
        List<String> ductNames = ductDTOList.stream().map(DuctDTO::getDuctName).toList();
        return Response.status(Response.Status.ACCEPTED).entity(ductNames).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDucts(DuctDTO ductDTO){
        try{
            ductsService.addDuct(ductMapper.toDomain(ductDTO));
        }catch (DuctAlreadyExistException e){
            return Response.status(Response.Status.CREATED).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("remove/{ductName}")
    public Response removeDuct(@PathParam("ductName") String ductName){
        ductsService.removeDuct(ductName);
        return Response.status(Response.Status.OK).build();
    }


}
