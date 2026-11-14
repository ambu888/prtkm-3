package com.usti.biodataku;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilActivity extends AppCompatActivity {


    private void bukaIntent(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Tidak ada aplikasi yang bisa membuka ini",
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil);
        String extra = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);
        final String nama = (extra == null) ? "Mahasiswa" : extra;
        TextView txtSapa = findViewById(R.id.txtSapa);
        txtSapa.setText("Halo, " + nama + "!");
        findViewById(R.id.btnWeb).setOnClickListener(v ->
                bukaIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.usti.ac.id"))));
        findViewById(R.id.btnTelepon).setOnClickListener(v ->
                bukaIntent(new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:085155330852"))));
        findViewById(R.id.btnEmail).setOnClickListener(v -> {
            Intent email = new Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mailto:admin@usti.ac.id"));
            email.putExtra(Intent.EXTRA_SUBJECT, "Pertanyaan dari " + nama);
            bukaIntent(email);
        });

        Button btnKembali = findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(v -> finish());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}