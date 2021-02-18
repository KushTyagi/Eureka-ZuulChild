package com.craterzone.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.craterzone.dao.ProductDao;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long>{

	public Optional<ProductDao> findByname(String name);
}
