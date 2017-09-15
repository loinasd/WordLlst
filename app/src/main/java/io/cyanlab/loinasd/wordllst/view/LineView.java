package io.cyanlab.loinasd.wordllst.view;

import io.cyanlab.loinasd.wordllst.R;
import io.cyanlab.loinasd.wordllst.model.Facade;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LineView {

    public static void getLine(LayoutInflater lineInflater, LinearLayout linearLayout, int wordlistNum, int lineNum){
        View view = lineInflater.inflate(R.layout.line,linearLayout,false);
        Facade facade = Facade.getFacade();
        TextView prim = (TextView)view.findViewById(R.id.primeTV);
        TextView trans = (TextView)view.findViewById(R.id.translateTV);
        prim.setText("");
        trans.setText("");
        String k = new String();

        k ="";
        for (int j = 0; j< facade.getPrimByLineNum(wordlistNum,lineNum).size();j++) {
            String s = new String();
            s = facade.getPrimByLineNum(wordlistNum,lineNum).get(j);
            k+=s;
            if (j!=facade.getPrimByLineNum(wordlistNum,lineNum).size()-1){
                k+=",";
            }
            k+=" ";
            prim.setText(k);
        }
        k ="";
        for (int j = 0; j< facade.getTransByLineNum(wordlistNum,lineNum).size();j++) {
            String s = new String();
            s = facade.getTransByLineNum(wordlistNum,lineNum).get(j);
            k+=s;
            if (j!=facade.getTransByLineNum(wordlistNum,lineNum).size()-1){
                k+=",";
            }
            k+=" ";
            trans.setText(k);
        }
        linearLayout.addView(view);
    }
}