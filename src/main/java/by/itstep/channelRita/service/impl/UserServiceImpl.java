package by.itstep.channelRita.service.impl;

import by.itstep.channelRita.dto.user.UserCreateDto;
import by.itstep.channelRita.dto.user.UserFullDto;
import by.itstep.channelRita.dto.user.UserUpdateDto;
import by.itstep.channelRita.entity.UserEntity;
import by.itstep.channelRita.exception.EntityIsNotFoundException;
import by.itstep.channelRita.exception.UserCredentialsAreTakenException;
import by.itstep.channelRita.repository.UserRepository;
import by.itstep.channelRita.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.itstep.channelRita.mapper.UserMapper.USER_MAPPER;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserFullDto findById(Integer id) {
        UserEntity foundEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityIsNotFoundException("User was not found by id: " + id));

//        if (foundEntity == null) {  // TODO replace with Optional and lambda
//            throw new EntityIsNotFoundException("User was not found by id: " + id);
//        }

//        String s = String.format("a: %s b: %s", 5,7); // пример как работает метод "формат"
        log.info("UserServiceImpl -> found user : {} start by id: {}", foundEntity, id);
        return USER_MAPPER.mapToFullDto(foundEntity);
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserFullDto> findAll() {
        List<UserEntity> foundEntities = userRepository.findAll();

//        List<UserFullDto> users = new ArrayList<>(); // TODO replace with StreamAPI
//        for (UserEntity entity : foundEntity) {
//            users.add(USER_MAPPER.mapToFullDto(entity));
//        }

        List<UserFullDto> users = foundEntities
                .stream()
                .map(userEntity -> USER_MAPPER.mapToFullDto(userEntity)).collect(toList());
        log.info("UserServiceImp; -> found {} users", users.size());
        return users;
    }

    @Override
    @Transactional
    public UserFullDto create(UserCreateDto createDto) {
        UserEntity entityToSave = USER_MAPPER.mapToEntity(createDto);

        // TODO = а что если email / login уже заняты ?
        checkIfLoginOrEmailIsTaken(entityToSave);

        UserEntity savedEntity = userRepository.save(entityToSave);
        log.info("UserServiceImpl - > user {} successfully saved", savedEntity);
        return USER_MAPPER.mapToFullDto(savedEntity);
    }

    @Override
    @Transactional
    public UserFullDto update(UserUpdateDto updateDto) {
        UserEntity entityToUpdate = userRepository.findOneById(updateDto.getId());
//        if (entityToUpdate == null) {
//            throw new RuntimeException("User was not found by id: " + updateDto.getId());
//        }
        entityToUpdate.setEmail(updateDto.getEmail());
        entityToUpdate.setImageUrl(updateDto.getImageUrl());

        checkIfLoginOrEmailIsTaken(entityToUpdate);

        UserEntity updatedEntity = userRepository.save(entityToUpdate);
        log.info("UserServiceImpl -> user {} was successfully updated", updatedEntity);
        return USER_MAPPER.mapToFullDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            throw new RuntimeException("User was not found by id: " + id);
        }
        userRepository.deleteById(id);

    }

    private void checkIfLoginOrEmailIsTaken(UserEntity userEntity) {
        // if (есть юзер с моим email / login И у него не мой ID)
//        List<UserEntity> foundUsers = userRepository.findByLoginOrEmail(userEntity.getLogin(), userEntity.getEmail());
//        for (UserEntity user : foundUsers) {
//            if (!user.getId().equals(userEntity.getId())) {
//                throw new UnsupportedOperationException(
//                        "Email: " + userEntity.getEmail() + " | login: " + userEntity.getLogin());
//            }
//        }

        boolean taken = userRepository.findByLoginOrEmail(userEntity.getLogin(), userEntity.getEmail())
                .stream()
                .anyMatch(user -> !user.getId().equals(userEntity.getId()));
        if (taken) {
            throw new UserCredentialsAreTakenException(
                    "Email: " + userEntity.getEmail() + " | login: " + userEntity.getLogin());

        }

    }

}
