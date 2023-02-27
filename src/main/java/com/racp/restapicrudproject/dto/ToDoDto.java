package com.racp.restapicrudproject.dto;

import com.racp.restapicrudproject.entity.ToDo;
import com.racp.restapicrudproject.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToDoDto {

    private Long id;
    private String title;
    private Boolean completed;
   private String description;

    public static ToDoDto toModel(ToDo toDo) {
        ToDoDto toDoDto = new ToDoDto();
        toDoDto.setId(toDoDto.getId());
        toDoDto.setTitle(toDo.getTitle());
        toDoDto.setCompleted(toDo.getCompleted());
        toDoDto.setDescription(toDo.getDescription());
        return toDoDto;
    }
}