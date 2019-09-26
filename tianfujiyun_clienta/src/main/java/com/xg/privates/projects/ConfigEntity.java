package com.xg.privates.projects;

import org.springframework.stereotype.Component;

import java.io.File;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Component
public class ConfigEntity {

    private  String fileUploadPath;   //路径

    private Boolean haveGreatPath = false; //创建路径

    public String getFileUploadPath() {
        if (fileUploadPath == null){
            return System.getProperty("java.io.tmpdir");
        }else {
            if (!fileUploadPath.endsWith(File.separator)){
                fileUploadPath = fileUploadPath+File.separator;
            }
            if (!haveGreatPath){
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveGreatPath = true;
            }
            return fileUploadPath;
        }

    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Boolean getHaveGreatPath() {
        return haveGreatPath;
    }

    public void setHaveGreatPath(Boolean haveGreatPath) {
        this.haveGreatPath = haveGreatPath;
    }
}
