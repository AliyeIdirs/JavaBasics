package com.unitedcoder.commandline;

import org.apache.commons.cli.*;

public class CommandArgumentDemo {
    public static void main(String[] args) {
        //Create command line Options object
        Options options= new Options();
        //Create Option
        Option base=new Option("n","number",true,"the base number");
        base.setRequired(true);
        options.addOption(base);
        //Create Option parameter p
        Option power=new Option("p","power value",true,"exponent");
        power.setRequired(true);
        options.addOption(power);

        //Create command line parser
        CommandLineParser parser=new DefaultParser();
        HelpFormatter formatter=new HelpFormatter();
        CommandLine terminal;
        try{
            terminal=parser.parse(options,args);
        }
        catch(ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("command -options", options);
            System.exit(1);
            return;
        }
            double baseNumber=Double.parseDouble(terminal.getOptionValue("n"));
            double powerValue=Double.parseDouble(terminal.getOptionValue("p"));
            System.out.println("Base number is: " +baseNumber+ " Power value is: "+powerValue);
            double finalResult=Math.pow(baseNumber,powerValue);
            System.out.println(baseNumber + " to the power of "+ powerValue +" = " +finalResult);
    }
}
