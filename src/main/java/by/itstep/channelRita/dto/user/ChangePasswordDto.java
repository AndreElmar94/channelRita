package by.itstep.channelRita.dto.user;

import lombok.Data;

@Data
public class ChangePasswordDto {

    private Integer id;
    private String oldPassword;
    private String newPassword;
}
