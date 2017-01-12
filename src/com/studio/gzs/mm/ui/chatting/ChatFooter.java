package com.studio.gzs.mm.ui.chatting;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.studio.gzs.mm.ui.MMEditText;
import com.studio.gzs.mm.R;

/*
 * �Զ���ؼ�
 */
public class ChatFooter extends LinearLayout{
	private ImageButton showBtn;
	public LinearLayout voice_panel;
	private LinearLayout text_panel;
	private MMEditText  chatting_content_et;
	private Button chatting_send_btn,voice_record_btn;
	private boolean isVoice=false;
	private ChatFooterClickListener chatFooterClickListener;
	
	public interface ChatFooterClickListener{
		void showBtnOnClickListener();
		void sentBtnOnClickListener();
		void recordBtnOnClickListener();
	}
	public ChatFooter(Context context, AttributeSet attrs) {
		super(context, attrs);	
		LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.chatting_footer, this);
		
		//��ʼ��������ť
		showBtn=(ImageButton)findViewById(R.id.chatting_attach_btn);
		chatting_send_btn=(Button)findViewById(R.id.chatting_send_btn);
		voice_record_btn=(Button)findViewById(R.id.voice_record_bt);
		//��ʼ��Panel
		text_panel=(LinearLayout) findViewById(R.id.text_panel_ll);
		voice_panel=(LinearLayout) findViewById(R.id.voice_panel_ll);
		
		//�༭��
		chatting_content_et=(MMEditText) findViewById(R.id.chatting_content_et);
		
		setVoice(isVoice);
		
		showBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	Log.d("log", "showBtnOnClick");				
				if(chatFooterClickListener!=null){
					chatFooterClickListener.showBtnOnClickListener();
				}
			}
		});
		chatting_send_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	Log.d("log", "SendBtnOnClick");
				if(chatFooterClickListener!=null){
					chatFooterClickListener.sentBtnOnClickListener();
				}		
			}
		});
		voice_record_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	Log.d("log", "RecordBtnOnClick");
				if(chatFooterClickListener!=null){
					chatFooterClickListener.recordBtnOnClickListener();
				}			
			}
		});
	}
	//�Ƿ���ʾ¼��ģʽ
	public void setVoice(boolean isVoice){
		this.isVoice=isVoice;
		if(isVoice){
			text_panel.setVisibility(View.GONE);
			voice_panel.setVisibility(View.VISIBLE);
		}else{
			text_panel.setVisibility(View.VISIBLE);
			voice_panel.setVisibility(View.GONE);
		}
		
	}
	/*
	 * �Ƿ�Խ�ģʽ
	 */
	public boolean getVoice(){
		return isVoice;
	}
	public void setCharFooterClickListener(ChatFooterClickListener chatFooterClickListener) {
		this.chatFooterClickListener = chatFooterClickListener;
	}
	/*
	 * �����ı��༭�������
	 */
	public void setText(CharSequence text ){
		this.chatting_content_et.setText(text);
	}
	/*
	 * ����ı��༭�������
	 */
	public Editable getText(){
		return this.chatting_content_et.getText();
	}
	/*
	 * �����ı��༭�������
	 */
	public void append(CharSequence text){
		this.chatting_content_et.append(text);
	}

	/*
	 * ��ñ༭��ѡ���ı��Ŀ�ʼλ��
	 */
	public int getSelectionStart(){
		return this.chatting_content_et.getSelectionStart();
	}
	/*
	 * ��ñ༭��ѡ���ı��Ľ���λ��
	 */
	public int getSelectionEnd(){
		return this.chatting_content_et.getSelectionEnd();
	}
	/*
	 * ���ñ༭��ǰ�Ĺ��λ��
	 */
	public void setSelection(int index){
		this.chatting_content_et.setSelection(index);
	}
	/*
	 * �ı��༭��ĳ���
	 */
	public int length(){
		return this.chatting_content_et.length();
	}
}
