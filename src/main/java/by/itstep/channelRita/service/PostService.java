package by.itstep.channelRita.service;

import by.itstep.channelRita.dto.post.PostCreateDto;
import by.itstep.channelRita.dto.post.PostFullDto;

public interface PostService {

    PostFullDto create(PostCreateDto createDto);
}
