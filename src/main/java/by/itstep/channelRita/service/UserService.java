package by.itstep.channelRita.service;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {

    UserFullDto findById(Integer id);

    List<UserFullDto> findAll();

    UserFullDto create(UserCreateDto dto);

    UserFullDto update(UserUpdateDto dto);

    void deleteById(Integer id);



}
