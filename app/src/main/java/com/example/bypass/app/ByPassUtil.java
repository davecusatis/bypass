package com.example.bypass.app;


import java.util.Hashtable;

/**
 * Created by David on 5/12/2014.
 */
public class BypassUtil
{

    // ------------------------------------------------------
    // TODO: DO THIS BETTER
    public static final BarData[] bars = new BarData[] { new BarData("The Den", "Chief Keef Special appearance", 50), new BarData("The Phyrst",  "Bring yr friends fer 21st bday", 50),
                                                         new BarData("Saloon", "MOnkey boiz", 50), new BarData("Bar Bleu", "Fish Bowlz $5", 50), new BarData("Big Poppas Barhouse", "big poppas ipa", 50), new BarData("Sypeck's man cave", "sypeck", 50)};


    private static Hashtable<String, BarData> barTable = new Hashtable<String, BarData>();

    public static String[] availablePasses = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static void fillTable()
    {
        for(int i = 0; i < bars.length; i++)
        {
            barTable.put(bars[i].getName(), bars[i]);
        }
    }

    public static String[] getBarNames()
    {
        final int arraySize = bars.length;
        String[] barzNames = new String[arraySize];

        for(int i = 0; i < arraySize; i++)
        {
            barzNames[i] = bars[i].getName();
        }
        return barzNames;
    }
    //-----------------------------------------------------

    public static BarData getDataFromName(String name)
    {
        return barTable.get(name);
    }

    public static class BarData
    {
        String name;
        String specials;
        int numPasses;
        public BarData(String _name, String _specials, int _numPasses)
        {
            name = _name;
            specials = _specials;
            numPasses = _numPasses;
        }

        public void setName(String _name)
        {
            name = _name;
        }
        public void setSpecials(String _specials)
        {
            name = _specials;
        }

        public void setPasses(int _numPasses)
        {
            numPasses = _numPasses;
        }

        public final String getName()
        {
            return name;
        }

        public final String getSpecials()
        {
            return specials;
        }

        public final int getNumPasses()
        {
            return numPasses;
        }

        @Override
        public String toString()
        {
            return this.getName() + " - " + this.getSpecials();
        }
    }
}
