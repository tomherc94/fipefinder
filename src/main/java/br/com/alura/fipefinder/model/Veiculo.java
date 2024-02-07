package br.com.alura.fipefinder.model;

public class Veiculo {

    private String marca;
    private String modelo;
    private String ano;
    private String tipoCombustivel;
    private String valor;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String ano, String tipoCombustivel, String valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoCombustivel = tipoCombustivel;
        this.valor = valor;
    }

    public Veiculo(DadosVeiculo dadosVeiculo) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.ano = dadosVeiculo.ano();
        this.tipoCombustivel = dadosVeiculo.tipoCombustivel();
        this.valor = dadosVeiculo.valor();
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getTipoCombustivel() {
        return tipoCombustivel;
    }
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", tipoCombustivel="
                + tipoCombustivel + ", valor=" + valor + "]";
    }

    
    
}
