package by.itstep.channelRita.util;

import by.itstep.channelRita.entity.ChannelEntity;
import by.itstep.channelRita.entity.ChannelEntityType;
import by.itstep.channelRita.entity.PostEntity;

import java.util.Arrays;
import java.util.List;

public class EntityGenerationUtils {
    public static ChannelEntity generateChannel(){
        ChannelEntity entity = new ChannelEntity();
        entity.setName("Name#" + Math.random() * 100);
        entity.setType(ChannelEntityType.PROGRAMMING);

        return entity;
    }

    public static List<PostEntity> generatePost(){
        PostEntity post1 = new PostEntity();
        post1.setContent("post1-content");
        post1.setTitle("post1-title");

        PostEntity post2 = new PostEntity();
        post2.setContent("post2-content");
        post2.setTitle("post2-title");

        PostEntity post3 = new PostEntity();
        post3.setContent("post3-content");
        post3.setTitle("post3-title");

        return Arrays.asList(post1,post2,post3);
    }
}
