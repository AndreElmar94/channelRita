package by.itstep.channelRita.dto.channel;

import by.itstep.channelRita.entity.ChannelEntityType;
import lombok.Data;

@Data
public class ChannelPreviewDto {

    private Integer id;
    private String name;
    private ChannelEntityType type;
}
