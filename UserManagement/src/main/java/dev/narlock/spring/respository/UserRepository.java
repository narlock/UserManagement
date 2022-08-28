package dev.narlock.spring.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.narlock.spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
