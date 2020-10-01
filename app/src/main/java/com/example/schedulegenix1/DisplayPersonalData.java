package com.example.schedulegenix1;

import android.os.Bundle;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayPersonalData extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb;

    TextView name;
    TextView birthday;
    TextView nic;
    TextView bAddress;
    TextView bPhoneNum;
    TextView mPassportNum;
    TextView bloodGroup;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_personal_data);
        name = (TextView) findViewById(R.id.editTextName);
        birthday = (TextView) findViewById(R.id.editTextBirthday);
        nic = (TextView) findViewById(R.id.editTextNic);
        bAddress = (TextView) findViewById(R.id.editTextBaddress);
        bPhoneNum = (TextView) findViewById(R.id.editTextBphoneNum);
        mPassportNum = (TextView) findViewById(R.id.editTextMpassportNum);
        bloodGroup = (TextView) findViewById(R.id.editTextBloodGroup);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");

            if (Value > 0) {
                //means this is the view part not the add contact part.

                Cursor rs = mydb.getPersonalData(Value);

                id_To_Update = Value;
                rs.moveToFirst();


                String nam = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_NAME));
                String birthda = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BIRTHDAY));
                String nica = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_NIC));
                String bAddres = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BUSINESS_ADDRESS));
                String bPhone = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BUSINESS_PHONE_NUM));
                String mPass = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_MOBILE_PASSPORT_NUM));
                String bloodGrou = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BLOOD_GROUP));


                if (!rs.isClosed()) {
                    rs.close();
                }
                Button b = (Button) findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence) nam);
                name.setFocusable(false);
                name.setClickable(false);

                birthday.setText((CharSequence) birthda);
                birthday.setFocusable(false);
                birthday.setClickable(false);

                nic.setText((CharSequence) nica);
                nic.setFocusable(false);
                nic.setClickable(false);

                bAddress.setText((CharSequence) bAddres);
                bAddress.setFocusable(false);
                bAddress.setClickable(false);

                bPhoneNum.setText((CharSequence) bPhone);
                bPhoneNum.setFocusable(false);
                bPhoneNum.setClickable(false);

                mPassportNum.setText((CharSequence) mPass);
                mPassportNum.setFocusable(false);
                mPassportNum.setClickable(false);

                bloodGroup.setText((CharSequence) bloodGrou);
                bloodGroup.setFocusable(false);
                bloodGroup.setClickable(false);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                getMenuInflater().inflate(R.menu.display_personal_store, menu);
            } else {
                getMenuInflater().inflate(R.menu.main_menu, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.Edit_Personal:
                Button b = (Button) findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                birthday.setEnabled(true);
                birthday.setFocusableInTouchMode(true);
                birthday.setClickable(true);

                nic.setEnabled(true);
                nic.setFocusableInTouchMode(true);
                nic.setClickable(true);

                bAddress.setEnabled(true);
                bAddress.setFocusableInTouchMode(true);
                bAddress.setClickable(true);

                bPhoneNum.setEnabled(true);
                bPhoneNum.setFocusableInTouchMode(true);
                bPhoneNum.setClickable(true);

                mPassportNum.setEnabled(true);
                mPassportNum.setFocusableInTouchMode(true);
                mPassportNum.setClickable(true);

                bloodGroup.setEnabled(true);
                bloodGroup.setFocusableInTouchMode(true);
                bloodGroup.setClickable(true);

                return true;
            case R.id.Delete_Personal:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deletePersonal)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deletePersonal(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PersonalInfo.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                if (mydb.updatePersonal(id_To_Update, name.getText().toString(),
                        birthday.getText().toString(),
                        nic.getText().toString(), bAddress.getText().toString(), bPhoneNum.getText().toString(), mPassportNum.getText().toString(), bloodGroup.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), PersonalInfo.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (mydb.insertPersonal(name.getText().toString(), birthday.getText().toString(),
                        nic.getText().toString(), bAddress.getText().toString(), bPhoneNum.getText().toString(), mPassportNum.getText().toString(),  bloodGroup.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), PersonalInfo.class);
                startActivity(intent);
            }
        }
    }
}