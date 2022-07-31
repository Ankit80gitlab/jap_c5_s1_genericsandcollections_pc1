package com.jap.collectiondemo;

import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MobileStore {

    LinkedList<Mobile> mob;

    public MobileStore()
    {
        mob = new LinkedList<>();
    }


    int count=0;


    public List<Mobile> readMobileData(String fileName)
    {
        try
        {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);

            String str;
            int m=0;
            while((str=buffer.readLine()) != null)
            {
                if(m==0){
                    m++;
                    continue;
                }
                String [] arr = str.split(",");
                Mobile obj = new Mobile(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3],arr[4],arr[5],Integer.parseInt(arr[6]));
                mob.add(obj);// added mobile object into linked list
                count++;
            }
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
        }

        return mob; //returned mobile object
    }

    //Find phones of a particular brand.
    public List<Mobile> findPhoneByBrand(String brandName)
    {
        ListIterator li1 = mob.listIterator();
        LinkedList mob2 = new LinkedList<>();

        int k=0;
        while(li1.hasNext())
        {
            Mobile m = (Mobile)li1.next();
            if(m.getBrandName().equalsIgnoreCase(brandName))
            {
                mob2.add(m);
            }
        }
        return mob2;
    }

    //Find the phones whose cost is $500 and above.
    public List<Mobile> findPhoneCostMoreThan500$()
    {
        ListIterator li2 = mob.listIterator();
        LinkedList mob3 = new LinkedList<>();

        int k=0;
        while(li2.hasNext())
        {
            Mobile n = (Mobile)li2.next();
            if(n.getCost()>=500)
            {
                mob3.add(n);
            }
        }
        return mob3;
    }

    //Enlist the phones which have camera specification as 12 MP and more
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
        ListIterator li3 = mob.listIterator();
        LinkedList mob4 = new LinkedList<>();

        while(li3.hasNext())
        {
            Mobile n = (Mobile)li3.next();
            if(n.getCameraPixels()>12)
            {
                mob4.add(n);
            }
        }
        return mob4;
    }
}

