package ui;

import java.util.Scanner;
import java.util.Arrays;
import model.*;

public class Main {

  private final static String PLACES[] = {"HomeCenter","Ferreteria Centro","Ferreteria Barrio"};
  private final static String CONSTRUCTION[] = {"Obra Negra","Obra Blanca","Pintura"};
  private final static double ROUGH_CONSTRUCTION = 1300000;
  private final static double SOFT_CONSTRUCTION = 2600000;
  private final static double PAINT = 980000;

  /**
  * Method that ask the amount of materials to buy. <br>
  * <b>pre: </b>
  * <b>post: </b> save the amount of materials to buy.
  * @param Scanner object that allow input to be captured. sc != null. <br>
  */
  public static int totalMaterialsRequest(Scanner sc){
    System.out.print("Ingrese la cantidad de materiales a comprar: ");
    int totalMaterials = sc.nextInt();
    sc.nextLine();
    return totalMaterials;
  }

  /**
  * Method that ask the names of the materials. <br>
  * <b>pre: </b>
  * <b>post: </b> save the names of the materials.
  *@param totalMaterials int that storage the amount of materials. totalmaterials != 0 && totalMaterials > 0.
  *@param Scanner object that allow input to be captured. sc != null. <br>
  */
  public static String[] namesMaterialsRequest(int totalMaterials, Scanner sc){
    String namesMaterials[] = new String[totalMaterials];
    System.out.println("Ingrese los nombres de los materiales: ");

    for (int i = 0; i < totalMaterials; i++){
      System.out.println("Material " + (i+1));
      namesMaterials[i] = sc.nextLine();
    }
    return namesMaterials;
  }

  /**
  * Method that ask the names of the materials. <br>
  * <b>pre: </b>
  * <b>post: </b> save the names of the materials.
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param namesMaterials namesMaterials != null.
  *@param Scanner object that allow input to be captured. sc != null. <br>
  *@param count accountant 0 <= count <=2
  */
  public static double[] pricesMaterialsRequest(int totalMaterials, String namesMaterials[], Scanner sc, int count){
    double pricesMaterials[] = new double[totalMaterials];
    System.out.println("Ingrese los precios de los materiales en " + PLACES[count] + ": ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      pricesMaterials[i] = sc.nextDouble();
      sc.nextLine();
    }
    return pricesMaterials;
  }

  /**
  * Method that ask the ammount of an specific materials. <br>
  * <b>pre: </b>
  * <b>post: </b> save the amount of an specific materials.
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param namesMaterials namesMaterials != null.
  *@param Scanner object that allow input to be captured. sc != null. <br>
  *@param count accountant 0 <= count <=2
  */
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

  /**
  * Method that ask the location of the costomer. <br>
  * <b>pre: </b>
  * <b>post: </b> save the location of the costomer.
  *@param Scanner object that allow input to be captured. sc != null. <br>
  */
  public static String locationRequest(Scanner sc){
    System.out.print("Ingrese la ubicacion del inmueble (Norte, Centro, Sur): ");
    String location = sc.nextLine();
    location = location.toLowerCase();
    return location;
  }

  /**
  * Method that ask the type of construction of an specific materials. <br>
  * <b>pre: </b>
  * <b>post: </b> save the type of construction of an specific materials.
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param namesMaterials namesMaterials != null.
  *@param Scanner object that allow input to be captured. sc != null. <br>
  */
  public static String[] typeConstructionRequest(int totalMaterials, String namesMaterials[], Scanner sc){
    String typeConstruction[] = new String[totalMaterials];
    System.out.println("Escriba para que necesita el material('obra negra', 'obra blanca', 'pintura'): ");
    for (int i = 0; i < totalMaterials; i++){
      System.out.print(namesMaterials[i] + ": ");
      typeConstruction[i] = sc.nextLine();
    }
    return typeConstruction;
  }

  /**
  * Method that print the total pay of the materials. <br>
  * <b>pre: </b>
  * <b>post: </b> print the total pay of the materials.
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param pricesMaterialsHomeCenter pricesMaterialsHomeCenter != null.
  *@param pricesMaterialsFerreteriaCentro pricesMaterialsFerreteriaCentro != null.
  *@param pricesMaterialsFerreteriaBarrio pricesMaterialsFerreteriaBarrio != null.
  *@param typeConstruction typeConstruction != null && typeConstruction == "obra negra" || "obra blanca" || "pintura"
  *@param CONSTRUCTION constant
  *@param amountMaterials amountMaterials != null.
  *@param namesMaterials namesMaterials != null.
  *@param location location == "norte" || "sur" || "centro"
  */
  public static void totalPaymentPlaces(int totalMaterials, double[] pricesMaterialsHomeCenter, double[] pricesMaterialsFerreteriaCentro, double[] pricesMaterialsFerreteriaBarrio, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials, String location){
    for (int i = 0; i < PLACES.length; i++){
      System.out.print("El valor total a pagar en " + PLACES[i] + " es de: ");
      switch (PLACES[i]){
        case "HomeCenter":
          System.out.println(Operation.totalPaymentHomeCenter(totalMaterials, pricesMaterialsHomeCenter, typeConstruction, CONSTRUCTION, amountMaterials, location));
          break;
        case "Ferreteria Centro":
          System.out.println(Operation.totalPaymentFerreteriaCentro(totalMaterials, pricesMaterialsFerreteriaCentro, typeConstruction, CONSTRUCTION, amountMaterials, location));
          break;
        case "Ferreteria Barrio":
          System.out.println(Operation.totalPaymentFerreteriaBarrio(totalMaterials, pricesMaterialsFerreteriaBarrio, typeConstruction, CONSTRUCTION, amountMaterials, location));
          break;
      }
    }
  }

