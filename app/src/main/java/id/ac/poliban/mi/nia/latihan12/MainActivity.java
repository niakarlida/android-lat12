package id.ac.poliban.mi.nia.latihan12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edLastName = findViewById(R.id.edLastName);
        EditText edFirstName = findViewById(R.id.edFirstName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);
        TextView tvResult = findViewById(R.id.tvResult);

        btSave.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            String lname,fname;
            lname = edLastName.getText().toString();
            fname = edFirstName.getText().toString();

            edit.putString("lname", lname);
            edit.putString("fname", fname);
            edit.apply();

            Toast.makeText(this, "data has been saved it", Toast.LENGTH_SHORT).show();
        });

        btLoad.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            String lname = sp.getString("lname", "na");
            String fname = sp.getString("fname", "na");
            tvResult.setText(String.format("%s %s", fname, lname));
        });
    }
}
