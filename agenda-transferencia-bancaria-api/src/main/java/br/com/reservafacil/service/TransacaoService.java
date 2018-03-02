package br.com.reservafacil.service;

import java.util.List;

import br.com.reservafacil.domain.Transacao;
import br.com.reservafacil.exception.BusinessException;

public interface TransacaoService {

	List<Transacao> listarTransferencias();

	Transacao agendarTransferencia(Transacao transacao) throws BusinessException;
	
}
