package com.example1.MarketplaceProjectOne.repo;

import com.example1.MarketplaceProjectOne.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
