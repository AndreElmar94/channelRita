package by.itstep.channelRita.dto.post;

import lombok.Data;

import java.util.List;

@Data
public class PostCreateDto {

    private String tittle;
    private String content;
    private Integer channelId;   // будет использов для поиска канала
    private List<Integer> channelIds;

}
