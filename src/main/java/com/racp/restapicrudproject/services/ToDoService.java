package com.racp.restapicrudproject.services;

import com.racp.restapicrudproject.dto.ToDoDto;
import com.racp.restapicrudproject.entity.ToDo;
import com.racp.restapicrudproject.entity.User;
import com.racp.restapicrudproject.repository.ToDoRepository;
import com.racp.restapicrudproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    public ToDoDto createToDo(ToDo toDo, Long userId) {
        User user=userRepository.findById(userId).orElse(null);
        toDo.setUser(user);
        return ToDoDto.toModel(toDoRepository.save(toDo));
    }

    public ToDoDto completeToDo(Long id) {
        ToDo toDo=toDoRepository.findById(id).orElse(null);
        toDo.setCompleted(!toDo.getCompleted());
        return ToDoDto.toModel(toDoRepository.save(toDo));
    }
}
