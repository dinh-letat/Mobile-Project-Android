package com.example.cardplay;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    int manghinhbai[] = new int[]{
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
            R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8,
            R.drawable.c9, R.drawable.c10, R.drawable.cj, R.drawable.cq,
            R.drawable.ck, R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7,
            R.drawable.d8, R.drawable.d9, R.drawable.d10, R.drawable.dj,
            R.drawable.dq, R.drawable.dk, R.drawable.h1, R.drawable.h2,
            R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6,
            R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk, R.drawable.s1,
            R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9,
            R.drawable.s10, R.drawable.sj, R.drawable.sq, R.drawable.sk

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
        TextView tv_ketqua = (TextView) findViewById(R.id.textView_ketqua);

        ImageView iva = (ImageView) findViewById(R.id.imageViewa);
        ImageView ivb = (ImageView) findViewById(R.id.imageViewb);
        ImageView ivc = (ImageView) findViewById(R.id.imageViewc);
        TextView tv_ketquaA = (TextView) findViewById(R.id.textView_ketquaA);


        Button btnChon = (Button)findViewById(R.id.button_chon);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1[] = new int[3];
                int value2[] = new int[3];
                value1 = layBaSoNgauNhien1(0, 51);

                value2 = layBaSoNgauNhien2(0, 51);

                iv1.setImageResource(manghinhbai[value1[0]]);
                iv2.setImageResource(manghinhbai[value1[1]]);
                iv3.setImageResource(manghinhbai[value1[2]]);
                tv_ketqua.setText(tinhKetQua1(value1));

                iva.setImageResource(manghinhbai[value2[0]]);
                ivb.setImageResource(manghinhbai[value2[1]]);
                ivc.setImageResource(manghinhbai[value2[2]]);
                tv_ketquaA.setText(tinhKetQua2(value2));

                String ketqua1 = tinhKetQua1(value1);
                String ketqua2 = tinhKetQua2(value2);

                if (ketqua1.compareTo(ketqua2) > 0) {
                    hienThiThongBao("Người chơi 1 chiến thắng!");
                } else if (ketqua1.compareTo(ketqua2) < 0) {
                    hienThiThongBao("Người chơi 2 chiến thắng!");
                } else {
                    hienThiThongBao("Hòa!");
                }
            }


        });
    }
    private String tinhKetQua1(int[] value) {
        String ketqua = "";
        if (tinhSoTay1(value) == 3){
            ketqua = "Kết quả: 3 tây";
        } else {
            int tong = 0;
            for (int i = 0; i < value.length; i++)
                if (value[i] % 13 < 10)
                    tong += value[i] % 13 + 1;
            if (tong % 10 == 0)
                ketqua = "Kết quả là 0, trong đó có " + tinhSoTay1(value) + " tây";
            else
                ketqua = "Kết quả là " + (tong % 10) + " nút, trong đó có " + tinhSoTay1(value) + " tây";
        }
        return ketqua;
    }

    private String tinhKetQua2(int[] value) {
        String ketqua = "";
        if (tinhSoTay2(value) == 3){
            ketqua = "Kết quả: 3 tây";
        } else {
            int tong = 0;
            for (int i = 0; i < value.length; i++)
                if (value[i] % 13 < 10)
                    tong += value[i] % 13 + 1;
            if (tong % 10 == 0)
                ketqua = "Kết quả là 0, trong đó có " + tinhSoTay2(value) + " tây";
            else
                ketqua = "Kết quả là " + (tong % 10) + " nút, trong đó có " + tinhSoTay2(value) + " tây";
        }
        return ketqua;
    }


    private void hienThiThongBao(String thongbao) {
        Toast.makeText(this, thongbao, Toast.LENGTH_LONG).show();
    }




    private int tinhSoTay1(int a[]){
        int k = 0;
        for (int i = 0; i < a.length; i++)
            if((a[i] % 13 >= 10) && (a[i] % 13 < 13))
                k++;
        return k;
    }
    private int tinhSoTay2(int a[]){
        int k = 0;
        for (int i = 0; i < a.length; i++)
            if((a[i] % 13 >= 10) && (a[i] % 13 < 13))
                k++;
        return k;
    }
    private int[] layBaSoNgauNhien1(int min, int max){
        int baso[] = new int[3];
        int i = 0;
        baso[i++] = random(min, max);
        do{
            int k = random(min, max);
            if(!kiemTraTrung(k, baso))
                baso[i++] = k;
        } while(i < 3);
        return baso;
    }
    private int[] layBaSoNgauNhien2(int min, int max){
        int baso[] = new int[3];
        int i = 0;
        baso[i++] = random(min, max);
        do{
            int k = random(min, max);
            if(!kiemTraTrung(k, baso))
                baso[i++] = k;
        } while(i < 3);
        return baso;
    }
    private boolean kiemTraTrung(int k, int a[]){
        for (int i = 0; i < a.length; i++)
            if (a[i] == k)
                return true;
        return false;
    }
    private boolean kiemTraTrung2(int k, int a[]){
        for (int i = 0; i < a.length; i++)
            if (a[i] == k)
                return true;
        return false;
    }

    private int random(int min, int max) {
        return min + (int)(Math.random() * ((max - min) +1));
    }
}