package com.taskmsys.task_management.repository;

import com.taskmsys.task_management.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<userEntity, Long> {

}
