package com.example.Orders.Repository.parentRepository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Orders.Entity.parent.UpdateOrderTracker;

public interface UpdateOrderTrackerRepository extends JpaRepository<UpdateOrderTracker, UUID> {
}
