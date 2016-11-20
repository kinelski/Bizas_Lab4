package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import notaFiscal.NotaFiscal;

public class Testes {

	@Test
	public void test() {
		NotaFiscal nf = new NotaFiscal();
		nf.validaNota();
		
		System.out.println(nf.printable());
	}

}
