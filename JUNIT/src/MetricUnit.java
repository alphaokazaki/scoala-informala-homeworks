import java.util.Arrays;

/**
 * @author Alpha
 * Class - Metric units, defining them.
 */
public class MetricUnit {

    private static String[] KNOWN_UNITS = new String[]{"mm", "cm", "dm", "m", "km"};
    private double value;
    private String unit;

    public MetricUnit(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }


    /**@throws  IllegalArgumentException in case the string can't be converted to {@link MetricUnit}
     * @param string
     * @return metricUnit
     */
    public static MetricUnit fromString(String string) {

        if (string==null)
            throw new IllegalArgumentException("null string");

        String[] separated=string.split(" ");

        if(separated.length<2)
            throw new IllegalArgumentException("no unit or value");

        if(!separated[1].toLowerCase().equals("mm")&&!separated[1].toLowerCase().equals("cm")&&
                !separated[1].toLowerCase().equals("dm")&&!separated[1].toLowerCase().equals("m")&&
                !separated[1].toLowerCase().equals("km"))
            throw new IllegalArgumentException("not valid unit");

        MetricUnit metricUnit = new MetricUnit(Double.parseDouble(separated[0]),separated[1].toLowerCase());

        return metricUnit;
    }


    /**
     * Method that converts units
     * @param other
     * @return
     */
    public MetricUnit add(MetricUnit other) {
        if (other == null) {
            return this;
        }

        MetricUnit result = null;
        String targetUnit = null;
        if (unitIndex(this.getUnit()) > unitIndex(other.getUnit())) {
            targetUnit = other.getUnit();
        }else {
            targetUnit = this.getUnit();
        }

        double thisValue = convertTo(targetUnit);

        double thatValue = other.convertTo(targetUnit);

        result = new MetricUnit(thisValue + thatValue, targetUnit);

        return result;
    }

    /**
     * Method gets the index of the unit.
     * @param unit
     * @return the index of our unit
     */
    private int unitIndex(String unit) {
        return Arrays.asList(KNOWN_UNITS).indexOf(unit);
    }

    /**
     *Converting units using index
     * @param unit
     * @return converted value
     */
    private double convertTo(String unit) {

        return getValue() * Math.pow(10, unitIndex(this.getUnit()) - unitIndex(unit));
    }

    /**
     * Calculating an expression stored as string.
     * a=operator(+,-)
     * b=value of unit
     * c=unit type
     * @param expression
     *
     */
    public MetricUnit calculateExpression(String expression){
        String[] separatedExpression = expression.split(" ");
        int a=2,b=0,c=1;
        MetricUnit result= new MetricUnit(Double.parseDouble(separatedExpression[b]),separatedExpression[c]);
        b=3;
        c=4;
        while (a<separatedExpression.length-1){
            if(separatedExpression[a].equals("+"))
                result=result.add(new MetricUnit(Double.parseDouble(separatedExpression[b]),separatedExpression[c]));
            else
                result=result.add(new MetricUnit(-Double.parseDouble(separatedExpression[b]),separatedExpression[c]));
            a=a+3;
            b=b+3;
            c=c+3;
        }
        return result;
    }

    @Override
    public String toString() {
        return "MetricUnit{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
