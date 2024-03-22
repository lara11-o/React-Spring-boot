package com.example.project.DTO.request;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

  private String name;


  private String email;

  private String password;

}
