package com.example.admin.resistencia;

import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {
    private Spinner bprimera,bsegunda,btercera,bcuarta,bmagnitud,btolerancia;
    private TextView tResultado1,tResultado2;
    private EditText evalresistencia;
    private int prim=0,seg=0,ter=0,cuart=0,sufijo=0,postol=0,posmag=0,prim1=0,seg1=0,ter1=0;
    private String tolerance="", resultado2="0.0 Ω ± 1%", cresult;
    private Button b1,b2,b3,b4,b5,b6,b7,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bprimera= (Spinner) findViewById(R.id.bprimera);
        bsegunda= (Spinner) findViewById(R.id.bsegunda);
        btercera= (Spinner) findViewById(R.id.btercera);
        bcuarta= (Spinner) findViewById(R.id.bcuarta);
        bmagnitud= (Spinner) findViewById(R.id.bmagnitud);
        btolerancia= (Spinner) findViewById(R.id.btolerancia);
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);
        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);
        tResultado1= (TextView) findViewById(R.id.tresultaado1);
        tResultado2= (TextView) findViewById(R.id.tresultaado2);
        evalresistencia= (EditText) findViewById(R.id.evalresistencia);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colores, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bprimera.setAdapter(adapter);

        bprimera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 prim=i;
                 calcular(prim, seg,ter,cuart);
                 actualizar(prim,seg, ter,cuart);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.colores, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bsegunda.setAdapter(adapter1);

        bsegunda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                seg=i;
                calcular(prim, seg,ter,cuart);
                actualizar(prim,seg, ter,cuart);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.colorytol, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btercera.setAdapter(adapter2);

        btercera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ter=i;
                calcular(prim, seg,ter,cuart);
                actualizar(prim,seg, ter,cuart);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.tolerancia, android.R.layout.simple_spinner_item);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bcuarta.setAdapter(adapter3);

        bcuarta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cuart=i;
                calcular(prim, seg,ter,cuart);
                actualizar(prim,seg, ter,cuart);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.sufijos2, android.R.layout.simple_spinner_item);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bmagnitud.setAdapter(adapter4);

        bmagnitud.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                posmag=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.btolerancia, android.R.layout.simple_spinner_item);

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btolerancia.setAdapter(adapter5);

        btolerancia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                postol=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void calcular(int prim, int seg, int ter, int cuart){
        String result=String.valueOf(prim)+String.valueOf(seg);
       double  resultado=Double.parseDouble(result);
        switch (ter){
            case 0:{
                resultado*=1;
                break;
            }
            case 1:{
                resultado*=10;
                break;
            }
            case 2:{
                resultado*=100;
                break;
            }
            case 3:{
                resultado*=1000;
                break;
            }
            case 4:
            {
                resultado*=10000;
                break;
            }
            case 5:{
                resultado*=100000;
                break;
            }
            case 6:{
                resultado*=1000000;
                break;
            }
            case 7:{
                resultado*=10000000;
                break;
            }
            case 8:{
                resultado*=100000000;
                break;
            }
            case 9:{
                resultado*=1000000000;
                break;
            }
            case 10:{
                resultado/=10;
                break;
            }
            case 11:{
                resultado/=100;
            }

        }

        if(resultado<1000){
            sufijo=0;
        }

        if(resultado>=1000 && resultado<1000000){
            resultado/=1000;
            sufijo=1;
        }
        if(resultado>=1000000){
            resultado/=1000000;
            sufijo=2;
        }

        switch ((cuart+1)){
            case 1:{
                tolerance="± 1%";
                break;
            }
            case 2:{
                tolerance="± 2%";
                break;
            }
            case 3:{
                tolerance="± 5%";
                break;
            }
            case 4:{
                tolerance="± 10%";
                break;
            }

        }
        if(sufijo==0){
            tResultado1.setText("La combinación corresponde a: \n"+ resultado+"Ω "+ tolerance);
        }
        if(sufijo==1){
            tResultado1.setText("La combinación corresponde a: \n"+ resultado+"KΩ"+" "+ tolerance);
        }
        if(sufijo==2){
            tResultado1.setText("La combinación corresponde a: \n"+resultado+"MΩ"+ " "+ tolerance);
        }

    }

    public void calcularlo(View view) {
        int cont = 0, contpunto = 0, pospunto = -1;

        if (!evalresistencia.getText().toString().isEmpty()) {
            String tmp = evalresistencia.getText().toString();
            int length = tmp.length();
            for (int i = 0; i < length; i++) {
                if (tmp.charAt(i) == '.') {
                    length-=1;
                }
            }
            double valor=Double.parseDouble(tmp);


            if(valor>0 && valor<1){

                prim1=Integer.parseInt(String.valueOf(tmp.charAt(2)))+1;
                if(tmp.toString().length()>3 && tmp.charAt(3)!=0){
                    seg1=Integer.parseInt(String.valueOf(tmp.charAt(3)))+1;
                    if(posmag==1){
                        ter1=2;
                    }
                    if(posmag==0){
                        ter1=12;
                    }
                    if(posmag==2){
                        ter1=5;
                    }
                }
                   else{
                        seg1=1;
                    if(posmag==1){
                        ter1=2;
                    }
                    if(posmag==0){
                        ter1=12;
                    }
                    if(posmag==2){
                        ter1=5;
                    }
                }

            }
            if(valor>=1 && valor<10){
                prim1 =  Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                if(tmp.toString().length()>1){
                    seg1= Integer.parseInt(String.valueOf(tmp.charAt(2)))+1;
                }
                else{
                    seg1=1;
                }
                if(posmag==1){
                   ter1=3;
              }
              if(posmag==0){
                  ter1=11;
              }
              if(posmag==2){
                  ter1=6;
              }
            }
            if(valor>=10 && valor<100){

                prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                if(posmag==1){
                    ter1=4;
                }
                if(posmag==0){
                    ter1=1;
                }
                if(posmag==2){
                    ter1=7;
                }
            }

            if(valor>=100 && valor<1000){
                prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                if(posmag==1){
                    ter1=5;
                }
                if(posmag==0){
                    ter1=2;
                }
                if(posmag==2){
                    ter1=8;
                }


            }
            if(valor>=1000 && valor<10000){
                prim1=Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                if(posmag==1){
                    ter1=6;
                }
                if(posmag==0){
                    ter1=3;
                }
                if(posmag==2){
                    ter1=9;
                }
            }
            if(valor>=10000 && valor<100000){
                prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                if(posmag==1){
                    ter1=7;
                }
                if(posmag==0){
                    ter1=4;
                }
                if(posmag==2){
                    ter1=10;
                }
            }
            if(valor>=100000 && valor<1000000){
                prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                if(posmag==1){
                    ter1=8;
                }
                if(posmag==0){
                    ter1=5;
                }
                if(posmag==2){

                    tResultado2.setText("Existen inconsistencias. ");
                    ter1=1;

                }

                if(valor>=1000000 && valor<10000000){
                        prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                    seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                    if(posmag==1){
                        ter1=9;
                    }
                    if(posmag==0){
                        ter1=6;
                    }
                    if(posmag==2){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                }

                if(valor>=10000000 && valor<100000000){
                    prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0))+1);
                    seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                    if(posmag==1){
                        ter1=10;
                    }
                    if(posmag==0){
                        ter1=7;
                    }
                    if(posmag==2){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                }
                if(valor>=10000000 && valor<100000000){
                    prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                    seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                    if(posmag==1){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                    if(posmag==0){
                        ter1=8;
                    }
                    if(posmag==2){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                }
                if(valor>=100000000 && valor<1000000000){
                    prim1 = Integer.parseInt(String.valueOf(tmp.charAt(0)))+1;
                    seg1 = Integer.parseInt(String.valueOf(tmp.charAt(1)))+1;
                    if(posmag==1){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                    if(posmag==0){
                        ter1=9;
                    }
                    if(posmag==2){
                        tResultado2.setText("Existen inconsistencias.");
                        ter1=1;

                    }
                }


            }
            b5=cambiarcolor(5);
            b6=cambiarcolor(6);
            b7=cambiarcolor(7);
            b8=cambiarcolor(8);


        }
    }
    public void actualizar(int prim, int seg, int ter, int cuart) {

       b1= cambiarcolor(1);
       b2= cambiarcolor(2);
       b3= cambiarcolor(3);
       b4= cambiarcolor(4);
    }
    public Button cambiarcolor(int posbutton){
        Button b=b1;
        int pos=0;
        if(posbutton==1){
            b=b1;
            pos=prim;
        }
        if(posbutton==2){
            b=b2;
            pos=seg;
        }
        if(posbutton==3){
            b=b3;
            pos=ter;
        }
        if(posbutton==4){
            b=b4;
            pos=cuart;
        }
        if(posbutton==5){
            b=b5;
            pos=prim1-1;
        }

        if(posbutton==6){
            b=b6;
            pos=seg1-1;
        }
        if(posbutton==7){
            b=b7;
            pos=ter1-1;
        }
        if(posbutton==8){
            b=b8;
            pos=postol;
        }

        switch (pos){
            case 0:{
              if(posbutton!=4 && posbutton!=8){
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.black));
              }
              else{
                  b.setBackgroundColor(b.getContext().getResources().getColor(R.color.brown));
              }
                break;
            }
            case 1:{

                if(posbutton!=4 && posbutton!=8){
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.brown));
                }
                else{
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.red));

                }
                break;
            }
            case 2:{
                if(posbutton!=4 && posbutton!=8) {
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.red));
                }
                else{
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.lightgoldenrodyellow));

                }
                break;
            }
            case 3:{

                if(posbutton!=4 && posbutton!=8) {
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.orange));
                }
                else{
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.silver));

                }
                break;
            }
            case 4:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.yellow));
                break;
            }
            case 5:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.green));
                break;
            }
            case 6:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.blue));
                break;
            }
            case 7:{
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.purple));
                    break;
            }
            case 8:{
                    b.setBackgroundColor(b.getContext().getResources().getColor(R.color.gray));
                     break;
            }
            case 9:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.white));
                break;
            }
            case 10:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.lightgoldenrodyellow));
                break;
            }
            case 11:{
                b.setBackgroundColor(b.getContext().getResources().getColor(R.color.silver));

                break;
            }
        }
    return b;
    }


}
