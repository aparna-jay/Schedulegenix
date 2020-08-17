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
    TextView address;
    TextView nic;
    TextView bAddress;
    TextView pCode;
    TextView bPhoneNum;
    TextView mPassportNum;
    TextView tFileNum;
    TextView carRegNum;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_personal_data);
        name = (TextView) findViewById(R.id.editTextName);
        address = (TextView) findViewById(R.id.editTextAddress);
        nic = (TextView) findViewById(R.id.editTextNic);
        bAddress = (TextView) findViewById(R.id.editTextBaddress);
        pCode = (TextView) findViewById(R.id.editTextPcode);
        bPhoneNum = (TextView) findViewById(R.id.editTextBphoneNum);
        mPassportNum = (TextView) findViewById(R.id.editTextMpassportNum);
        tFileNum = (TextView) findViewById(R.id.editTextTfileNum);
        carRegNum = (TextView) findViewById(R.id.editTextCarRegNum);

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
                String addres = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_ADDRESS));
                String nica = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_NIC));
                String bAddres = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BUSINESS_ADDRESS));
                String pcod = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_POST_CODE));
                String bPhone = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_BUSINESS_PHONE_NUM));
                String mPass = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_MOBILE_PASSPORT_NUM));
                String tFile = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_TAX_FILE_NUM));
                String carReg = rs.getString(rs.getColumnIndex(DBHelper.PERSONAL_STORE_COLUMN_CAR_REG_NUM));


                if (!rs.isClosed()) {
                    rs.close();
                }
                Button b = (Button) findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence) nam);
                name.setFocusable(false);
                name.setClickable(false);

                address.setText((CharSequence) addres);
                address.setFocusable(false);
                address.setClickable(false);

                nic.setText((CharSequence) nica);
                nic.setFocusable(false);
                nic.setClickable(false);

                bAddress.setText((CharSequence) bAddres);
                bAddress.setFocusable(false);
                bAddress.setClickable(false);

                pCode.setText((CharSequence) pcod);
                pCode.setFocusable(false);
                pCode.setClickable(false);

                bPhoneNum.setText((CharSequence) bPhone);
                bPhoneNum.setFocusable(false);
                bPhoneNum.setClickable(false);

                mPassportNum.setText((CharSequence) mPass);
                mPassportNum.setFocusable(false);
                mPassportNum.setClickable(false);

                tFileNum.setText((CharSequence) tFile);
                tFileNum.setFocusable(false);
                tFileNum.setClickable(false);

                carRegNum.setText((CharSequence) carReg);
                carRegNum.setFocusable(false);
                carRegNum.setClickable(false);

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

                address.setEnabled(true);
                address.setFocusableInTouchMode(true);
                address.setClickable(true);

                nic.setEnabled(true);
                nic.setFocusableInTouchMode(true);
                nic.setClickable(true);

                bAddress.setEnabled(true);
                bAddress.setFocusableInTouchMode(true);
                bAddress.setClickable(true);

                pCode.setEnabled(true);
                pCode.setFocusableInTouchMode(true);
                pCode.setClickable(true);

                bPhoneNum.setEnabled(true);
                bPhoneNum.setFocusableInTouchMode(true);
                bPhoneNum.setClickable(true);

                mPassportNum.setEnabled(true);
                mPassportNum.setFocusableInTouchMode(true);
                mPassportNum.setClickable(true);

                tFileNum.setEnabled(true);
                tFileNum.setFocusableInTouchMode(true);
                tFileNum.setClickable(true);

                carRegNum.setEnabled(true);
                carRegNum.setFocusableInTouchMode(true);
                carRegNum.setClickable(true);

                return true;
            case R.id.Delete_Personal:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deletePersonal)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deletePersonal(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
                        address.getText().toString(),
                        nic.getText().toString(), bAddress.getText().toString(), pCode.getText().toString(), bPhoneNum.getText().toString(), mPassportNum.getText().toString(), tFileNum.getText().toString(), carRegNum.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (mydb.insertPersonal(name.getText().toString(), address.getText().toString(),
                        nic.getText().toString(), bAddress.getText().toString(), pCode.getText().toString(), bPhoneNum.getText().toString(), mPassportNum.getText().toString(), tFileNum.getText().toString(), carRegNum.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }
}