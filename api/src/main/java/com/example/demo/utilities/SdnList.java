package com.example.demo.utilities;

import java.io.*;

public class SdnList {
	public boolean findReceiverName(String recievername)throws Exception{
        boolean nameExsits=false;
        String inputFileName="src/main/resources/sdnlist.txt";
        FileReader fileReader=new FileReader(inputFileName);
        BufferedReader bufferReader=new BufferedReader(fileReader);
        String recievername1;
        while((recievername1=bufferReader.readLine())!=null)
        {
            recievername1=recievername1.toUpperCase();
            if(recievername1.contains(recievername.toUpperCase()))
            {
                nameExsits=true;
                fileReader.close();
                bufferReader.close();
                return nameExsits;
                
            }
        }
        
        fileReader.close();
        bufferReader.close();
        return nameExsits;
        
        
        
    }
}
