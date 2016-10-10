package com.zhi.www.filereader;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/10.
 */
public class FileUtils {

    private static SaveResult saveResult;

    public FileUtils(SaveResult saveResult) {
        this.saveResult = saveResult;
    }

    /**
     * 将内容保存成文件
     *
     * @param name    文件名
     * @param content 内容
     */

    public static void save(String name, String content) {
        checkDir(name);
        File file = new File(Constants.FILE_PATH + File.separator + name);
        byte[] bytes = content.getBytes();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
            saveResult.result(Constants.CODE_SAVE_SUCCESS);
        } catch (FileNotFoundException e) {
            saveResult.result(Constants.CODE_SAVE_FAIL);
            e.printStackTrace();
        } catch (IOException e) {
            saveResult.result(Constants.CODE_SAVE_FAIL);
            ToastUtils.make(R.string.str_file_fail);
            e.printStackTrace();
        }
    }

    /**
     * 检查文件目录和文件是否存在
     *
     * @param name 文件名
     */
    public static void checkDir(String name) {
        File file = new File(Constants.FILE_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        File f = new File(Constants.FILE_PATH, name);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件
     *
     * @param name
     */
    public static String read(String name) throws FileNotFoundException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            FileInputStream fis = new FileInputStream(new File(Constants.FILE_PATH + File.separator + name));
            int len = 0;
            String content = "";
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) > 0) {
                content = new String(bytes, 0, len);
            }
            bos.close();
            fis.close();
            return content;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}