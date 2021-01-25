package com.example1.MarketplaceProjectOne.repo;

import com.example1.MarketplaceProjectOne.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
