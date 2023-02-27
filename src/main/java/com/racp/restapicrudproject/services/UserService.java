package com.racp.restapicrudproject.services;

import com.racp.restapicrudproject.dto.UserDto;
import com.racp.restapicrudproject.entity.User;
import com.racp.restapicrudproject.exception.UserAlreadyExistException;
import com.racp.restapicrudproject.exception.UserNotFoundException;
import com.racp.restapicrudproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> allUsersDto = new ArrayList<>();
        for (User u : allUsers) {
            allUsersDto.add(UserDto.toModel(u));
        }
        return allUsersDto;
    }

    public UserDto getById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserDto.toModel(user);
    }

    public UserDto getByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserDto.toModel(user);
    }

    public void save(User user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
    }

    public UserDto delete(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserDto.toModel(user);
    }

}
