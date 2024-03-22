//package com.example.project.Entity;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Application {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int id;
//    String first_name;
//    String last_name;
//    String email;
//    String password;
//    String academicBackground;
//    String coverLetter;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User applicant;
//
//    @ManyToOne
//    @JoinColumn(name = "opportunity_id")
//    private Opportunity opportunity;
//
//
////    @CreatedDate
////    @Temporal(TemporalType.TIMESTAMP)
////    @Column(name = "created_at", nullable = false, updatable = false)
////    private Date createdAt;
////
////    @LastModifiedDate
////    @Temporal(TemporalType.TIMESTAMP)
////    @Column(name = "updated_at", nullable = false)
////    private Date updatedAt;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAcademicBackground() {
//        return academicBackground;
//    }
//
//    public void setAcademicBackground(String academicBackground) {
//        this.academicBackground = academicBackground;
//    }
//
//    public String getCoverLetter() {
//        return coverLetter;
//    }
//
//    public void setCoverLetter(String coverLetter) {
//        this.coverLetter = coverLetter;
//    }
//
//    public User getApplicant() {
//        return applicant;
//    }
//
//    public void setApplicant(User applicant) {
//        this.applicant = applicant;
//    }
//
//    public Opportunity getOpportunity() {
//        return opportunity;
//    }
//
//    public void setOpportunity(Opportunity opportunity) {
//        this.opportunity = opportunity;
//    }
//
////    public Date getCreatedAt() {
////        return createdAt;
////    }
////
////    public void setCreatedAt(Date createdAt) {
////        this.createdAt = createdAt;
////    }
////
////    public Date getUpdatedAt() {
////        return updatedAt;
////    }
////
////    public void setUpdatedAt(Date updatedAt) {
////        this.updatedAt = updatedAt;
////    }
//}
