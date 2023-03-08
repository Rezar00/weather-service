package com.wiseboy.weatherservice.mapper;

import java.util.List;

public interface GenericMapper<ENT, DTO> {

    DTO entityToDto(ENT ent);

    ENT dtoToEntity(DTO dto);

    List<DTO> entitiesToDtoList(List<ENT> entities);

    List<ENT> dtoListToEntities(List<DTO> dtoList);
}
