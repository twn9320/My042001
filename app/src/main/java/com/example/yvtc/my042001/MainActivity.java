package com.example.yvtc.my042001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    File myFile;
    TextView tv;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        ;
        myFile = new File(getFilesDir()+File.separator+"mydata.txt");
    }

    public void clickWrite(View v){
        try {
            FileWriter fw = new FileWriter(myFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(editText.getText().toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  clickRead(View v){

        try {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            String str=br.readLine();
            tv.setText(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
