package com.example.simulado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.simulado.entity.*;
import com.example.simulado.service.*;

@SpringBootApplication
public class SimuladoApplication {

	private static final Logger Log = LoggerFactory.getLogger(SimuladoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimuladoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PessoaService pessoaService,
								  FoneService foneService,
								  CategoriaService categoriaService,
								  MusicaService musicaService,
								  CantorService cantorService,
								  GravacaoService gravacaoService,
								  GravadoraService gravadoraService) {

		return (arg) -> {
			Log.info("<= Simulado prova =>");

			// SALVANDO PESSOA
			Log.info("Salvando pessoa");
			List<Fone> fones = new ArrayList<>();
			Fone celular = new Fone();
			celular.setNumero("99672-0831");
			celular.setTipoFone(Fone.TipoFone.L);
			Fone residencial = new Fone();
			residencial.setNumero("3042-5178");
			residencial.setTipoFone(Fone.TipoFone.R);
			fones.add(celular);
			fones.add(residencial);
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("Goku");
			pessoa.setFones(fones);
			pessoaService.save(pessoa);

			//DELETANDO PESSOA
			Log.info("Deletando pessoa");
			pessoaService.findById(1L).ifPresentOrElse(value -> pessoaService.delete(value.getId()),
				() -> Log.info("Pessoa nao localizada para exclusao"));

			//CONSULTANDO TODAS AS PESSOAS
			Log.info("Consultando todas as pessoas");
			pessoaService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA PESSOA
			Log.info("Consultando pessoa pelo id");
			pessoaService.findById(2L).ifPresentOrElse(value -> Log.info(value.toString()),
				() -> Log.info("Nenhuma pessoa encontrada"));

			//SALVANDO FONE
			Log.info("Salvando fone");
			Fone comercial = new Fone();
			Pessoa ichigo = new Pessoa();
			ichigo.setNome("Ichigo");
			Pessoa ichigoSalvo =  pessoaService.save(ichigo);
			comercial.setNumero("3276-8556");
			comercial.setTipoFone(Fone.TipoFone.C);
			comercial.setPessoa(ichigoSalvo);
			foneService.save(comercial);

			//DELETANDO FONE
			Log.info("Deletando fone");
			foneService.findById(48L).ifPresentOrElse(value -> foneService.delete(value.getId()),
				() -> Log.info("Fone nao localizado para exclusao"));

			//CONSULTANDO TODOS OS FONES
			Log.info("Consultando todos os fones");
			foneService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UM FONE
			Log.info("Consultando um fone");
			foneService.findById(4L).ifPresentOrElse(value -> Log.info(value.toString()), 
				() -> Log.info("Fone nao encontrado"));

			//SALVANDO CATEGORIA
			Log.info("Salvando categoria");
			List<Musica> musicasMetal = new ArrayList<>();
			Musica ridersOfTheStorm = new Musica();
			ridersOfTheStorm.setDuracao(5000L);
			ridersOfTheStorm.setTitulo("Riders of the Storm");
			Musica enterSandman = new Musica();
			enterSandman.setDuracao(3500L);
			enterSandman.setTitulo("Enter Sandman");
			musicasMetal.add(ridersOfTheStorm);
			musicasMetal.add(enterSandman);
			Categoria categoriaMetal = new Categoria();
			categoriaMetal.setDesc("Metal");
			categoriaMetal.setMusicas(musicasMetal);
			categoriaService.save(categoriaMetal);

			//DELETANDO CATEGORIA
			Log.info("Deletando categoria");
			categoriaService.findById(3L).ifPresentOrElse(value -> categoriaService.delete(value.getId()),
				() -> Log.info("Categoria nao localizada para exclusao"));

			//CONSULTANDO TODAS AS CATEGORIAS
			Log.info("Consultando todas as categorias");
			categoriaService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA PESSOA
			Log.info("Consultando categoria pelo id");
			categoriaService.findById(2L).ifPresentOrElse(value -> Log.info(value.toString()),
				() -> Log.info("Nenhuma categoria encontrada"));

			//SALVANDO MUSICA
			Categoria categoriaHardRock = new Categoria();
			categoriaHardRock.setDesc("Hard Rock");
			Categoria categoriaHardRockSalvo = categoriaService.save(categoriaHardRock);
			Musica tnt = new Musica();
			tnt.setDuracao(2500L);
			tnt.setTitulo("TNT");
			tnt.setCategoria(categoriaHardRockSalvo);
			musicaService.save(tnt);

			//DELETANDO MUSICA
			Log.info("Deletando musica");
			musicaService.findById(11L).ifPresentOrElse(value -> musicaService.delete(value.getId()),
				() -> Log.info("Musica nao localizado para exclusao"));

			//CONSULTANDO TODOS AS MUSICAS
			Log.info("Consultando todos as musicas");
			musicaService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA MUSICA
			Log.info("Consultando uma musica");
			musicaService.findById(24L).ifPresentOrElse(value -> Log.info(value.toString()), 
				() -> Log.info("Musica nao encontrada"));

			//SALVANDO GRAVADORA
			Gravadora totalLivreGravadora = new Gravadora();
			totalLivreGravadora.setNome("Total Livre");
			totalLivreGravadora.setPais("Brasil");
			gravadoraService.save(totalLivreGravadora);

			//DELETANDO GRAVADORA
			Log.info("Deletando gravadora");
			gravadoraService.findById(2L).ifPresentOrElse(value -> gravadoraService.delete(value.getId()),
				() -> Log.info("Gravadora nao localizado para exclusao"));

			//CONSULTANDO TODOS AS GRAVADORAS
			Log.info("Consultando todos as gravadoras");
			gravadoraService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA GRAVADORA
			Log.info("Consultando uma gravadora");
			gravadoraService.findById(1L).ifPresentOrElse(value -> Log.info(value.toString()), 
				() -> Log.info("Gravadora nao encontrada"));

			//SALVANDO CANTOR
			Cantor metallica = new Cantor();
			metallica.setNome("Metallica");
			metallica.setPais("Estados Unidos");
			cantorService.save(metallica);

			//DELETANDO CANTOR
			Log.info("Deletando cantor");
			cantorService.findById(9L).ifPresentOrElse(value -> cantorService.delete(value.getId()),
				() -> Log.info("Cantor nao localizado para exclusao"));

			//CONSULTANDO TODOS OS CANTORES
			Log.info("Consultando todos os cantores");
			cantorService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA GRAVADORA
			Log.info("Consultando um cantor");
			cantorService.findById(3L).ifPresentOrElse(value -> Log.info(value.toString()), 
				() -> Log.info("Cantor nao encontrado"));

			//SALVANDO GRAVACAO
			Categoria categoriaPowerMetal = new Categoria();
			categoriaPowerMetal.setDesc("Power Metal");
			Categoria categoriaPowerMetalSalvo = categoriaService.save(categoriaPowerMetal);
			Musica throughTheFireFlames = new Musica();
			throughTheFireFlames.setDuracao(7000L);
			throughTheFireFlames.setTitulo("Through The Fire Flames");
			throughTheFireFlames.setCategoria(categoriaPowerMetalSalvo);
			Musica throughTheFireFlamesSalvo = musicaService.save(throughTheFireFlames);
			Gravadora centuryMediaGravadora = new Gravadora();
			centuryMediaGravadora.setNome("Century Media");
			centuryMediaGravadora.setPais("Estados Unidos");
			Gravadora centuryMediaGravadoraSalva =  gravadoraService.save(centuryMediaGravadora);
			Cantor dragonForce = new Cantor();
			dragonForce.setNome("Dragonforce");
			dragonForce.setPais("Estados Unidos");
			Cantor dragonForceSalvo = cantorService.save(dragonForce);
			Gravacao gravacao = new Gravacao();
			gravacao.setCantor(dragonForceSalvo);
			gravacao.setGravadora(centuryMediaGravadoraSalva);
			gravacao.setMusica(throughTheFireFlamesSalvo);
			gravacao.setDataGravacao(new Date());
			gravacaoService.save(gravacao);

			//DELETANDO GRAVACAO
			Log.info("Deletando gravacao");
			gravacaoService.findById(13L).ifPresentOrElse(value -> gravacaoService.delete(value.getId()),
				() -> Log.info("Gravação nao localizada para exclusao"));

			//CONSULTANDO TODOS AS GRAVAÇÕES
			Log.info("Consultando todos as gravacoes");
			gravacaoService.findAll().forEach(value -> Log.info(value.toString()));

			//CONSULTANDO UMA GRAVACAO
			Log.info("Consultando uma gravacao");
			gravacaoService.findById(22L).ifPresentOrElse(value -> Log.info(value.toString()), 
				() -> Log.info("Gravacao nao encontrado"));
		};
	}
}
