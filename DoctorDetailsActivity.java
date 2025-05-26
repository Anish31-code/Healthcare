package com.example.health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] familyPhysicianDetails = {
            {"Dr. A", "Hospital A", "1234567890", "₹1500"},
            {"Dr. B", "Hospital B", "1234567891", "₹1800"},
            {"Dr. C", "Hospital C", "1234567892", "₹2500"},
            {"Dr. D", "Hospital D", "1234567893", "₹3500"},
            {"Dr. E", "Hospital E", "1234567894", "₹1500"},
            {"Dr. F", "Hospital F", "1234567895", "₹14500"},
            {"Dr. G", "Hospital G", "1234567896", "₹16500"},
            {"Dr. H", "Hospital H", "1234567897", "₹19500"},
            {"Dr. I", "Hospital I", "1234567898", "₹2000"}
    };

    private String[][] dentistDetails = {
            {"Dr. S", "Hospital S", "1234567808", "₹2500"},
            {"Dr. T", "Hospital T", "1234567809", "₹1500"},
            {"Dr. U", "Hospital U", "1234567810", "₹3500"},
            {"Dr. V", "Hospital V", "1234567811", "₹5500"},
            {"Dr. W", "Hospital W", "1234567812", "₹7500"},
            {"Dr. X", "Hospital X", "1234567813", "₹1500"},
            {"Dr. Y", "Hospital Y", "1234567814", "₹2500"},
            {"Dr. Z", "Hospital Z", "1234567815", "₹6500"},
            {"Dr. AA", "Hospital AA", "1234567816", "₹7500"}
    };

    private String[][] cardiologistDetails = {
            {"Dr. J", "Hospital J", "1234567899", "₹7500"},
            {"Dr. K", "Hospital K", "1234567800", "₹9500"},
            {"Dr. L", "Hospital L", "1234567801", "₹1500"},
            {"Dr. M", "Hospital M", "1234567802", "₹2500"},
            {"Dr. N", "Hospital N", "1234567803", "₹1100"},
            {"Dr. O", "Hospital O", "1234567804", "₹1500"},
            {"Dr. P", "Hospital P", "1234567805", "₹1700"},
            {"Dr. Q", "Hospital Q", "1234567806", "₹1800"},
            {"Dr. R", "Hospital R", "1234567807", "₹1500"}
    };

    private String[][] dietitianDetails = {
            {"Dr. BB", "Hospital BB", "1234567817", "₹2100"},
            {"Dr. CC", "Hospital CC", "1234567818", "₹2200"},
            {"Dr. DD", "Hospital DD", "1234567819", "₹2500"},
            {"Dr. EE", "Hospital EE", "1234567820", "₹2700"},
            {"Dr. FF", "Hospital FF", "1234567821", "₹2800"},
            {"Dr. GG", "Hospital GG", "1234567822", "₹1500"},
            {"Dr. HH", "Hospital HH", "1234567823", "₹3500"},
            {"Dr. II", "Hospital II", "1234567824", "₹1800"},
            {"Dr. JJ", "Hospital JJ", "1234567825", "₹1500"}
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
        setContentView(R.layout.activity_doctor_detail);

        tvTitle = findViewById(R.id.textViewDDTitle);
        tvDescription = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonDBack);
        listView = findViewById(R.id.listViewDD);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tvTitle.setText(title);
        tvDescription.setText("Description for " + title);

        String[][] selectedDoctorDetails;

        switch (title) {
            case "Family Physicians":
                selectedDoctorDetails = familyPhysicianDetails;
                break;
            case "Cardiologists":
                selectedDoctorDetails = cardiologistDetails;
                break;
            case "Dentists":
                selectedDoctorDetails = dentistDetails;
                break;
            case "Dietitian":
                selectedDoctorDetails = dietitianDetails;
                break;
            default:
                selectedDoctorDetails = new String[0][0];
        }

        list = new ArrayList<>();
        for (String[] details : selectedDoctorDetails) {
            HashMap<String, String> item = new HashMap<>();
            item.put("name", details[0]);
            item.put("hospital", details[1]);
            item.put("contact", details[2]);
            item.put("fees", details[3]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"name", "hospital", "contact", "fees"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d});

        listView.setAdapter(sa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", selectedDoctorDetails[i][0]);
                it.putExtra("text3", selectedDoctorDetails[i][1]);
                it.putExtra("text4", selectedDoctorDetails[i][2]);
                it.putExtra("text5", selectedDoctorDetails[i][3]);
                startActivity(it);
            }
        });
    }
}
