package com.ccr.hackathon.backend.repository;

import com.ccr.hackathon.backend.model.ManagementContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementContentRepository extends JpaRepository<ManagementContent, Long> {
}
