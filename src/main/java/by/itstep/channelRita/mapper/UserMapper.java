package by.itstep.channelRita.mapper;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "profileImageUrl", source = "imageUrl")
//    @Mapping(target = "phoneNumber", expression = "java(String.valueOf(entity.getId() * 999))")
//    @Mapping(target = "phoneNumber", expression = "id")
    UserFullDto mapToFullDto(UserEntity entity);

    @Mapping(target = "id", ignore = true)
    UserEntity mapToEntity(UserCreateDto dto);

    default String map(Integer number) {
        return String.valueOf(number * 999);
    }
}




//@Mapper
//public interface AnswerMapper {
//
//    AnswerMapper ANSWER_MAPPER = Mappers.getMapper(AnswerMapper.class);
//
//    @Mapping(source = "question.id", target = "questionId")
//    @Mapping(source = "chosenOption.id", target = "optionId")
//    @Mapping(source = "result.id", target = "resultId")
//    AnswerFullDto mapToFullDto(AnswerEntity answerEntity);
//
//    @Mapping(source = "question.id", target = "questionId")
//    @Mapping(source = "chosenOption.id", target = "optionId")
//    AnswerCreateDto mapToCreateDto(AnswerEntity answerEntity);
//
//    @Mapping(source = "questionId", target = "question.id")
//    @Mapping(source = "optionId", target = "chosenOption.id")
//    @Mapping(source = "resultId", target = "result.id")
//    AnswerEntity mapToEntity(AnswerFullDto fullDto);
//
//    @Mapping(source = "questionId", target = "question.id")
//    @Mapping(source = "optionId", target = "chosenOption.id")
//    AnswerEntity mapToEntity(AnswerCreateDto createDto);
