package ui;

import java.util.Scanner;
import model.*;

public class Main {

  public final static String PLACES[] = {"HomeCenter","Ferreteria Centro","Ferreteria Barrio"};
  public final static String CONSTRUCTION[] = {"Obra Negra","Obra Blanca","Pintura"};
  public final static double ROUGH_CONSTRUCTION = 1300000;
  public final static double SOFT_CONSTRUCTION = 2600000;
  public final static double PAINT = 980000;

  public static int totalMaterialsRequest(Scanner sc){
    System.out.print("Ingrese la cantidad de materiales a comprar: ");
    int totalMaterials = sc.nextInt();
    sc.nextLine();
    return totalMaterials;
  }

  public static String[] namesMaterialsRequest(int totalMaterials, Scanner sc){
    String namesMaterials[] = new String[totalMaterials];
    System.out.println("Ingrese los nombres de los materiales: ");

    for (int i = 0; i < totalMaterials; i++){
      System.out.println("Material " + (i+1));
      namesMaterials[i] = sc.nextLine();
    }
    return namesMaterials;
  }

  public static double[] pricesMaterialsHomeCenterRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    double pricesMaterialsHomeCenter[] = new double[totalMaterials];
    System.out.println("Ingrese los precios de los materiales en " + PLACES[0] + ": ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      pricesMaterialsHomeCenter[i] = sc.nextDouble();
      sc.nextLine();
    }
    return pricesMaterialsHomeCenter;
  }

  public static double[] pricesMaterialsFerreteriaCentroRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    double pricesMaterialsFerreteriaCentro[] = new double[totalMaterials];
    System.out.println("Ingrese los precios de los materiales en " + PLACES[1] + ": ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      pricesMaterialsFerreteriaCentro[i] = sc.nextDouble();
      sc.nextLine();
    }
    return pricesMaterialsFerreteriaCentro;
  }

  public static double[] pricesMaterialsFerreteriaBarrioRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    double pricesMaterialsFerreteriaBarrio[] = new double[totalMaterials];
    System.out.println("Ingrese los precios de los materiales en " + PLACES[2] + ": ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      pricesMaterialsFerreteriaBarrio[i] = sc.nextDouble();
      sc.nextLine();
    }
    return pricesMaterialsFerreteriaBarrio;
  }

  public static int[] amountMaterialsRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    int amountMaterials[] = new int[totalMaterials];
    System.out.println("Ingrese la cantidad de materiales para: ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      amountMaterials[i] = sc.nextInt();
      sc.nextLine();
    }
    return amountMaterials;
  }

  public static String[] typeConstructionRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    String typeConstruction[] = new String[totalMaterials];
    System.out.println("Escriba para que necesita el material('obra negra', 'obra blanca', 'pintura'): ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      typeConstruction[i] = sc.nextLine();
    }
    return typeConstruction;
  }

  public static void totalPaymentPlaces(int totalMaterials, double[] pricesMaterialsHomeCenter, double[] pricesMaterialsFerreteriaCentro, double[] pricesMaterialsFerreteriaBarrio, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials){
    for (int i = 0; i < PLACES.length; i++){
      System.out.print("El valor total a pagar en " + PLACES[i] + " es de: ");
      switch (PLACES[i]){
        case "HomeCenter":
          System.out.println(Operation.totalPaymentHomeCenter(totalMaterials, pricesMaterialsHomeCenter, typeConstruction, CONSTRUCTION, amountMaterials));
          break;
        case "Ferreteria Centro":
          System.out.println(Operation.totalPaymentFerreteriaCentro(totalMaterials, pricesMaterialsFerreteriaCentro, typeConstruction, CONSTRUCTION, amountMaterials));
          break;
        case "Ferreteria Barrio":
          System.out.println(Operation.totalPaymentFerreteriaBarrio(totalMaterials, pricesMaterialsFerreteriaBarrio, typeConstruction, CONSTRUCTION, amountMaterials));
          break;
      }
    }
  }

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    int totalMaterials = totalMaterialsRequest(sc);
    String namesMaterials[] = namesMaterialsRequest(totalMaterials, sc);
    double pricesMaterialsHomeCenter[] = pricesMaterialsHomeCenterRequest(totalMaterials, namesMaterials, sc);
    double pricesMaterialsFerreteriaCentro[] = pricesMaterialsFerreteriaCentroRequest(totalMaterials, namesMaterials, sc);
    double pricesMaterialsFerreteriaBarrio[] = pricesMaterialsFerreteriaBarrioRequest(totalMaterials, namesMaterials, sc);
    int amountMaterials[] = amountMaterialsRequest(totalMaterials, namesMaterials, sc);
    String typeConstruction[] = typeConstructionRequest(totalMaterials, namesMaterials, sc);
    totalPaymentPlaces(totalMaterials, pricesMaterialsHomeCenter, pricesMaterialsFerreteriaCentro, pricesMaterialsFerreteriaBarrio, typeConstruction, CONSTRUCTION, amountMaterials);

  }
}
