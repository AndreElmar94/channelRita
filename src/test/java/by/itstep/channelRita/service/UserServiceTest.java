package by.itstep.channelRita.service;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.dto.user.UserUpdateDto;
import by.itstep.channelRita.entity.UserEntity;
import by.itstep.channelRita.exception.EntityIsNotFoundException;
import by.itstep.channelRita.repository.UserRepository;
import by.itstep.channelRita.service.UserService;
import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.dto.user.UserUpdateDto;
import by.itstep.channelRita.entity.UserEntity;
import by.itstep.channelRita.exception.EntityIsNotFoundException;
import by.itstep.channelRita.repository.UserRepository;
import by.itstep.channelRita.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    private void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testFindById_happyPath() {
        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("Bob");
        userEntity.setPassword("12345678");
        userEntity.setEmail("Bob.@gmail.com");
        userEntity.setImageUrl("http:///pic.jpg");

        UserEntity saved = userRepository.save(userEntity);

        //when
        UserFullDto foundDto = userService.findById(saved.getId());

        //then
        Assertions.assertNotNull(foundDto);
        Assertions.assertEquals(saved.getId(), foundDto.getId());
        Assertions.assertEquals(saved.getEmail(), foundDto.getEmail());
    }

    @Test
    void testUpdate_happyPath() {
        //given
        UserCreateDto createDto = new UserCreateDto();
        createDto.setEmail("Bob@bobson.com");
        createDto.setLogin("bob");
        createDto.setPassword("12345678");
        createDto.setImageUrl("http://img.jpg");

        UserFullDto createdUser = userService.create(createDto);

        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setEmail("update@updated.com");
        updateDto.setImageUrl("http://updated.jpg");
        updateDto.setId(createdUser.getId());   // TODO -> КЛЮЧЕВОЙ МОМЕНТ !!!!!!!!!!!!!!!!!!!!

        //when
        UserFullDto updateUser = userService.update(updateDto);

        //then
        Assertions.assertNotNull(updateUser);
        Assertions.assertEquals(updateUser.getId(), createdUser.getId());

        Assertions.assertNotEquals(updateUser.getEmail(), createdUser.getEmail());
        Assertions.assertNotEquals(updateUser.getProfileImageUrl(), createdUser.getProfileImageUrl());

        Assertions.assertEquals(updateUser.getLogin(), createdUser.getLogin());
        Assertions.assertEquals(updateUser.getProfileImageUrl(), updateDto.getImageUrl());
        Assertions.assertEquals(updateUser.getPhoneNumber(), updateUser.getPhoneNumber());
    }

//    @Test
//    void testUpdate_whenNotFound() {
//        //given
//        UserUpdateDto updateDto = new UserUpdateDto();
//        updateDto.setEmail("random@gmail.com");
//        updateDto.setImageUrl("http://random.jpg");
//
//        int notExistingId = 13;
//        updateDto.setId(notExistingId);
//
//        //when
//        Exception exception = Assertions.assertThrows(EntityIsNotFoundException.class, () -> userService.update(updateDto));
//
//
//        //then
//        Assertions.assertTrue(exception.getMessage().contains(String.valueOf(notExistingId)));
//    }
}
