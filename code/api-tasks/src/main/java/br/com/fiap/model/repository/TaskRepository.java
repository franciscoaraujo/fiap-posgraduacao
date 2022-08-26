package br.com.fiap.model.repository;

import br.com.fiap.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("select t from TaskEntity t where t.userEntity.id= :id order by t.createdAt desc ")
    Optional<List<TaskEntity>> findTaskByIdUser(@Param("id")Long id );
}
