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

  public static double totalPaymentHomeCenter(int totalMaterials, double[] pricesMaterialsHomeCenter, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsHomeCenter[i] * amountMaterials[i];
    }

    suma += typeConstructionPayment;
    return suma;
  }

  public static double totalPaymentFerreteriaCentro(int totalMaterials, double[] pricesMaterialsFerreteriaCentro, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsFerreteriaCentro[i] * amountMaterials[i];
    }
    suma += typeConstructionPayment;
    return suma;
  }

  public static double totalPaymentFerreteriaBarrio(int totalMaterials, double[] pricesMaterialsFerreteriaBarrio, String[] typeConstruction, String[] CONSTRUCTION, int[] amountMaterials){
    double typeConstructionPayment = typeConstructionPaymentRequest(totalMaterials, typeConstruction, CONSTRUCTION);
    double suma = 0;
    for (int i = 0; i < totalMaterials; i++){
      suma += pricesMaterialsFerreteriaBarrio[i] * amountMaterials[i];
    }
    suma += typeConstructionPayment;
    return suma;
  }

}
