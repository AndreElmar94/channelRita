package by.itstep.channelRita;

import by.itstep.channelRita.entity.ChannelEntity;
import by.itstep.channelRita.entity.ChannelEntityType;
import by.itstep.channelRita.entity.PostEntity;
import by.itstep.channelRita.repository.ChannelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static by.itstep.channelRita.EntityGenerationUtils.generateChannel;
import static by.itstep.channelRita.EntityGenerationUtils.generatePosts;

@SpringBootTest
public class ChannelRitaRepositoryTest {

//    @Autowired
//    private ChannelRepository repository;
//
//    @Test
//    void findById_happyPath() {
//        // given
//        ChannelEntity toSave = generateChannel(); // он ничего не знает про посты
//        List<PostEntity> posts = generatePosts(); // Получаем список рандомных постов. И они ничего не знают про канал
//
//        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        toSave.setPosts(posts); // Связываем entity между собой (канал с постами)
//        for (PostEntity p : posts) {
//            p.setChannel(toSave);   // А теперь каждый транзитивный ENTITY знает про свой канал
//        }
//        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//
//
//        ChannelEntity saved = repository.save(toSave);  // В момент сохранения, toSave содержит 3 новых поста
//        Integer idToSearch = saved.getId(); // берем ID ранее
//        // созданного элемента, чотьы потом его найти в БД
//
//        //when
//        ChannelEntity found = repository.findOneById(idToSearch);
//
//        //then
//        Assertions.assertNotNull(found);
//        Assertions.assertEquals(saved.getId(), found.getId());
//        Assertions.assertEquals(3, found.getPosts().size());
//
//    }
//
//
//    @Test
//    void deleteById_happyPath() {
//        // given
//        ChannelEntity toSave = generateChannel(); // он ничего не знает про посты
//        List<PostEntity> posts = generatePosts(); // Получаем список рандомных постов. И они ничего не знают про канал
//
//        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        toSave.setPosts(posts); // Связываем entity между собой (канал с постами)
//        for (PostEntity p : posts) {
//            p.setChannel(toSave);   // А теперь каждый транзитивный ENTITY знает про свой канал
//        }
//        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//
//
//        ChannelEntity saved = repository.save(toSave);  // В момент сохранения, toSave содержит 3 новых поста
//        Integer idToSearch = saved.getId(); // берем ID ранее
//        // созданного элемента, чотьы потом его найти в БД
//
//        //when
//        System.out.println("=============================== ");
//        repository.deleteById(idToSearch);    // удаляем канал
//        ChannelEntity found = repository.findOneById(idToSearch);    // ищем по ID того, кого только что удалили
//
//        //then
//        Assertions.assertNull(found);    // убедились, что его нет
//
//    }
//

}
