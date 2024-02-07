package br.com.alura.fipefinder.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.fipefinder.enuns.Tipo;
import br.com.alura.fipefinder.model.Dados;
import br.com.alura.fipefinder.model.DadosVeiculo;
import br.com.alura.fipefinder.model.Modelos;
import br.com.alura.fipefinder.model.Veiculo;
import br.com.alura.fipefinder.service.ConsumidorApi;
import br.com.alura.fipefinder.service.Conversor;

public class Principal {

    private ConsumidorApi consumidorApi = new ConsumidorApi();
    private Conversor conversor = new Conversor();
    private Scanner sc = new Scanner(System.in);
    private Menus menus = new Menus();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private String url;

    public void runApp() {
        // ESCOLHA DO TIPO
        System.out.println(menus.menuTipos());
        var opcao = sc.nextLine();

        String json;
        List<Dados> dados;

        if (opcao.toLowerCase().contains("carr")) {
            url = ENDERECO + Tipo.CARROS.toString().toLowerCase() + "/marcas/";
        } else if (opcao.toLowerCase().contains("mot")) {
            url = ENDERECO + Tipo.MOTOS.toString().toLowerCase() + "/marcas/";
        } else if (opcao.toLowerCase().contains("cami")) {
            url = ENDERECO + Tipo.CAMINHOES.toString().toLowerCase() + "/marcas/";
        } else {
            System.out.println("Opção inválida!");
        }

        json = consumidorApi.obterDados(url);
        dados = conversor.obterListaDados(json, Dados.class);
        dados.stream()
                .map(m -> m.codigo() + " - " + m.nome())
                .forEach(System.out::println);

        // ESCOLHA DA MARCA
        System.out.println(menus.menuMarcas());
        int codigo = sc.nextInt();
        sc.nextLine();

        url = url + String.valueOf(codigo) + "/modelos/";
        json = consumidorApi.obterDados(url);

        Modelos modelos = conversor.obterDados(json,
                Modelos.class);
        modelos.dados().stream()
                .map(m -> m.codigo() + " - " + m.nome())
                .forEach(System.out::println);

        // PROCURE O MODELO POR UM TRECHO DO NOME
        System.out.println(menus.menuModelosPorTrecho());
        String trecho = sc.nextLine();

        modelos.dados().stream()
                .filter(m -> m.nome().toUpperCase().contains(trecho.toUpperCase()))
                .map(m -> m.codigo() + " - " + m.nome())
                .forEach(System.out::println);

        // ESCOLHA DO MODELO
        System.out.println(menus.menuModelos());
        codigo = sc.nextInt();
        sc.nextLine();

        url = url + String.valueOf(codigo) + "/anos/";
        json = consumidorApi.obterDados(url);
        dados = conversor.obterListaDados(json, Dados.class);
        List<String> anos = dados.stream()
                .map(m -> m.codigo())
                .collect(Collectors.toList());      

        // INFORMAÇÕES SOBRE TODOS OS ANOS
        System.out.println("AVALIAÇÕES");

        List<Veiculo> listaVeiculos = new ArrayList<>();
        for (String ano : anos) {
            var urlAnos = url + String.valueOf(ano);
            json = consumidorApi.obterDados(urlAnos);
            DadosVeiculo dadosVeiculo = conversor.obterDados(json, DadosVeiculo.class);
            Veiculo veiculo = new Veiculo(dadosVeiculo);
            listaVeiculos.add(veiculo);

        }

        listaVeiculos.forEach(System.out::println);

    }
}
