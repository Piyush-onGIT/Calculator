package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText box = findViewById(R.id.input);
        EditText result = findViewById(R.id.result);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mult = findViewById(R.id.mult);
        Button div = findViewById(R.id.div);
        Button C = findViewById(R.id.btnC);
        Button eq = findViewById(R.id.eq);
        Button dot = findViewById(R.id.dot);
        Button cut = findViewById(R.id.back);

        box.setFocusable(false);
        result.setFocusable(false);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "0");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "-");
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + "/");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                box.setText(data + ".");
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                box.setText("");
                result.setText("");
            }
        });

        cut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = box.getText().toString();
                int len = data.length();
                String newData = "";
                int i = 0;
                while (i < len-1){
                    newData = newData + data.charAt(i);
                    i++;
                }
                box.setText(newData);
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inf_data = box.getText().toString();
                String post[] = infixToPostfix(inf_data);
                String res = evaluate(post);
                result.setText(res);

            }
        });
    }

    public static String[] separate(String exp){
        String a = exp;
        int len = a.length();
        int i = 0;
        String arr[] = new String[1000];
        int j = 0;

        while (i < len){
            String opd = "";
            char c = a.charAt(i);
            if(isOp(c) == 1){
                arr[j] = String.valueOf(c);
                j++;
                i++;
            }
            else{
                while (isOp(c) == 0){
                    opd = opd + c;
                    i++;
                    if(i < len){
                        c = a.charAt(i);
                    }
                    else if (i == len){
                        break;
                    }
                }
                arr[j] = opd;
                j++;
            }
            // i++;
        }

        return arr;
    }

    public static String calc(String a, String b, String exp){
        double A = Double.parseDouble(a);
        double B = Double.parseDouble(b);
        double res = 0.0;
        switch(exp){
            case "+":
                res = B + A;
                break;
            case "-":
                res = B - A;
                break;
            case "*":
                res = B * A;
                break;
            case "/":
                res = B / A;
                break;
        }
        return String.valueOf(res);
    }

    public static int isOp(char op){
        if (op == '+' || op == '-' || op == '*' || op == '/'){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static String[] infixToPostfix(String exp){

        String arr[] = separate(exp);
        String postfix[] = new String[1000];
        Stack1 array = new Stack1();
        int length = 0;
        int index = 0;
        while(arr[index] != null){
            length++;
            index++;
        }
        int i = 0;
        int post = 0;

        while(i < length){

            String op = arr[i];
            char ch = op.charAt(0);
            if(isOp(ch) == 1){
                if(array.isEmpty()){
                    array.push(op);
                    i++;
                }
                else{
                    if(ch == '+' || ch == '-'){
                        while(array.isEmpty() == false){
                            String add = array.pop();
                            postfix[post] = add;
                            post++;
                        }
                        array.push(op);
                        i++;
                    }
                    else if(ch == '*' || ch == '/'){
                        while(array.top() == "*" || array.top() == "/"){
                            String add1 = array.pop();
                            postfix[post] = add1;
                            post++;
                        }
                        array.push(op);
                        i++;
                    }
                }
            }
            else{
                postfix[post] = op;
                post++;
                i++;
            }

        }

        // for(int k = 0; k < postfix.length && postfix[k] != null; k++){
        //     System.out.print(postfix[k] + ", ");
        // }

        while(array.isEmpty() == false){
            String add2 = array.pop();
            postfix[post] = add2;
            post++;
        }

        return postfix;
    }

    public static String evaluate(String[] exp){
        Stack1 array = new Stack1 ();
        String infix = "";
        int len = 0;
        int j = 0;
        while(exp[j] != null){
            len++;
            j++;
        }
        int i = 0;
        while (i < len){
            // System.out.println(i);
            char ch = exp[i].charAt(0);
            if (isOp(ch) == 1){
                String a = array.pop ();
                String b = array.pop();
                infix = b + exp[i] + a;
                String res = calc(a, b, exp[i]);
                array.push(res);
                infix = "";
                i++;
            }
            else{
                array.push(exp[i]);
                i++;
            }
        }
        return array.ind(0);
    }

}

class Stack1{
    int MAX = 1000;
    String arr[] = new String[MAX];
    int top = 0;

    public void push(String data) {
        arr[top] = data;
        top++;
    }

    public String pop(){
        top--;
        String data = arr[top];
        arr[top] = null;
        return data;
    }

    public String top(){
        String data = arr[0];
        return data;
    }

    public boolean isEmpty(){
        boolean res;
        if (arr[0] == null){
            res = true;
        }
        else{
            res = false;
        }
        return res;
    }

    public void show() {
        int ind = 0;
        String n = arr[ind];

        while(n != null){
            System.out.print(arr[ind] + ", ");
            ind++;
            n = arr[ind];
        }
    }

    public String ind(int index){
        return arr[index];
    }
}