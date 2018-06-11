package com.gokwh.anastasia.gokwh;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class menu3_1 extends AppCompatActivity {

    // Creating EditText.
    EditText Nama, Alamat, Email, Telp, Usaha, Deskripsi;

    // Creating button;
    Button Simpan;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String NamaHolder, AlamatHolder, EmailHolder, TelpHolder, UsahaHolder, DeskripsiHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://gokwh.net/elektronik.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3_1);

        // Assigning ID's to EditText.
        Nama = (EditText) findViewById(R.id.input_nama);
        Alamat = (EditText) findViewById(R.id.input_alamat);
        Email = (EditText) findViewById(R.id.input_email);
        Telp = (EditText) findViewById(R.id.input_hp);
        Usaha = (EditText) findViewById(R.id.input_usaha);
        Deskripsi = (EditText) findViewById(R.id.input_des);

        // Assigning ID's to Button.
        Simpan = (Button) findViewById(R.id.simpan);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(menu3_1.this);

        progressDialog = new ProgressDialog(menu3_1.this);

        // Adding click listener to button.
        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialogCreate();
            }
        });
    }

    // Creating method to get value from EditText.
    public void GetValueFromEditText() {
        NamaHolder = Nama.getText().toString().trim();
        AlamatHolder = Alamat.getText().toString().trim();
        EmailHolder = Email.getText().toString().trim();
        TelpHolder = Telp.getText().toString().trim();
        UsahaHolder = Usaha.getText().toString().trim();
        DeskripsiHolder = Deskripsi.getText().toString().trim();
    }

    public void AlertDialogCreate() {

        new AlertDialog.Builder(menu3_1.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Go KWH")
                .setMessage("Apakah data yang anda masukkan sudah benar ?")
                .setPositiveButton("Simpan", null)
                .setNegativeButton("Batal", null)
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (Nama.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan Nama Anda", Toast.LENGTH_SHORT).show();
                            Nama.setError("Harap Masukan Nama Anda");
                        } else if (Alamat.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan Alamat Anda", Toast.LENGTH_SHORT).show();
                            Alamat.setError("Harap Masukkan Alamat Anda");
                        } else if (Email.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan E-Mail Anda", Toast.LENGTH_SHORT).show();
                            Email.setError("Harap Masukkan E-Mail Anda");
                        } else if (Telp.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan Nomor Telepon Anda", Toast.LENGTH_SHORT).show();
                            Telp.setError("Harap Masukkan Nomor Telepon Anda");
                        } else if (Usaha.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan Usaha Anda", Toast.LENGTH_SHORT).show();
                            Usaha.setError("Harap Masukkan Usaha Anda");
                        } else if (Deskripsi.getText().toString().length() == 0) {
                            Toast.makeText(menu3_1.this, "Harap Masukkan Deskripsi Anda", Toast.LENGTH_SHORT).show();
                            Deskripsi.setError("Harap Masukkan Deskripsi Anda");
                        } else {

                        Toast.makeText(menu3_1.this, "Menginput Data", Toast.LENGTH_SHORT).show();

                        // Showing progress dialog at user registration time.
                        progressDialog.setMessage("Harap Tunggu");
                        progressDialog.show();

                        // Calling method to get value from EditText.
                        GetValueFromEditText();

                        // Creating string request with post method.
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String ServerResponse) {

                                        // Hiding the progress dialog after all task complete.
                                        progressDialog.dismiss();

                                        // Showing response message coming from server.
                                        Toast.makeText(menu3_1.this, ServerResponse, Toast.LENGTH_LONG).show();
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError volleyError) {

                                        // Hiding the progress dialog after all task complete.
                                        progressDialog.dismiss();

                                        // Showing error message if something goes wrong.
                                        Toast.makeText(menu3_1.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() {

                                // Creating Map String Params.
                                Map<String, String> params = new HashMap<String, String>();

                                // Adding All values to Params.
                                params.put("nama", NamaHolder);
                                params.put("alamat", AlamatHolder);
                                params.put("email", EmailHolder);
                                params.put("telp", TelpHolder);
                                params.put("jenis", UsahaHolder);
                                params.put("deskripsi", DeskripsiHolder);

                                return params;
                            }

                        };

                        // Creating RequestQueue.
                        RequestQueue requestQueue = Volley.newRequestQueue(menu3_1.this);

                        // Adding the StringRequest object into requestQueue.
                        requestQueue.add(stringRequest);

                        Intent intent = new Intent(menu3_1.this, MainActivity.class);
                        startActivity(intent);
                    }
                }})
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(menu3_1.this, "Harap Periksa Data Anda Kembali", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}