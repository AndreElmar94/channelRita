package by.itstep.channelRita.repository;

import by.itstep.channelRita.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    UserEntity findByLogin(String login);

    UserEntity findOneById(Integer id);

    List<UserEntity> findByLoginOrEmail(String login, String email);



}
