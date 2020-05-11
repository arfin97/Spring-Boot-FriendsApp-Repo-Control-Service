package com.bs23.friend.repositories;

import com.bs23.friend.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Long> {
    List<Friend> findFriendByEmailOrPhone(String email, String phone);
}
