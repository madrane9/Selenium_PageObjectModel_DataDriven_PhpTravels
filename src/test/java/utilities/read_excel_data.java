package utilities;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel_data {
	
	public String[][]read_sheet() throws InvalidFormatException, IOException{
		
		File myfile=new File(".\\Test_data\\BookNew.xlsx");
		// XSSFWorkbook das ist ein Class zuständig für Excell, man soll unsere File ihn reingeben
		XSSFWorkbook wb= new XSSFWorkbook(myfile);
		
		//XSSFSheet das ist ein Class ich habe mysheet als reference variable von ihm und nannte die erste Seite in Excell "Sheet1"
		// d.h nimm diese Seite "Sheet1"
		XSSFSheet mysheet = wb.getSheet("Sheet1");
		
		int number_of_rows = mysheet.getPhysicalNumberOfRows();
		int number_of_columns = mysheet.getRow(0).getLastCellNum();

		// - 1 weil wir die Rows ohne Header wollen
		String[][]myarray = new String[number_of_rows-1][number_of_columns];
		// wir fangen mit 1 wegen Header an
		for (int i=1; i<number_of_rows; i++) {
			//wir fangen mit 0 an
			
			for (int j=0; j<number_of_columns; j++) {
				XSSFRow row=mysheet.getRow(i);
				myarray[i-1][j]=row.getCell(j).getStringCellValue();  //(2x get) es heisst Method chain. und getStringCellValue = hol mir was in der Zelle ist
	
			}
		}
		return myarray;
	}

}
