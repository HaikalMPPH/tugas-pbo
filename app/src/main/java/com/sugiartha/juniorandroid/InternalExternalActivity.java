package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalExternalActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "dts2022.txt";
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_external);

        Button buatFile = findViewById(R.id.btnBuatFile);
        Button ubahFile = findViewById(R.id.btnUbahFile);
        Button bacaFile = findViewById(R.id.btnBacaFile);
        Button deleteFile = findViewById(R.id.btnHapusFile);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    void buatFile() {
        String isiFile = "Jadilah Jagoan Digital";
        File file = new File(getFilesDir(), FILENAME);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(isiFile.getBytes());
            outputStream.close();

            Toast.makeText(this, getFilesDir().toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ubahFile() {
        String ubah = "Semangat Berjuang Peserta DTS";
        File file = new File(getFilesDir(), FILENAME);

        try {
            FileOutputStream outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.close();

            Toast.makeText(this, "File berhasil diubah", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void bacaFile() {
        File file = new File(getFilesDir(), FILENAME);

        if (file.exists()) {
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
                Toast.makeText(this, "Membaca File", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            textBaca.setText(text.toString());
        }
    }

    void hapusFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()) {
            file.delete();
            Toast.makeText(this, "File sudah terhapus", Toast.LENGTH_SHORT).show();

            // Menghapus pesan pada TextView
            textBaca.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        jalanPerintah(view.getId());
    }

    public void jalanPerintah(int id) {
        switch (id) {
            case R.id.btnBuatFile:
                buatFile();
                break;
            case R.id.btnUbahFile:
                ubahFile();
                break;
            case R.id.btnBacaFile:
                bacaFile();
                break;
            case R.id.btnHapusFile:
                hapusFile();
                break;
        }
    }
}
