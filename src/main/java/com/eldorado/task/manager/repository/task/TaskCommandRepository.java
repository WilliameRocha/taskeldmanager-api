package com.eldorado.task.manager.repository.task;

import com.eldorado.task.manager.domain.dto.task.TaskCommandDTO;
import com.eldorado.task.manager.domain.task.Task;
import com.eldorado.task.manager.domain.user.User;
import com.eldorado.task.manager.repository.interfaces.task.ITaskCommandRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskCommandRepository implements ITaskCommandRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Task createTask(TaskCommandDTO taskCommandDTO) {
        Task task = Task.builder()
                        .user(User.builder()
                                  .id(taskCommandDTO.getUserId())
                                  .build())
                        .title(taskCommandDTO.getTitle())
                        .status(taskCommandDTO.getStatus())
                        .deadline(taskCommandDTO.getDeadline())
                        .build();
        this.entityManager.persist(task);
        return task;
    }

    @Override
    @Transactional
    public boolean updateTask(Long id, TaskCommandDTO taskCommandDTO) {

        Task task = Task.builder()
                        .id(id)
                        .user(User.builder()
                                  .id(taskCommandDTO.getUserId())
                                  .build())
                        .title(taskCommandDTO.getTitle())
                        .status(taskCommandDTO.getStatus())
                        .deadline(taskCommandDTO.getDeadline())
                        .build();
        Task result = this.entityManager.merge(task);

        return this.entityManager.contains(result);
    }

    @Override
    @Transactional
    public boolean deleteTask(Long taskId) {
        int totalDeleted = this.entityManager.createQuery("DELETE FROM Task task WHERE task.id = :taskId")
                                             .setParameter("taskId", taskId)
                                             .executeUpdate();
        return totalDeleted > 0;
    }
}
