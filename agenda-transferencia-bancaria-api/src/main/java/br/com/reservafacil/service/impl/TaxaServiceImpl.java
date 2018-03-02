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
			return new BigDecimal(3).add(valor.multiply(new BigDecimal(0.03))).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 0 && dias <= 10) {
			return new BigDecimal(12).multiply(new BigDecimal(dias)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 10 && dias <= 20) {
			return valor.multiply(new BigDecimal(0.08)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 20 && dias <= 30) {
			return valor.multiply(new BigDecimal(0.06)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 30 && dias <= 40) {
			return valor.multiply(new BigDecimal(0.04)).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else if (dias > 40 && (valor.compareTo(new BigDecimal(100_000)) > 0)) {
			return valor.multiply(new BigDecimal(0.02)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		throw new BusinessException("Não há taxa aplicável para este cenário");
	}

}
