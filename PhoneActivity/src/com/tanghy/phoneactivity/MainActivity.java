package com.tanghy.phoneactivity;

import java.util.ArrayList;
import java.util.List;

import com.tanghy.phoneactivity.PhoneGroupAdapter.ExpandableListHolder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

public class MainActivity extends Activity implements 

	ExpandableListView.OnGroupClickListener,ExpandableListView.OnChildClickListener{

		private List<PhoneGroup> groups;  

		 

		    private PhoneGroupAdapter exlist_adapter = null;  

		    private ExpandableListView exlist;  

		 

		public void onCreate(Bundle savedInstanceState) {  

		        super.onCreate(savedInstanceState);  

		        //����layout

		        setContentView(R.layout.activity_main);  

		        //ȡ��listview

		        exlist = (ExpandableListView) findViewById(R.id.phonelist); 

		       //����init���������������Ҫ��,��ʼ��һЩ����

		        init();

		        //����expandablelistview��������

		        exlist_adapter = new PhoneGroupAdapter(this, groups);  

		        exlist.setOnChildClickListener(this);

		        exlist.setAdapter(exlist_adapter);  //����ͼ��������

		 

		}

		    private void init() {  

		    groups = new ArrayList<PhoneGroup>();

		    	  

		        //����List����group1������

		        List<PhoneListItem> group1_children = new ArrayList<PhoneListItem>();

		        //��List���������

		        PhoneListItem item = new PhoneListItem("������","1308763994", false);  

		        group1_children.add(item);  

		        item = new PhoneListItem("������","1308763994", false);  

		        group1_children.add(item);  

		        item = new PhoneListItem("������","1308763994", false);  

		        group1_children.add(item);  

		 

		        //ƴװ�� PhoneGroup

		        PhoneGroup phonegroup1=new PhoneGroup("group1",false,group1_children);

		 

		        //------��ǰ��Ĵ��븴��һ�飬�����һ����group2

		        //����List����group2������

		        List<PhoneListItem> group2_children = new ArrayList<PhoneListItem>();

		        //��List���������

		        item = new PhoneListItem("������","1589065423", false);  

		        group2_children.add(item);  

		        item = new PhoneListItem("������","1589065423", false);  

		        group2_children.add(item);  

		        item = new PhoneListItem("������","1589065423", false);  

		        group2_children.add(item);  

		 

		        //ƴװ�� PhoneGroup

		        PhoneGroup phonegroup2=new PhoneGroup("group2",false,group2_children);

		        //��ӽ�groups����

		        groups.add(phonegroup1);

		        groups.add(phonegroup2);

		    }

		    //�������б����ʱ���÷�����֡�ѡ�У�ȡ��ѡ�С�״̬��

		@Override

		public boolean onChildClick(ExpandableListView parent, View v,

		int groupPosition, int childPosition, long id) {

		PhoneGroupAdapter.ExpandableListHolder holder=(ExpandableListHolder) v.getTag(); 

		holder.chkChecked.setChecked(!holder.chkChecked.isChecked());

		groups.get(groupPosition).children.get(childPosition).checked=

		!groups.get(groupPosition).children.get(childPosition).checked;

		return false;

		}

		@Override

		public boolean onGroupClick(ExpandableListView parent, View v,

		int groupPosition, long id) {

//			 groups.get(groupPosition).setChecked(!groups.get(groupPosition).getChecked());

//			 exlist_adapter.notifyDataSetChanged();

		//

		return false;

		}  

}
