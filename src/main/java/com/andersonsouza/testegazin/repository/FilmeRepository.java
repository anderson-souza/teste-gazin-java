package com.andersonsouza.testegazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonsouza.testegazin.domain.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
