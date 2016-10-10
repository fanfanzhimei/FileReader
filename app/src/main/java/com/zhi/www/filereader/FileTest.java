package com.zhi.www.filereader;

import android.test.AndroidTestCase;
import android.util.Log;

import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2016/10/10.
 */
public class FileTest extends AndroidTestCase{
    private static final String TAG = FileTest.class.getSimpleName();
    public void test(){
        String result;
        try {
            result = FileUtils.read("dh.txt");
            Log.e(TAG, result);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "文件不存在");
            e.printStackTrace();
        }
    }
}