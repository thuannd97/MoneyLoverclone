package thuannd.com.moneyloverclone.view.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import thuannd.com.moneyloverclone.R;

public class FragmentDealList extends Fragment {
    public static String KEY_MONTH = "month";
    public static String KEY_YEAR = "year";
    private int month = 1;
    private int year = 2019;

    public static FragmentDealList newInstance(int month, int year) {

        Bundle args = new Bundle();
        args.putInt(KEY_MONTH, month);
        args.putInt(KEY_YEAR, year);
        FragmentDealList fragment = new FragmentDealList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        month = getArguments().getInt(KEY_MONTH);
        year = getArguments().getInt(KEY_YEAR);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_deal_list, null);
        TextView txtData = view.findViewById(R.id.test);
        if(month == 1){
            txtData.setText("danh sach giao dich thang 1");
        }
        if(month == 2){
            txtData.setText("danh sach giao dich thang 2");
        }
        if(month == 3){
            txtData.setText("danh sach giao dich thang 3");
        }
        if(month == 4){
            txtData.setText("danh sach giao dich thang 4");
        }
        if(month == 5){
            txtData.setText("danh sach giao dich thang 5");
        }
        if(month == 6){
            txtData.setText("danh sach giao dich thang 6");
        }
        return view;
    }

    // lay du lieu tu database
    public void loadData(){

    }
}
