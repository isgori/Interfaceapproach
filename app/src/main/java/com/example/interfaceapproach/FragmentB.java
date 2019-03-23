package com.example.interfaceapproach;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {
    private  FragmenBListener listener;
    private EditText editText;
    private Button buttonOK;

    public interface FragmenBListener {
        void onInputBSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b,container,false);

        editText = v.findViewById(R.id.edit_text);
        buttonOK= v.findViewById(R.id.button_ok);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });

        return  v;
    }

    public  void updateEditetx(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmenBListener){
            listener = (FragmenBListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement FragmenBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null ;
    }
}
