package com.unitedcoder.classconcepts.package1;

public class Beta {
    public static void main(String[] args) {
        Alpha alpha= new Alpha();

        alpha.alphaVersion="2.0";
        alpha.set("Alpha1");
        System.out.println(alpha.getAlphaInfo());
        alpha.year=2023;
        alpha.getYear();
        alpha.getAge();

    }
    private  String betaVersion;

    public Beta() {
    }

    public Beta(String betaVersion) {
        this.betaVersion = betaVersion;
    }

    public String getBetaVersion() {
        return betaVersion;
    }

    public void setBetaVersion(String betaVersion) {
        this.betaVersion = betaVersion;
    }
}
