package com.example.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ScientificCalculator extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText mInput_1EditText;
    private TextView mResultTextView;
    private String result;
    private Double input;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mInput_1EditText.getText().length() > 0) {
                switch (v.getId()) {
                    case R.id.log:
                        Log.d("TAG", mInput_1EditText.getText().toString());
                        //TODO use editTest Text
                        input = Double.parseDouble(mInput_1EditText.getText().toString());
                        result = String.valueOf(Math.log(input));
                        mResultTextView.setText(result);
                        break;

                    case R.id.ln:
                        input = Double.parseDouble(mInput_1EditText.getText().toString());
                        result = String.valueOf(Math.pow(input, 10));
                        mResultTextView.setText(result);
                        break;

                }

            }
        }
    };

    public ScientificCalculator() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.scientific_operations, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInput_1EditText = (EditText) view.findViewById(R.id.input);
        mResultTextView = (TextView) view.findViewById(R.id.ResultTextView);
        // button initialisation
        Button buttonLog = (Button) view.findViewById(R.id.log);
        Button buttonLn = (Button) view.findViewById(R.id.ln);
        // set click listeners
        buttonLog.setOnClickListener(onClickListener);
        buttonLn.setOnClickListener(onClickListener);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
