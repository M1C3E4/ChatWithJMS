package com.example.ChatWithJMS.adapters.api.dataTransferObject;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DuctDTO {
    private UUID ductID;
    private String ductName;
    private List<PeopleDTO> ductPeople;
}
