package com.tudor.appbackend.mappers;

import com.tudor.appbackend.dto.PartnerDto;
import com.tudor.appbackend.models.Partner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartnerMapper {
    PartnerDto toDto(Partner partner);
    Partner fromDto(PartnerDto partnerDto);

    List<PartnerDto> toDtoList(List<Partner> partners);
    List<Partner> fromDtoList(List<PartnerDto> partnerDtos);
}
