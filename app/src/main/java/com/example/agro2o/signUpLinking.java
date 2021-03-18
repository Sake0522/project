package com.example.agro2o;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signUpLinking extends AppCompatActivity {
    EditText name,username,txtpassword,txtnumber;
    Button btnotp;
    DatabaseReference reff;
    Member member;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_linking);

        name = (EditText)findViewById(R.id.name);
        username = (EditText)findViewById(R.id.username);
        txtpassword = (EditText)findViewById(R.id.password);
        txtnumber = (EditText)findViewById(R.id.number);
        btnotp = (Button)findViewById(R.id.btnotp);
        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long ph = Long.parseLong(txtnumber.getText().toString().trim());

                member.setName(name.getText().toString().trim());
                member.setUsername(username.getText().toString().trim());
                member.setPassword(txtpassword.getText().toString().trim());
                member.setNumber(ph);
                reff.child(String.valueOf(maxid+1)).setValue(member);


                Toast.makeText(signUpLinking.this,"DataBase Updated Successfully",Toast.LENGTH_LONG).show();
             }
        });

    }

}
