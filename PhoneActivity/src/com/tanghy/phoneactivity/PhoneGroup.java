package com.tanghy.phoneactivity;

import java.util.List;

public class PhoneGroup {
	
	public String title;

	private boolean checked;

	public  List<PhoneListItem> children;  

	public PhoneGroup(String title,boolean checked,List<PhoneListItem> children){

	this.title=title;

	setChecked(checked);

	this.children=children;

	}

	public boolean getChecked(){

	return checked;

	}

	public void setChecked(boolean b){

	checked=b;

	if(children!=null&&children.size()>0){//��children��Ϊ�գ�ѭ������children��checked

	for(PhoneListItem each : children){

	each.checked=checked;

	}

	}

	}

}
