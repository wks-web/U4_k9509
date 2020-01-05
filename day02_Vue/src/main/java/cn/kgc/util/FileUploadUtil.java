package cn.kgc.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public class FileUploadUtil {
    private static final String savePosition="d:\\images\\";
    /**
     * 上传文件的工具类
     * @param pf  上传文件
     * @return  上传文件的名称
     */
    public static String  upload(CommonsMultipartFile pf){
        try {
            //获取文件的扩展名
            String fname=pf.getOriginalFilename();
            String fexpName=fname.substring(fname.lastIndexOf("."));
            //生成新的文件名
            String unique=System.currentTimeMillis()+"";
            String saveFileName=unique+fexpName;
            String savePath=savePosition+saveFileName;
            File savefile=new File(savePath);
            pf.transferTo(savefile); //上传
            return saveFileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteFile(String fileName){
        File file=new File(savePosition+fileName);
        return file.delete();
    }

}
