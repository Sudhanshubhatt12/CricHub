package com.Cricbuzz.cricbuzz.repository;

import com.Cricbuzz.cricbuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketMatchRepository extends JpaRepository<CricketMatch,Integer> {
}