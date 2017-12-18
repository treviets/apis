package net.cd.common.util;

import java.math.BigDecimal;

public class FigureUtil {
    /**
     *
     * @param p periodic payment/ present value
     * @param r rate of return
     * @param n number of periods
     * @return
     */
    public static BigDecimal PV(double p, double r, int n){
        if(r == 0)
            return new BigDecimal(p * n);
        if (n == 0)
            return  new BigDecimal(0);
         double rr = Math.pow(1 + r, n);
         return new BigDecimal(p/r).multiply(new BigDecimal(1-1/rr)).multiply(new BigDecimal(1+r)).abs();
    }

}
