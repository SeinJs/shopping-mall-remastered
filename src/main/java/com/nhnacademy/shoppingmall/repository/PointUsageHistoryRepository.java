package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.entity.PointUsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointUsageHistoryRepository extends JpaRepository<PointUsageHistory, Integer> {
}
