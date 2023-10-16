package com.example.tuan22_bai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit_account, edit_pw;
    private CheckBox checkInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_account = findViewById(R.id.edit_account);
        edit_pw = findViewById(R.id.edit_pw);
        checkInfo = findViewById(R.id.checkInfo);

        Button btn_signin = findViewById(R.id.btn_signin);
        Button btn_exit = findViewById(R.id.btn_exit);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit_account.getText().toString();
                String password = edit_pw.getText().toString();
                boolean saveInfo = checkInfo.isChecked();

                if (saveInfo){
                    showAlertDialog("Bạn đã đăng nhập thành công và lưu thông tin!" + "\n"
                            + "Tài khoản: " + username +"\n" + "Mật khẩu: " + password);
                } else {
                    showAlertDialog("Bạn đã đăng nhập thành công và không lưu thông tin!");
                }
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void showAlertDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage(message);

        builder.setPositiveButton("oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}