package br.ufes.model;

import java.util.ArrayList;

public class Funcionario {

  private String nome;
  private double salarioBase;
  private double salarioTotal;
  private int distanciaMoradia;
  private int faltas;
  private String cargo;
  private final ArrayList<Bonus> bonusRecebidos;

  public Funcionario(String nome, double salarioBase, String cargo) throws Exception {
    String exceptions = "";

    if (nome == null || nome == "") {
      exceptions = exceptions.concat("\n#1 Informe um nome válido");
    }

    if (cargo == null || cargo == "") {
      exceptions = exceptions.concat("\n#2 Informe um cargo válido");
    }
    if (salarioBase < 998.0) {
      exceptions = exceptions.concat("\n#3 O salário base deve ser >= R$ 998,00");
    }

    if (exceptions.length() > 0) {
      throw new Exception(exceptions);
    }
    this.nome = nome;
    this.cargo = cargo;
    this.salarioBase = salarioBase;
    this.bonusRecebidos = new ArrayList<>();
  }

  // NOVO CONSTRUTOR

  public Funcionario(String nome, double salarioBase, String cargo, int distanciaMoradia, int faltas) throws Exception {
    String exceptions = "";

    if (nome == null || nome == "") {
      exceptions = exceptions.concat("\n#1 Informe um nome válido");
    }
    if (cargo == null || cargo == "") {
      exceptions = exceptions.concat("\n#2 Informe um cargo válido");
    }
    if (salarioBase < 998.0) {
      exceptions = exceptions.concat("\n#3 O salário base deve ser >= R$ 998,00");
    }
    if (distanciaMoradia < 0) {
      exceptions = exceptions.concat("\n#4 A distância deve ser >= 0");
    }
    if (faltas < 0) {
      exceptions = exceptions.concat("\n#5 Faltas deve ser >= 0");
    }

    if (exceptions.length() > 0) {
      throw new Exception(exceptions);
    }
    this.nome = nome;
    this.cargo = cargo;
    this.salarioBase = salarioBase;
    this.distanciaMoradia = distanciaMoradia;
    this.faltas = faltas;
    this.bonusRecebidos = new ArrayList<>();
  }

  public String getNome() {
    return nome;
  }

  public double getSalarioBase() {
    return this.salarioBase;
  }

  public int getFaltas() {
    return faltas;
  }

  public int getDistanciaMoradia() {
    return distanciaMoradia;
  }

  public String getCargo() {
    return cargo;
  }

  public double getSalario() {
    return this.calculaSalario();
  }

  public void setNome(String nome) throws Exception {
    if (nome == null || nome.trim().equals("")) {
      throw new Exception("\n#1 Informe um nome válido");
    }
    this.nome = nome;
  }

  public void setCargo(String cargo) throws Exception {
    if (cargo == null || cargo.trim().equals("")) {
      throw new Exception("\n#2 Informe um cargo válido");
    }
    this.cargo = cargo;
  }

  public void setSalarioBase(double salarioBase) throws Exception {
    if (salarioBase < 998.0) {
      throw new Exception("\n#3 O salário base deve ser >= R$ 998,00");
    }

    this.salarioBase = salarioBase;
  }

  public void setFaltas(int faltas) throws Exception {

    if (faltas < 0)
      throw new Exception("Faltas não pode ser menor que zero!");
    this.faltas = faltas;
  }

  public void setDistanciaMoradia(int distanciaMoradia) throws Exception {

    if (distanciaMoradia < 0)
      throw new Exception("Distância não pode ser menor que zero!");

    this.distanciaMoradia = distanciaMoradia;
  }

  private double calculaSalario() {
    this.salarioTotal = this.salarioBase + this.calculaTotalBonus();
    return this.salarioTotal;
  }

  public void addBonus(Bonus bonus) {
    if (this.bonusRecebidos.contains(bonus)) {
      this.bonusRecebidos.remove(bonus);
    }

    this.bonusRecebidos.add(bonus);
  }

  public double calculaTotalBonus() {
    double totalBonus = 0;
    for (Bonus bonus : bonusRecebidos) {
      totalBonus += bonus.getValor();
    }

    return totalBonus;
  }

  @Override
  public String toString() {
    String strBonusRecebidos = "";
    for (Bonus bonusRecebido : bonusRecebidos) {
      strBonusRecebidos += "\n\t" + bonusRecebido;
    }
    String strFuncionario = "Funcionario {" + "nome: " + this.nome + ", " + "salarioBase: " + this.salarioBase + ", "
        + "totalBonus: " + this.calculaTotalBonus() + ", " + "salarioTotal: " + this.getSalario() + '}';

    if (bonusRecebidos.size() > 0) {
      strFuncionario += "\nBonus recebidos: " + strBonusRecebidos;
    }

    return strFuncionario;
  }
}
