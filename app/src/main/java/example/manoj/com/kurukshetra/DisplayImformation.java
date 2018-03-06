package example.manoj.com.kurukshetra;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayImformation extends AppCompatActivity {

    private String Name;
    private String Gender;
    private String Email;
    private String Phone;
    private String Password;

    private TextView tvName;
    private TextView tvGender;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_imformation);
        Intent intent = getIntent();

        tvName = (TextView)findViewById(R.id.tvName);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        tvPassword = (TextView)findViewById(R.id.tvPassword);

        Name = intent.getStringExtra("Name");
        Gender = intent.getStringExtra("Gender");
        Email = intent.getStringExtra("Email");
        Phone = intent.getStringExtra("Phone");
        Password = intent.getStringExtra("Password");


        tvName.setText(Name);
        tvEmail.setText("   "+Email);
        tvGender.setText(Gender);
        tvPhone.setText("   "+Phone);
        tvPassword.setText("   "+Password);


    }
}
