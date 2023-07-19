package lu.its4u.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import lu.its4u.api.entity.ApiCallEntity;

public interface ApiCallRepository extends JpaRepository<ApiCallEntity, Long> {
//	@Query(value = "select * from api_call where callDate <= :date", nativeQuery = true)
	List<ApiCallEntity> findByCallDateBefore(@Param("date") Date callDate);

}
