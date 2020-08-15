package com.yalladealz.userapp.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.yalladealz.userapp.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.image_item, container, false);

		String images = "";
		int position = 0;

		if (getArguments() != null) {
			images = getArguments().getString("images");
			position = getArguments().getInt("position");
		}

		ArrayList<String> paths = new Gson().fromJson(images, new TypeToken<ArrayList<String>>(){}.getType());
		PhotoView imageView = view.findViewById(R.id.image_view);
		if (paths != null) {
			Glide.with(this)
					.load(paths.get(position))
					.into(imageView);
		}
		return view;
	}

	private static GalleryFragment newInstance(int position, ArrayList<String> images){
		GalleryFragment fragment = new GalleryFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
		bundle.putString("images", new Gson().toJson(images, new TypeToken<ArrayList<String>>(){}.getType()));
		fragment.setArguments(bundle);
		return fragment;
	}
	public static class GalleryPager extends FragmentStatePagerAdapter {
		ArrayList<String> images;
		public static final String TAG = "galleryPager";

		public GalleryPager(@NonNull FragmentManager fm, int behavior, ArrayList<String> images) {
			super(fm, behavior);
			this.images = images;
			Log.d(TAG, "GalleryPager: ");
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			Log.d(TAG, "getCount: " + images.size());
			return images.size();
		}

		@NonNull
		@Override
		public Fragment getItem(int position) {
			Log.d(TAG, "getItem: " + position);
			return GalleryFragment.newInstance(position, images);
		}
	}
}
