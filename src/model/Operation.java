package model;

public class Operation {

  public static double typeConstructionPaymentRequest(int totalMaterials, String[] typeConstruction, String[] CONSTRUCTION){
    double typeConstructionPayment = 0;
    for (int i = 0; i < totalMaterials; i++){
      typeConstructionPayment += (typeConstruction[i].equalsIgnoreCase(CONSTRUCTION[0])) ? 1300000 : 0;
      typeConstructionPayment += (typeConstruction[i].equalsIgnoreCase(CONSTRUCTION[1])) ? 2600000 : 0;
      typeConstructionPayment += (typeConstruction[i].equalsIgnoreCase(CONSTRUCTION[2])) ? 980000 : 0;
    }
    return typeConstructionPayment;
  }

  public static double orderingHome(double suma, String location){
    double domicilio = 0;
    switch (location){
      case "norte":
        if(suma < 80000){
          domicilio = 120000;
        } else if(suma < 300000 ) {
          domicilio = 28000;
        }
        break;
      case "centro":
        if(suma < 80000){
          domicilio = 50000;
        }
        break;
      case "sur":
        if(suma < 80000){
          domicilio = 120000;
        } else if(suma < 300000) {
          domicilio = 55000;
        }
        break;
    }
    return domicilio;
  }

  public static double totalPaymentHomeCenter(int totalMaterials, double[] pricesMaterialsHomeCenter, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials, String location){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsHomeCenter[i] * amountMaterials[i];
    }
    double domicilio = orderingHome(suma, location);
    suma += domicilio;
    suma += typeConstructionPayment;
    return suma;
  }

  public static double totalPaymentFerreteriaCentro(int totalMaterials, double[] pricesMaterialsFerreteriaCentro, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials, String location){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsFerreteriaCentro[i] * amountMaterials[i];
    }
    double domicilio = orderingHome(suma, location);
    suma += domicilio;
    suma += typeConstructionPayment;
    return suma;
  }

  public static double totalPaymentFerreteriaBarrio(int totalMaterials, double[] pricesMaterialsFerreteriaBarrio, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials, String location){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsFerreteriaBarrio[i] * amountMaterials[i];
    }
    double domicilio = orderingHome(suma, location);
    suma += domicilio;
    suma += typeConstructionPayment;
    return suma;
  }

  public static int[] deployAddonsCountRequest(int totalMaterials, String[] typeConstruction){
    int countA = 0;
    int countB = 0;
    int countC = 0;
    for(int i = 0; i < totalMaterials; i++){
      switch (typeConstruction[i]){
        case "obra negra":
          countA++;
          break;
        case "obra blanca":
          countB++;
          break;
        case "pintura":
          countC++;
          break;
      }
    }
    int deployAddonsCount[] = {countA, countB, countC};
    return deployAddonsCount;
  }
}
