package com.example.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEncrypt(View v) {
        try {
            String key = ((EditText) findViewById(R.id.key)).getText().toString();
            String file = ((EditText) findViewById(R.id.data)).getText().toString();
            Cipher c = new Cipher(key);
            String encryptFile = c.Encrypt(file);
            ((EditText) findViewById(R.id.data)).setText(encryptFile);
        }
        catch (Exception e) {
            String msg = e.getMessage();
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    public void onDecrypt(View v) {
        try {
            String key = ((EditText) findViewById(R.id.key)).getText().toString();
            String file = ((EditText) findViewById(R.id.data)).getText().toString();
            Cipher c = new Cipher(key);
            String decryptFile = c.Decrypt(file);
            ((EditText) findViewById(R.id.data)).setText(decryptFile);
        } catch (Exception e) {
            String msg = e.getMessage();
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    public void onSave(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            String msg = e.getMessage();
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

    }

    public void onLoad(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show = "";
            for (int c = fr.read(); c != -1; c = fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);

        } catch (Exception e) {
            String msg = e.getMessage();
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }





}