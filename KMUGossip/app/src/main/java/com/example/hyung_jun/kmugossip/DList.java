package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Hyung-Jun on 2015-07-23.
 */
public class DList extends Activity {
    private ListView dListView = null;
    private ListViewAdapter dAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlist_layout);

        dListView = (ListView)findViewById(R.id.dList_List);
        dAdapter = new ListViewAdapter(this);
        dListView.setAdapter(dAdapter);
        //sample
        dAdapter.addItem(getResources().getDrawable(R.drawable.gossipicon),"잘생긴형준","여기는 학업게시판","2015-07-20","man","컴퓨터공학과","학부생");
        dAdapter.addItem(getResources().getDrawable(R.drawable.gossipicon),"못생긴동우","학업","2015-07-20","woman","경영정보학부(대학원)","대학원생");
        dAdapter.addItem(getResources().getDrawable(R.drawable.gossipicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","man","전자정보공학과","타대생");
        dAdapter.addItem(getResources().getDrawable(R.drawable.gossipicon),"이거왜만들었나요","이거 왜 만들었나요?","2015-07-20","woman","미술학부","졸업생");


        //List내용이 클릭되면 이벤트 -> 댓글확인
        dListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListData mData = dAdapter.mListData.get(position);
            }
        });
    }
    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mDate;
        public TextView nick;
        public TextView gender;
        public TextView major;
        public TextView state;
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(Drawable icon,String nick, String mTitle, String mDate, String gender, String major, String state){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.nick = nick;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;
            addInfo.major = gender;
            addInfo.major = major;
            addInfo.state = state;

            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

        public void sort(){
            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange(){
            this.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.dlistview_layout, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.dListIcon_img);
                holder.mText = (TextView) convertView.findViewById(R.id.dListContent_text);
                holder.mDate = (TextView) convertView.findViewById(R.id.dListData_text);
                holder.nick = (TextView) convertView.findViewById(R.id.dListNick_text);
                holder.gender =(TextView) convertView.findViewById(R.id.dListGender_text);
                holder.major = (TextView) convertView.findViewById(R.id.dListMajor_text);
                holder.state = (TextView) convertView.findViewById(R.id.dListState_text);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            ListData mData = mListData.get(position);

            if (mData.mIcon != null) {
                holder.mIcon.setVisibility(View.VISIBLE);
                holder.mIcon.setImageDrawable(mData.mIcon);
            }else{
                holder.mIcon.setVisibility(View.GONE);
            }

            holder.mText.setText(mData.mTitle);
            holder.mDate.setText(mData.mDate);
            holder.nick.setText(mData.nick);
            holder.gender.setText(mData.gender);
            holder.major.setText(mData.major);
            holder.state.setText(mData.state);

            return convertView;
        }
    }

}