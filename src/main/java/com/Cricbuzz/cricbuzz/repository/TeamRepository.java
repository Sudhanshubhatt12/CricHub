package com.Cricbuzz.cricbuzz.repository;

import com.Cricbuzz.cricbuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}