package com.example.modul2_bt3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCaculator extends AppCompatActivity implements View.OnClickListener{
    /** implements View.OnClickListener để có thể sử dụng các OnClickListener VD: button_0.setOnClickListener(this); */
    private boolean continue_caculating = false, doubleClick_operator = false;
    Button button_del, button_c, button_dot, button_equals, button_add, button_hieu, button_x, button_div;
    Button button_0, button_1,  button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_ANS;
    TextView screennumber, screenresult, screenoperator, screenremember;

    Double ANS = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);

        Button btnBackMain = findViewById(R.id.btnBackMain);
        btnBackMain.setOnClickListener(v->startActivity(new Intent(ActivityCaculator.this, MainActivity.class)));
        /** screen */
            screennumber = findViewById(R.id.screennumber);
            screenresult = findViewById(R.id.screenresult);
            screenoperator = findViewById(R.id.screenoperator);
            screenremember = findViewById(R.id.screenremember);

        /** Button */
            button_0 = (Button) findViewById(R.id.button_0);
            button_1 = (Button) findViewById(R.id.button_1);
            button_2 = (Button) findViewById(R.id.button_2);
            button_3 = (Button) findViewById(R.id.button_3);
            button_4 = (Button) findViewById(R.id.button_4);
            button_5 = (Button) findViewById(R.id.button_5);
            button_6 = (Button) findViewById(R.id.button_6);
            button_7 = (Button) findViewById(R.id.button_7);
            button_8 = (Button) findViewById(R.id.button_8);
            button_9 = (Button) findViewById(R.id.button_9);
            button_ANS = (Button) findViewById(R.id.button_ANS);

            button_dot = (Button) findViewById(R.id.button_dot);
            button_equals = (Button) findViewById(R.id.button_equals);
            button_del = (Button) findViewById(R.id.button_del);
            button_c = (Button) findViewById(R.id.button_C);

            button_add = (Button) findViewById(R.id.button_add);
            button_hieu = (Button) findViewById(R.id.button_tru);
            button_x = (Button) findViewById(R.id.button_x);
            button_div = (Button) findViewById(R.id.button_div);


        /** set btn number */
            button_0.setOnClickListener(this);
            button_1.setOnClickListener(this);
            button_2.setOnClickListener(this);
            button_3.setOnClickListener(this);
            button_4.setOnClickListener(this);
            button_5.setOnClickListener(this);
            button_6.setOnClickListener(this);
            button_7.setOnClickListener(this);
            button_8.setOnClickListener(this);
            button_9.setOnClickListener(this);
            button_ANS.setOnClickListener(this);

        /** set tool */
            button_c.setOnClickListener(this);
            button_del.setOnClickListener(this);
            button_dot.setOnClickListener(this);
            button_equals.setOnClickListener(this);

        /** set Screen Operator */
            button_add.setOnClickListener(this);
            button_hieu.setOnClickListener(this);
            button_x.setOnClickListener(this);
            button_div.setOnClickListener(this);



    }
    private void checkData2Notice(Object data){
        /** Cách dùng Builder để truyền data*/
        // Tạo một đối tượng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityCaculator.this);
        // Đặt tiêu đề cho hộp thoại
        builder.setTitle("Thông báo lỗi: ");
        // Đặt nội dung thông báo cho hộp thoại
        builder.setMessage((String) data );
        // Hiển thị hộp thoại
        builder.show();
    }

    private void checkerror(){
        if (screenremember.getText().toString().equals("")) {
            checkData2Notice("Bạn cần nhập đủ các thành phần");
            button_c.performClick();
            return;
        }
    }
    private void onClick_0 (){
        /** Cách khai báo phương thức OnClick_0 từ file xml
         * tương ứng với từng chỉ một button*/
    }

    private void caculating(String operator, View v){
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                screenoperator.setText(operator);
                if(continue_caculating) {screenremember.setText(screenresult.getText().toString());}
                else {screenremember.setText(screennumber.getText().toString());}
                screennumber.setText("");
                continue_caculating = false;
            }
        }, 100);

    }


    @Override /** Cách Override onClick*/
    public void onClick(View v) {
        if(v == button_0) {screennumber.setText(screennumber.getText() + "0");}
        if(v == button_1) {screennumber.setText(screennumber.getText() + "1");}
        if(v == button_2) {screennumber.setText(screennumber.getText() + "2");}
        if(v == button_3) {screennumber.setText(screennumber.getText() + "3");}
        if(v == button_4) {screennumber.setText(screennumber.getText() + "4");}
        if(v == button_5) {screennumber.setText(screennumber.getText() + "5");}
        if(v == button_6) {screennumber.setText(screennumber.getText() + "6");}
        if(v == button_7) {screennumber.setText(screennumber.getText() + "7");}
        if(v == button_8) {screennumber.setText(screennumber.getText() + "8");}
        if(v == button_9) {screennumber.setText(screennumber.getText() + "9");}
        if(v == button_dot) {screennumber.setText(screennumber.getText() + ".");}
        else if (v == button_c) {
            screennumber.setText("");
            screenresult.setText("0");
            screenoperator.setText("");
            screenremember.setText("");
        }
        else if (v == button_del) {
            if(screennumber.getText().toString().equals("")) {
                button_c.performClick(); /** Gọi đến onClick của button_c */
                return;
            }
            String str = screennumber.getText().toString().substring(0, screennumber.getText().toString().length() - 1);
            screennumber.setText(str);
        }
        else if (v == button_add) {
            caculating("+", v);
        }
        else if (v == button_x) {
            caculating("*", v);
        }
        else if (v == button_div) {
            caculating("/", v);
        }
        else if (v == button_hieu) {
            caculating("-", v);
        }
        else if (v == button_equals) {
            if(screennumber.getText().toString().equals("")){
                checkData2Notice("Bạn cần nhập giá trị đầu vào");
                return;
            }
            continue_caculating = true;
            switch (screenoperator.getText().toString()) {
                case ("+"):
                    if (screenremember.getText().toString().equals("")) {
                        checkData2Notice("Bạn cần nhập đủ các thành phần");
                        button_c.performClick();
                        return;
                    }
                    ANS = Double.parseDouble(screenremember.getText().toString()) + Double.parseDouble(screennumber.getText().toString());
                    screenresult.setText(String.valueOf(ANS));
                    break;
                case ("-"):
                    if (screenremember.getText().toString().equals("")) {
                        checkData2Notice("Bạn cần nhập đủ các thành phần");
                        button_c.performClick();
                        return;
                    }
                    ANS = Double.parseDouble(screenremember.getText().toString()) - Double.parseDouble(screennumber.getText().toString());
                    screenresult.setText(String.valueOf(ANS));
                    break;
                case ("*"):
                    if (screenremember.getText().toString().equals("")) {
                        checkData2Notice("Bạn cần nhập đủ các thành phần");
                        button_c.performClick();
                        return;
                    }
                    ANS = Double.parseDouble(screenremember.getText().toString()) * Double.parseDouble(screennumber.getText().toString());
                    screenresult.setText(String.valueOf(ANS));
                    break;
                case ("/"):
                    if (screenremember.getText().toString().equals("")) {
                        checkData2Notice("Bạn cần nhập đủ các thành phần");
                        button_c.performClick();
                        return;
                    }
                    if(Double.parseDouble(screennumber.getText().toString())==0.0) {
                        checkData2Notice("Không chia được cho 0");
                        break;
                    }
                    ANS = Double.parseDouble(screenremember.getText().toString()) / Double.parseDouble(screennumber.getText().toString());
                    screenresult.setText(String.valueOf(ANS));
                    break;
            }
        }
        else if (v == button_ANS) {screennumber.setText(String.valueOf(ANS));}
//        else if () {}
//        else if () {}
//        else if () {}

    }
}