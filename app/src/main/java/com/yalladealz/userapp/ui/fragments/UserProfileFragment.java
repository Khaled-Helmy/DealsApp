package com.yalladealz.userapp.ui.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.adapters.ViewPagerAdapter;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.ui.fragments.ProfilePageFragments.AvailableDealsFragment;
import com.yalladealz.userapp.ui.fragments.ProfilePageFragments.DetailsFragment;
import com.yalladealz.userapp.ui.fragments.ProfilePageFragments.OrderHistoryFragment;
import com.yalladealz.userapp.ui.fragments.ProfilePageFragments.PointsFragment;
import com.yalladealz.userapp.util.SharedPrefUtil;
import com.yalladealz.userapp.viewModels.UserUpdateViewModel;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;


@SuppressWarnings("ConstantConditions")
public class UserProfileFragment extends Fragment {

    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.tableLayout)
    TabLayout tableLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.image)
    ImageView image;
    private String fullName = "";

    private LoginResponse loginResponse;
    private int IMAGE_CODE = 100;
    private Unbinder unbinder;

    public UserProfileFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_profile, container, false);
        unbinder = ButterKnife.bind(this, v);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPager.post(() -> {
            adapter.addFragment(new DetailsFragment(), getString(R.string.details));
            adapter.addFragment(new OrderHistoryFragment(), getString(R.string.history));
            adapter.addFragment(new AvailableDealsFragment(), getString(R.string.available));
            adapter.addFragment(new PointsFragment(), getString(R.string.points));
            adapter.addFragment(new WalletFragment(), getString(R.string.balance));
            viewPager.setAdapter(adapter);
            tableLayout.setupWithViewPager(viewPager);

        });


        UserUpdateViewModel updateModel = ViewModelProviders.of(this).get(UserUpdateViewModel.class);

        if (SharedPrefUtil.hasKey(getContext(), "ID") || SharedPrefUtil.hasKey(getContext(), "HASH")) {
            long id = Long.parseLong(SharedPrefUtil.getData(getContext(), "ID", 0L).toString());
            String hash = String.valueOf(SharedPrefUtil.getData(getContext(), "HASH", " "));

           /* updateModel.UpdateUser(new UserInfo(id, hash,null, null, null, null, null));*/

            updateModel.GetData().observe(this, loginRespons -> {
                loginResponse = loginRespons;
                if (loginResponse != null) {
                    fullName = loginResponse.getUserInfo().getFirstName() + " " + loginResponse.getUserInfo().getLastName();
                    txtName.setText(fullName);
                }
            });
        } else {
            Toast.makeText(getContext(), "no id", Toast.LENGTH_SHORT).show();
        }


        return v;
    }

    @OnClick(R.id.image)
    void onViewClicked() {
        getPermission();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CODE) {
            if (resultCode == RESULT_OK) {
                Uri img = data.getData();
                String imgUrl = getRealPathFromURI_API19(img);
                Glide.with(getContext()).load(imgUrl).into(image);

                File file = new File(imgUrl);
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestBody);

//                model.updatrPhoto(body);
            }
        }
    }

    @SuppressLint("NewApi")
    private String getRealPathFromURI_API19(Uri uri) {

        String filePath = "";

        String wholeID = DocumentsContract.getDocumentId(uri);
        String id = wholeID.split(":")[1];

        String[] column = {MediaStore.Images.Media.DATA};
        String sel = MediaStore.Images.Media._ID + "=?";

        Cursor cursor = getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column,
                sel, new String[]{id}, null);

        int columnIndex = cursor.getColumnIndex(column[0]);

        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }

    private void getPermission() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(getActivity(), permissions, 1);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}