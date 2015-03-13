package cz.greca.tabor.skladGre.service;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Potravina;
import cz.greca.tabor.skladGre.entity.TaborovyDen;

@Service
public class InitDbService {
	
	// GRE: varianta kdy jsem pouzival DB HSQLBD a data byla ulozena pouze v pameti, ktere se
	// zde inicializovaly, v AppConfig ma svuj datasource, a v pom byla pro to nejaka dependence
	
	/*
	@Autowired
	private TaborovyDenService taborovyDenService;

	@Autowired
	private PotravinaService potravinaService;

	public static String removeDiacritics(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	@PostConstruct
	public void init() throws ParseException {

		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-13");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-14");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-15");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-16");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-17");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-18");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-19");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-20");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-21");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-22");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-23");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-24");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-25");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-26");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-27");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-28");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-29");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}
		{
			TaborovyDen td = new TaborovyDen();
			Date den = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-30");
			td.setDen(den);
			td.setNorma(9000);
			taborovyDenService.save(td);
		}

		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ANANAS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ANANAS KANDOVANÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ANANASOVÝ KOMPOT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ARAŠÍDY NELOUPANÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAGETA 130")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAGETA 95")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAGETA FRANCOUZSKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAGETA MALÁ SVĚTLÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAGETA PŠENIČNO-ŽITNÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BANÁN SUŠENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BANÁNY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BAZALKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BEBE BRUMÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BLUMY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BOBKOVÝ LIST")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRAMBOROVÉ KNEDLÍKY PLNĚNÉ UZE. MASEM")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRAMBOROVÉ TĚSTO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRAMBORY PYTEL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BROSKVE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRUSINKOVÝ KOMPOT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRUSINKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BRUSINKY SUŠENÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("BYLINKOVÉ MÁSLO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CELER")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CIBULE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CIBULE SMAŽENÁ SUŠENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CITRONKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CITRONY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CUKR KRUPICE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CUKR KRYSTAL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CUKR MOUČKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CUKR VANILÍNOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ BON TEA OVOCNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ OVOCNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ PIGI BRUSINKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ PIGI ČERNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ VELTATEX ČERNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ VELTATEX OVOCNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ VELTATEX, BON TEA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČAJ ZELENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČESNEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČÍNSKÉ ZELÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČOČKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ČOKOLÁDA NA VAŘENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DATLE SUŠENÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DONUTY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DROŽDÍ 1kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DROŽDÍ 42")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽEM PORCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUS ANANAS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUS POMERANČ, MULTIVITAMÍN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK FRUIKO 250")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK FRUIKO JABLKO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK FRUIKO JAHODA, BROSKEV")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK FRUIKO MULTIVITAMÍN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK FRUIKO POMERANČ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("DŽUSÍK JUPÍK V LAHVI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("FAZOLE BÍLÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("FENYKL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("GRANKO 250")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("GRANKO 500")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("GRENADINA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("GREPY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("GRILOVACÍ KOŘENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOŘČICE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOUSKA CELOZRNNÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOUSKA MAKOVÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOUSKA SYPANÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOVĚZÍ PŘEDNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HOVĚZÍ ZADNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HRÁCH ŽLUTÝ PŮLENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HRÁŠEK MRAŽENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HRÁŠEK STERILOVANÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HROZNY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HRUŠKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("HŘEBÍČEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CHLÉB 1,2kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("CHLÉB ŠUMAVA 1kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("INSTANTNÍ NUDLE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JABLKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JABLKA GOLDEN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JABLKA GOLDEN SKLÁDANÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JABLKA SUŠENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JAHODOVÝ KOMPOT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JAHODY MRAŽENÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JÁTRA KUŘECÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JÁTRA VEPŘOVÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JOGURT BÍLÝ 500")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JOGURT OVOCNÝ DANONE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JOGURT OVOCNÝ VALAŠSKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JOGURT SLADKÝ BÍLÝ DANONE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("JOGURTOVÝ NÁPOJ ACTIVIA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KAKAO HOLANDSKÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KARI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KAROTKA MRAŽENÁ KOSTKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KÁVA JIHLAVANKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEČUP 5kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEČUP GOURMET 900")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEČUP JEMNÝ 1 900")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEČUP JEMNÝ 500")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEČUP JEMNÝ 900")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KEDLUBNY BÍLÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KINDER PINQUÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KIWI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KLASIK TEKUTÉ OCHUCOVADLO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KLOBÁSA LOUPEŽNICKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KLOBÁSA VARNSDORFSKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KMÍN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOBLIHA S NUGÁTEM")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOBLIHA VELKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOKOS STROUHANÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOLÁČ MERUŇKOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOLÁČ POSVÍCENSKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KORBÁČKY PŘÍRODNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOŘENÍ NA PIZZU")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOSTIČKY CUCAVÉ FERDA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KOSTIČKY CUCAVÉ PEDRO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUKUŘICE KLASY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUKUŘICE MRAŽENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUKUŘICE STERILOVANÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUŘECÍ PRSA CHLAZENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUŘECÍ PRSNÍ ŘÍZEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUŘECÍ ŘÍZEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUŘECÍ STEAK MRAŽENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("KUŘECÍ STEHNO MRAŽENÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("LEMON KONCENTRÁT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("LENTILKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MAJORÁNKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MAKOVÝ ROHLÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MALINOVKA TOČENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MANDARINKOVÝ KOMPOT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MANDARINKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MÁSLO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MÁSLO PORCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MATTONI OCHUCENÁ 0,5")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MATTONI OCHUCENÁ 1,5")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MED")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MED PORCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELOUN CANTALOUPE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELOUN GALIA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELOUN PIEL de SAPO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELOUN VODNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELOUN ŽLUTÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MELTA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MILKY MAX KONCENTRÁT ČOKOLÁDA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MILKY MAX KONCENTRÁT VANILKA, KOKOS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MÍŠA ŘEZY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MLÉKO OCHUCENÉ 250")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MLÉKO TRVANLIVÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MOUKA HLADKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MOUKA HRUBÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MOUKA KRUPIČKA DĚTSKÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MOUKA POLOHRUBÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MRKEV")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MÜSLI TYČINKA BONNO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("MUŠKÁTOVÝ KVĚT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NANUK DINOPARK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NANUK JUPÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NEKTARINKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NEKTARINKY KOŠ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NESQUICK KULIČKY 450")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NOVÉ KOŘENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NUGETA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("NUGETA PORCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OCET")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OKURKY NAKLÁDANÉ 670")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OKURKY SALÁTOVÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OKURKY STERILOVANÉ 3,5L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OLEJ ROSTLINNÝ 10L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OLEJ SLUNEČNICOVÝ 1L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OLEJ SLUNEČNICOVÝ 3L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OMEGA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OPLATKY MIŇONKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("OREGANO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAPRIKA SLADKÁ MLETÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAPRIKA STERILOVANÁ 4L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAPRIKA STERILOVANÁ 670")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAPRIKY ČERVENÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAPRIKY ŽLUTÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PÁREK LIBERECKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PÁREK VEPŘOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PÁREK VÍDEŇSKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PAŠTIKA PORCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PEPŘ CELÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PEPŘ MLETÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PERNÍK SMĚS NA PEČENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PETRŽEL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PETRŽELOVÁ NAŤ SUŠENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PIŠKOTY 240")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PIŠKOTY 480")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PIZZA ROHLÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PODĚBRADKA OCHUCENÁ 0,5L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("POLÉVKA GULÁŠOVÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("POMAZÁNKOVÉ MÁSLO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("POMERANČE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("POMERANČE SÍŤ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PÓREK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PROVENSÁLSKÉ KOŘENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PŘESNÍDÁVKA BROSKEV")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PŘESNÍDÁVKA JABLKO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PŘESNÍDÁVKA JAHODA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PŘESNÍDÁVKA SMĚS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PUDING ČOKOLÁDOVÝ SE ŠLEHAČKOU")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("PUDING VANILKOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RAJČATA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RAJČATA KRÁJENÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RAJČATOVÝ PROTLAK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ROHLÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ROHLÍK SEZAMOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ROHLÍK STAROČESKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ROHLÍK SÝROVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RUM")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RYBÍ FILÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("RÝŽE PARBOILED")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŘEDKVIČKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŘEPA ČERVENÁ STERILOVANÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÁDLO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM GOTHAJSKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM KUŘECÍ TOČENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM POLIČAN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM SLOVENSKÝ TOČENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM ŠUNKOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM TOČENÝ KABANOS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁM VYSOČINA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SALÁT LEDOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SIRUP DOBRÁ VODA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SIRUP GRENADINA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SIRUP JUPÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SIRUP KOKOS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SIRUP NELI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SKOŘICE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SLEPICE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMAŽENÝ HRÁŠEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMĚS OŘECHŮ S OVOCEM")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMĚS SUŠENÉHO OVOCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMETANA DO KÁVY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMETANA NA VAŘENÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMETANA ZAKYSANÁ 180g")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMETANA ZAKYSANÁ 190g")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SMETANA ZAKYSANÁ 3kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SOJOVÁ OMÁČKA 170")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SOJOVÁ OMÁČKA 1L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SRDCE KUŘECÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("STROUHANKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SŮL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENÁ ZELENINA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA CORNY MILK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA DELLISA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA FIDORKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA FIDORKA VIŠEŇ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA HORALKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKA TATRANKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKY BEBE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SUŠENKY DISCO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR BALKÁN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR CIHLA SLOVENSKO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR EDAM")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR GOLDI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR HERMELÍN NA GRIL")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR LIPNO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR PARMEZÁN")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR TAVENÝ 1kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR TAVENÝ PLÁTKOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR TAVENÝ SMETANOVÝ 1kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR TAVENÝ VYSOKOTUČNÝ 1kg")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("SÝR VESELÁ KRÁVA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠÁTEČEK MARMELÁDA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠÁTEČEK S NÁPLNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠKROB BRAMBOROVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠLEHAČKA 1L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠLEHAČKA SPRAY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPAGETY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPEK UZENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPEKÁČEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPEKÁČEK RUČNĚ VÁZANÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPEKÁČEK TESCO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠPENÁT PORCOVANÝ MRAŽENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠUNKA KUŘECÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠUNKA KUŘECÍ PRSNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŠVESTKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TERMIX")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY BABIČČINY NUDLE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY BAREVNÁ VŘETENA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY FLEKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY KOLÍNKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY MUŠLIČKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY NUDLIČKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY PENNE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY VŘETENA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TĚSTOVINY ZOO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TIC TAC")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TORTILLA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TŘÍBAREVNÝ ŘEZ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TUŇÁK DRCENÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TUŇÁK KOUSKY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TVAROH MĚKKÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TVAROH TUČNÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TVAROH TVRDÝ NA STROUHÁNÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TVAROHÁČEK SMETÁNEK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TVAROHO-OVOCNÁ PĚNA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA BANÁNY V ČOK.")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA BOUNTY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA DELI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA FIT KID")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA FLY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA GEJŠA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA JAHODY V ČOK.")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA KAŠTANY")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA KOKO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA MARGOT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA MILENA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA MILKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA PAPITA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKA SNICKERS")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("TYČINKY KOFILA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("UZENÁ KRKOVICE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("UZENÝ BOK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VÁNOČKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEGA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEJCE")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVÁ KÝTA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVÁ PEČENĚ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVÁ PLEC")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVÁ PLEC MLETÁ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVOHOVĚZÍ OŘEZ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VEPŘOVÝ BOK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VODA NEOCHUCENÁ 1,5L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VODA OCHUCENÁ 1,5L")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VÝVAR HOVĚZÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VÝVAR HOVĚZÍ 1")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VÝVAR SLEPIČÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("VÝVAR ZELENINOVÝ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELENIN.SMĚS POD SVÍČKOVOU MRAŽ.")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELENIN.SMĚS POLÉVKOVÁ MRAŽ.")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELENINOVÁ SMĚS HALALI")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELENINOVÁ SMĚS KUNOVJANKA")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELENINOVÉ LEČO")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELÍ HLÁVKOVÉ BÍLÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELÍ KYSANÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZELÍ KYSANÉ KBELÍK")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ZMRZLINY KORNOUT")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŽALUDKY KUŘECÍ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŽAMPIONY STERILOVANÉ")); potravinaService.save(p);}
		{Potravina p = new Potravina(); p.setJmeno(removeDiacritics("ŽEMLE")); potravinaService.save(p);}

	}
	*/
}
