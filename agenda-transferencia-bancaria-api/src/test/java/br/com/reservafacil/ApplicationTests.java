package br.com.reservafacil;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.reservafacil.domain.Transacao;
import br.com.reservafacil.exception.BusinessException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private final String URI = "/v1/transferencias";
	
	 @Rule
     public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCalculaTaxaMesmoDia() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now()), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(6).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaAteDezDias() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now().plusDays(10L)), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(120).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaMaiorDezAteVinteDias() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now().plusDays(20L)), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(8).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaMaiorVinteAteTrintaDias() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now().plusDays(30L)), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(6).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaMaiorTrintaAteQuarentaDias() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now().plusDays(40L)), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(4).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaMaiorQuarentaDiasValorMaiorCemMil() {	
		Transacao transacaoEfetuada = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100_000.01), LocalDate.now().plusDays(41L)), Transacao.class);
		assertThat(transacaoEfetuada.getTaxa()).isEqualTo(new BigDecimal(2_000).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void testCalculaTaxaMaiorQuarentaDiasValorMenorIgualCemMil() {	
		String message = restTemplate.postForObject(URI, new Transacao("111222", "222333", new BigDecimal(100), LocalDate.now().plusDays(41L)), BusinessException.class).getMessage();
		assertThat(message).isEqualTo("Não há taxa aplicável para este cenário");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testlistaTransferencias() {	
		List<Transacao> transferencias = restTemplate.getForObject(URI, List.class);
		assertTrue(!transferencias.isEmpty());
	}
	
}
