package com.example.lmq.xsy5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.btn1);
       final String MyFileName = "lmq.txt";
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try{

                    FileOutputStream fileOutputStream = openFileOutput(MyFileName,MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);

                    String content = "2015011425 卢梦琪";
                    try{
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                        Toast.makeText(MainActivity.this, "You write something", Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Button button2 =(Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream in =null;
                BufferedReader reader=null;
                StringBuilder content = new StringBuilder();
                try {

                    in = openFileInput(MyFileName);
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    try{
                        while ((line = reader.readLine()) != null) {
                            content.append(line);
                        }
                        Toast.makeText(MainActivity.this,content.toString(),Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if(in!=null)
                            in.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}