package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
    private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Inicio");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Hugo", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	//Deve ser método static
	@BeforeAll
	public static void AntesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	//Deve ser método static
	@AfterAll
	public static void DepoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}

	@Test
	public void reajusteDeveSerTresPorcentoADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
    
    @Test
	public void reajusteDeveSerTresPorcentoBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
    
    @Test
	public void reajusteDeveSerTresPorcentoOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
