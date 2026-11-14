package com.usti.biodataku;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Main: onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Main: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Main: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Main: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Main: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Main: onDestroy");
    }

    public static final String EXTRA_NAMA = "com.usti.biodataku.EXTRA_NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText edtNama = findViewById(R.id.edtNama);
        Button btnProfil = findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(v -> {
            String nama = edtNama.getText().toString().trim();
            if (nama.isEmpty()) {
                Toast.makeText(this, "Nama wajib diisi", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
            intent.putExtra(EXTRA_NAMA, nama);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}