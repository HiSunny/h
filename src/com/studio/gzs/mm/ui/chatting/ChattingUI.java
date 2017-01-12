package com.studio.gzs.mm.ui.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.studio.gzs.mm.ui.chatting.ChatFooter.ChatFooterClickListener;
import com.studio.gzs.mm.R;

public class ChattingUI extends Activity {
	private LinearLayout volumn_panel;//�����������
	private RelativeLayout msg_type_chooser;//����ģʽ
	private ChatFooter  chatFooter;//�������
	private Button mode_voice_btn,mode_msg_btn,smiley_btn,add_camera_btn,add_video_btn;
	private ModeOnClickListener listener;

	
	private int file_Size;
	private String[] smiley_names=null;
	private Bitmap[] smiley_icon=null;
	private AlertDialog smileyDialog;
	
	private  CharSequence  qqname=null;
	
	private ListView chatting_history_lv;
	private ArrayList<ChattingItem> chattinglist=new ArrayList<ChattingItem>();
	private ChattingAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.chatting);
		
		initDate();
		
		chatting_history_lv=(ListView)findViewById(R.id.chatting_history_lv);
		
		volumn_panel=(LinearLayout) findViewById(R.id.chatting_volumn_panel);
		
		chatFooter=(ChatFooter) findViewById(R.id.nav_footer);
		
		adapter=new ChattingAdapter(ChattingUI.this,chattinglist);
		
		chatting_history_lv.setAdapter(adapter);
		
				
		initsmiley();
		
		initChatTypeChooser();
		
		
		chatFooter.setCharFooterClickListener(new ChatFooterClickListener() {					
			
			@Override
			public void showBtnOnClickListener() {
				//Log.d("log", "showBtnOnClickListener");
				if(View.VISIBLE==msg_type_chooser.getVisibility()){
					msg_type_chooser.setVisibility(View.GONE);
				}else{
					msg_type_chooser.setVisibility(View.VISIBLE);
					
				}
				
			}		
			@Override
			public void sentBtnOnClickListener() {
				//Log.d("log", "sentBtnOnClickListener");
				ChattingItem item=new ChattingItem();
				item.chatting_content=chatFooter.getText().toString();
				item.isLocal=true;
				chattinglist.add(item);
				//adapter.notifyDataSetChanged();	
				adapter=new ChattingAdapter(ChattingUI.this,chattinglist);
				chatting_history_lv.setAdapter(adapter);
				
				chatting_history_lv.setSelection(chattinglist.size()-1);
				
				chatFooter.setText("");
			
			}
			
			@Override
			public void recordBtnOnClickListener() {
				//Log.d("log", "recordBtnOnClickListener");
				Toast.makeText(ChattingUI.this, "¼��", 500).show();
			}
		});

	}
	/*
	 * ��ʼ������
	 */
	public void initsmiley(){
		try {
			//ע�⣺getAssets.list()ֻ�ܵõ��ļ��������ļ������ƣ�����ȷ��˳��
			smiley_names=getResources().getStringArray(R.array.smiley_values_ch);
			file_Size=getAssets().list("smiley").length;//��ȡAssetĿ¼��smiley�ļ��µ������ļ���
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
		LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vi=inflater.inflate(R.layout.smiley_layout, null);
		GridView smiley_grid=(GridView)vi.findViewById(R.id.smiley_grid);
		smiley_grid.setAdapter(new ImageAdapter(this));
		
		//��������ѡ��Ի��� 
    	AlertDialog.Builder alertBuidler=  new AlertDialog.Builder(this);
       //alertBuidler.setTitle("��ѡ�����");
        alertBuidler.setView(vi);
        smileyDialog= alertBuidler.create();
     	
	}
	   /*  
	   * ��Assets�ж�ȡͼƬ  
	   */  
	  private Bitmap getImageFromAssetsFile(String fileName)  
	  {  
	      Bitmap image = null;  
	      AssetManager am = getResources().getAssets();  
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
	  public void initDate(){
			ChattingItem item=new ChattingItem();
			item.chatting_time="���� 09:23";
			item.chatting_content="�����";
			item.isLocal=false;
			ChattingItem item1=new ChattingItem();
			item1.chatting_time="���� 11:00";
			item1.chatting_content="���а�";
			item1.isLocal=true;
			ChattingItem item2=new ChattingItem();
			item2.chatting_time="���� 12:00";
			item2.chatting_content="���ȥ�����ˣ�";
			item2.isLocal=false;
			ChattingItem item3=new ChattingItem();
			item3.chatting_time="���� 13:00";
			item3.chatting_content="�ڼ����";
			item3.isLocal=true;
			ChattingItem item4=new ChattingItem();
			item4.chatting_time="���� 13:00";
			item4.chatting_content="��ô���£�";
			item4.isLocal=false;
			
			ChattingItem item5=new ChattingItem();
			item5.chatting_time="���� 13:00";
			item5.chatting_content="�Ӱ��۰�";
			item5.isLocal=true;
			
			chattinglist.add(item);
			chattinglist.add(item1);
			chattinglist.add(item2);
			chattinglist.add(item3);
			chattinglist.add(item4);
			chattinglist.add(item5);
			
	  }
	public void initChatTypeChooser(){
		msg_type_chooser=(RelativeLayout) findViewById(R.id.linearLayout1);
		msg_type_chooser.setVisibility(View.GONE);//Ĭ�ϲ���ʾ
		mode_voice_btn=(Button)findViewById(R.id.mode_voice_btn);//�Խ�
		mode_msg_btn=(Button)findViewById(R.id.mode_msg_btn);//����
		smiley_btn=(Button)findViewById(R.id.smiley_btn);//����
		add_camera_btn=(Button)findViewById(R.id.add_camera_btn);//ͼƬ
		add_video_btn=(Button)findViewById(R.id.add_video_btn);//��Ƶ
		
		listener=new ModeOnClickListener();
		mode_voice_btn.setOnClickListener(listener);
		mode_msg_btn.setOnClickListener(listener);
		smiley_btn.setOnClickListener(listener);
		add_camera_btn.setOnClickListener(listener);
		add_video_btn.setOnClickListener(listener);
		
	}
	/*
	 * GridView ������
	 */
	public class ImageAdapter extends BaseAdapter{
		
		public ImageAdapter(Context c){
			mContext=c;
		}

		@Override
		public int getCount() {
			return smiley_icon.length;
		}

		@Override
		public Object getItem(int position) {
			return smiley_icon[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			 final ImageView imageView;
	            if (convertView == null) {
	                imageView = new ImageView(mContext);
	             // imageView.setLayoutParams(new GridView.LayoutParams(24, 24));
	                imageView.setBackgroundResource(R.drawable.smiley_bg);
	             // imageView.setAdjustViewBounds(false);
	             // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	             // imageView.setPadding(2, 2, 2, 2);
	            } else {
	                imageView = (ImageView) convertView;
	            }
	            imageView.setImageBitmap(smiley_icon[position]);
	            imageView.setTag(position);
	            
	            imageView.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						qqname=smiley_names[(Integer) imageView.getTag()];
						
						SpannableString s_name = new SpannableString(qqname); //ת���ɿ��滻���ı�
	    				
	    		        Drawable d = imageView.getDrawable(); //�����滻��ͼ��
	    		        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight()); 
	    		        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE); 
	    		        
	    		        s_name.setSpan(span,0, qqname.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); 
	    		        
	       		        if( chatFooter.getSelectionStart()==0) //�������ǰ����ʱ��
	       		        {
	       		        	if(chatFooter.getText().length()>1) //��������λ���ƻص���ǰ���ʱ��
	       		        	{
	       		        		//ԭEditeText�ı�
	       		        		CharSequence  old_txt=chatFooter.getText();
	       		        		//�����µ��ı�
	       		        		chatFooter.setText(s_name);
	       		        		//�����֮ǰ��
	       		        		chatFooter.append(old_txt);
	       		        		chatFooter.setSelection(s_name.length());//���õ�ǰ���λ��	       		        		
	       		        
	       		        	}
	       		        	else  //����һ�����������ǰ���ʱ�򣬼�һ��ʼ�Ͳ���ͼƬ
	       		        	{
	       		        		chatFooter.setText(s_name);
	       		        		chatFooter.setSelection(chatFooter.length());

	       		        	}
	           		       
	       		        }//����ڽ�β��ʱ��
	       		        else  if (chatFooter.getSelectionStart()==chatFooter.length())
	    		        	{
	       		        		chatFooter.append(s_name);
	    	   		        	//���ù��λ��
	       		        		chatFooter.setSelection(chatFooter.length());
	    	    		        
	    		        	}
	       		        	// ����겻�ڽ�β��ʱ��
	       		         else 
	       		        	{  		        	     
	     	        		    CharSequence  charText=chatFooter.getText();
	       		        		
	       		        	   CharSequence  charText1=charText.subSequence(0, chatFooter.getSelectionStart());
	    	        	       CharSequence  charText2= charText.subSequence( chatFooter.getSelectionStart(), charText.length());
	        				   
	    	        	       chatFooter.setText(charText1);
	    	        	       chatFooter.append(s_name);
	        		
       		       
	    	        	       chatFooter.append(charText2);
	    	        	       chatFooter.setSelection(charText1.length()+s_name.length());
	        		        //  editText.setSelection(editText.getText().length());
	       		        	}	
	       		        smileyDialog.dismiss();
	       		        msg_type_chooser.setVisibility(View.GONE);
	       		        
	    			}
	    		});
	            return imageView;
		}
		 private Context mContext;
	}
		
	public class ModeOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mode_voice_btn:
				chatFooter.setVoice(true);
				break;
			case R.id.mode_msg_btn:
				chatFooter.setVoice(false);
				break;
			case R.id.smiley_btn:
				smileyDialog.show();
				WindowManager.LayoutParams  lp=smileyDialog.getWindow().getAttributes();
		    	lp.width=320;
		    	lp.height=250;
		   // 	lp.x=130;
		   // 	lp.y=-150;
		    	smileyDialog.getWindow().setAttributes(lp);
		      //smileyDialog.setView(vi,0,0,0,0);
				break;
			case R.id.add_camera_btn:
				Toast.makeText(ChattingUI.this, "ͼƬ", 500).show();
				break;
			case R.id.add_video_btn:
				Toast.makeText(ChattingUI.this, "��Ƶ", 500).show();
				break;
			default:
				break;
			}
			
		}
		
	}

}
