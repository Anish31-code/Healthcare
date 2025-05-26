package com.example.health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabTestDetailsActivity extends AppCompatActivity {

    private String[][] bloodTestDetails = {
            {"Complete Blood Count", "₹500", "Detailed blood test"},
            {"Lipid Profile", "₹1500", "Cholesterol test"},
            {"Blood Sugar", "₹300", "Sugar level test"},
            {"Thyroid Profile", "₹800", "Thyroid test"}
    };

    private String[][] imagingTestDetails = {
            {"X-Ray", "₹1500", "X-Ray imaging"},
            {"Ultrasound", "₹2500", "Ultrasound imaging"},
            {"CT Scan", "₹5000", "CT Scan imaging"},
            {"MRI", "₹7000", "MRI imaging"}
    };

    private String[][] cardiacTestDetails = {
            {"Echocardiogram", "₹3000", "Heart ultrasound"},
            {"Treadmill Test", "₹5000", "Exercise stress test"},
            {"Holter Monitor", "₹7000", "24-hour heart monitoring"}
    };

    private TextView tvTitle;
    private TextView tvDescription;
    private Button btnBack;
    private ListView listView;

    private List<HashMap<String, String>> list;
    private SimpleAdapter sa;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvTitle = findViewById(R.id.textViewDDTitle);
        tvDescription = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonDBack);
        listView = findViewById(R.id.listViewDD);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tvTitle.setText(title);
        tvDescription.setText("Description for " + title);

        String[][] selectedLabTestDetails;

        switch (title) {
            case "Blood Tests":
                selectedLabTestDetails = bloodTestDetails;
                break;
            case "Imaging Tests":
                selectedLabTestDetails = imagingTestDetails;
                break;
            case "Cardiac Tests":
                selectedLabTestDetails = cardiacTestDetails;
                break;
            default:
                selectedLabTestDetails = new String[0][0];
        }

        list = new ArrayList<>();
        for (String[] details : selectedLabTestDetails) {
            HashMap<String, String> item = new HashMap<>();
            item.put("name", details[0]);
            item.put("price", details[1]);
            item.put("description", details[2]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"name", "price", "description"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c});

        listView.setAdapter(sa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Set OnClickListener for the "Go to Cart" button
        Button goToCartButton = findViewById(R.id.buttonGoToCart);
        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation to the cart screen here
                Intent intent = new Intent(LabTestDetailsActivity.this, LabTestActivity.class);
                startActivity(intent);

                // Show a toast message when the button is clicked
                Toast.makeText(LabTestDetailsActivity.this, "Record insert in Cart ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
