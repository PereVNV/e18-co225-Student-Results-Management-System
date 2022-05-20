package com.example.gsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Get the Intent that started this activity and extract the string
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            String id=bundle.getString("id");
            TextView personName = findViewById(R.id.userName);
            TextView personEmail = findViewById(R.id.userEmail);
            TextView personID=findViewById(R.id.userID);
            personName.setText(name);
            personEmail.setText(email);
            personID.setText(id);
        }
    }
}