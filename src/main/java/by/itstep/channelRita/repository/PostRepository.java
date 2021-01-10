package by.itstep.channelRita.repository;

import by.itstep.channelRita.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    @Query(value = "SELECT  * FROM post WHERE id = :myId", nativeQuery = true)
    PostEntity findOneById(@Param("myId") Integer id);


}
