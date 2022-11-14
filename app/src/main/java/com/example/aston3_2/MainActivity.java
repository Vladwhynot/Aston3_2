package com.example.aston3_2;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        editText = findViewById(R.id.editText);
        editText.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP &&
                        (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER)) {
                    Piccaso();
                    return true;
                }
                return false;
            }
        });

    }


     public void Piccaso(){
         String link = editText.getText().toString();

         Picasso.with(this)
                 .load(link)
                 .error(R.drawable.ic_baseline_close_24)
                 .into(imageView, new Callback() {
                     @Override
                     public void onSuccess() {
                     }

                     @Override
                     public void onError() {
                         Toast.makeText(getApplicationContext(), "Error!", LENGTH_SHORT).show();
                     }
                 });
     }

}