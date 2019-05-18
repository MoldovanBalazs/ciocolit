package com.wcff.ciocolit.service;

import com.wcff.ciocolit.domain.Task;
import com.wcff.ciocolit.domain.User;
import com.wcff.ciocolit.dto.TaskDto;
import com.wcff.ciocolit.repository.TaskRepository;
import com.wcff.ciocolit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks/{username}")
    public List<TaskDto> getUserTasks(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<Task> tasks = taskRepository.findAllByUserList(users);
        List<TaskDto> dtos = new ArrayList<>();
        if(tasks != null) {
            tasks.forEach(task -> {
                TaskDto dto = new TaskDto();
                dto.setName(task.getName());
                dto.setProgress(task.getProgress());
                dtos.add(dto);
            });
        }
        if(dtos.isEmpty()) {
            return null;
        }
        return dtos;
    }
}
