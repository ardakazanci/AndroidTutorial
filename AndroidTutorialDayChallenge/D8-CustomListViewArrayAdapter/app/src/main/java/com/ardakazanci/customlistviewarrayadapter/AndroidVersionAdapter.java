package com.ardakazanci.customlistviewarrayadapter;


// Create a ArrayAdapter - > BaseAdapter

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidVersionAdapter extends ArrayAdapter<AndroidModel> {

    // LOGCAT = AndroidVersionAdapter.class
    private static final String lOG_CAT = AndroidVersionAdapter.class.getSimpleName();


    // First Chapter - > Const. Method
    // TWO ARGS : Context - ArrayList Model

    /**
     * @param activity       : Context
     * @param androidVersion : Model Reference
     */
    public AndroidVersionAdapter(Activity activity, ArrayList<AndroidModel> androidVersion) {
        // Custom View Type - Second Parameter 0
        super(activity, 0, androidVersion);

    }


    // Custom XML - TO - VİEW
    // Second Chapter - > getView -> XML TO VIEW

    /**
     * @param position    : Object Position
     * @param convertView : View - XML TO VİEW
     * @param parent      : MainListView
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            // Garbage XML TO VİEW
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_style, parent, false);

        }

        AndroidModel androidModelCurrentView = getItem(position); // Object Position

        TextView androidVersionName = listItemView.findViewById(R.id.list_version_name);

        androidVersionName.setText(androidModelCurrentView.getmVersionName());

        TextView androidVersionNumber = listItemView.findViewById(R.id.list_version_number);

        androidVersionNumber.setText(androidModelCurrentView.getmVersionNumber());

        ImageView androidVersionImage = listItemView.findViewById(R.id.list_image);

        androidVersionImage.setImageResource(androidModelCurrentView.getmImageResourceId());

        return listItemView;

    }


}
