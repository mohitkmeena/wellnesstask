package com.mohit.wellnesstask.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.wellnesstask.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {   

    /*
     * repoitory for task entity
     * it will access the database
     *  it have built in methods like save() and findbyid() etc.  inherited from JpaRepository
     * 
     */
}
