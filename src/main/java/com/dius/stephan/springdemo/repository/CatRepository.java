package com.dius.stephan.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dius.stephan.springdemo.models.Cat;

/*
 * By extending JpaRepository, this interface will automagically
 * be implemented on-the-fly by Spring Data, such that methods like
 * {@link JpaRepository#save(Object)} or {@link JpaRepository#findOne(java.io.Serializable)}
 * can be used without having to implement any code.
 * 
 *
 */
public interface CatRepository extends JpaRepository<Cat, Long> {

	/*
	 * Spring Data is also able to map methods on queries, as long as
	 * they follow naming conventions. Thus, it is not required to 
	 * implement methods like this, either.
	 */
    List<Cat> findByName(String name);
}