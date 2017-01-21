package com.ramadan.recyclerview;

import android.view.View;

/**
 * Created by Mahmoud Ramadan on 1/21/17.
 */
public interface RecyclerViewClickListener {
    void onClick(View view,int position);
    void onLongClick(View view,int position);
}
