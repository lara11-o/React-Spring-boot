package com.example.project.Service;

import com.example.project.DAO.Opportunity.OpportunityDAO;
import com.example.project.DAO.Repository.OpportunityRepo;
import com.example.project.DAO.User.UserDAO;
import com.example.project.DTO.UserMessageDTO;
import com.example.project.Entity.Opportunity;
import com.example.project.Entity.User;
import com.example.project.Exception.OpportunityException.NotFoundException;
import com.example.project.Exception.OpportunityException.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImp implements OpportunityService {
    private OpportunityRepo opportunityRepo;
    private OpportunityDAO opportunityDAO;
    private UserDAO userDAO;

    @Autowired
    public OpportunityServiceImp(OpportunityRepo opportunityRepo, OpportunityDAO opportunityDAO, UserDAO userDAO) {
        this.opportunityRepo = opportunityRepo;
        this.opportunityDAO = opportunityDAO;
        this.userDAO = userDAO;
    }

    @Override
    public UserMessageDTO addOpportunity(Opportunity opportunity) {
        if (opportunity.getTitle().isEmpty()) {
            throw new InvalidInputException("Title cannot be empty");
        } else {
            opportunityRepo.save(opportunity);
            return new UserMessageDTO("Opportunity posted successfully!", true);
        }
    }

    @Override
    public Opportunity getPostDetails(int id) {
        return opportunityDAO.getDetailsById(id);
    }

    @Override
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepo.findAll();
    }

    @Override
    public String updateOpportunity(int id, Opportunity opportunity) {
        try {
            Opportunity existingOpportunity = opportunityRepo.getById(id);
            if (existingOpportunity != null) {
                existingOpportunity.setTitle(opportunity.getTitle());
                existingOpportunity.setDeadline(opportunity.getDeadline());
                existingOpportunity.setDuration(opportunity.getDuration());
                existingOpportunity.setField_of_study(opportunity.getField_of_study());
                existingOpportunity.setLocation(opportunity.getLocation());
                existingOpportunity.setDescription(opportunity.getDescription());
                opportunityRepo.save(existingOpportunity);
                return "Opportunity updated successfully!";
            } else {
                return "Opportunity not found!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update opportunity: " + e.getMessage();
        }
    }

    @Override
    public List<Opportunity> getAllOpportunitiesByUserId(int userId) {
        return opportunityDAO.getAllOpportunitiesOfUser(userId);
    }

    @Override
    public UserMessageDTO addOpportunityByUser(Opportunity opportunity, int userId) {
        if (opportunity.getTitle().isEmpty() || userId <= 0) {
            return new UserMessageDTO("Invalid input parameters", false);
        } else {
            User user = userDAO.findById(userId);
            if (user == null) {
                return new UserMessageDTO("User not found", false);
            }
            opportunity.setPostedBy(user);
            opportunityRepo.save(opportunity);
            return new UserMessageDTO("Opportunity posted successfully!", true);
        }
    }

    @Override
    public List<Opportunity> searchByCategory(String field_of_study) {
        return opportunityDAO.searchByCategory(field_of_study);
    }

    @Override
    public String deleteOpportunity(int id) {
        int deletedOppId = opportunityDAO.deleteOppOfUser(id);
        if (deletedOppId != -1) {
            return "Opportunity with ID " + deletedOppId + " has been deleted successfully";
        } else {
            throw new NotFoundException("Opportunity not found with id: " + id);
        }
    }
}

