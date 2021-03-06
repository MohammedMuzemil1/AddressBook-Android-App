package com.addiscan.addiscode.addressbookrestconsume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.addiscan.addiscode.addressbookrestconsume.clientdata.ClientData;
import com.addiscan.addiscode.addressbookrestconsume.models.Contact;

/**
 * Created by Mohammed on 1/11/2015.
 */
public class NewContactActivity extends Activity {
    private TextView firstName,lastName,email,department,year;
    private Contact contact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        firstName = (TextView)findViewById(R.id.firstNameEditTextNewContact);
        lastName = (TextView)findViewById(R.id.lastNameEditTextNewContact);
        email = (TextView)findViewById(R.id.emailEditTextNewContact);
        department = (TextView)findViewById(R.id.departmentEditTextNewContact);
        year = (TextView)findViewById(R.id.yearEditTextNewContact);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_contact,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;

            case R.id.menu_save:

                contact = new Contact(
                          "",
                          firstName.getText().toString(),
                          lastName.getText().toString(),
                          email.getText().toString(),
                          department.getText().toString(),
                          year.getText().toString()
                );
                new ClientData().SaveContact(contact);
                return true;

            case R.id.menu_discard:
                startActivity(new Intent(this, MainActivity.class));
                return true;
        }
        return true;
    }
}
