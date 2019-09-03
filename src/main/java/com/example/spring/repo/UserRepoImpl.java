package com.example.spring.repo;

import com.example.spring.models.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepoImpl implements UserRepo {

    RedisTemplate<String,User> redisTemplate;

    HashOperations hashOperations;

    public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations= redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
    hashOperations.put("USER",user.getId(),user);
    System.out.println("User Details are saved");
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return (User)hashOperations.get("USER",id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(id);
    }
}
