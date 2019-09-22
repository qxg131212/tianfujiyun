package com.xg.service.impl;

import com.xg.service.ReadxlsService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ReadxlsServiceImpl /*implements ReadxlsService*/ {
    /*@Override
    public void readXls(InputStream is) {
        Workbook hssfWorkbook =  WorkbookFactory.create(is);

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    *//**已经直接取数据行，无需判定
                     if(hssfRow.getCell(0) == null ){
                     continue;
                     }else if(hssfRow.getCell(0).getCellType() == Cell.CELL_TYPE_STRING){
                     String value = hssfRow.getCell(0).getStringCellValue();
                     try{
                     Integer.parseInt(value);
                     }catch(Exception e){
                     continue;
                     }

                     }
                     *//*
                   Map<String, Object> map = new HashMap<String, Object>();
                  *//*  map.put("jgId", getValue(hssfRow.getCell(1)));
                    map.put("name", getValue(hssfRow.getCell(3)));
                    map.put("cardType", getValue(hssfRow.getCell(4)).split("-")[0]);
                    map.put("cardNo", getValue(hssfRow.getCell(5)));
                    map.put("sex", getValue(hssfRow.getCell(6)).split("-")[0]);
                    map.put("birth", getValue(hssfRow.getCell(7)));*//*

                    map.put("jgId", 1);
                    map.put("name", 2);
                    map.put("cardType", 3);
                    map.put("cardNo", 4);
                    map.put("sex", 5);
                    map.put("birth",6);


                }
            }
        }

    }*/
}
