package br.com.reservafacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reservafacil.domain.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
