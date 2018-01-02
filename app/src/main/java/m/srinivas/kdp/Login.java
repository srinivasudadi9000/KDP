package m.srinivas.kdp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements View.OnClickListener {
    EditText username_et, password_et;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                login();
                break;
        }
    }
    private void login(){
        final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Login.this);
        alertDialogBuilder.setTitle("KDP");
        // alertDialogBuilder.setIcon(R.drawable.aplogo);
        // set dialog message
        alertDialogBuilder.setMessage("Successfully Logged In !!!").setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent categories = new Intent(Login.this,Category_List.class);
                        startActivity(categories);
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        // create alert dialog
        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
}
