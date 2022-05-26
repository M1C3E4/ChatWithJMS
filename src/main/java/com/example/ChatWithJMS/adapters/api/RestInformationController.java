package com.example.ChatWithJMS.adapters.api;

import com.example.ChatWithJMS.adapters.api.dataTransferObject.InformationDTO;
import com.example.ChatWithJMS.adapters.api.mappers.InformationMapper;
import com.example.ChatWithJMS.domain.exception.DuctNotFoundException;
import com.example.ChatWithJMS.domain.exception.PeopleNotExistInDuctException;
import com.example.ChatWithJMS.ports.InformationService;
import lombok.var;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("information")
public class RestInformationController {
    @Inject
    private InformationService informationService;
    @Inject
    InformationMapper informationMapper;

    @Path("send")
    @POST@Consumes(MediaType.APPLICATION_JSON)
    public Response sendInformation(InformationDTO informationDTO){
        var information = informationMapper.toDomain(informationDTO);
        try{
            informationService.send(information, informationDTO.getDuctName());
        }catch (DuctNotFoundException | PeopleNotExistInDuctException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
