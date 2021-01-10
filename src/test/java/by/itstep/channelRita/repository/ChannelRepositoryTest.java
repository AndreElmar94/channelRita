package by.itstep.channelRita.repository;

import by.itstep.channelRita.entity.ChannelEntity;
import by.itstep.channelRita.entity.PostEntity;
import by.itstep.channelRita.repository.ChannelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static by.itstep.channelRita.util.EntityGenerationUtils.generateChannel;
import static by.itstep.channelRita.util.EntityGenerationUtils.generatePost;
//
//@SpringBootTest
//public class ChannelRepositoryTest {
//
//    @Autowired
//    public ChannelRepository repository;
//
//
//    @Test
//    void findById_happyPath(){
//        //given
//        ChannelEntity toSave = generateChannel();
//        List<PostEntity> posts = generatePost();
//
//        toSave.setPosts(posts);
//        for (PostEntity p : posts){
//            p.setChannel(toSave);
//        }
//
//        ChannelEntity saved = repository.save(toSave);
//        Integer idToSearch = saved.getId();
//
//        //when
//        ChannelEntity found = repository.findOneById(idToSearch);
//        Assertions.assertEquals(3, found.getPosts().size());
//
//
//
//        found.getPosts().remove(0);
//        ChannelEntity saved2 = repository.save(found);
//        ChannelEntity found2 = repository.findOneById(saved2.getId());
//
//        //then
//        Assertions.assertNotNull(found);
//        Assertions.assertEquals(saved.getId(), found.getId());
//        Assertions.assertEquals(2, found.getPosts().size());
//
//
//    }
//
//    @Test
//    void deleteById_happyPath(){
//        //given
//        ChannelEntity toSave = generateChannel();
//        List<PostEntity> posts = generatePost();
//
//        toSave.setPosts(posts);
//        for (PostEntity p : posts){
//            p.setChannel(toSave);
//        }
//
//        ChannelEntity saved = repository.save(toSave);
//        Integer idToSearch = saved.getId();
//
//        //when
//        System.out.println("***********************");
//        repository.deleteById(idToSearch); // удаляем канал
//        ChannelEntity found = repository.findOneById(idToSearch);
//
//        //then ?
//        Assertions.assertNull(found);
//
//    }
//
//    //--------------------GENERATIONS-------------------
//
//
//
//}
