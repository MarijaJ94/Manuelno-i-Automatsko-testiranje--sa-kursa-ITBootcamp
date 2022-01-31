package SUMAPocetnaTacka;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Putanja {
        public ExcelReader excelReader;


@BeforeClass
        public void putanjaDoExcela() throws IOException {

        excelReader=new ExcelReader("C:\\Users\\user\\IdeaProjects\\KlaseKurs\\src\\SumaUExcelu\\src\\test\\java\\SUMAPocetnaTacka\\domaciSuma.xlsx");
}

}
