package com.example.hyung_jun.kmugossip;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
public class AList extends Activity {
    private ListView aListView = null;
    private ListViewAdapter aAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alist_layout);

        aListView = (ListView)findViewById(R.id.aList_List);
        aAdapter = new ListViewAdapter(this);
        aListView.setAdapter(aAdapter);
        //sample
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"못생긴동우","못생겼어 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon), "이거왜만들었나요", "이거 왜 만들었나요?", "2015-07-20", "woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"잘생긴형준","글씨가 써지네요 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"못생긴동우","못생겼어 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"이거왜만들었나요","이거 왜 만들었나요?","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"잘생긴형준","글씨가 써지네요 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"못생긴동우","못생겼어 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"이거왜만들었나요","이거 왜 만들었나요?","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"잘생긴형준","글씨가 써지네요 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"못생긴동우","못생겼어 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"이거왜만들었나요","이거 왜 만들었나요?","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"잘생긴형준","글씨가 써지네요 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"못생긴동우","못생겼어 우후후","2015-07-20","man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"빵꾸똥꾸","똥마렵네요","2015-07-20","woman");
        aAdapter.addItem(getResources().getDrawable(R.drawable.loveicon),"이거왜만들었나요","이거 왜 만들었나요?","2015-07-20","woman");
        //List내용이 클릭되면 이벤트 -> 댓글확인
        aListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListData mData = aAdapter.mListData.get(position);
            }
        });
    }
    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mDate;
        public TextView nick;
        public TextView gender;
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

        public void addItem(Drawable icon,String nick, String mTitle, String mDate, String gender){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.nick = nick;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;
            addInfo.gender = gender;

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
                convertView = inflater.inflate(R.layout.alistview_layout, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.aListIcon_img);
                holder.mText = (TextView) convertView.findViewById(R.id.aListContent_text);
                holder.mDate = (TextView) convertView.findViewById(R.id.aListData_text);
                holder.nick = (TextView) convertView.findViewById(R.id.aListNick_text);
                holder.gender = (TextView) convertView.findViewById(R.id.aListGender_text);

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

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AList.this, Reply.class);
                    startActivity(intent);
                }
            });
            return convertView;

        }

    }
}
