package com.ccr.hackathon.backend.repository;

import com.ccr.hackathon.backend.model.TechContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechContentRepository extends JpaRepository<TechContent, Long> {
}
