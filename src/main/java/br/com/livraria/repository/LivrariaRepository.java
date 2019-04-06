package br.com.livraria.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.DAO.LivroDAO;

public interface LivrariaRepository extends JpaRepository<LivroDAO, Long> {
	
	

}
