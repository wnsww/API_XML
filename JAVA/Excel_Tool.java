package org.gliderwiki.basejava;

//자바 엑셀 처리 툴

//import
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.IOException;
import java.io.FileOutputStream;

public class Excel_Tool {
	
			public static HSSFWorkbook Excel_Read(String path){
				
				try {
					//불러올 파일 경로
			        FileInputStream fis = new FileInputStream(path);
			        HSSFWorkbook workbook = new HSSFWorkbook(fis);
			        
			        //해당 엑셀파일의 시트(Sheet) 수
			        HSSFSheet sheet = workbook.getSheetAt(0);
			        //해당 시트의 행의 개수
			        int rows = sheet.getPhysicalNumberOfRows();
			        
			        for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
			        	// 각 행을 읽어온다
			            HSSFRow row = sheet.getRow(rowIndex);
			            if (row != null) {
			                int cells = row.getPhysicalNumberOfCells();
			                for (int columnIndex = 0; columnIndex <= cells; columnIndex++) {
			                	// 셀에 담겨있는 값을 읽는다.
			                    HSSFCell cell = row.getCell(columnIndex);
			                    String value = "";
			                    
			                    // 각 셀에 담겨있는 데이터의 타입을 체크하고 해당 타입에 맞게 가져온다.
			                    switch (cell.getCellType()) {
			                    
				                    case HSSFCell.CELL_TYPE_NUMERIC:
				                        value = cell.getNumericCellValue() + "";
				                        break;
				                    case HSSFCell.CELL_TYPE_STRING:
				                        value = cell.getStringCellValue() + "";
				                        break;
				                    case HSSFCell.CELL_TYPE_BLANK:
				                        value = cell.getBooleanCellValue() + "";
				                        break;
				                    case HSSFCell.CELL_TYPE_ERROR:
				                        value = cell.getErrorCellValue() + "";
				                        break;
			                    }//switch
			                    System.out.println(value);
			                }//for
			                
			            }//if
			            
			        }// for
			        
			    return workbook;
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
				
			}//class Excel_Read
	
	
		    public static HSSFWorkbook excel_create(String path,String sheet_name) {
		    	// 새 엑셀 생성
		    	HSSFWorkbook workbook = new HSSFWorkbook(); 
		    	// 새 시트(Sheet) 생성
		        HSSFSheet sheet = workbook.createSheet(sheet_name); 
		     // 엑셀의 행은 0번부터 시작
		        HSSFRow row = sheet.createRow(0); 
		        // 행의 셀은 0번부터 시작
		        HSSFCell cell = row.createCell(0);
		      //생성한 셀에 데이터 삽입
		        cell.setCellValue("끼요옷"); 
		        
		        try {
		            FileOutputStream fileoutputstream = new FileOutputStream(path);
		            workbook.write(fileoutputstream);
		            fileoutputstream.close();
		            
		            System.out.println("성공");
		            
		          return workbook;
		        } catch (IOException e1) {
		            e1.printStackTrace();
		            System.out.println("실패");
		        }
		
		    }

	}//class base

	
	
