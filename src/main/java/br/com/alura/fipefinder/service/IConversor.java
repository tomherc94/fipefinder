package br.com.alura.fipefinder.service;

import java.util.List;

public interface IConversor {

    <T> T obterDados(String json, Class<T> classe);
    <T> List<T> obterListaDados(String json, Class<T> classe);
    
}
