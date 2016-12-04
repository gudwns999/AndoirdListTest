package com.example.hyung_jun.kmugossip;
import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;
/**
 * Created by Hyung-Jun on 2015-07-23.
 */
public class ListData {
    /**
     * 리스트 정보를 담고 있을 객체 생성
     */
    // 아이콘
    public Drawable mIcon;
    //닉네임
    public String nick;
    // 제목
    public String mTitle;
    // 날짜
    public String mDate;
    //성별
    public String gender;
    //상태
    public String state;
    //전공
    public String major;
    /**
     * 알파벳 이름으로 정렬
     */
    public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(ListData mListDate_1, ListData mListDate_2) {
            return sCollator.compare(mListDate_1.mTitle, mListDate_2.mTitle);
        }
    };
}
