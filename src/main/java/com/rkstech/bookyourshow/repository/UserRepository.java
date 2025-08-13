package com.rkstech.bookyourshow.repository;

import com.rkstech.bookyourshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepository extends JpaRepository<User,Long> {

}
