package com.tw;

public class MultiplicationTable {
    public String create(int start, int end)
    {
        if(this.isValid(start , end))
            return this.generateTable(start , end);
        return null;
    }

    public Boolean isValid(int start, int end)
    {
        return isInRange(start) && isInRange(end) && isStartNotBiggerThanEnd(start , end);
    }

    public Boolean isInRange(int number)
    {
        return number >= 1 && number <=1000;
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end)
    {
        return end >= start;
    }

    public String generateTable(int start, int end)
    {
        String result = new String();

        for(int row = start ; row <= end ; row++)
        {
            result += this.generateLine(start, row);
            if(row != end)
                result += "\r\n";
        }

        return result;

    }

    public String generateLine(int start, int row)
    {
        String result = new String();
        boolean first = true;
        for(int i = start ; i <= row ; i++)
        {
            if(!first)
                result += "  ";

            result += this.generateSingleExpression(i , row);
            first = false;

        }
        return result;
    }

    public String generateSingleExpression(int multiplicand, int multiplier)
    {
        int result = multiplicand * multiplier;
        return String.format("%d*%d=%d" , multiplicand , multiplier , result);
    }
}
