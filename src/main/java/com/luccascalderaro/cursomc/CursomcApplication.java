package com.luccascalderaro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luccascalderaro.cursomc.domain.Categoria;
import com.luccascalderaro.cursomc.domain.Cidade;
import com.luccascalderaro.cursomc.domain.Cliente;
import com.luccascalderaro.cursomc.domain.Endereco;
import com.luccascalderaro.cursomc.domain.Estado;
import com.luccascalderaro.cursomc.domain.Produto;
import com.luccascalderaro.cursomc.domain.enums.TipoCliente;
import com.luccascalderaro.cursomc.repositories.CategoriaRepository;
import com.luccascalderaro.cursomc.repositories.CidadeRepository;
import com.luccascalderaro.cursomc.repositories.ClienteRepository;
import com.luccascalderaro.cursomc.repositories.EnderecoRepository;
import com.luccascalderaro.cursomc.repositories.EstadoRepository;
import com.luccascalderaro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository	enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", e1);
		Cidade c2 = new Cidade(null,"São Paulo",e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "4545169855", TipoCliente.PESSOAFISICA );
		
		cli1.getTelefones().addAll(Arrays.asList("5656565","8488484"));
		
		Endereco end1 = new Endereco(null, "Rua flores", "300", "ap 30", "Jardim", "01500", cli1, c1);
		Endereco end2 = new Endereco(null, "Av Matos", "105", "Sala 800","Centro", "016000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		
		
		
	}

}
