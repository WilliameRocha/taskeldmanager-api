package com.eldorado.task.manager.repository.task;

import com.eldorado.task.manager.domain.dto.task.TaskQueryByStatusRequestDTO;
import com.eldorado.task.manager.domain.dto.task.TaskQueryDTO;
import com.eldorado.task.manager.domain.task.Task;
import com.eldorado.task.manager.repository.interfaces.task.ITaskQueryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class TaskQueryRepository implements ITaskQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TaskQueryDTO> getAllTasks() {
        return this.entityManager.createQuery("SELECT task FROM Task task", Task.class)
                                 .getResultList()
                                 .stream()
                                 .map(task -> TaskQueryDTO.builder()
                                                                .id(task.getId())
                                                                .userId(task.getUser().getId())
                                                                .title(task.getTitle())
                                                                .status(task.getStatus())
                                                                .deadline(task.getDeadline())
                                                                .createdAt(task.getCreatedAt())
                                                                .build())
                                 .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskQueryDTO> getTaskById(Long id) {
        Task task = this.entityManager.find(Task.class, id);
        TaskQueryDTO taskQueryDTO = null;
        if(task != null) {
            taskQueryDTO = TaskQueryDTO.builder()
                                       .id(task.getId())
                                       .userId(task.getUser().getId())
                                       .title(task.getTitle())
                                       .status(task.getStatus())
                                       .deadline(task.getDeadline())
                                       .createdAt(task.getCreatedAt())
                                       .build();
        }
        return Optional.ofNullable(taskQueryDTO);
    }

    @Override
    @Transactional
    public List<TaskQueryDTO> getTasksByUserId(Long userId) {
        return this.entityManager.createQuery("SELECT task FROM Task task WHERE task.user.id = :userId", Task.class)
                                 .setParameter("userId", userId)
                                 .getResultList()
                                 .stream()
                                 .map(task -> TaskQueryDTO.builder()
                                                                .id(task.getId())
                                                                .userId(task.getUser().getId())
                                                                .title(task.getTitle())
                                                                .status(task.getStatus())
                                                                .deadline(task.getDeadline())
                                                                .createdAt(task.getCreatedAt())
                                                                .build())
                                 .collect(Collectors.toList());
    }

    @Override
    public List<TaskQueryDTO> getTasksByStatus(TaskQueryByStatusRequestDTO filter) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);

        Root<Task> taskRoot = criteriaQuery.from(Task.class);

        Predicate predicate = criteriaBuilder.equal(taskRoot.get("status"), filter.getStatus());

        criteriaQuery.where(predicate);

        Order order = criteriaBuilder.asc(taskRoot.get(filter.getOrderBy()));

        if(filter.getOrderByDirection().equalsIgnoreCase("DESC")) {
            order = criteriaBuilder.desc(taskRoot.get(filter.getOrderBy()));
        }

        criteriaQuery.orderBy(order);

        return this.entityManager.createQuery(criteriaQuery)
                .getResultList()
                .stream()
                .map(task -> TaskQueryDTO.builder()
                        .id(task.getId())
                        .userId(task.getUser().getId())
                        .title(task.getTitle())
                        .status(task.getStatus())
                        .deadline(task.getDeadline())
                        .createdAt(task.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
