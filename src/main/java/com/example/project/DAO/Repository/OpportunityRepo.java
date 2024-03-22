package com.example.project.DAO.Repository;

import com.example.project.Entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepo extends JpaRepository<Opportunity, Integer> {

}
