package com.emelyantsev303;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

//Емельянцев Никита, 303

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] price =  new EditText[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num[0] = findViewById(R.id.textApple);
        num[1] = findViewById(R.id.textStrawberry);
        num[2] = findViewById(R.id.textBlueberry);
        num[3] = findViewById(R.id.textPotatoes);

        chk[0] = findViewById(R.id.checkApple);
        chk[1] = findViewById(R.id.checkStrawberry);
        chk[2] = findViewById(R.id.checkBlueberry);
        chk[3] = findViewById(R.id.checkPotatoes);

        price[0] = findViewById(R.id.textPriceApple);
        price[1] = findViewById(R.id.priceStraw);
        price[2] = findViewById(R.id.priceBlue);
        price[3] = findViewById(R.id.pricePot);
    }

    @SuppressLint("DefaultLocale")
    public void OnCalc(View v) {

        float sum = 0.0f;
        int n = chk.length;
        String rep = "";

        for (int i = 0; i < n; i++) {
            if(chk[i].isChecked()) {
                try {
                    int q = Integer.parseInt(num[i].getText().toString());
                    int pr = Integer.parseInt(price[i].getText().toString());
                    float val = q * pr;
                    sum += val;
                    rep += String.format("Операция № %d: %d x %s = %d x %d = %.2f\n",
                            i+1, q, chk[i].getText().toString(), q, pr, val);
                } catch (Exception ex) {
                    Toast.makeText(this,"Поля ввода заполнены неверно!",Toast.LENGTH_LONG).show();
                    return;
                }
            }
            rep += String.format("Итого: %.2f\n", sum);
        }
       // Toast.makeText(this,rep,Toast.LENGTH_LONG).show();

        AlertDialog.Builder bid = new AlertDialog.Builder(this);
        AlertDialog dlg = bid.create();
        dlg.setIcon(R.drawable.email);
        dlg.setTitle("Information");
        dlg.setMessage(rep);
        dlg.show();
    }
}