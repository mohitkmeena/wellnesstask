package com.mohit.wellnesstask.model;


import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "task")
public class Task {

  /*
   * it is the model layer task
   * with id title description dueDate status createdAt updatedAt
   * we are using lombok for getters , setters and constructors to keep our code clean and maintain the readability
   */
  @Id
   private int id;
   private String title;
   private String description;
   
   private Date dueDate;
   @Enumerated(EnumType.STRING)
   private Status status;
  
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;


   public enum Status { 
    pending, 
    in_progress, 
    completed;
 }

    

    
}
