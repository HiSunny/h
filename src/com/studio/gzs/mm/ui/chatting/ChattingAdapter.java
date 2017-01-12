package com.studio.gzs.mm.ui.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.gzs.mm.R;

public class ChattingAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<ChattingItem> chattingList=null;
	private LayoutInflater inflater;
	private String[] smiley_names=null;
	private Bitmap[] smiley_icon=null;
	private int file_Size;
	private boolean flag;

	private List<String> contentLoc = new ArrayList<String>();//记录文本中的表情字符串
	
	
	public ChattingAdapter(Activity a,ArrayList<ChattingItem> chattings){
		context=a;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(chattings==null){
			chattingList=new ArrayList<ChattingItem>();
		}else{
			chattingList=chattings;
		}
		try {
			smiley_names=context.getResources().getStringArray(R.array.smiley_values_ch);
			//注意：getAssets.list()只能得到文件下所有文件的名称，不能确定顺序。
			smiley_names=context.getResources().getStringArray(R.array.smiley_values_ch);
			file_Size=context.getAssets().list("smiley").length;//获取Asset目录下smiley文件下的所有文件名
			if(file_Size>0){
				smiley_icon=new Bitmap[file_Size];
				for(int i=0;i<file_Size;i++){
					smiley_icon[i]=getImageFromAssetsFile("smiley/"+i+".png");
				}				
			}else{
				smiley_icon=new Bitmap[0];
			}
		} catch (IOException e) {
			Log.d("log", e.getMessage());
		}		
	}

	@Override
	public int getCount() {
		return chattingList.size();
	}

	@Override
	public Object getItem(int position) {
		return chattingList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ChattingItem chattingitem=chattingList.get(position);
	//	Log.d("log", "Position:"+position+";Flag:"+flag);
		ViewHolder holder = null;
        if (convertView == null || (holder = (ViewHolder) convertView.getTag()).flag != chattingitem.isLocal) {
                 holder = new ViewHolder();
                 if (chattingitem.isLocal) {
                         holder.flag = true;
                         convertView = LayoutInflater.from(context).inflate(R.layout.chatting_item_to, null);
                 } else {
                         holder.flag = false;
                         convertView = LayoutInflater.from(context).inflate(R.layout.chatting_item_from, null);
                 }
                 holder.chatting_time_tv=(TextView) convertView.findViewById(R.id.chatting_time_tv);
                 holder.chatting_content_itv=(TextView)convertView.findViewById(R.id.chatting_content_itv);
                 holder.chatting_avatar_iv=(ImageView)convertView.findViewById(R.id.chatting_avatar_iv);
                 convertView.setTag(holder);
         }
         holder.chatting_time_tv.setText(chattingList.get(position).chatting_time);
         holder.chatting_avatar_iv.setVisibility(View.VISIBLE);               	
		String s = chattingList.get(position).chatting_content;
		
		if(s.contains("[") && s.contains("]")){
			Drawable d2=null;
			SpannableString ss2 = new SpannableString(s);
			contentLoc = collect(s);
			
			for(int i=0 ;i<contentLoc.size(); i++){
				for(int k=0;k<smiley_names.length;k++){
					if(contentLoc.get(i).contains(smiley_names[k])){
						d2=new BitmapDrawable(smiley_icon[k]);
						d2.setBounds(0, 0, d2.getIntrinsicWidth(), d2.getIntrinsicHeight());
						ImageSpan span2 = new ImageSpan(d2, ImageSpan.ALIGN_BOTTOM);
						
						int frist = s.indexOf(contentLoc.get(i));
						ss2.setSpan(span2, frist, frist+contentLoc.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					}
				}
			}
			holder.chatting_content_itv.setText(ss2);
		}else{
			holder.chatting_content_itv.setText(s);
		}	
		return convertView;
		
	}
	private class ViewHolder{
		boolean flag;
		TextView chatting_time_tv;
		TextView chatting_content_itv;
		ImageView chatting_avatar_iv;
		
	}
	   /*  
	   * 从Assets中读取图片  
	   */  
	  private Bitmap getImageFromAssetsFile(String fileName)  
	  {  
	      Bitmap image = null;  
	      AssetManager am =context.getResources().getAssets();  
	      try  
	      {  
	          InputStream is = am.open(fileName);  
	          image = BitmapFactory.decodeStream(is);
	          is.close(); 
	      }  
	      catch (IOException e)  
	      {  
	          e.printStackTrace();  
	      }  	     
	      return image;  
	  
	  } 
	public List<String> collect(String str) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("\\[.+?\\]");
		Matcher m = p.matcher(str);
		while (m.find())
			list.add(m.group());
		return list;
	}
}
