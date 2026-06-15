package com.filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeDAO extends JpaRepository<Filme, Long> {
}