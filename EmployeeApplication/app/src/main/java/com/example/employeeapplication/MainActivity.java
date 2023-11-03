package com.example.employeeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmployeeID, edtEmployeeName;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale;
    private Spinner spinnerDepartment;
    private Button btnAddEmployee;
    private ListView lvEmployeeList;
    private ArrayList<String> employeeList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmployeeID = findViewById(R.id.edtEmployeeID);
        edtEmployeeName = findViewById(R.id.edtEmployeeName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        spinnerDepartment = findViewById(R.id.spinnerDepartment);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        lvEmployeeList = findViewById(R.id.lvEmployeeList);

        // Populate the spinner with department options
        ArrayAdapter<CharSequence> departmentAdapter = ArrayAdapter.createFromResource(this,
                R.array.departments_array, android.R.layout.simple_spinner_item);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartment.setAdapter(departmentAdapter);

        employeeList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        lvEmployeeList.setAdapter(adapter);

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = "";
                if (radioMale.isChecked()) {
                    gender = "Nam";
                } else if (radioFemale.isChecked()) {
                    gender = "Nữ";
                }

                String employeeInfo = "Mã: " + edtEmployeeID.getText().toString() +
                        "\nTên: " + edtEmployeeName.getText().toString() +
                        "\nĐơn vị: " + spinnerDepartment.getSelectedItem().toString() +
                        "\nGiới tính: " + gender;

                employeeList.add(employeeInfo);
                adapter.notifyDataSetChanged();

                // Clear input fields
                edtEmployeeID.setText("");
                edtEmployeeName.setText("");
                radioGroupGender.clearCheck();
            }
        });
    }
}
