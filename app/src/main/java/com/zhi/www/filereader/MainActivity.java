package com.zhi.www.filereader;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener , SaveResult{

    private FileUtils fileUtils = new FileUtils(this);
    private EditText mEtName, mEtContent;
    private Button mBtnSave;
    private TextView mTvPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvent();
    }

    private void initViews() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mTvPath = (TextView) findViewById(R.id.tv_path);

        mTvPath.setText(Constants.FILE_PATH);
    }

    private void initEvent() {
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                save();
                break;
        }
    }

    private void save(){
        Editable eName = mEtName.getText();
        Editable eContent = mEtContent.getText();
        if(null == eName || null == eContent){
            return;
        }
        String name = eName.toString();
        String content = eContent.toString();
        if("".equals(name.trim())){
            ToastUtils.make(R.string.str_null_file_name);
            return;
        }
        if ("".equals(content.trim())){
            ToastUtils.make(R.string.str_null_file_content);
            return;
        }
        String fileName = name+".txt";
        fileUtils.save(fileName, content);
    }

    @Override
    public void result(int code) {
        switch (code){
            case Constants.CODE_SAVE_SUCCESS:
                ToastUtils.make(R.string.str_file_success);
                mEtName.setText("");
                mEtContent.setText("");
                break;
            case Constants.CODE_SAVE_FAIL:
                ToastUtils.make(R.string.str_file_fail);
                break;
        }
    }
}