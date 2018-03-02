package br.com.reservafacil.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.reservafacil.domain.Transacao;
import br.com.reservafacil.service.ValidaTransacaoService;

@Service
public class ValidaTransacaoServiceImpl implements ValidaTransacaoService {

	@Override
	public void validar(Transacao transacao) {

		if(transacao.getContaOrigem() == null) 	throw new IllegalArgumentException("O valor da conta de origem não pode ser nulo, não foi possível agendar a transferência");
		
		if(transacao.getContaDestino() == null) throw new IllegalArgumentException("O valor da conta de destino não pode ser nulo, não foi possível agendar a transferência");
		
		if (transacao.getValorTransferencia() == null || transacao.getValorTransferencia().compareTo(BigDecimal.ZERO) < 1) throw new IllegalArgumentException("O valor deve ser maior que zero, não foi possível agendar a transferência");
		
		if (transacao.getDataTransferencia() == null) throw new IllegalArgumentException("O valor deve ser maior que zero, não foi possível agendar a transferência");
		
	}

}
