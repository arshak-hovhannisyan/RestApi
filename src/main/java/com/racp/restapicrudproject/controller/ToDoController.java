package com.racp.restapicrudproject.controller;

import com.racp.restapicrudproject.entity.ToDo;
import com.racp.restapicrudproject.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/createToDo")
    public ResponseEntity<?> createOnlyToDo(@RequestBody ToDo toDo) {
        try {
            toDoService.createOnlyToDo(toDo);
            return ResponseEntity.ok("Задача сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/createToDoUser")
    public ResponseEntity<?> createToDoWithUser(@RequestBody ToDo todo,
                                                @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDoWithUser(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/todoStatus")
    public ResponseEntity<?> completeToDo(@RequestParam Long Id) {
        try {
            return ResponseEntity.ok(toDoService.completeToDo(Id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }
}