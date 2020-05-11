package com.bs23.friend.repositories;

import com.bs23.friend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
