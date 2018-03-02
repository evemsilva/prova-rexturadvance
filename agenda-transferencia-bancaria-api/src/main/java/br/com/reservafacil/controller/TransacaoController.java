package br.com.reservafacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reservafacil.domain.Transacao;
import br.com.reservafacil.exception.BusinessException;
import br.com.reservafacil.service.TransacaoService;
import br.com.reservafacil.service.ValidaTransacaoService;

@RestController
@RequestMapping("/v1/transferencias")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private ValidaTransacaoService validaTransacaoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transacao>> listarTransacoes() {		
		List<Transacao> transacoes = transacaoService.listarTransferencias();
		return ResponseEntity.ok(transacoes);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transacao> agendarTransferencia(@RequestBody Transacao transacao) throws BusinessException {
		validaTransacaoService.validar(transacao);
		Transacao transacaoConcluida = transacaoService.agendarTransferencia(transacao);
		return new ResponseEntity<>(transacaoConcluida, HttpStatus.CREATED);
	}

}
