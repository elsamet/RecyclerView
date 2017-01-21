package com.ramadan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Mahmoud Ramadan on 1/21/17.
 */
public class RecyclerViewTouchListener implements RecyclerViewClickListener, RecyclerView.OnItemTouchListener {

    GestureDetector gestureDetector;
    RecyclerViewClickListener rvClickListener;

    RecyclerViewTouchListener(Context context,final RecyclerView rv, final RecyclerViewClickListener clickListener){
       this.rvClickListener=clickListener;
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child=rv.findChildViewUnder(e.getX(),e.getY());
                if(child!=null&&clickListener!=null){
                    clickListener.onLongClick(child, rv.getChildPosition(child));
                }

            }
        });
    }


    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && rvClickListener != null && gestureDetector.onTouchEvent(e)) {
            rvClickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
