package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculationView;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculationView = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }//////////////////////////////////////////////////////////////////////////////////////////////////end of mm

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();

        int cursorpos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorpos);
        String rightStr = oldStr.substring(cursorpos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd,rightStr));

        display.setSelection(cursorpos + strToAdd.length());
    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zero_text));
    }

    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.one_text));
    }

    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.two_text));
    }

    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.three_text));
    }

    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.four_text));
    }

    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.five_text));
    }

    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.six_text));
    }

    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.seven_text));
    }

    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eight_text));
    }

    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nine_text));
    }

    public void dotBTNPush(View view){
        updateText(getResources().getString(R.string.dot));
    }

    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.additionText));
    }

    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void dividBTNPush(View view){
        updateText(getResources().getString(R.string.dividText));
    }

    public void clearBTNPush(View view){
        display.setText("");
        previousCalculationView.setText("");
    }

    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parentesisOpenText));
    }

    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parentesisCloseText));
    }

    //ONLCIK EQUAL BUTTON
    public void equalBTNPush(View view){
        String  userExp = display.getText().toString();

        previousCalculationView.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.dividText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    //ONLICK BACKSPACE
    public void backspaceBTNPush(View view){

        int cursorpos = display.getSelectionStart();
        int textlen = display.getText().length();

        if (cursorpos !=0 && textlen !=0){
            SpannableStringBuilder  selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos-1, cursorpos, "");
            display.setText(selection);
            display.setSelection(cursorpos-1);
        }

    }



    public void trigSinBTNPush(View view){//1
        updateText("sin(");

    }

    public void trigCosBTNPush(View view){//2
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){//3
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){//4
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){//5
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){//6
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){//7
        updateText("1n(");
    }

    public void logBTNPush(View view){//8
        updateText("1og(");
    }

    public void squareRoootBTNPush(View view){//15
        updateText("sqrt");
    }

    public void absBTNPush(View view){//9
        updateText("^abs");
    }

    public void piBTNPush(View view){//10
        updateText("pi");
    }

    public void eBTNPush(View view){//11
        updateText("e");
    }

    public void xSquareBTNPush(View view){//12
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){//13
        updateText("^(");
    }

    public void primeBTNPush(View view){//14
        updateText("ispr(");
    }





}