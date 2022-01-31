package SUMAPocetnaTacka;

import org.testng.annotations.Test;

public class TestSuma extends Putanja{




    @Test
    public void izracunajSumu(){
        int suma = 0;
        for (int i = 0; i <= excelReader.getLastRow("Brojevi") ; i++) {


            int broj = excelReader.getIntegerData("Brojevi",i,0);

            suma=suma+broj;


        }

        System.out.println(suma);
    }
}
