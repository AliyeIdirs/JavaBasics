package com.unitedcoder.classconcepts.package1;

public class Alpha {
    public static void main(String[] args) {
        Alpha alpha= new Alpha();
        alpha.age=25;
    }
    private String alphaInfo;
    public String alphaVersion;

    int year;

    protected int age;
    protected void getAge(){
        System.out.println(age);
    }
    void  getYear(){
        System.out.println(year);
    }
    public Alpha() {
    }

    public Alpha(String alphaInfo) {
        this.alphaInfo = alphaInfo;
    }

    public String getAlphaInfo() {
        return alphaInfo;
    }

    private void setAlphaInfo(String alphaInfo) {
        this.alphaInfo = alphaInfo;
    }

    public void set(String alphaInfo){
        setAlphaInfo(alphaInfo);
    }
}
