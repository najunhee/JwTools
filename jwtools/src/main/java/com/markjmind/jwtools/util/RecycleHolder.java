package com.markjmind.jwtools.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * <br>捲土重來<br>
 *
 * @author 오재웅(JaeWoong-Oh)
 * @email markjmind@gmail.com
 * @since 2016-06-13
 */
public class RecycleHolder extends RecyclerView.ViewHolder{
    public HashMap<Integer, View> views = new HashMap();
    private Finder finder;
    private View layout;

    public RecycleHolder(View itemView) {
        super(itemView);
        initFinder(itemView);
        this.layout = itemView;
    }

    private void initFinder(final View finder){
        this.finder = new Finder() {
            @Override
            public View findViewById(int id) {
                return finder.findViewById(id);
            }
        };
    }

    public View getView(int id){
        if(views.containsKey(id)) {
            return views.get(id);
        }else{
            View view = finder.findViewById(id);
            views.put(id, view);
            return view;
        }
    }

    public View getLayout(){
        return layout;
    }

    public TextView getTextView(int id){
        return (TextView) getView(id);
    }

    public ImageView getImageView(int id){
        return (ImageView) getView(id);
    }

    public EditText getEditText(int id){
        return (EditText) getView(id);
    }

    public Button getButton(int id){
        return (Button) getView(id);
    }

    public ViewGroup getViewGroup(int id){
        return (ViewGroup) getView(id);
    }

    public LinearLayout getLinearLayout(int id){
        return (LinearLayout) getView(id);
    }

    public FrameLayout getFrameLayout(int id){
        return (FrameLayout) getView(id);
    }

    interface Finder{
        View findViewById(int id);
    }
}
