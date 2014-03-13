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

		        //加载layout

		        setContentView(R.layout.activity_main);  

		        //取得listview

		        exlist = (ExpandableListView) findViewById(R.id.phonelist); 

		       //调用init方法，这个方法主要是,初始化一些数据

		        init();

		        //构建expandablelistview的适配器

		        exlist_adapter = new PhoneGroupAdapter(this, groups);  

		        exlist.setOnChildClickListener(this);

		        exlist.setAdapter(exlist_adapter);  //绑定视图－适配器

		 

		}

		    private void init() {  

		    groups = new ArrayList<PhoneGroup>();

		    	  

		        //构建List用作group1的子项

		        List<PhoneListItem> group1_children = new ArrayList<PhoneListItem>();

		        //往List中添加内容

		        PhoneListItem item = new PhoneListItem("和文明","1308763994", false);  

		        group1_children.add(item);  

		        item = new PhoneListItem("黄文明","1308763994", false);  

		        group1_children.add(item);  

		        item = new PhoneListItem("王文明","1308763994", false);  

		        group1_children.add(item);  

		 

		        //拼装成 PhoneGroup

		        PhoneGroup phonegroup1=new PhoneGroup("group1",false,group1_children);

		 

		        //------把前面的代码复制一遍，再添加一个组group2

		        //构建List用作group2的子项

		        List<PhoneListItem> group2_children = new ArrayList<PhoneListItem>();

		        //往List中添加内容

		        item = new PhoneListItem("张文明","1589065423", false);  

		        group2_children.add(item);  

		        item = new PhoneListItem("李文明","1589065423", false);  

		        group2_children.add(item);  

		        item = new PhoneListItem("赵文明","1589065423", false);  

		        group2_children.add(item);  

		 

		        //拼装成 PhoneGroup

		        PhoneGroup phonegroup2=new PhoneGroup("group2",false,group2_children);

		        //添加进groups数组

		        groups.add(phonegroup1);

		        groups.add(phonegroup2);

		    }

		    //当分组行背点击时，让分组呈现“选中／取消选中”状态。

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
