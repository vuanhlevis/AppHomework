package com.example.levua.appcaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "";
    TextView tv_Result;
    EditText tv_Operation;
    int x = 0;


    public enum Operation {
        ADD, SUBSTRACT, MULTI, EQUAL, DIVI, DEL
    }

    boolean isNum;
    String currentNumber = "";
    String ANumber = "";
    String BNumber = "";
    Operation currentOperation;
    double result = 0;
    boolean clickOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Result = (TextView) findViewById(R.id.tv_result);
        tv_Operation = (EditText) findViewById(R.id.tv_curr);
        tv_Result.setText("");
        tv_Operation.setText("");
        currentOperation = null;

        Button btNum = (Button) findViewById(R.id.btNum);

        Button btadd = (Button) findViewById(R.id.buton_add);
        Button btsub = (Button) findViewById(R.id.buton_substract);
        Button btdiv = (Button) findViewById(R.id.buton_division);
        Button btmul = (Button) findViewById(R.id.buton_multi);
        Button btequal = (Button) findViewById(R.id.buton_equal);
        Button btAC = (Button) findViewById(R.id.buton_AC);

        btNum.setOnClickListener(this);

        btadd.setOnClickListener(this);
        btsub.setOnClickListener(this);
        btdiv.setOnClickListener(this);
        btmul.setOnClickListener(this);
        btequal.setOnClickListener(this);
        btAC.setOnClickListener(this);
    }

    boolean tmp = false;

    public void PressedNum() {
        ANumber = tv_Operation.getText().toString();

        tv_Operation.setText(ANumber);
    }

    @Override
    public void onClick(View v) {
        Button buton = (Button) v;
        if (buton != null) {
            switch (v.getId()) {
                case R.id.btNum:
                    isNum = true;
                    tv_Operation.setText(tv_Operation.getText() + (String) buton.getText());
                    if (!tmp) {
                        ANumber = tv_Operation.getText().toString();
                    } else {
                        BNumber = tv_Operation.getText().toString();
                    }
                    break;

                case R.id.buton_add:

                    tmp = true;
                    tv_Operation.setText("");
                    x = 1;
                    clickOperation = true;


                    break;
                case R.id.buton_division:

                    tmp = true;
                    tv_Operation.setText("");
                    clickOperation = true;
                    x = 2;

                    break;
                case R.id.buton_multi:

                    tmp = true;
                    tv_Operation.setText("");
                    clickOperation = true;
                    x = 3;

                    break;
                case R.id.buton_substract:

                    tmp = true;
                    tv_Operation.setText("");
                    clickOperation = true;
                    x = 4;

                    break;
                case R.id.buton_equal:
                    CompleteOperation(Operation.EQUAL);
                    clickOperation = true;

                    break;
                case R.id.buton_AC:
                    CompleteOperation(Operation.DEL);
                    clickOperation = true;
                    x = 5;

                    break;
            }
        }

    }

    private void CompleteOperation(Operation operation) {
//        clickOperation = false;
        BNumber = tv_Operation.getText().toString();
        tv_Operation.setText("");

        switch (operation) {

            case EQUAL:
                if (ANumber == "") {
                    ANumber = "0";
                }

                if (BNumber == "") {
                    BNumber = "0";
                }

                if (x == 1) {
                    result = Integer.parseInt(ANumber) + Integer.parseInt(BNumber);
//                    result = Integer.parseInt(ANumber) ;
                    tv_Result.setText(result + "");

                    tmp = false;
                    ANumber = "";
                    BNumber = "";
                    x = 0;
                    result = 0;
                    break;
                } else if (x == 2) {
                    result = Integer.parseInt(ANumber) / Integer.parseInt(BNumber);
                    tv_Result.setText(result + "");

                    tmp = false;
                    ANumber = "";
                    BNumber = "";
                    x = 0;
                    result = 0;
                    break;
                } else if (x == 3) {
                    result = Integer.parseInt(ANumber) * Integer.parseInt(BNumber);
                    tv_Result.setText(result + "");
                    tmp = false;
                    tmp = false;
                    ANumber = "";
                    BNumber = "";
                    x = 0;
                    result = 0;
                    break;
                } else if (x == 4) {
                    result = Integer.parseInt(ANumber) - Integer.parseInt(BNumber);
                    tv_Result.setText(result + "");
                    tmp = false;
                    tmp = false;
                    ANumber = "";
                    BNumber = "";
                    x = 0;
                    result = 0;
                    break;
                } else if (x == 5) {
                    result = 0;
                    tv_Result.setText("0");
                    tmp = false;
                    tmp = false;
                    ANumber = "";
                    BNumber = "";
                    x = 0;
                    result = 0;
                    break;
                } else if (x == 0) {
                    tv_Result.setText(ANumber);
                }
                break;
            case DEL:
                ANumber = "";
                BNumber = "";
                result = 0;
                tv_Operation.setText("");
                tv_Result.setText("");
                x = 0;
                tmp = false;
        }
    }
//
//        if (currentOperation != null) {
//            clickOperation = false;
//            if (currentNumber != "") {
//
//                BNumber = currentNumber;
//                currentNumber = "";
//                switch (currentOperation) {
//                    case ADD:
//                        result = Integer.parseInt(ANumber) + Integer.parseInt(BNumber);
//                        tv_Result.setText(result + "");
//                        BNumber = "";
//                        break;
//                    case SUBSTRACT:
//                        result = Integer.parseInt(ANumber) - Integer.parseInt(BNumber);
//                        tv_Result.setText(result + "");
//                        BNumber = "";
//                        break;
//                    case MULTI:
//                        result = Integer.parseInt(ANumber) * Integer.parseInt(BNumber);
//                        tv_Result.setText(result + "");
//                        BNumber = "";
//                        break;
//                    case DIVI:
//                        result = Integer.parseInt(ANumber) / Integer.parseInt(BNumber);
//                        tv_Result.setText(result + "");
//                        BNumber = "";
//                        break;
//                    case EQUAL:
//                        if (BNumber == "") {
//                            BNumber = "0";
//                        }
//                        result = Integer.parseInt(ANumber) + Integer.parseInt(BNumber);
//                        tv_Result.setText(result + "");
//                        BNumber = "";
//                        ANumber = "";
//                        result = 0;
//                        currentOperation = null;
//                        break;
//
//                    case DEL:
//                        ANumber = "";
//                        BNumber = "";
//                        tv_Operation.setText("0");
//                        tv_Result.setText("0");
//                        result = 0;
//                        currentOperation = null;
//                }
//
//
////                ANumber = "0";
//                result = 0;
//
//                tv_Operation.setText(currentNumber);
//
//            }
//        } else {
//            ANumber = currentNumber;
//            currentNumber = "";
////            tv_Result.setText("lol");
//        }
//        currentOperation = operation;
//
//    }

}
