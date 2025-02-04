package com.taskmsys.task_management.repository;

import com.taskmsys.task_management.entity.taskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<taskEntity, Long> {
}
