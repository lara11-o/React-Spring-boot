package com.example.project.DAO.Opportunity;


import com.example.project.Entity.Opportunity;

import java.util.List;

public interface OpportunityDAO {
    void save(Opportunity opportunity);

    Opportunity getDetailsById(int id);

    List<Opportunity> getAllOpportunitiesOfUser(int id);

    List<Opportunity> searchByCategory(String category);

    int deleteOppOfUser(int id);
}
