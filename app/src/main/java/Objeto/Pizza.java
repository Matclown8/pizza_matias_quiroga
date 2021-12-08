package Objeto;

public class Pizza {

    private String[] pizzas = {"Pizza Napolitana", "Pizza Predilecta", "Pizza Vegana", "Pizza Selecta"};
    private int[] precios = {12500, 13800, 15600, 18600};

    private String[] ingredientes = {"Tocino", "Extra Queso", "Champiñon", "Salame", "Albahaca"};
    private int[] preciosi = {350, 500, 250, 300, 450};

    public Pizza(){
    }

    public Pizza(String[] pizzas, int[] precios, String[] ingredientes, int[] preciosi) {
        this.pizzas = pizzas;
        this.precios = precios;
        this.ingredientes = ingredientes;
        this.preciosi = preciosi;
    }

    public String[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(String[] pizzas) {
        this.pizzas = pizzas;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int[] getPreciosi() {
        return preciosi;
    }

    public void setPreciosi(int[] preciosi) {
        this.preciosi = preciosi;
    }

    public int calcular(int tipo, int ingre){
        return tipo+ingre;
    }
}
