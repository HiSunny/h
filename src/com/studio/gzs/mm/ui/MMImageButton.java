package com.studio.gzs.mm.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class MMImageButton extends LinearLayout {
	private ImageView title_btn_iv;
	private TextView title_btn_tv;
	private Drawable title_logo;//按钮图标
	private String title;//按钮标题

	private boolean isImageFlag=false;//显示标题还是图标

    public MMImageButton(Context context, AttributeSet attrs) {
       super(context,attrs);
       LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   li.inflate(R.layout.image_button, this);
	   initMMImageButton();
		
    }
    public void initMMImageButton(){
 	   title_btn_iv=(ImageView) findViewById(R.id.title_btn_iv);
 	   title_btn_tv=(TextView)findViewById(R.id.title_btn_tv);
 	   setImageFlag(isImageFlag);
    }
    public void setImageFlag(boolean isImageFlag){
    	this.isImageFlag=isImageFlag;
    	if(isImageFlag){
    		title_btn_iv.setVisibility(View.VISIBLE);
    		title_btn_tv.setVisibility(View.GONE);
    	}else{
    		title_btn_iv.setVisibility(View.GONE);
    		title_btn_tv.setVisibility(View.VISIBLE);
    	}
    }
    public boolean getImageFlag(){
    	return this.isImageFlag;
    }
    public void setTitleLogo(Drawable title_logo){
    	this.title_logo=title_logo;
    	title_btn_iv.setImageDrawable(title_logo);
    }
    public Drawable getTtitleLogo(){
    	return this.title_logo;
    }
    public void setTitle(String title){
    	this.title=title;
    	title_btn_tv.setText(title);
    }
    public void setTitle(int resid){
    	this.title=getResources().getString(resid);
    	title_btn_tv.setText(resid);
    }
    
}
