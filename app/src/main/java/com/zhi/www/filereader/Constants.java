package com.zhi.www.filereader;

import android.os.Environment;

/**
 * Created by Administrator on 2016/10/10.
 */
public class Constants {

    public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getPath();

    public static final String FILE_PATH = ROOT_PATH + "/AAA";

    public static final int CODE_SAVE_SUCCESS = 0x1;
    public static final int CODE_SAVE_FAIL = 0x2;
}
