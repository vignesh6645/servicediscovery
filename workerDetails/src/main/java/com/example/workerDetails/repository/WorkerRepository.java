package com.example.workerDetails.repository;

import com.example.workerDetails.model.worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<worker,Integer> {
}
