package com.example.hari.demohb;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hari on 18/05/18.
 */

public class StudentList extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public StudentList(Activity context, List<Student> studentList){
    super(context, R.layout.list_layout, studentList);
        this.context=context;
        this.studentList=studentList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewname=(TextView) listViewItem.findViewById(R.id.textViewname);
        TextView textViewregno=(TextView) listViewItem.findViewById(R.id.textViewregno);

        Student student = studentList.get(position);

        textViewname.setText(student.getName());
        textViewregno.setText(student.getRegno());

        return listViewItem;


    }
}
