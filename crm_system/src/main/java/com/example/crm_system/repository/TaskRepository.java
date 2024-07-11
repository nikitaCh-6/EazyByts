package com.example.crm_system.repository;

import com.example.crm_system.model.Tasks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Tasks> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Tasks.class).getResultList();
    }

    @Transactional
    public Tasks save(Tasks task) {
        if (task.getId() == null) {
            entityManager.persist(task);
        } else {
            entityManager.merge(task);
        }
        return task;
    }

    @Transactional
    public void delete(Long id) {
        Tasks task = entityManager.find(Tasks.class, id);
        if (task != null) {
            entityManager.remove(task);
        }
    }

    @Transactional
    public Optional<Tasks> findById(Long id) {
        Tasks task = entityManager.find(Tasks.class, id);
        return task != null ? Optional.of(task) : Optional.empty();
    }

    @Transactional
    public void deleteById(Long id) {
        Tasks task = entityManager.find(Tasks.class, id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}
