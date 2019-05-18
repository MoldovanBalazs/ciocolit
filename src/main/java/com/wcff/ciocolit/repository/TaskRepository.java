package com.wcff.ciocolit.repository;

import com.wcff.ciocolit.domain.Task;
import com.wcff.ciocolit.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByUserList(List<User> users);

}
