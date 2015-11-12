package utfpr.edu.br.calcpolonesa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Stack;


public class Main extends Activity {
    private Stack<String> pilha = new Stack<String>();
    private EditText inp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.pilha = new Stack<String>();
        this.inp = (EditText) findViewById(R.id.inp);
    }

    private double calcularRPN (Stack<String> partes) throws Exception  {
        String tk = partes.pop();
        double x,y;

        try  {
            x = Double.parseDouble(tk);
        } catch (Exception e)  {
            y = this.calcularRPN(partes);
            x = this.calcularRPN(partes);

            if (tk.equals("+")) {
                x += y;
            } else if (tk.equals("-"))  {
                x -= y;
            } else if (tk.equals("*"))  {
                x *= y;
            } else if (tk.equals("/"))  {
                if (y == 0) {
                    // TODO: Mostrar modal erro
                } else {
                    x /= y;
                }
            } else {
                throw new Exception();
            }
        }
        return x;
    }

    public void adicionarPilha (View v) {
        switch (v.getId()) {
            case R.id.btn0:
                this.pilha.push("0");
                break;
            case R.id.btn1:
                this.pilha.push("1");
                break;
            case R.id.btn2:
                this.pilha.push("2");
                break;
            case R.id.btn3:
                this.pilha.push("3");
                break;
            case R.id.btn4:
                this.pilha.push("4");
                break;
            case R.id.btn5:
                this.pilha.push("5");
                break;
            case R.id.btn6:
                this.pilha.push("6");
                break;
            case R.id.btn7:
                this.pilha.push("7");
                break;
            case R.id.btn8:
                this.pilha.push("8");
                break;
            case R.id.btn9:
                this.pilha.push("9");
                break;
            case R.id.btnSoma:
                this.pilha.push("+");
                break;
            case R.id.btnSubtracao:
                this.pilha.push("-");
                break;
            case R.id.btnMultiplicacao:
                this.pilha.push("*");
                break;
            case R.id.btnDivisao:
                this.pilha.push("/");
                break;
        }

        String resultado = "";
        for (String elemento: this.pilha) {
            resultado += elemento;
        }
        this.inp.setText(resultado);
    }

    public void calcular (View v) throws Exception {
        double resultado = this.calcularRPN(this.pilha);
        inp.setText(String.valueOf(resultado));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
