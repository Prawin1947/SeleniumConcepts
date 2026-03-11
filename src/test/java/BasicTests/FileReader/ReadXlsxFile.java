package BasicTests.FileReader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadXlsxFile {

//For .xlsx files: Use XSSFWorkbook.

    @Test
    public void readFile()throws Exception{


        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/xlsxFile/readFile.xlsx"));

        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);
        //Sheet sheet = workbook.getSheet("SheetName");

        //Read the headers
        Row firstRow =  sheet.getRow(0);
        List<String> headers = new ArrayList<>();
        int i = 0;
        int nameIndex = 0;
        int gradeIndex = 0;
        for(Cell cell : firstRow){
            headers.add(cell.getStringCellValue());
            if(cell.getStringCellValue().equals("Name")){
                nameIndex = i;
            }else if(cell.getStringCellValue().equals("Grade")){
                gradeIndex = i;
            }
            i++;
        }

        //Get specified column data for the
        for(Row r : sheet){
           String name = r.getCell(nameIndex).getStringCellValue();
           String grade = r.getCell(gradeIndex).getStringCellValue();
            System.out.println("Name : "+name +" :: Grade : "+grade);
        }

    }

    @Test
    public void writeToTheSheet()throws Exception{

       List<String> headerList =  Arrays.asList(new String[]{"Id","Name","Age","Grade","Min","Max"});

        FileOutputStream outputStream = new FileOutputStream("src/test/resources/xlsxFile/writeFile.xlsx");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("TestData");
        Row firstRow  = sheet.createRow(0);
        for(int i=0;i<5;i++){
            firstRow.createCell(i).setCellValue(headerList.get(i));
        }
        for(int i=1;i<6;i++){
            Row row = sheet.createRow(i);

            for(int j=0;j<5;j++){
                row.createCell(j).setCellValue("Value ("+i+","+j+")");
            }
        }
        workbook.write(outputStream);
    }

    @Test
    public void findEmptyCell() throws Exception{

        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/xlsxFile/readFile.xlsx"));

        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheet("readFile");

        int r=0;
        for(Row row: sheet){
            int c=0;
          for(Cell cell : row){
           CellType type =   cell.getCellType();
              if(type == CellType.BLANK){
                  System.out.println("The empty cell is in '"+ r +"' ROW and in '"+c+"' CELL");
              }
              c++;
          }
          r++;
        }
    }
}
