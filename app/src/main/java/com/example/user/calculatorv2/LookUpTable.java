package com.example.user.calculatorv2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 2016-02-22.
 */
public class LookUpTable {
    private static final int MAX_ITEMS = 128;

    private double[] 	items;
    private int			size;

    private String atantable = "0.7853981633974483\n" +
            "0.4636476090008061\n" +
            "0.24497866312686414\n" +
            "0.12435499454676144\n" +
            "0.06241880999595735\n" +
            "0.031239833430268277\n" +
            "0.015623728620476831\n" +
            "0.007812341060101111\n" +
            "0.0039062301319669718\n" +
            "0.0019531225164788188\n" +
            "9.765621895593195E-4\n" +
            "4.882812111948983E-4\n" +
            "2.4414062014936177E-4\n" +
            "1.2207031189367021E-4\n" +
            "6.103515617420877E-5\n" +
            "3.0517578115526096E-5\n" +
            "1.5258789061315762E-5\n" +
            "7.62939453110197E-6\n" +
            "3.814697265606496E-6\n" +
            "1.907348632810187E-6\n" +
            "9.536743164059608E-7\n" +
            "4.7683715820308884E-7\n" +
            "2.3841857910155797E-7\n" +
            "1.1920928955078068E-7\n" +
            "5.960464477539055E-8\n" +
            "2.9802322387695303E-8\n" +
            "1.4901161193847655E-8\n" +
            "7.450580596923828E-9\n" +
            "3.725290298461914E-9\n" +
            "1.862645149230957E-9\n" +
            "9.313225746154785E-10\n" +
            "4.6566128730773926E-10\n" +
            "2.3283064365386963E-10\n" +
            "1.1641532182693481E-10\n" +
            "5.820766091346741E-11\n" +
            "2.9103830456733704E-11\n" +
            "1.4551915228366852E-11\n" +
            "7.275957614183426E-12\n" +
            "3.637978807091713E-12\n" +
            "1.8189894035458565E-12\n" +
            "9.094947017729282E-13\n" +
            "4.547473508864641E-13\n" +
            "2.2737367544323206E-13\n" +
            "1.1368683772161603E-13\n" +
            "5.6843418860808015E-14\n" +
            "2.8421709430404007E-14\n" +
            "1.4210854715202004E-14\n" +
            "7.105427357601002E-15\n" +
            "3.552713678800501E-15\n" +
            "1.7763568394002505E-15";

    private String kTable = "0.7071067811865475\n" +
            "0.6324555320336758\n" +
            "0.6135719910778963\n" +
            "0.6088339125177524\n" +
            "0.6076482562561683\n" +
            "0.607351770141296\n" +
            "0.6072776440935261\n" +
            "0.6072591122988928\n" +
            "0.6072544793325625\n" +
            "0.6072533210898753\n" +
            "0.6072530315291345\n" +
            "0.607252959138945\n" +
            "0.6072529410413973\n" +
            "0.6072529365170103\n" +
            "0.6072529353859135\n" +
            "0.6072529351031394\n" +
            "0.6072529350324458\n" +
            "0.6072529350147724\n" +
            "0.607252935010354\n" +
            "0.6072529350092495\n" +
            "0.6072529350089734\n" +
            "0.6072529350089043\n" +
            "0.6072529350088871\n" +
            "0.6072529350088828\n" +
            "0.6072529350088817\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814\n" +
            "0.6072529350088814";



    public LookUpTable(String type) {
        items = new double[MAX_ITEMS];
        String linesAT[] = atantable.split("\\r?\\n");
        int sizeAT = linesAT.length;
        String linesKT[] = kTable.split("\\r?\\n");
        int sizeKT = linesKT.length;


        if (type.equals("at")){

            for(int i = 0; i<linesAT.length; i++){

                items[i] = Double.parseDouble(linesAT[i]);
            }
        }
        else if (type.equals("kt")){


            for(int i = 0; i<linesKT.length; i++){

                items[i] = Double.parseDouble(linesKT[i]);
            }
        }
        if (sizeAT<sizeKT)
            size = sizeAT;
        else
            size = sizeKT;
    }

    // Returns the element at index i in the table.
    public double get(int i) {

        if (i > (size-1)) {
            System.err.println("Error: index for lookup table too large.");
            return 0;

        }
        return items[i];
    }

    // Returns the number of elements stored within the table.
    public int getSize() {

        return size;

    }


}