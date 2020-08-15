package com.yalladealz.userapp.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.ViewModelFactory;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.util.CommonMethod;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.util.ValidationUtil;
import com.yalladealz.userapp.viewModels.LoginViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.yalladealz.userapp.ui.fragments.GalleryFragment.GalleryPager.TAG;
import static com.yalladealz.userapp.util.CommonMethod.showToast;
import static com.yalladealz.userapp.util.CommonMethod.snackbar;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.EMAIL;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.ID;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.IS_LOGIN;
import static com.yalladealz.userapp.util.ConstantUtil.SharedPrefUtilKeys.USER_NAME;
import static com.yalladealz.userapp.util.LogUtil.debug;
import static com.yalladealz.userapp.util.LogUtil.error;
import static com.yalladealz.userapp.util.LogUtil.verbose;
import static com.yalladealz.userapp.util.SharedPrefUtil.getData;
import static com.yalladealz.userapp.util.SharedPrefUtil.hasKey;
import static com.yalladealz.userapp.util.SharedPrefUtil.save;

public class LoginFragment extends Fragment {

    private static final int GOOGLE_SIGN_IN = 1000;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    @BindView(R.id.sign_up)
    TextView signUp;

    @BindView(R.id.sign_in_button)
    AppCompatButton signInButton;

    @BindView(R.id.rootView)
    RelativeLayout rootView;

    @BindView(R.id.login_button)
    LoginButton loginButton;

    @BindView(R.id.facebook_btn)
    AppCompatButton facebookBtn;


    //    @BindView(R.id.login_button)
//    LoginButton loginButton;

    private LoginViewModel model;
    @BindView(R.id.etEmail)
    EditText et_Email;
    @BindView(R.id.etPassword)
    EditText et_Pass;
    Unbinder unbinder;

    private GoogleSignInClient signInClient;
    private CallbackManager callbackManager;
    private String userEmail, password;

    private int check = 0;

    private FirebaseAuth auth;
    boolean isLogin;
    private ProgressDialog progressDialog;

    public LoginFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        model = ViewModelProviders.of(this, new ViewModelFactory(getActivity().getApplication()))
                .get(LoginViewModel.class);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Logging in");
        progressDialog.setMessage("Please wait...");


