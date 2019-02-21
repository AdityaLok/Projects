package com.example.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GeneralCalculator extends Fragment implements Operations {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private EditText mInput1;
    private EditText mInput2;
    private TextView mResultTextView;
    private String result;
    private Integer variable1;
    private Integer variable2;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mInput1.getText().length() > 0
                    && mInput2.getText().length() > 0) {
                switch (v.getId()) {
                    case R.id.add:
                        variable1 = Integer.parseInt(mInput1.getText().toString());
                        variable2 = Integer.parseInt(mInput2.getText().toString());
                        result = String.valueOf(add(variable1, variable2));
                        mResultTextView.setText(result);
                        break;

                    case R.id.subtract:
                        variable1 = Integer.parseInt(mInput1.getText().toString());
                        variable2 = Integer.parseInt(mInput2.getText().toString());
                        result = String.valueOf(subtract(variable1, variable2));
                        mResultTextView.setText(result);
                        break;

                    case R.id.multiply:
                        variable1 = Integer.parseInt(mInput1.getText().toString());
                        variable2 = Integer.parseInt(mInput2.getText().toString());
                        result = String.valueOf(multiply(variable1, variable2));
                        mResultTextView.setText(result);
                        break;

                    case R.id.divide:
                        variable1 = Integer.parseInt(mInput1.getText().toString());
                        variable2 = Integer.parseInt(mInput2.getText().toString());
                        if (variable2 == 0)
                            Toast.makeText(getContext(), "2nd variable cannnot be zero", Toast.LENGTH_SHORT).show();
                        else {
                            result = String.valueOf(divide(variable1, variable2));
                            mResultTextView.setText(result);
                        }
                        break;
                }
            }
        }
    };

    public GeneralCalculator() {

    }

    public static GeneralCalculator newInstance(String param1, String param2) {
        GeneralCalculator fragment = new GeneralCalculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.general_operations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInput1 = (EditText) view.findViewById(R.id.input1);
        mInput2 = (EditText) view.findViewById(R.id.input2);
        mResultTextView = (TextView) view.findViewById(R.id.ResultTextViewGeneral);
        Button buttonAdd = (Button) view.findViewById(R.id.add);
        Button buttonSubtract = (Button) view.findViewById(R.id.subtract);
        Button buttonMultiply = (Button) view.findViewById(R.id.multiply);
        Button buttonDivide = (Button) view.findViewById(R.id.divide);

        buttonAdd.setOnClickListener(clickListener);
        buttonSubtract.setOnClickListener(clickListener);
        buttonMultiply.setOnClickListener(clickListener);
        buttonDivide.setOnClickListener(clickListener);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    @Override
    public int add(Integer var1, Integer var2) {
        return var1 + var2;
    }

    @Override
    public int subtract(Integer var1, Integer var2) {
        return var1 - var2;
    }

    @Override
    public int multiply(Integer var1, Integer var2) {
        return var1 * var2;
    }

    @Override
    public int divide(Integer var1, Integer var2) {
        return var1 / var2;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
