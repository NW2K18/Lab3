package com.example.todofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class TodoFragment extends Fragment {

    // Todo object, what is it used for?
    private Todo mTodo;
    // EditText object, presumebly to edit text titles?
    private EditText mEditTextTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxIsComplete;

    // Don't forget override for inherited methods
    // onCreate is always used
    public void onCreate(Bundle savedInstanceState) {
        // Takes the saved instance state from the parent method, which is null at first
        super.onCreate(savedInstanceState);
        // mTodo is now a new todo, why?
        mTodo = new Todo();
        // TODO: refactor
        // ^What does this mean?
        // Sets the title as test title and the boolean that the mTodo is complete... why?
        mTodo.setTitle("Test title");
        mTodo.setIsComplete("true");
    }

    // What is Nullable? We know what override is
    // We have put in onCreate, now we are implementing onCreateView
    // It is a "View", so it's the V of the MVC?
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // This is inflating the view using the fragment xml file, container to contain it
        // with attachToRoot being false for some reason
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        // Here we are utilising methods within the EditText object?
        // R is used to find the ID
        mEditTextTitle = (EditText) view.findViewById(R.id.todo_title);
        // So this is setting the title according to the mTodo title
        mEditTextTitle.setText(mTodo.getTitle());
        // Adding text changed listener? Apparently called a TextWatcher
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            //So the methods in these brackets are the overriden methods from the TextWatcher
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Intentionally left blank
            }
        });

        // These methods utilise mButton values?
        mButtonDate = (Button) view.findViewById(R.id.todo_date);
        // Parses the date into a string
        mButtonDate.setText(mTodo.getDate().toString());
        // It is not enabled?
        mButtonDate.setEnabled(false);

        // These methods deal with the checkbox
        // Checkbox and Buttons are widgets
        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        // ID is referred to a lot here, where is it?
        // This creates a new OnCheckedChangeListener, a listener checking if the checkbox
        // is complete
        mCheckBoxIsComplete.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //The boolean here is set using another boolean isChecked
                mTodo.setIsComplete(isChecked);
            }
        });

        // Lastly, this fragment returns the view
        return view;
    }
}
