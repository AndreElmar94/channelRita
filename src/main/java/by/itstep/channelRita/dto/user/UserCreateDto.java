package by.itstep.channelRita.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserCreateDto {

    @ApiModelProperty(name = "Login", example = "bob_bobson", notes = "Must be unique")
    @NotEmpty(message = "Login can't be empty!")
    private String login;

    @ApiModelProperty(example = "12345678")
    @NotEmpty(message = "Password can't be empty!")
    private String password;

    //    @MustStartWithHttp
    @ApiModelProperty(example = "http://image.jpg", notes = "Link to the image file")
    private String imageUrl;

    @ApiModelProperty(example = "bob@gmail.com", notes = "Email must be unique")
    @Email
    @NotEmpty
    private String email;

}
