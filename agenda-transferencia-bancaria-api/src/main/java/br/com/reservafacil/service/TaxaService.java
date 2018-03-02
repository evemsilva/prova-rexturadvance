package br.com.reservafacil.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.reservafacil.exception.BusinessException;

public interface TaxaService {

	BigDecimal calcularTaxa(BigDecimal valor, LocalDate dataTransferencia) throws BusinessException;

}
