package com.cartoes.apirest.model.controllers;

import java.time.LocalDate;
import java.util.*;

import com.cartoes.apirest.model.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import com.cartoes.apirest.model.Cartao;
import com.cartoes.apirest.model.enums.TipoEmissor;
import com.cartoes.apirest.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	private List<Cartao> cartoes = new ArrayList<>();

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@GetMapping("/{id}")
	public Cartao cartao(@PathVariable("id") int id) {

		Optional <Cartao> cartaoFind = Optional.ofNullable(this.cartaoRepository.findById(id));

		if(cartaoFind.isPresent()){
			return cartaoFind.get();
		}

		return null;
	}
	
	@PostMapping("/")
	public Cartao cartao(@RequestBody Cartao cartao) {
	//	cartao.setDataExpiracao(new Date( "2021/10/11"));
	//	cartao.setDn(new String("1066"));
	//	cartao.setLogo(new String("547"  ));
		cartao.setCartao(new String("UUIDV4"));
	//	cartao.setCartaoAtivo(new String("N"));
	//	cartao.setTipo(TipoEmissor.ADICIONAL );
	//	cartao.setTipo(TipoEmissor.TITULAR );
	//	cartao.setTipoP(TipoPessoa.ADICIONAL);
	//	cartao.setTipoP(TipoPessoa.CLIENTE);
		if (cartao.getDataExpiracao()==null){
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.YEAR, 4);
			c.add(Calendar.MONTH, 3);
			// Convert calendar back to Date
			Date currentDatePlus = c.getTime();
			cartao.setDataExpiracao(currentDatePlus);
		}

		if (cartao.getCartaoAtivo()==null){
			cartao.setCartaoAtivo("S");
			cartao.setCartaoAtivo("N");
		}
		if (cartao.getDn()==null){
			cartao.setDn("1066");
		}
		if (cartao.getCodigoOrganizacao()==null){
			cartao.setCodigoOrganizacao("007");
		}
		if (cartao.getLogo()==null){
			cartao.setLogo("005");
		}
		if (cartao.getTipo()==null){
			cartao.setTipo(TipoEmissor.TITULAR);
			cartao.setTipo( TipoEmissor.ADICIONAL);
		}
		if (cartao.getTipoP()==null){
			cartao.setTipoP(TipoPessoa.CLIENTE);
			cartao.setTipoP( TipoPessoa.ADICIONAL);
			cartao.setTipoP( TipoPessoa.CONTRATO);
			cartao.setTipoP( TipoPessoa.PORTADOR);
		}

		return this.cartaoRepository.save(cartao);
	}
	
	@GetMapping("/list")
	public List<Cartao> list(){
		return this.cartaoRepository.findAll();
		
	}

	@GetMapping("/list/{id}")
	public List<Cartao> listMoreThan(@PathVariable("id")int id){
		return this.cartaoRepository.findAllMoreThan(id);

	}

	@GetMapping("/list/cartao/{id}")
	public Cartao ListaCartaoUnico(@PathVariable(value = "id")int id){
		return this.cartaoRepository.findById(id);

	}

	@DeleteMapping ("/list/delete")
	public void DeletaCartao(@RequestBody Cartao cartao){
		cartaoRepository.delete(cartao);

	}

}
