package com.kw.Proj2_spr_2020202060.Login.Repository;

import com.kw.Proj2_spr_2020202060.Login.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :#{#user.id} AND u.password = :#{#user.password}")
    Optional<User> findByUser(User user);
}
