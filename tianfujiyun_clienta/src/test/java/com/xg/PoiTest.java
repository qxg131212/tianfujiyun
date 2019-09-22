package com.xg;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;

public class PoiTest {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //创建一个空白的workbook
        HSSFWorkbook workBook = new HSSFWorkbook();
        FileOutputStream fos = new FileOutputStream("f:/test.xls");
        //创建sheet页
        HSSFSheet sheet1 = workBook.createSheet("工作表1");
        HSSFSheet sheet2 = workBook.createSheet("工作表12");
        ////////////////////////////////////////////
        //创建对象给第二行第一个单元格赋值
        Row row2 = sheet2.createRow(1);
        sheet2.autoSizeColumn(1);
        row2.setHeight((short) 100);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue("sheet2赋值成功");
        System.out.println(cell2.getCellType());
        ///////////////////////////////////////////
        //创建对象给第二行第一个单元格赋值
        Row row = sheet1.createRow(1);
        Cell cell = null;
        for(int i=0; i<4;i++){
            cell = row.createCell(i);
            cell.setCellValue("sheet1中赋值成功");
            cell.setCellValue("姓名");
            cell.setCellValue("邮箱");
        }
        //设置行高//
        row.setHeight((short) 1000);
        //设置列宽  第一个参数第几列（从0开始）   第二个参数宽度
        sheet1.setColumnWidth((short) 0, (short) 5000);
        //设置样式
        HSSFCellStyle cellStyle = workBook.createCellStyle();
        // 文字居中
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置单元格的文本方式为可多行编写方式
        cellStyle.setWrapText(true);
        // 1.如果需要前景颜色或背景颜色，一定要指定填充方式，两者顺序无所谓；
        // 2.如果同时存在前景颜色和背景颜色，前景颜色的设置要写在前面；
        // 3.前景颜色不是字体颜色。
        //指定填充模式
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(HSSFColor.RED.index);
        cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
        // 创建一个字体对象，因为字体也是单元格格式的一部分，所以从属于HSSFCellStyle
        // 下面几个字体的相关设置望文生义，就不用一一说明了吧
        HSSFFont font = workBook.createFont();
        font.setFontName("宋体");
        font.setItalic(true);
        font.setColor(HSSFColor.BLUE.index);
        font.setFontHeightInPoints((short) 20);
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 将字体对象赋值给单元格样式对象
        cellStyle.setFont(font);

        //将样式设置到cell中
        cell.setCellStyle(cellStyle);


        workBook.write(fos);
        fos.close();
    }

}

