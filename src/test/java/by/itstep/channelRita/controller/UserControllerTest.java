package by.itstep.channelRita.controller;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.entity.UserEntity;
import by.itstep.channelRita.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // метод который может одни объекты в другие преобразовывать
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void clearDatabase() {
        repository.deleteAll();
    }

    @Test
    void testFindById_happyPath() throws Exception {
        //given
        // когда кто-то взовет  achieventService.send(), то дайте ему Dto

        UserEntity userToSave = new UserEntity();
        userToSave.setEmail("bob@mail.com");    //FAKER
        userToSave.setLogin("bob");
        userToSave.setPassword("bob");
        userToSave.setImageUrl("http://pic.jpg");

        UserEntity savedUser = repository.save(userToSave);

        //when
        MvcResult result = mockMvc.perform(get("/users/{id}", savedUser.getId()))    //вызов был отправлен
//                .andExpect(ожидаю_что_статус_200)
//                .andExpect(ожидаю_что_заголовок_слово_bob)
                .andExpect(status().isOk())
                .andReturn();

        byte[] bytes = result.getResponse().getContentAsByteArray();
        UserFullDto foundUser = objectMapper.readValue(bytes, UserFullDto.class);

        //then
        Assertions.assertNotNull(foundUser);
        Assertions.assertNotNull(foundUser.getId());
        Assertions.assertEquals(foundUser.getId(), savedUser.getId());

    }

    @Test
    void testFindById_whenNotFound() throws Exception {
        //given
        int notExistingId = 100000;   // не существующий ID

        //when
        mockMvc.perform(get("/users/{id}", notExistingId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        //then -> тут тогда не нужен !
    }

    @Test
    void TestCreate_happyPath() throws Exception {
        // given
        UserCreateDto userToSave = new UserCreateDto();
        userToSave.setEmail("Bob_email@gmail.com");    //FAKER
        userToSave.setLogin("bob");
        userToSave.setPassword("bob123");
        userToSave.setImageUrl("http://pic.jpg");

        //when
        MvcResult result = mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)        // на Applecation запросы - буду JSON ответы
                .content(objectMapper.writeValueAsString(userToSave)))

                .andExpect(status().isCreated())    // .isOk()
                .andReturn();

        byte[] bytes = result.getResponse().getContentAsByteArray();
        UserFullDto savedUser = objectMapper.readValue(bytes, UserFullDto.class);

        //then
        Assertions.assertNotNull(savedUser);
    }

    @Test
    void TestCreate_whenEmailIsEmpty() throws Exception {
        // given
        UserCreateDto userToSave = new UserCreateDto();
        userToSave.setEmail(null);    // INVALID email !!!!!!!
        userToSave.setLogin("bob");
        userToSave.setPassword("bob");
        userToSave.setImageUrl("http://pic.jpg");

        //when
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)        // на Applecation запросы - буду JSON ответы
                .content(objectMapper.writeValueAsString(userToSave)))

                .andExpect(status().isBadRequest());   // CHEK status !!!!!!!!!!

    }

    @Test
    void testFindAll_happyPath() throws Exception {
        // given
        UserEntity userToSave = new UserEntity();
        userToSave.setEmail("bob@mail.com");    //FAKER
        userToSave.setLogin("bob");
        userToSave.setPassword("bob");
        userToSave.setImageUrl("http://pic.jpg");

        UserEntity userToSave2 = new UserEntity();
        userToSave2.setEmail("bob2@mail.com");    //FAKER
        userToSave2.setLogin("bob2");
        userToSave2.setPassword("bob2");
        userToSave2.setImageUrl("http://pic2.jpg");

        repository.save(userToSave);
        repository.save(userToSave2);

        //when
        MvcResult result = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
        byte[] bytes = result.getResponse().getContentAsByteArray();
        List<UserFullDto> foundUsers = objectMapper.readValue(bytes, new TypeReference<List<UserFullDto>>() {
        });

        // then
        Assertions.assertNotNull(foundUsers);
        Assertions.assertEquals(2, foundUsers.size());
    }
}
