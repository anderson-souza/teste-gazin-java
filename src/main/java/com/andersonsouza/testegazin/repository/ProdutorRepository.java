package com.andersonsouza.testegazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonsouza.testegazin.domain.entity.Produtor;

public interface ProdutorRepository extends JpaRepository<Produtor, Long> {

}