        isLogin = (boolean) getData(getContext(), IS_LOGIN, false);
        if (isLogin) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_global_homeFragment);
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        boolean isLogged = (boolean) getData(getContext(), IS_LOGIN, false);
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        try {
            if (isLogged) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_global_homeFragment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        unbinder = ButterKnife.bind(this, view);
        model = ViewModelProviders.of(this).get(LoginViewModel.class);

        signInClient = model.configureGoogleSignIn();
        callbackManager = CallbackManager.Factory.create();

        loginButton.setFragment(this);
        model.facebookLogin(loginButton, callbackManager, getActivity());

        return view;
    }

    @OnClick(R.id.loginBtn)
    void submit() {
        model.loginFlied(new SginUpUserInfo(userEmail,password));

        progressDialog.show();

        check = 0;
        if (checkValidation()) {
            if (CommonMethod.isNetworkAvailable(getContext())) {
                if (check == 1) {
                    model.loginMobile(userEmail,password);
                } else if (check == 0) {
                    model.login(userEmail, password);
                }

                model.getData().observe(this, loginResponse -> {
                    Log.d("khaled500","khaled500" );
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                            .navigate(R.id.nav_homeFragment);
                    if (loginResponse == null) {
                        Log.d("khaled600","khaled600" );
                        return;
                    }
                    String message = loginResponse.getMessage();
                    Log.d("khaled700","khaled700" );

                 if (loginResponse.getLogin() != null) {
                        progressDialog.dismiss();
                     Log.d("khaled50000","khaled50000" );
                        save(getContext(), "ID", loginResponse.getUserInfo().getUserId());
                        debug("ID saved");
                        save(getContext(), "HASH", loginResponse.getUserInfo().getAppHash());
                        save(getContext(), IS_LOGIN, true);
                        save(getContext(), "loginExpiration", System.currentTimeMillis());
                              SharedPrefUtil.saveLoginResponse(getContext(), loginResponse);



                    } else {
                        progressDialog.dismiss();
                    }

                    snackbar(rootView, message);

                });

            } else {
                snackbar(rootView, "No internet connection.");
            }
        }
    }

    private boolean checkValidation() {
        userEmail = et_Email.getText().toString().trim();
        password = et_Pass.getText().toString().trim();

        if (et_Email.getText().toString().trim().equals("")) {
            et_Email.setError(getString(R.string.enter_email_error));
            return false;
        }
        if (et_Pass.getText().toString().trim().equals("")) {
            et_Pass.setError(getString(R.string.enter_pass_error));
            return false;
        }
        if (ValidationUtil.validEmail(userEmail)) {
            if (userEmail.length() == 11) {
                try {
                    int num = Integer.parseInt(userEmail);
                    check = 1;
                    return true;
                } catch (NumberFormatException e) {
                    et_Email.setError("inValid");
                    return false;
                }
            } else {
                et_Email.setError("inValid");
                return false;
            }
        }
        if (!ValidationUtil.validPassword(password)) {
            et_Pass.setError(getString(R.string.password_size_error));
            return false;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        updateUI(user);
    }

    private void updateUI(FirebaseUser user) {

        // TODO getLastSignInAccount ? 3/12/2020
        GoogleSignInAccount acct =  GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        if (user != null) {
            String uid = user.getUid();
            String email = user.getEmail();
            String displayName = user.getDisplayName();

            model.getEmailGoogle(email);
            model.getLastNameGoogle(displayName);

            CommonMethod.showToast("Your Email" + email +"Your id" + uid , getContext());
            Log.w(TAG, "Your Email"+ email);

            if (hasKey(getContext(), ID)) {
                save(getContext(), IS_LOGIN, true); }

            else {
                //save data
                save(getContext(), USER_NAME, displayName);
                save(getContext(), ID, uid);
                save(getContext(), EMAIL, email);
                save(getContext(), IS_LOGIN, true);
                save(getContext(), "loginExpiration", System.currentTimeMillis());

            }

        }


    }


    @OnClick(R.id.sign_up)
    void onSignUp() {

        Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                .navigate(R.id.nav_registerFragment);
    }

    // TODO code  google SignIn is true but something wrong in Task<>  12/3/2020
    @OnClick(R.id.sign_in_button)

    void onGoogleSingInClicked() {
        Intent signInIntent = model.signIn(signInClient);
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN) {
            verbose("request code");

            Task<GoogleSignInAccount> task = model.getSinedInAccount(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("omar0","omar0" );
                if (account != null) {
                    Log.w(TAG, "Done");
                    Log.d("omar01","omar01" );
                    firebaseAuthWithGoogle(account);
                }
            } catch (ApiException e) {
                Log.d("omar02","omar02"+e.getMessage() );
                error("error: " + e.getStatusCode());
                e.printStackTrace();
            }

        } else {
            Log.w(TAG, "signInWithCredential:failure");
            debug("callbackmanager");
        }
    }

 

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        verbose("firebaseAuthWithGoogle: " + account.getIdToken());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential).addOnCompleteListener(task -> {

            Log.d("omar","omar" );

            if (task.isSuccessful()) {


                Log.d("omar2","omar2" );
                verbose("signInWithCredential: success" + task.getResult());
                FirebaseUser currentUser = auth.getCurrentUser();

                if (currentUser != null) {
                    updateUI(currentUser);
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                            .navigate(R.id.nav_userProfileFragment);
                }


            } else {

                Log.d("omar3","omar3" );
                verbose("signInWithCredential: failed" + task.getException());
                showToast("Authentication Failed", getContext());
                updateUI(null);
            }
        });
    }

    @OnClick({R.id.login_button, R.id.facebook_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                break;
            case R.id.facebook_btn:
                debug("facebook clicked");
                loginButton.performClick();
                break;
        }
    }
}
