package com.example.tuan22bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button addButton;
    private ListView listView;
    private TextView textView;
    private ArrayList<String> nameList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        nameList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);

        // nhấn vào nút nhập, lấy giá trị trong editText, lưu vào mảng và hiển thị lên ListView
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                if (!name.isEmpty()){
                    nameList.add(name);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        // lấy giá trị vị trí của từng phần tử
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectionName = nameList.get(i);
                textView.setText("Vị trí: " + i  + " " + "Giá trị: " + selectionName);
            }
        });

    }
}