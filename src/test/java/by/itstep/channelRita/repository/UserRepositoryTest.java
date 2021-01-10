package by.itstep.channelRita.repository;

import by.itstep.channelRita.entity.UserEntity;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	private final Faker faker = new Faker();

	@Test
	void contextLoads() {

	}

	@Test
	void testCreate_happyPath() {
		//given
		UserEntity toSave1 = generateUser();

		//when
		UserEntity saved = repository.save(toSave1);



		//then
		Assertions.assertNotNull(saved);
		Assertions.assertNotNull(saved.getId());
	}

	@Test
	void testFindByLogin_happyPath(){
		//given
		UserEntity toSave = generateUser();
		UserEntity saved = repository.save(toSave);
		String loginToSearch = saved.getLogin();

		//when
		UserEntity found = repository.findByLogin(loginToSearch);

		//then
		Assertions.assertNotNull(found);
		Assertions.assertEquals(saved.getId(), found.getId());
		Assertions.assertEquals(saved.getLogin(), found.getLogin());

	}

	@Test
	void testFindById_happyPath(){
		//given
		UserEntity toSave = generateUser();
		UserEntity saved = repository.save(toSave);
		Integer idToSearch = saved.getId();

		//when
		UserEntity found = repository.findOneById(idToSearch);

		//then
		Assertions.assertNotNull(found);
		Assertions.assertEquals(saved.getId(), found.getId()); //мы ждем что они совпадут
		Assertions.assertEquals(saved.getLogin(), found.getLogin());//мы ждем что они совпадут

	}


	private UserEntity generateUser(){
		UserEntity userEntity = new UserEntity();
		userEntity.setLogin(faker.artist().name() + Math.random() * 100 );
		userEntity.setPassword(faker.random().toString());
		userEntity.setImageUrl(faker.avatar().image());
		System.out.println(userEntity.toString());

		return userEntity;
	}



}
