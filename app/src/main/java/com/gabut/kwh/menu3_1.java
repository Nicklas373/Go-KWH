package com.gabut.kwh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class menu3_1 extends AppCompatActivity {

    EditText editTextNama, editTextAlamat, editTextEmail, editTextTelp, editTextUsaha, editTextDeskripsi;
    String GetNama, GetAlamat, GetEmail, GetTelp, GetUsaha, GetDeskripsi;
    Button simpan;

    String DataParseUrl = "http://gokwh.net/elektronik.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3_1);

        editTextNama = (EditText) findViewById(R.id.input_nama);
        editTextAlamat = (EditText) findViewById(R.id.input_alamat);
        editTextEmail = (EditText) findViewById(R.id.input_email);
        editTextTelp = (EditText) findViewById(R.id.input_hp);
        editTextUsaha = (EditText) findViewById(R.id.input_usaha);
        editTextDeskripsi = (EditText) findViewById(R.id.input_des);

        simpan = (Button) findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GetDataFromEditText();

                SendDataToServer(GetNama, GetAlamat, GetEmail, GetTelp, GetUsaha, GetDeskripsi);

                Intent intent = new Intent(menu3_1.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    public void GetDataFromEditText(){
        GetNama = editTextNama.getText().toString();
        GetAlamat = editTextAlamat.getText().toString();
        GetEmail = editTextEmail.getText().toString();
        GetTelp = editTextTelp.getText().toString();
        GetUsaha = editTextUsaha.getText().toString();
        GetDeskripsi = editTextDeskripsi.getText().toString();
    }

    public void SendDataToServer(final String nama, final String alamat, final String email, final String telp, final String usaha, final String deskripsi){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickNama = nama ;
                String QuickAlamat = alamat ;
                String QuickEmail = email ;
                String QuickTelp = telp;
                String QuickUsaha = usaha;
                String QuickDeskripsi = deskripsi;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("nama", QuickNama));
                nameValuePairs.add(new BasicNameValuePair("alamat", QuickAlamat));
                nameValuePairs.add(new BasicNameValuePair("email", QuickEmail));
                nameValuePairs.add(new BasicNameValuePair("telp", QuickTelp));
                nameValuePairs.add(new BasicNameValuePair("jenis", QuickUsaha));
                nameValuePairs.add(new BasicNameValuePair("deskripsi", QuickDeskripsi));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(DataParseUrl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Submit Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(menu3_1.this, "Data Anda Sudah Terkirim", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(nama, alamat, email, telp, deskripsi);
    }
}