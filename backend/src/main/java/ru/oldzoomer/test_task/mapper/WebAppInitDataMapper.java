package ru.oldzoomer.test_task.mapper;

import org.mapstruct.Mapper;

import ru.oldzoomer.test_task.dto.WebAppInitDataDto;
import ru.oldzoomer.test_task.entity.WebAppInitData;

@Mapper
public interface WebAppInitDataMapper {
    WebAppInitData toEntity(WebAppInitDataDto dto);

    WebAppInitData.Chat toEntity(WebAppInitDataDto.Chat dto);

    WebAppInitDataDto.User toDto(WebAppInitData.User entity);

    WebAppInitData.User toEntity(WebAppInitDataDto.User dto);
}
