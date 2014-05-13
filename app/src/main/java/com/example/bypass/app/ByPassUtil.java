package com.example.bypass.app;

/**
 * Created by David on 5/12/2014.
 */
public class ByPassUtil {

    private class BarData
    {
        String name;
        String specials;

        public BarData(String _name, String _specials)
        {
            name = _name;
            specials = _specials;
        }

        public void setName(String _name)
        {
            name = _name;
        }
        public void setSpecials(String _specials)
        {
            name = _specials;
        }

        public final String getName()
        {
            return name;
        }

        public final String getSpecials()
        {
            return specials;
        }

        @Override
        public String toString()
        {
            return this.getName() + " - " + this.getSpecials();
        }
    }
}
