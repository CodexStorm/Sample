package example.manoj.com.kurukshetra;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private String Name;
    private String Email;
    private String Phone;
    private String Password;
    private String Gender;

    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private RadioGroup rgGender;
    private Button bProceed;
    private String emailPattern;
    private RadioButton rbMale;
    private RadioButton rbFemale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText)findViewById(R.id.etFullName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etPassword = (EditText)findViewById(R.id.etPassword);
        rgGender = (RadioGroup)findViewById(R.id.rgGender);
        rbMale =(RadioButton)findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        bProceed = (Button)findViewById(R.id.bProceed);
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().length()==0){
                    etName.setError("Username is not entered");
                    etName.requestFocus();
                }
                else if(!etEmail.getText().toString().trim().matches(emailPattern)){
                    etEmail.setError("Email is not valid");
                    etEmail.requestFocus();
                }
                else if(etPhone.getText().toString().trim().length()<10||etPhone.getText().toString().trim().length()>10){
                    etPhone.setError("Phone Number is not Valid");
                    etPhone.requestFocus();
                }
                else if(etPassword.getText().toString().trim().length()==0){
                    etPassword.setError("Password is not entered");
                    etPassword.requestFocus();
                }
                else if(!rbMale.isChecked()&&!rbFemale.isChecked()){
                    Toast.makeText(getApplicationContext(),"Select Gender",Toast.LENGTH_SHORT).show();
                }

                else{
                    Email = etEmail.getText().toString();
                    Name = etName.getText().toString();
                    Password = etPassword.getText().toString();
                    Phone = etPhone.getText().toString();
                    if(rbMale.isChecked())
                        Gender="Male";
                    else
                        Gender="Female";

                    Intent intent=new Intent(getApplicationContext(), DisplayImformation.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("Email",Email);
                    intent.putExtra("Gender",Gender);
                    intent.putExtra("Password",Password);
                    intent.putExtra("Phone",Phone);
                    startActivity(intent);
                }
            }
        });
    }
}
