package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

//Link planilha: https://docs.google.com/spreadsheets/d/1sRZBMUMHlfPb1jFaEY9xkanywA52UwUHMj-hYTqPBG0/edit?usp=sharing

public class FuncionarioBonusTest {

  public FuncionarioBonusTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {

  }

  @After
  public void tearDown() {
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void CT001() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    double salarioEsperado = 2500.00;

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalarioBase(), 0.001);
  }

  @Test
  public void CT002() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    double salarioEsperado = 2650.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT003() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(101);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 2950.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT004() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(151);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 3150.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT005() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(51);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 2800.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT006() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#3 O salário base deve ser >= R$ 998,00"));

    // Assert
    new Funcionario("Fulano", 997.00, "Gerente");
  }

  @Test
  public void CT007() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome válido"));

    // Assert
    new Funcionario(null, 998.00, "Gerente");
  }

  @Test
  public void CT008() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome válido"));

    // Assert
    new Funcionario(null, 2500.00, "Gerente");
  }

  @Test
  public void CT009() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome válido"));

    // Assert
    new Funcionario("", 2500.00, "Gerente");
  }

  @Test
  public void CT010() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo válido"));

    // Assert
    new Funcionario("Fulano", 2500.00, null);
  }

  @Test
  public void CT011() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo válido"));

    // Assert
    new Funcionario("Fulano", 2500.00, "");
  }

  @Test
  public void CT012() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");
    funcionario.setFaltas(2);
    double salarioEsperado = 2630.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT013() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");
    funcionario.setFaltas(6);
    funcionario.setDistanciaMoradia(10);
    double salarioEsperado = 2605.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT014() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");
    funcionario.setDistanciaMoradia(151);
    double salarioEsperado = 3205.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT015() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");
    funcionario.setDistanciaMoradia(51);
    double salarioEsperado = 2825.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT016() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");
    funcionario.setDistanciaMoradia(151);
    double salarioEsperado = 3175.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT017() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("Distância não pode ser menor que zero!"));
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");

    // Assert
    funcionario.setDistanciaMoradia(-1);
  }

  @Test
  public void CT018() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("Faltas não pode ser menor que zero!"));
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");

    // Assert
    funcionario.setFaltas(-1);
  }

  @Test
  public void CT019() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#3 O salário base deve ser >= R$ 998,00"));

    // Assert
    new Funcionario("Fulano", -1.00, "Gerente");
  }

  // NOVOS CASOS

  @Test
  public void CT020() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome válido"));

    // Assert
    funcionario.setNome(null);
  }

  @Test
  public void CT021() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome válido"));

    // Assert
    funcionario.setNome("       ");
  }

  @Test
  public void CT022() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo válido"));

    // Assert
    funcionario.setCargo(null);
  }

  @Test
  public void CT023() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo válido"));

    // Assert
    funcionario.setCargo("       ");
  }

  @Test
  public void CT024() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#3 O salário base deve ser >= R$ 998,00"));

    // Assert
    funcionario.setSalarioBase(-50.0);
  }

  @Test
  public void CT025() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente", 30, 5);
    double salarioEsperado = 1107.98;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT026() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente Senior", 30, 5);
    double salarioEsperado = 1107.98;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }
}
