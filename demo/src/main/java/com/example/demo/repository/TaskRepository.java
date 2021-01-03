package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  List<Task> findByUserId(Integer userId);

  Task findByTaskId(Integer taskId);

  @Transactional
  @Modifying
  @Query("update Task t set t.taskStatus=:taskStatus where t.taskId=:taskId")
  void updateTaskStatus(@Param("taskId") Integer taskId, @Param("taskStatus") String taskStatus);

  @Transactional
  @Modifying
  @Query("update Task t set t.taskReview=:taskReview where t.taskId=:taskId")
  void updateTaskReview(@Param("taskId") Integer taskId, @Param("taskReview") String taskReview);
}
