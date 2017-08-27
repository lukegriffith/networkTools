package co.uk.lukemgriffith;

import com.sun.deploy.util.StringUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by luke on 27/08/2017.
 */

public class tools {

    static String convertCIDR (int notation)
    {

        int remain = 32 - notation;

        String ones = String.join("", Collections.nCopies(notation, "1"));

        String zeroes = String.join( "", Collections.nCopies(remain, "0"));

        String bitString = String.join( "", ones, zeroes);

        Collection<Integer> octets = new ArrayList<Integer>();
        Integer placeValue = 0;
        Integer octet = 0;

        for (int x = 0; x < 32; x++)
        {
            octet = octet + ((int)bitString.charAt(x) - '0') * (int)Math.pow(2,placeValue);

            placeValue++;

            if ( (x + 1) % 8 == 0 )
            {
                placeValue = 0;
                octets.add(octet);
                octet = 0;
            }
        }

        return octets.stream().map(Object::toString)
                    .collect(Collectors.joining("."));


    }
}
