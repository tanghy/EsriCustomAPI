package com.tanghy.phoneactivity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class PhoneGroupAdapter extends BaseExpandableListAdapter {

	class ExpandableListHolder {  //����һ���ڲ��࣬���ڱ���listitem��3������ͼ����,2��textview��1��checkbox
        TextView tvName;  
        TextView tvPhone;  
        CheckBox chkChecked;  
    } 
		private Context context;  	 //��activity
		private LayoutInflater mChildInflater;  //���ڼ���listitem�Ĳ���xml
		private LayoutInflater mGroupInflater;  //���ڼ���group�Ĳ���xml
		private List<PhoneGroup> groups;  	 //����group
		//���췽��������c �� activity������group �� ����group
		public PhoneGroupAdapter(Context c,List<PhoneGroup> groups){
		context=c;
		mChildInflater = (LayoutInflater) context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mGroupInflater = (LayoutInflater) context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.groups = groups;
		}
		@Override
		public Object getChild(int arg0, int arg1) {//������������item������ȡ��listitem	 // TODO Auto-generated method stub
		return groups.get(arg0).children.get(arg1);
		}
		@Override
		public long getChildId(int arg0, int arg1) {//����item����
		return arg1;
		}
		@Override
		public int getChildrenCount(int groupPosition) {//�������������ط������item��
		return groups.get(groupPosition).children.size();
		}
		@Override
		public Object getGroup(int groupPosition) {//����������������
		return groups.get(groupPosition);
		}
		@Override
		public int getGroupCount() {//���ط�����
		return groups.size();
		}
		@Override
		public long getGroupId(int groupPosition) {//���ط�������
		return groupPosition;
		}
		@Override
		public View getGroupView(int position, boolean isExpanded,
		View view, ViewGroup parent) {//������������Ⱦ"����ͼ"
		ExpandableListHolder holder = null;  //�����ʱ����holder
        if (view == null) {  //�ж�view����view�Ƿ��ѹ����ã��Ƿ�Ϊ��
        
        	//������ͼΪ�գ���������ͼ��ע��flate��ʹ�ã�R.layout.browser_expandable_list_item������
        	//�Ѽ��ص��ڴ��browser_expandable_list_item.xml�ļ�
            view = mGroupInflater.inflate(  
                    R.layout.phone_list_item, null);  
            //������Ҫ��ȡ����ĸ�����ͼ����������ͼ�����ԡ���tag�����������ͼ������
            holder = new ExpandableListHolder();  
            //��view��ȡ��textView
            holder.tvName = (TextView) view.findViewById(R.id.phone_name);  
            //��view��ȡ��textview
            holder.tvPhone = (TextView) view.findViewById(R.id.phone_number);  
            //��view��ȡ��checkbox
            holder.chkChecked = (CheckBox) view  
                    .findViewById(R.id.phone_check);      
//            holder.chkChecked.setEnabled(false);//����checkbox
            //��checkbox��textview�����ñ��浽����ͼ��tag������
            view.setTag(holder);   
        } else {  //��view��Ϊ�գ�ֱ�Ӵ�view��tag�����л�ø�����ͼ������
            holder = (ExpandableListHolder) view.getTag();  
        }
        //��Ӧ���������������ݣ�ģ�ͣ�
        PhoneGroup info = this.groups.get(position);  
       if (info != null) {  
        	//����ģ��ֵ����textview���ı�
            holder.tvName.setText(info.title);  
            //����ģ��ֵ����checkbox��checked����
            holder.chkChecked.setChecked(info.getChecked()); 
    	 holder.chkChecked.setTag(info);
            holder.chkChecked.setOnClickListener(new OnClickListener(){
    	 @Override
    	 public void onClick(View v) {
    	 PhoneGroup group=(PhoneGroup)v.getTag();
    	 group.setChecked(!group.getChecked());
    	 notifyDataSetChanged();
    	 }
	            });
	        }  
	// TODO Auto-generated method stub
	return view;
	}
	    //����Ⱦ����  
	@Override
    public View getChildView(int groupPosition, int childPosition,  
            boolean isLastChild, View convertView, ViewGroup parent) {  
        ExpandableListHolder holder = null;  //�����ʱ����
        if (convertView == null) {  //����δ��ʼ��
        	//ͨ��flater��ʼ������ͼ
            convertView = mChildInflater.inflate(  
                    R.layout.phone_list_item, null);  
            //��������ͼ��3������ͼ���÷ŵ�tag��
            holder = new ExpandableListHolder();  
            holder.tvName = (TextView) convertView  
                    .findViewById(R.id.phone_name);  
              
            holder.tvPhone = (TextView) convertView.findViewById(R.id.phone_number);  
            holder.chkChecked = (CheckBox) convertView  
                    .findViewById(R.id.phone_check);
//            holder.chkChecked.setEnabled(false);
            convertView.setTag(holder);
        } else {  //�����ѳ�ʼ����ֱ�Ӵ�tag���Ի������ͼ������
            holder = (ExpandableListHolder) convertView.getTag();  
        }  
        //��������ݣ�ģ�ͣ�
        PhoneListItem info = this.groups.get(groupPosition)  
                .children.get(childPosition);  
        
        if (info != null) {  
        	//����ģ�����ݣ���������ͼ�Ŀؼ�ֵ
            holder.tvName.setText(info.name);  
            holder.tvPhone.setText(info.phone);  
            holder.chkChecked.setChecked(info.checked); 
            holder.chkChecked.setTag(info);
            holder.chkChecked.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
		CheckBox check=(CheckBox)v;
		PhoneListItem item=(PhoneListItem)v.getTag();
		item.checked=!item.checked;
		//	 check.setChecked(!check.isChecked());
		}
		            
		            });
		        }  
		        return convertView;  
		    } 
		@Override
		public boolean hasStableIds() {//���Ƿ����Ψһid
		return false;
		}
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {//���Ƿ��ѡ
		return true;
		}

}
