package by.itstep.channelRita.dto.user;

import lombok.Data;

@Data
public class UserFullDto {

    private Integer id;
    private String login;
    private String profileImageUrl;
    private String email;
    private String phoneNumber;

}
