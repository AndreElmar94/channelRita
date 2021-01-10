package by.itstep.channelRita;

import by.itstep.channelRita.entity.UserEntity;
import by.itstep.channelRita.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChannelRitaApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    void contextLoads() {

    }

    @Test
    void testCreate_happyPath() {

        // given
        UserEntity toSave = generateUser();

        // when
        UserEntity saved = repository.save(toSave);

        //then
        Assertions.assertNotNull(saved);
        Assertions.assertNotNull(saved.getId());

    }


    @Test
    void testFindByLogin_happyPath() {

        // given
        UserEntity toSave = generateUser();
        UserEntity saved = repository.save(toSave);
        String loginToSearch = saved.getLogin();

        // when
        UserEntity found = repository.findByLogin(loginToSearch);

        //then
        Assertions.assertNotNull(found); // проверка что ЛОГИН есть в базе
        Assertions.assertEquals(saved.getId(), found.getId()); // его ID совпадает с тем ID который искали
        Assertions.assertEquals(saved.getLogin(), found.getLogin()); // его Login совпадает с тем Login  который искали

    }

    @Test
    void testFindById_happyPath() {

        // given
        UserEntity toSave = generateUser();
        UserEntity saved = repository.save(toSave);
        Integer idToSearch = saved.getId();

        // when
        UserEntity found = repository.findOneById(idToSearch);

        //then
        Assertions.assertNotNull(found); // проверка что ЛОГИН есть в базе
        Assertions.assertEquals(saved.getId(), found.getId()); // его ID совпадает с тем ID который искали
        Assertions.assertEquals(saved.getLogin(), found.getLogin()); // его Login совпадает с тем Login  который искали

    }

    // FAKER

    private UserEntity generateUser() {
        UserEntity user = new UserEntity();
        user.setLogin("Login#" + Math.random() * 100);
        user.setPassword("Password#" + Math.random() * 100);
        user.setImageUrl("Image#" + Math.random() * 100);

        return user;
    }



}
