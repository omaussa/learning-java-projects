package TemperatureConverter;

import java.util.Iterator;
import java.util.Locale;

public class TemperatureConverter {

    // args temperatureValue temperatureUnit unitToConvert
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("ERROR: should use converter <value> <temp_unit> <unit_to_convert>");
            System.exit(-1);
        }
        try {
            double temperature = Double.parseDouble(args[0]);
            String initialUnit = args[1].toLowerCase();
            String targetUnit = args[2].toLowerCase();
            if (!validateUnit(initialUnit)) {
                throw new Exception("ERROR: Invalid unit " + initialUnit);
            }
            if (!validateUnit(targetUnit)) {
                throw new Exception("ERROR: Invalid unit " + targetUnit);
            }
            double output = temperature;
            switch (initialUnit) {
                case "c":
                    if (targetUnit.equals("f")) {
                        output = convertCToF(temperature);
                    } else if (targetUnit.equals("k")) {
                        output = convertCToK(temperature);
                    }
                    break;
                case "f":
                    if (targetUnit.equals("c")) {
                        output = convertFToC(temperature);
                    } else if (targetUnit.equals("k")) {
                        output = convertFToC(temperature);
                        output = convertCToK(output);
                    }
                    break;
                case "k":
                    if (targetUnit.equals("c")) {
                        output = convertKToC(temperature);
                    } else if (targetUnit.equals("f")) {
                        output = convertKToC(temperature);
                        output = convertCToF(output);
                    }
                    break;
            }
            System.out.println(String.valueOf(temperature) + "°" + initialUnit.toUpperCase() + " -> " + String.valueOf(output) + "°" + targetUnit.toUpperCase());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: first argument must be a number");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    // validate temperature units, only allow C, F and K
    static boolean validateUnit(String unit) {
        return unit.equals("c")|| unit.equals("f") || unit.equals("k");
    }

    // convert F to C
    static double convertFToC(double f) {
        return (f-32)*(5/9);
    }
    // convert C to F
    static double convertCToF(double c) {
        return (c*9/5) + 32;
    }
    // convert C to K
    static double convertCToK(double c) {
        return c + 273.15;
    }
    // convert K to C
    static double convertKToC(double k) {
        return k - 273.15;
    }
}
