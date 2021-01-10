package by.itstep.channelRita.mapper;

import by.itstep.channelRita.dto.post.PostCreateDto;
import by.itstep.channelRita.dto.post.PostFullDto;
import by.itstep.channelRita.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "channel", ignore = true)
    PostEntity mapToEntity(PostCreateDto createDto);

    @Mapping(target = "channelId", source = "channel.id")
    PostFullDto mapToFullDto(PostEntity entity);


}
