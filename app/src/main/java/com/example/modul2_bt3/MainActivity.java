package com.example.modul2_bt3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Double;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnthoat = findViewById(R.id.btnQuit);
        btnthoat.setOnClickListener(v->finish());

        EditText editText1 = findViewById(R.id.editTextText1);
        EditText editText2 = findViewById(R.id.editTextText2);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Double a = null, b = null;

        Button btntong = findViewById(R.id.btntong);
        btntong.setOnClickListener(v -> {
            GetAndCheckInput(editText1);
            GetAndCheckInput(editText2);
            try {
                Double c = Double.parseDouble(editText1.getText().toString())
                        + Double.parseDouble(editText2.getText().toString());
                textViewResult.setText("Kết quả Tổng = " + c);
            } catch (Exception e) {
                checkData2Notice("Không thể thực hiện phép cộng");
            }
        });

        Button btnhieu = findViewById(R.id.btnhieu);
        btnhieu.setOnClickListener(v -> {
            GetAndCheckInput(editText1);
            GetAndCheckInput(editText2);
            try {
                Double c = Double.parseDouble(editText1.getText().toString())
                        - Double.parseDouble(editText2.getText().toString());
                textViewResult.setText("Kết quả Hiệu = " + c);
            } catch (Exception e) {
                checkData2Notice("Không thể thực hiện phép hiệu");
            }
        });

        Button btntich = findViewById(R.id.btntich);
        btntich.setOnClickListener(v -> {
            GetAndCheckInput(editText1);
            GetAndCheckInput(editText2);
            try {
                Double c = Double.parseDouble(editText1.getText().toString())
                        * Double.parseDouble(editText2.getText().toString());
                textViewResult.setText("Kết quả Tích = " + c);
            } catch (Exception e) {
                checkData2Notice("Không thể thực hiện phép tích");
            }
        });

        Button btnthuong = findViewById(R.id.btnthuong);
        btnthuong.setOnClickListener(v -> {
            GetAndCheckInput(editText1);
            GetAndCheckInput(editText2);
            try {
                Double c = Double.parseDouble(editText1.getText().toString()) / Double.parseDouble(editText2.getText().toString());
                if(c.toString().equals("Infinity")) {
                    checkData2Notice("Không chia được cho số 0");
                    textViewResult.setText("Không chia được cho số 0");
                    return;
                }
                textViewResult.setText("Kết quả Thương = " + c);
            } catch (Exception e) {
                checkData2Notice("Không thể thực hiện phép thương");
            }
        });

        Button btngcd = findViewById(R.id.btnUCLN);
        btngcd.setOnClickListener(v -> {
            textViewResult.setText("Kết quả: ");
            try {
                int c = Integer.parseInt(editText1.getText().toString());
                int d = Integer.parseInt(editText2.getText().toString());
                textViewResult.setText("Kết quả: " + gcd(c,d));
            }catch (Exception exception){
                checkData2Notice("Bạn cần nhập 2 số nguyên");
            }
        });

        Button btnCaculator = findViewById(R.id.btnCaculator);
        btnCaculator.setOnClickListener(v->startActivity(new Intent(MainActivity.this, ActivityCaculator.class)));

    }
    private void checkData2Notice(Object data){
        /** Cách dùng Builder để truyền data*/
        // Tạo một đối tượng AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Đặt tiêu đề cho hộp thoại
        builder.setTitle("Thông báo lỗi: ");
        // Đặt nội dung thông báo cho hộp thoại
        builder.setMessage((String) data );
        // Hiển thị hộp thoại
        builder.show();
    }
    private void GetAndCheckInput(EditText editText){
        String text = editText.getText().toString();
        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Kết quả: ");
        try {
            Double.parseDouble(text);
        }catch (Exception exception){
            checkData2Notice(text + " Không là một số");
        }
    }
    public int gcd(int a, int b) {
        if (a == 0) {return b;}
        if (b == 0) {return a;}
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}