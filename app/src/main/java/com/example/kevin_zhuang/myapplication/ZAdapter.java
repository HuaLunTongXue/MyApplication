package com.example.kevin_zhuang.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/28<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class ZAdapter extends BaseAdapter{

    private static final String TAG= ZAdapter.class.getSimpleName();
    private List<String> mData;
    private Context mContext;




    public ZAdapter(Context context,List<String> list){
        this.mData = list;
        this.mContext = context;

    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d(TAG,"i="+i);
        String mString = mData.get(i);
        View view2;
        ViewHolder viewHolder;
        if(view==null){
            view2 = View.inflate(mContext,R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tvInfo = (TextView)view2.findViewById(R.id.list_item_tv);
            view2.setTag(viewHolder);
        }else{
            view2 = view;
             viewHolder = (ViewHolder) view2.getTag();
        }
        viewHolder.tvInfo.setText(mString);

        if(i==2){
            view2.setVisibility(View.GONE);
        }


        return view2;
    }





    private static class ViewHolder{
        TextView tvInfo;
    }

}


