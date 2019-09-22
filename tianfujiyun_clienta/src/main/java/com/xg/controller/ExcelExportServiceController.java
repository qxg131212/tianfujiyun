package com.xg.controller;

import com.xg.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelExportServiceController {

    @Autowired
    private ExcelExportService excelExportService;

    @GetMapping()
    public String ExcelExport(){

        return "SUCCESS";
    }

}
