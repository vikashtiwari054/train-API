package com.example.train.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.train.entity.Train;

import jakarta.transaction.Transactional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from train  where number=:number", nativeQuery = true)
	void removeTrain(@Param("number") String number);

//	@Transactional
//    @Modifying
//    @Query("UPDATE train t SET t.name = :name, t.stations=:stations WHERE t.number = :number")
//    void updateTrain(@Param("name") String name, @Param("stations") List<String> stations,@Param("number") String number);

	boolean existsByNumber(String number);

	Train findByNumber(String number);

	@Query("SELECT t.name FROM Train t WHERE t.source = ?1 AND t.destination = ?2")
	List<String> findBySourceAndDestination(String source, String destination);
}
