package com.xg.privates.projects;

import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "getCode")
public class VerCodeController {

    @Autowired
    private ConfigEntity configEntity;

    @RequestMapping("/{pid}")
    public void  getVerCode(@PathVariable("pid") String pid, HttpServletResponse response){
        String path = configEntity.getFileUploadPath() + pid + ".jpg";
    }

}
