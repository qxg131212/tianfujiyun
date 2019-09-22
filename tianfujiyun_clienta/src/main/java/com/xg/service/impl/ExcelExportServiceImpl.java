package com.xg.service.impl;

import com.xg.service.ExcelExportService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @Autor qiaoxiaogang
 * @Time  2019-09-19
 * @Description Exacle的下载接口
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {
    /**
     *
     * @param response
     * @param list
     * @param filename
     * @param title
     */
    @Override
    public void exportXml(HttpServletResponse response, List<List<Object>> list, String filename, String[] title) {
        String[] header = title;
        /***生成Excel***/


        // 第一步，创建一个workbook，对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(filename);
        // 第三步，在sheet中添加表头第0行
        XSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置 字体相关配置
        XSSFCellStyle style = wb.createCellStyle();

        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setFontName("宋体");
        font.setBold(true);
//这两行的是自己注
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
        style.setFont(font);
        //依次0行中在添加cell，并设置对应字段名
        XSSFCell cell = null;
        for(int i=0;i<header.length;i++){
            cell = row.createCell((short) i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }

        if(list == null){
            return;
        }

      for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            //依次从clist中读取相关数据，并写入excel
            List<Object> clist = list.get(i);
            XSSFDataFormat format = wb.createDataFormat();
            for(int n=0;n<clist.size();n++) {
                Object value = clist.get(n);
                if(value instanceof Date){
//                    row.createCell((short)n).setCellValue(fmt.format(value));
                }else{
                    row.createCell((short)n).setCellValue(clist.get(n).toString());
                }
            }
        }

        try
        {
            //设置文件内容下载方式
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=\"" +
                    java.net.URLEncoder.encode(filename, "UTF-8") + ".xlsx" + "\" ");
            wb.write(response.getOutputStream());
            response.getOutputStream().close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
