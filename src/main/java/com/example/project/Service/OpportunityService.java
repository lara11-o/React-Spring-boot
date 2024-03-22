package com.example.project.Service;

import com.example.project.DTO.UserMessageDTO;
import com.example.project.Entity.Opportunity;

import java.util.List;

public interface OpportunityService {
    UserMessageDTO addOpportunity(Opportunity opportunity);
    Opportunity getPostDetails(int id);
    List<Opportunity> getAllOpportunities();
    String updateOpportunity(int id, Opportunity opportunity);
    List<Opportunity> getAllOpportunitiesByUserId(int userId);
    UserMessageDTO addOpportunityByUser(Opportunity opportunity, int userId);
    List<Opportunity> searchByCategory(String field_of_study);
    String deleteOpportunity(int id);
}

