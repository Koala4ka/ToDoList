package com.planmanage.notes.controller;

import com.planmanage.notes.model.TodoItem;
import com.planmanage.notes.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoItemController {

    @Autowired
    private TodoItemService itemService;

    @GetMapping("/item/{itemId}")
    public TodoItem getItem(@PathVariable Long itemId) {
        System.out.println(itemId);
        return itemService.getItem(itemId);
    }

    @GetMapping("/list/{listId}")
    public List<TodoItem> getItem(@PathVariable UUID listId) {
        return itemService.getAllTodoItemsForListId(listId);
    }

    @PostMapping("/new")
    public ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem item) {
        System.out.println(item);
        return ResponseEntity.ok(itemService.saveTodoItem(item));
    }

    @PutMapping("/edit")
    public ResponseEntity<TodoItem> editTodoItem(@RequestBody TodoItem item) {
        return ResponseEntity.ok(itemService.editTodoItem(item));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteTodoItem(id));
    }

    @PutMapping("/state/{id}")
    public ResponseEntity<TodoItem> changeDoneState(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.changeDoneStateForTodoItem(id));
    }
}


