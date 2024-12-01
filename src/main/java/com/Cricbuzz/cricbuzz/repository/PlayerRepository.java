package com.Cricbuzz.cricbuzz.repository;

import com.Cricbuzz.cricbuzz.model.Player;
import com.Cricbuzz.cricbuzz.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    List<Player> findByAgeGreaterThanEqual(int age);

    @Query(value = "select p from Player p where p.age >= :age and p.speciality = :speciality")
    List<Player> getAllByAgeGreaterThanAndSpeciality(int age,
                                                     Speciality speciality);
}