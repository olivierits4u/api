package lu.its4u.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.its4u.api.entity.ApiCallEntity;

public interface ApiCallRepository extends JpaRepository<ApiCallEntity, Long> {

}
