package by.itstep.channelRita.mapper;

import by.itstep.channelRita.dto.channel.ChannelPreviewDto;
import by.itstep.channelRita.dto.channel.ChannelCreateDto;
import by.itstep.channelRita.dto.channel.ChannelFullDto;
import by.itstep.channelRita.entity.ChannelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(
        componentModel = "spring",
        uses = PostMapper.class
)
public interface ChannelMapper {


    ChannelMapper CHANNEL_MAPPER = Mappers.getMapper(ChannelMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    ChannelEntity toEntity(ChannelCreateDto createDto);


    ChannelFullDto toFullDto(ChannelEntity entity);

    ChannelPreviewDto toPreviewDto(ChannelEntity entity);


}

