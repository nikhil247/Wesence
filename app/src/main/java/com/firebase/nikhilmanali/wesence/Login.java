package com.firebase.nikhilmanali.wesence;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONObject;

import java.util.Arrays;

public class Login extends AppCompatActivity {

    private LoginButton loginButton;  // facebook login button
    private CallbackManager callbackManager; // callbackManager


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext()); // Initializing facebook sdk
        setContentView(R.layout.activity_login);


        callbackManager = CallbackManager.Factory.create(); // Initialize the callbackManger
        loginButton = (LoginButton) findViewById(R.id.login_button); // Intialize the login button

        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));


        //  facebook callback

        FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {



                // Facebook Email address
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {

    //->  If login is sucessfull then open the mainactivity of the feeds Activity
                                try {
                                    Intent i=new Intent(Login.this,MainActivity.class);
                                    startActivity(i);
                                }catch (Exception e){

                                }
     //-> fields require as per the field.

                               /* Name = object.getString("name");
                                Email = object.getString("email");
                                // Gender=object.getString("gender");
                                BD=object.getString("link");

                                profilePicUrl = object.getJSONObject("picture").getJSONObject("data").getString("url")*/;

                            }
                        });

    //-> For setting the parameter of the account in a bundle
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,email,picture.type(large)");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        };
        loginButton.registerCallback(callbackManager, mCallBack);

    }

    // Getting result back to the activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }


}




