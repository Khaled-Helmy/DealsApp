package com.yalladealz.userapp.util;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.ui.fragments.LoginFragment;

public class ConstantUtil {
    public static final String YOUTUBE_API_KEY = "AIzaSyCVJwKkn2BI9mkU4hJqWFKxo5f3sDJGU40";
    public static final String DEAL_ID = "deal_id";
    public static final String DEAL_RATING = "deal_rating";
    public static final String OPTION_ID = "option_id";
    public static final String DEAL_IMAGE = "https://www.yalladealz.com/images/deals/";
    public static class SharedPrefUtilKeys {
        public static final String ID = "id";
        public static final String USER_NAME = "user_name";
        public static final String EMAIL = "email";
        public static final String IS_LOGIN = "user_login";
    }

    public static String[] about_title_array = {
            "Ready to Travel",
            "Pick the Ticket",
            "Flight to Destination",
            "Enjoy Holiday"
    };
    public static String[] about_description_array = {
            "Choose your destination, plan Your trip. Pick the best place for Your holiday",
            "Select the day, pick Your ticket. We give you the best prices. We guarantee!",
            "Safe and Comfort flight is our priority. Professional crew and services.",
            "Enjoy your holiday, Don't forget to feel the moment and take a photo!",
    };
    public static int[] about_images_array = {
            R.drawable.img_wizard_1,
            R.drawable.img_wizard_2,
            R.drawable.img_wizard_3,
            R.drawable.img_wizard_3
    };
}
