package com.ccr.hackathon.backend.repository;

import com.ccr.hackathon.backend.model.SoftSkillsContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsContentRepository extends JpaRepository<SoftSkillsContent, Long> {
}
