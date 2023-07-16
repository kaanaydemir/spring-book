package com.example.readapi.mapper;


import com.example.readapi.dtos.ReadDto;
import com.example.readapi.entity.Read;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReadMapper {
    ReadDto convert(Read entity);
    Read convert(ReadDto dto);
}
