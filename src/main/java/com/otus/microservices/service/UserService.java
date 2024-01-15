package com.otus.microservices.service;

import com.otus.microservices.exception.InvalidDataPersistenceException;
import com.otus.microservices.model.User;
import com.otus.microservices.repository.UserRepository;
import com.otus.microservices.rest.dto.UserDto;
import com.otus.microservices.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }
    @Transactional
    public UserDto save(UserDto dto) {
        if (dto.getId() != null) {
            throw new InvalidDataPersistenceException(String.format("UserDto has not null id (%s)", dto.getId()));
        }
        User entity = userMapper.toEntity(dto);
        this.userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Transactional
    public UserDto update(Integer userId, UserDto dto) {
        if (userId == null) {
            throw new InvalidDataPersistenceException("UserId is null");
        }
        boolean isExists = userRepository.existsById(userId);
        if (!isExists) {
            throw new InvalidDataPersistenceException(String.format("User with id = %s not found while update", userId));
        }
        dto.setId(userId);
        User entity = userMapper.toEntity(dto);
        this.userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Transactional
    public void delete(Integer id) {
        boolean isExists = userRepository.existsById(id);
        if (!isExists) {
            throw new InvalidDataPersistenceException(String.format("User with id = %s not found while delete", id));
        }
        this.userRepository.deleteById(id);
    }
}
