package com.example.project.controllers.restController;

import com.example.project.DTO.UserMessageDTO;
import com.example.project.Entity.Opportunity;
import com.example.project.Service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class OpportunityController {

    private final OpportunityService opportunityService;

    @Autowired
    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    @PostMapping("/opportunities")
    public ResponseEntity<UserMessageDTO> addOpportunity(@RequestBody Opportunity opportunity){
        return ResponseEntity.ok(opportunityService.addOpportunity(opportunity));
    }

    @GetMapping("/opportunity/{id}")
    public ResponseEntity<Opportunity> GetPostDetails(@PathVariable int id){
        Opportunity opportunity = opportunityService.getPostDetails(id);
        if(opportunity != null){
            return ResponseEntity.ok(opportunity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/opportunities")
    public ResponseEntity<List<Opportunity>> GetAllOpportunities(){
        List<Opportunity> opportunities = opportunityService.getAllOpportunities();
        return ResponseEntity.ok(opportunities);
    }

    @PutMapping("/UpdateDetails/{id}")
    public ResponseEntity<String> updateOpportunity(@PathVariable int id, @RequestBody Opportunity opportunity) {
        return ResponseEntity.ok(opportunityService.updateOpportunity(id, opportunity));
    }

    @GetMapping("/opportunities/{userId}")
    public ResponseEntity<List<Opportunity>> getAllOpportunitiesByUserId(@PathVariable int userId) {
        List<Opportunity> opportunities = opportunityService.getAllOpportunitiesByUserId(userId);
        return ResponseEntity.ok(opportunities);
    }

    @PostMapping("/postOppByUser/{userId}")
    public ResponseEntity<UserMessageDTO> addOpportunityByUser(@RequestBody Opportunity opportunity, @PathVariable int userId) {
        return ResponseEntity.ok(opportunityService.addOpportunityByUser(opportunity, userId));
    }

    @GetMapping("/serachCategory/{field_of_study}")
    public ResponseEntity<List<Opportunity>> searchByCategory(@PathVariable String field_of_study){
        List<Opportunity> categories = opportunityService.searchByCategory(field_of_study);
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/deleteOpp/{id}")
    public ResponseEntity<String> deleteOpportunity(@PathVariable int id) {
        return ResponseEntity.ok(opportunityService.deleteOpportunity(id));
    }
}
