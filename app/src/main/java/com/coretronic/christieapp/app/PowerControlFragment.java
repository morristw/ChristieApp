package com.coretronic.christieapp.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coretronic.christieapp.app.Common.KeyMap;

public class PowerControlFragment extends Fragment {
    private String TAG = PowerControlFragment.class.getSimpleName();
    private LinearLayout powerGroup;
    private ImageButton powerIcon;
    private LinearLayout buttonGroup;
    private TextView btn1;
    private View line;
    private TextView btn2;
    private boolean powerState = false;
    private Resources rs;
    private Context mContext;
    private static final int REQUEST_DEVICE_LIST = 1;


    private void assignViews(View v) {
        powerGroup = (LinearLayout) v.findViewById(R.id.powerGroup);
        powerIcon = (ImageButton) v.findViewById(R.id.powerIcon);
        buttonGroup = (LinearLayout) v.findViewById(R.id.buttonGroup);
        btn1 = (TextView) v.findViewById(R.id.key_info);
        line = v.findViewById(R.id.line);
        btn2 = (TextView) v.findViewById(R.id.key_exit);
        powerIcon.setOnClickListener(btnListener);
        btn1.setOnClickListener(btnListener);
        btn2.setOnClickListener(btnListener);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rs = getActivity().getResources();
        // telnet client
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_power_control, container, false);
        assignViews(view);
        return view;
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        String keyValue = "";

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.powerIcon:
                    Intent serverIntent = new Intent(getActivity(), DeviceListActivity.class);
                    startActivityForResult(serverIntent, REQUEST_DEVICE_LIST);
//                    if (powerState) {
//                        btn1.setTextColor(rs.getColor(R.color.gray));
//                        btn1.setEnabled(false);
//                        btn2.setTextColor(rs.getColor(R.color.gray));
//                        btn2.setEnabled(false);
//                        buttonGroup.setBackgroundResource(R.color.black);
//                        powerState = false;
//                    } else {
//                        btn1.setTextColor(rs.getColor(R.color.black));
//                        btn1.setEnabled(true);
//                        btn2.setTextColor(rs.getColor(R.color.black));
//                        btn2.setEnabled(true);
//                        buttonGroup.setBackgroundResource(R.color.origen);
//                        powerState = true;
//                    }
                    break;
                case R.id.key_info:
                    Log.d(TAG, "btn1");
                    keyValue = KeyMap.keyMap.get(v.getId());
                    ChristieActivity.sendCommand(keyValue);
                    break;
                case R.id.key_exit:
                    Log.d(TAG, "btn2");
                    keyValue = KeyMap.keyMap.get(v.getId());
                    ChristieActivity.sendCommand(keyValue);
                    break;
            }
        }
    };


}
