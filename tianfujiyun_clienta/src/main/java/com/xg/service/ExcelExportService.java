package com.xg.service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExcelExportService {

    public  void exportXml(HttpServletResponse response, List<List<Object>> list,String filename,String[] title);

}
