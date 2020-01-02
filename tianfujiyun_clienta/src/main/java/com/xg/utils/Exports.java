package com.xg.utils;

import com.xg.entity.User;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class Exports {
    public static void main(String[] args) throws IOException {
        String exportType  = "信息";
        HttpServletResponse response = new HttpServletResponse() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public String encodeURL(String s) {
                return null;
            }

            @Override
            public String encodeRedirectURL(String s) {
                return null;
            }

            @Override
            public String encodeUrl(String s) {
                return null;
            }

            @Override
            public String encodeRedirectUrl(String s) {
                return null;
            }

            @Override
            public void sendError(int i, String s) throws IOException {

            }

            @Override
            public void sendError(int i) throws IOException {

            }

            @Override
            public void sendRedirect(String s) throws IOException {

            }

            @Override
            public void setDateHeader(String s, long l) {

            }

            @Override
            public void addDateHeader(String s, long l) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setIntHeader(String s, int i) {

            }

            @Override
            public void addIntHeader(String s, int i) {

            }

            @Override
            public void setStatus(int i) {

            }

            @Override
            public void setStatus(int i, String s) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaderNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return null;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) {

            }

            @Override
            public void setContentLength(int i) {

            }

            @Override
            public void setContentLengthLong(long l) {

            }

            @Override
            public void setContentType(String s) {

            }

            @Override
            public void setBufferSize(int i) {

            }

            @Override
            public int getBufferSize() {
                return 0;
            }

            @Override
            public void flushBuffer() throws IOException {

            }

            @Override
            public void resetBuffer() {

            }

            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void reset() {

            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }
        } ;
        String result = "ok";
        String sheetName = "sheet";
        List<Object> auditTypes = new ArrayList<>();
        //进一步封装成参数
        String[] firstRow1 = {"姓名","年龄","地址"};
        String[] firstRow2 = {"姓名","年龄","住址"};
        String [] title = firstRow1;
        switch(exportType){
            case "pick":
                auditTypes.add(801);
                sheetName = "信息列表";
                title = firstRow2;
                break;
            case "xinxi":
                auditTypes.add(802);
                sheetName ="信息";
                title = firstRow1;
                break;
        }
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCellStyle cellStyle = wb.createCellStyle();
        //设置工作博
        XSSFSheet sheet = wb.createSheet(sheetName);
        //设置sheet标题列
        XSSFRow header = sheet.createRow(0);
        for(int i=0;i<title.length;i++){
            header.createCell(i)/*.setCellStyle(cellStyle)*/;
            header.createCell(i).setCellValue(title[i]);
        }
        try {
            User user = new User();
            List<User> list = new ArrayList<>();

            Iterator<User> iterator = list.iterator();
            //遍历写入总数据
            int j = 1;
            while (iterator.hasNext()) {
                User temp = iterator.next();
                //创建数据行
                XSSFRow row = sheet.createRow(j);
                XSSFCell name = row.createCell(0);
                XSSFCell age = row.createCell(1);
                XSSFCell adress = row.createCell(2);

                /*name.setCellValue(temp.getUname());
                age.setCellValue(temp.getAge());
                adress.setCellValue(temp.getAddress());*/

                j++;
            }
        }catch (Exception e){
            result = "FAIL,Caused By"+ e.getMessage();
            wb.close();
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try{
            wb.write(os);//将数据写入
        }catch (IOException e){
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        //设置reponse参数，可以打开下载页面
        response.reset();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            String filename = sheetName + ".xlsx";
            response.setContentType("application/octet-stream;chaset=ISO8859-1");
            response.setHeader("Content-Disposition","attachment;filename=".concat(String.valueOf(URLEncoder.encode(filename))));
            response.addHeader("Pargam","no-cache");
            response.addHeader("Cache-Control","no-cache");
            ServletOutputStream out = response.getOutputStream();
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff,0,buff.length))){
                bos.write(buff,0,bytesRead);
            }
            result = "ok";
        }catch (final  IOException e){
            e.printStackTrace();
            result = "FAIL,Caused By" + e.getMessage();
        }finally {
            if (bis != null)
                try{
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            if (bos != null)
                try{
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            System.out.println(result);
        }

    }
}
