package com.merocal.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView textTv;
Button but_1, but_2, but_3, but_4, but_5, but_6, but_7, but_8, but_9, but_p, but_s, but_m, but_d, but_e, but_dot, but_0, but_c,but_del;
int count = 0;
String doa;
Numbers numbers = new Numbers();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_del = findViewById(R.id.delete);
        but_del.setOnClickListener(this);
        textTv = findViewById(R.id.textTv);
        textTv.setShowSoftInputOnFocus(false);
        but_0 = findViewById(R.id.btn0);
        but_0.setOnClickListener(this);
        but_1 = findViewById(R.id.btn1);
        but_1.setOnClickListener(this);
        but_2 = findViewById(R.id.btn2);
        but_2.setOnClickListener(this);
        but_3 = findViewById(R.id.btn3);
        but_3.setOnClickListener(this);
        but_4 = findViewById(R.id.btn4);
        but_4.setOnClickListener(this);
        but_5 = findViewById(R.id.btn5);
        but_5.setOnClickListener(this);
        but_6 = findViewById(R.id.btn6);
        but_6.setOnClickListener(this);
        but_7 = findViewById(R.id.btn7);
        but_7.setOnClickListener(this);
        but_8 = findViewById(R.id.btn8);
        but_8.setOnClickListener(this);
        but_9 = findViewById(R.id.btn9);
        but_9.setOnClickListener(this);
        but_p = findViewById(R.id.btnadd);
        but_p.setOnClickListener(this);
        but_s =  findViewById(R.id.btnsub);
        but_s.setOnClickListener(this);
        but_m = findViewById(R.id.btnmultiply);
        but_m.setOnClickListener(this);
        but_d = findViewById(R.id.btndivide);
        but_d.setOnClickListener(this);
        but_e = findViewById(R.id.btnequal);
        but_e.setOnClickListener(this);
        but_dot = findViewById(R.id.btndecimal);
        but_dot.setOnClickListener(this);
        but_c = findViewById(R.id.clear);
        but_c.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                textTv.append("0");
                break;
            case R.id.btn1:
                textTv.append("1");
                break;
            case R.id.btn2:
                textTv.append("2");
                break;
            case R.id.btn3:
                textTv.append("3");
                break;
            case R.id.btn4:
                textTv.append("4");
                break;
            case R.id.btn5:
                textTv.append("5");
                break;
            case R.id.btn6:
                textTv.append("6");
                break;
            case R.id.btn7:
                textTv.append("7");
                break;
            case R.id.btn8:
                textTv.append("8");
                break;
            case R.id.btn9:
                textTv.append("9");
                break;
            case R.id.btndecimal:
                if ((textTv.getText().toString()).contains(".")) {

                } else {
                    textTv.append(".");
                }
                break;
            case R.id.clear:
                try {
                    String NumberEntered = textTv.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 1);
                    String word =(NumberEntered);
                    textTv.setText(word);
                    return;
                } catch (Exception e) {
                    textTv.setError("Please enter value");
                }
                break;
            case R.id.btnadd:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "plus";}
                else {
                    textTv.setError("only two times");

                }
                break;
            case R.id.btnsub:
                count++;
                if (count<2){
                    SetData(count);
                    doa = "sub";}
                else{
                    textTv.setError("only two times");

                }
                break;
            case R.id.btndivide:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "di";}
                else{
                    textTv.setError("only two time");
                }

                break;
            case R.id.btnmultiply:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "mul";}
                else{
                    textTv.setError("only two time");
                }

                break;
            case R.id.btnequal:
                MathCal mathCal= new MathCal();
                count++;
                SetData(count);
                if (doa.equalsIgnoreCase("plus")){
                    textTv.setText(mathCal.add(numbers));

                }else if (doa.equalsIgnoreCase("sub")){
                    textTv.setText(mathCal.sub(numbers));
                }else if (doa.equalsIgnoreCase("di")){
                    textTv.setText(mathCal.divide(numbers));

                }else if (doa.equalsIgnoreCase("mul")){
                    textTv.setText(mathCal.mul(numbers));
                }
                break;
                case R.id.delete:
                    textTv.setText("");
                    count=0;





        }

    }

    private void SetData(int count) {
      if (!textTv.getText().toString().isEmpty()){
          if (count == 1) {
              numbers.setFirstNumber(Double.parseDouble(textTv.getText().toString()));
              textTv.setText("");
              return;
          } else if (count == 2) {
              numbers.setSecondNumber(Double.parseDouble(textTv.getText().toString()));
              textTv.setText("");
              return;
          } else {
              textTv.setError("only two time");
              return;
          }
      } else {
          textTv.setError("please enter the number first");
         count--;
          return;
      }
    }
}
