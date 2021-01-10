package by.itstep.channelRita.dto.post;

import lombok.Data;

@Data
public class PostFullDto {

    private Integer id;
    private String tittle;
    private String content;
    private Integer channelId;
}
