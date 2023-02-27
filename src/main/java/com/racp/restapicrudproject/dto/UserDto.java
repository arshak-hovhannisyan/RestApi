package com.racp.restapicrudproject.dto;

import com.racp.restapicrudproject.entity.ToDo;
import com.racp.restapicrudproject.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private List<ToDoDto> todos;

    public static UserDto toModel(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setTodos(user.getTodos().stream().map(ToDoDto::toModel).collect(Collectors.toList()));
        return userDto;
    }
}
