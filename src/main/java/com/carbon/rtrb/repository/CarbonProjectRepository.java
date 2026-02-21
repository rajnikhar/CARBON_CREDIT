package com.carbon.rtrb.repository;

import com.carbon.rtrb.model.CarbonProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarbonProjectRepository extends JpaRepository<CarbonProject,String> {
}
