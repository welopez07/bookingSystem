package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Integer> {
}
