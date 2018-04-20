package com.example.androidserver;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,String>{
    User findByUserName(String userName);
}
