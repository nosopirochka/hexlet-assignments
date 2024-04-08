package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> index() {
        return taskRepository.findAll().stream()
                .map(taskMapper::map)
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO show(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody @Valid TaskCreateDTO createDTO) {
        var task = taskMapper.map(createDTO);
        var user = userRepository.findById(createDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id "
                        + createDTO.getAssigneeId()
                        + " not found"));
        user.addTask(task);
        userRepository.save(user);
        return taskMapper.map(taskRepository.save(task));
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO update(@PathVariable long id, @RequestBody @Valid TaskUpdateDTO updateDTO) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        taskMapper.update(updateDTO, task);
        var user = userRepository.findById(updateDTO.getAssigneeId()).get();
        task.setAssignee(user);

        userRepository.save(user);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        var user = task.getAssignee();
        user.removeTask(task);
        userRepository.save(user);
    }
    // END
}
