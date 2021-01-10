package by.itstep.channelRita.service.impl;

import by.itstep.channelRita.dto.post.PostCreateDto;
import by.itstep.channelRita.dto.post.PostFullDto;
import by.itstep.channelRita.entity.ChannelEntity;
import by.itstep.channelRita.entity.PostEntity;
import by.itstep.channelRita.repository.ChannelRepository;
import by.itstep.channelRita.repository.PostRepository;
import by.itstep.channelRita.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static by.itstep.channelRita.mapper.PostMapper.POST_MAPPER;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    @Transactional
    public PostFullDto create(PostCreateDto createDto) {

        PostEntity postToSave = POST_MAPPER.mapToEntity(createDto);

        ChannelEntity channel = channelRepository.findOneById(createDto.getChannelId());
        postToSave.setChannel(channel);

        PostEntity savedPost = postRepository.save(postToSave);

        PostFullDto postDto = POST_MAPPER.mapToFullDto(savedPost);
        System.out.println("LOG");

        return postDto;
    }
}
