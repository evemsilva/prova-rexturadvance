package br.com.reservafacil.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reservafacil.domain.Transacao;
import br.com.reservafacil.exception.BusinessException;
import br.com.reservafacil.repository.TransacaoRepository;
import br.com.reservafacil.service.TaxaService;
import br.com.reservafacil.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private TaxaService taxaService;

	@Override
	public List<Transacao> listarTransferencias() {
		return repository.findAll();
	}

	@Override
	public Transacao agendarTransferencia(Transacao transacao) throws BusinessException {
		BigDecimal taxa = taxaService.calcularTaxa(transacao.getValorTransferencia(), transacao.getDataTransferencia());
		transacao.setTaxa(taxa);
		transacao.setDataAgendamento(LocalDate.now());
		return repository.save(transacao);
	}

}
