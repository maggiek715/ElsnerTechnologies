package com.golden.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
public XSSFWorkbook wb;
public XSSFSheet sh;
public XSSFRow row;
public XSSFCell cell;
public FileOutputStream fileout;
public FileInputStream f2;
public String getCellData(String SheetName, int rownum , int colnum) throws IOException
{
f2 = new FileInputStream(System.getProperty("user.dir")+"\\Datasheet\\Technologies.xlsx");
wb= new XSSFWorkbook(f2);
sh=wb.getSheet(SheetName);
row= sh.getRow(rownum);
cell=row.getCell(colnum);
String output= cell.getStringCellValue();
System.out.println(output);
switch(cell.getCellType()) {
case STRING:
return cell.getStringCellValue();
case NUMERIC:
return String.valueOf(cell.getNumericCellValue());
default:
break;
}
return null;
}
public static void main(String [] args) throws IOException {
ExcelReader excel= new ExcelReader();
excel.getCellData("Login", 1, 0);
}
}