  /**
  * Method that print the better place to buy the materials. <br>
  * <b>pre: </b>
  * <b>post: </b> print the better place to buy the materials.
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param pricesMaterialsHomeCenter pricesMaterialsHomeCenter != null.
  *@param pricesMaterialsFerreteriaCentro pricesMaterialsFerreteriaCentro != null.
  *@param pricesMaterialsFerreteriaBarrio pricesMaterialsFerreteriaBarrio != null.
  *@param amountMaterials amountMaterials != null.
  *@param location object that allow input to be captured. sc != null. <br>
  */
  public static void betterPaymentRequest( int totalMaterials, double[] pricesMaterialsHomeCenter, double[] pricesMaterialsFerreteriaBarrio, double[] pricesMaterialsFerreteriaCentro, int[] amountMaterials, String[] namesMaterials, String location){
    double betterPaymentMaterial[] = new double[totalMaterials];
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      if (pricesMaterialsHomeCenter[i] <= pricesMaterialsFerreteriaBarrio[i] && pricesMaterialsHomeCenter[i] <= pricesMaterialsFerreteriaCentro[i]){
        System.out.println("El mejor lugar para el material " + namesMaterials[i] + " es " + PLACES[0]);
        suma += pricesMaterialsHomeCenter[i] * amountMaterials[i];
      } else if (pricesMaterialsFerreteriaCentro[i] <= pricesMaterialsHomeCenter[i] && pricesMaterialsFerreteriaCentro[i] <= pricesMaterialsFerreteriaBarrio[i]){
        System.out.println("El mejor lugar para el material " + namesMaterials[i] + " es " + PLACES[1]);
        suma += pricesMaterialsFerreteriaCentro[i] * amountMaterials[i];
      } else {
        System.out.println("El mejor lugar para el material " + namesMaterials[i] + " es " + PLACES[2]);
        suma += pricesMaterialsFerreteriaBarrio[i] * amountMaterials[i];
      }
    }
    double domicilio = Operation.orderingHome(suma, location);
    suma += domicilio;
    System.out.println("Debera pagar entonces: " + suma);
  }

  /**
  * Method that print the materials by type of construction <br>
  * <b>pre: </b>
  * <b>post: </b> print the materials by type of construction
  *@param totalMaterials totalmaterials != 0 && totalMaterials > 0.
  *@param typeConstruction typeConstruction != null && typeConstruction == "obra negra" || "obra blanca" || "pintura"
  *@param namesMaterials namesMaterials != null.
  *@param deployAddonsCount deployAddons != null
  */
  public static void deployAddons(int totalMaterials, String[] typeConstruction, String[] namesMaterials, int[] deployAddonsCount){
    String roughAddons[] = new String[deployAddonsCount[0]];
    String softAddons[] = new String[deployAddonsCount[1]];
    String paintAddons[] = new String[deployAddonsCount[2]];
    int countA = 0;
    int countB = 0;
    int countC = 0;
    for(int i = 0; i < totalMaterials; i++){
      switch (typeConstruction[i]){
        case "obra negra":
          roughAddons[countA] = namesMaterials[i];
          countA++;
          break;
        case "obra blanca":
          softAddons[countB] = namesMaterials[i];
          countB++;
          break;
        case "pintura":
          paintAddons[countC] = namesMaterials[i];
          countC++;
          break;
      }
    }
    System.out.println("Los objetos que son utilizados para obra negra son: " + Arrays.toString(roughAddons));
    System.out.println("Los objetos que son utilizados para obra blanca son: " + Arrays.toString(softAddons));
    System.out.println("Los objetos que son utilizados para pintura son: " + Arrays.toString(paintAddons));
  }

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    int totalMaterials = totalMaterialsRequest(sc);
    String namesMaterials[] = namesMaterialsRequest(totalMaterials, sc);
    int count = 0;
    double pricesMaterialsHomeCenter[] = pricesMaterialsRequest(totalMaterials, namesMaterials, sc, count);
    count += 1;
    double pricesMaterialsFerreteriaCentro[] = pricesMaterialsRequest(totalMaterials, namesMaterials, sc, count);
    count += 1;
    double pricesMaterialsFerreteriaBarrio[] = pricesMaterialsRequest(totalMaterials, namesMaterials, sc, count);
    int amountMaterials[] = amountMaterialsRequest(totalMaterials, namesMaterials, sc);
    String location = locationRequest(sc);
    String typeConstruction[] = typeConstructionRequest(totalMaterials, namesMaterials, sc);
    totalPaymentPlaces(totalMaterials, pricesMaterialsHomeCenter, pricesMaterialsFerreteriaCentro, pricesMaterialsFerreteriaBarrio, typeConstruction, CONSTRUCTION, amountMaterials, location);
    betterPaymentRequest(totalMaterials, pricesMaterialsHomeCenter, pricesMaterialsFerreteriaBarrio, pricesMaterialsFerreteriaCentro, amountMaterials, namesMaterials, location);
    int deployAddonsCount[] = Operation.deployAddonsCountRequest(totalMaterials, typeConstruction);
    deployAddons(totalMaterials, typeConstruction, namesMaterials, deployAddonsCount);
  }
}
