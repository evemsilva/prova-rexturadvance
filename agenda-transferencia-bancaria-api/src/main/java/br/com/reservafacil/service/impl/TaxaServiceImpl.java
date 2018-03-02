package br.com.reservafacil.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import br.com.reservafacil.exception.BusinessException;
import br.com.reservafacil.service.TaxaService;

@Service
public class TaxaServiceImpl implements TaxaService {

	@Override
	public BigDecimal calcularTaxa(BigDecimal valor, LocalDate dataTransferencia) throws BusinessException {
		
		LocalDate hoje = LocalDate.now();
		
		if (ChronoUnit.DAYS.between(hoje, dataTransferencia) < 0) throw new IllegalArgumentException("Data de transferencia menor que a data atual, não foi possível agendar a transferência");

		long dias = ChronoUnit.DAYS.between(hoje, dataTransferencia);
		
		if (dias == 0) {
			return new BigDecimal(3).add(valor.multiply(BigDecimal.valueOf(0.03))).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 0L && dias <= 10L) {
			return new BigDecimal(12).multiply(new BigDecimal(dias)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 10L && dias <= 20L) {
			return valor.multiply(BigDecimal.valueOf(0.08)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 20L && dias <= 30L) {
			return valor.multiply(BigDecimal.valueOf(0.06)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 30L && dias <= 40L) {
			return valor.multiply(BigDecimal.valueOf(0.04)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 40L && (valor.compareTo(new BigDecimal(100_000)) > 0)) {
			return valor.multiply(BigDecimal.valueOf(0.02)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		throw new BusinessException("Não há taxa aplicável para este cenário");
	}

}
