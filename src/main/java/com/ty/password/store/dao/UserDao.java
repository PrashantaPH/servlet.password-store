package com.ty.password.store.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.password.store.dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User validateUser(String email, String password) {
		String jpql = "SELECT u FROM User u WHERE u.email=?1 AND u.password=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> user = query.getResultList();
		return user.get(0);
	}
}
