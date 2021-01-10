package by.itstep.channelRita.dto.post;

import lombok.Data;

@Data
public class PostUpdateDto {

    private Integer id;   // ID поста который обновляем
    private String tittle;
    private String content;

}

