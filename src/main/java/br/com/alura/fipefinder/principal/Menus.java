package br.com.alura.fipefinder.principal;

public class Menus {

    private StringBuilder sb = new StringBuilder();

    public String menuTipos() {
        sb.delete(0, sb.length());
        sb.append("---MENU---\n");
        sb.append("Carros\n");
        sb.append("Motos\n");
        sb.append("Caminhões\n");
        sb.append("Escolha um tipo: ");

        return sb.toString();
    }

    public String menuMarcas() {
        sb.delete(0, sb.length());
        sb.append("---MENU---\n");
        sb.append("Escolha o código de uma marca: ");

        return sb.toString();
    }

    public String menuModelosPorTrecho() {
        sb.delete(0, sb.length());
        sb.append("---MENU---\n");
        sb.append("Procure o modelo por um trecho do nome: ");

        return sb.toString();
    }

    public String menuModelos() {
        sb.delete(0, sb.length());
        sb.append("---MENU---\n");
        sb.append("Escolha o código de um modelo: ");

        return sb.toString();
    }

}
