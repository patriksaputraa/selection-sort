package com.javafx;

public class Selection {
    private int[] data;
    private int jumlah;
    private String proses;

    public Selection(int size){
        this.data = new int[size];
        this.jumlah = 0;
    }

    public void addData(int value){
        if(this.jumlah<data.length){
            this.data[this.jumlah++] = value;
        }else{
            System.out.println("Array FULL");
        }
    }

    public void removeData(){
        if(this.jumlah>0){
            this.data[--this.jumlah] = 0;
        }else{
            System.out.println("KOSONG");
        }
    }

    public int getJumlah(){
        return this.jumlah;
    }

    public int getMaxElement(){
        return this.data.length;
    }
    public String getData(){
        String result = "";
        for(int idx=0;idx<this.jumlah;idx++){
            result += data[idx] + " ";
        }
        return result;
    }

    public void selectionSort(){
        this.proses = "Data Awal: " + this.getData() + "\n";
        
        this.proses += "pivot\tidx.min\tvalue\tarray -->" + this.getData() + "\n";
        int cari, pivot, min, titip, byk=this.getJumlah();
        for(pivot=0;pivot<byk;pivot++){
            min = pivot;
            for(cari=pivot+1;cari<byk;cari++){
                if(data[cari]<data[min]){
                    min = cari;
                }
            }
            this.proses += "   " + pivot + "\t\t    " + min + "\t\t   " + data[min] + "\t\t" + "array -->" + this.getData() + "\n";
            titip = data[pivot];
            data[pivot] = data[min];
            data[min] = titip;
        }
        this.proses += "Data Akhir: " + this.getData() + "\n";
    }

    public String getProses(){
        return this.proses;
    }
}

