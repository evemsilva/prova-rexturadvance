package br.com.reservafacil.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private BigDecimal taxa;
	private LocalDate dataTransferencia;
	private LocalDate dataAgendamento;

	public Transacao() {
	}

	public Transacao(String contaOrigem, String contaDestino, BigDecimal valorTransferencia,
			LocalDate dataTransferencia) {
		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.dataTransferencia = dataTransferencia;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

}
