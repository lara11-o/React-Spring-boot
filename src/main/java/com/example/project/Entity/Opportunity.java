package com.example.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String deadline;
    String location;

    String description;
    String duration;
    String field_of_study;

//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_at", nullable = false, updatable = false)
//     Date createdAt;
//
//    @LastModifiedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updated_at", nullable = false)
//     Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
     User user;

//    @OneToMany(mappedBy = "opportunity")
//            @JsonIgnore
//     List<Application> applications ;

    public Opportunity() {

    }

    public Opportunity(int id, String title, String deadline, String location, String description, String duration, String field_of_study) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.location = location;
        this.description = description;
        this.duration = duration;
        this.field_of_study = field_of_study;
//        this.createdAt = new Date();
//        this.updatedAt = new Date();
//        this.applications = application;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getField_of_study() {
        return field_of_study;
    }

    public void setField_of_study(String field_of_study) {
        this.field_of_study = field_of_study;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public User getPostedBy() {
        return user;
    }

    public void setPostedBy(User postedBy) {
        this.user = postedBy;
    }

//    public List<Application> getApplications() {
//        return applications;
//    }
//
//    public void setApplications(List<Application> applications) {
//        this.applications = applications;
//    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", description=" + description +
                ", location=" + location +
                ", duration='" + duration + '\'' +
                ", field_of_study='" + field_of_study + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
                ", user=" + user +
//                ", applicationList=" + applications +
                '}';
    }
}
