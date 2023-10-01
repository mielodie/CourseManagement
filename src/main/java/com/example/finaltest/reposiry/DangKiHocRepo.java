package com.example.finaltest.reposiry;

import com.example.finaltest.entity.DangKiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKiHocRepo extends JpaRepository<DangKiHoc, Integer> {
}
