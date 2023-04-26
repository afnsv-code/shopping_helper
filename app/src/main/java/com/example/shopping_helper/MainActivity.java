package com.example.shopping_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText weight;
    private EditText price;
    private Button button;
    private Button btn_reset;
    private TextView result_info;

    double weight_num, price_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        price  = findViewById(R.id.price);
        result_info = findViewById(R.id.result_info);
        button = findViewById(R.id.button);
        btn_reset = findViewById(R.id.btn_reset);

        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if (weight.getText().toString().trim().equals("") || price.getText().toString().trim().equals(""))
                      Toast.makeText(MainActivity.this, R.string.empty_field, Toast.LENGTH_LONG).show();
                  else
                      try {
                          Double weight_num = new Double(weight.getText().toString());
                          Double price_num = new Double(price.getText().toString());
                          System.out.println(weight_num);
                          System.out.println(price_num);
                          double ans = (price_num / weight_num ) * 1000;
                          ans = Math.round(ans * 100) / 100.0;
                          result_info.setText(Double.toString(ans));
//                          System.out.println(ans);
                      } catch (NumberFormatException e) {
                          System.err.println("Неправильный формат строки!");
                      }

              }
        }

        );
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight.getText().clear();
                price.getText().clear();
            }
        });
    }
}