package by.itstep.channelRita.controller;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.dto.user.UserUpdateDto;
import by.itstep.channelRita.exception.UserCredentialsAreTakenException;
import by.itstep.channelRita.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "Controller dedicated to manage users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users/{id}")
    @ApiOperation(value = "Find one user by id", notes = "Existing id must be specified")
    public UserFullDto getById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    @ApiOperation(value = "Find add tests")
    public List<UserFullDto> findAll() {
        return userService.findAll();
    }


    @GetMapping("/users/filter")
    @ApiOperation(value = "Find all by parameters", notes = "Actually it's gonna return all existing users no matter what")
    public List<UserFullDto> findAllByName(@ApiParam(required = false, defaultValue = "Bob") @RequestParam String name,
                                           @ApiParam(required = false) @RequestParam String email) {
        return userService.findAll();   // ЖУТКО ПЛОХО !!!
    }

    // хочу получить список всех email(-ов)
    // @GetMapping("/users/emails)

    @PostMapping("/users/create")
    public ResponseEntity<UserFullDto> create(@Valid @RequestBody UserCreateDto createDto) {
        try {
            return new ResponseEntity<>(userService.create(createDto), HttpStatus.CREATED);
        } catch (UserCredentialsAreTakenException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users")
    public UserFullDto update(@RequestBody UserUpdateDto updateDto) {
        return userService.update(updateDto);
    }


    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }


    @GetMapping("/test-create")
    public void test() {
        for (int i = 0; i < 10; i++) {
            UserCreateDto createDto = new UserCreateDto();
            createDto.setEmail("email " + Math.random());
            createDto.setLogin("login " + Math.random());
            createDto.setPassword("password " + Math.random());
            createDto.setImageUrl("image " + Math.random());

            userService.create(createDto);
        }
    }


}
