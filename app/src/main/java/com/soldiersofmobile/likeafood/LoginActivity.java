package com.soldiersofmobile.likeafood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.soldiersofmobile.events.UserStateChangedEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class LoginActivity extends ActionBarActivity {


    @Inject
    UserManager userManager;
    @Inject
    Bus bus;

    @InjectView(R.id.userEditText)
    EditText userEditText;
    @InjectView(R.id.passwordEditText)
    EditText passwordEditText;
    @InjectView(R.id.signUpButton)
    Button signUpButton;
    @InjectView(R.id.signInButton)
    Button signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        App.doDaggerInject(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.signUpButton)
    public void signUp() {

        String user = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userManager.signUp(user, password);


    }

    @OnClick(R.id.signInButton)
    public void signIn(View view) {

    }


    @Subscribe
    public void onUserStateChanged(UserStateChangedEvent event) {

        if(!userManager.isUserNotLogged()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }
}
