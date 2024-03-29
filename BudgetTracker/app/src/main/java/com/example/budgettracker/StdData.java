package com.example.budgettracker;

public class StdData {
    public int id;
    public int amount;
    public String type;
    public String category;
    public String mode;
    public String note;

    public StdData() {
    }

    public StdData(int amount,int id,String type,String category,String mode,String note) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.mode = mode;
        this.note = note;
    }

}
