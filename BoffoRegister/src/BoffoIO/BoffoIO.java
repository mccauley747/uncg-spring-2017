package boffoio;

/**
 *
 * @author sjwhyatt
 */
import java.util.Scanner;

public class BoffoIO {

    protected Scanner input;

    public int scanBarcode(){
        int barcode = input.nextInt();
        return barcode;
    }
}
