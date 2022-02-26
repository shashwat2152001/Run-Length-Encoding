import java.util.Scanner;

public class RleProgram {

    //Translates data (RLE or raw) a hexadecimal string (without delimiters). This method can also aid debugging.
    public static String toHexString(byte[] data) {


        String hex = "";
        for(int i = 0; i < data.length; i++){

            if ((int)data[i] == 10){
                hex += "a";
                continue;
            }
            else if ((int)data[i] == 11){
                hex += "b";
                continue;
            }
            else if ((int)data[i] == 12){
                hex += "c";
                continue;
            }
            else if ((int)data[i] == 13){
                hex += "d";
                continue;
            }
            else if ((int)data[i] == 14){
                hex += "e";
                continue;
            }
            else if ((int)data[i] == 15){
                hex += "f";
                continue;
            }
            hex += data[i];
//taking values above 9 in decimal and converting to hex value and adding to string "hex"
        }




return hex;
    }

    //Returns number of runs of data in an image data set; double this result for length of encoded (RLE) byte array.
    public static int countRuns(byte[] flatData){

        int runs=1;
        int more = 1;

        for (int i = 1; i<flatData.length; i++){

            if (flatData[i-1] != flatData[i]){
                runs++;

            }
            else {
                more++;
            }
            if(more > 15){
                more = 1;
                runs++;
            }

        }

return runs;
    }

    //Returns encoding (in RLE) of the raw data passed in; used to generate RLE representation of a data.
    public static byte[] encodeRle(byte[] flatData) {

        int number = 1;

        byte[] encoding = new byte[countRuns(flatData)*2];
        //length would be equal to countRuns method * 2
        int index = 0;


        for (int i = 1; i < flatData.length; i++) {


            if (flatData[i - 1] == flatData[i]) {
                number++;
                if(number % 15 == 0){
                    encoding[index] = (byte) number;
                    encoding[index + 1] = flatData[i - 1];
                    index += 2;
                    number = 0;
                }
            }
            else{
                encoding[index] = (byte) number;
                encoding[index + 1] = flatData[i - 1];
                index += 2;
                number = 1;

            }
        }
        encoding[index] = (byte) number;
        encoding[index+1] = flatData[flatData.length-1];
        //makes sure the last 2 things in the array get accounted for
            return encoding;

    }

    //Returns decompressed size RLE data; used to generate flat data from RLE encoding. (Counterpart to #2)
    public static int getDecodedLength(byte[] rleData){
        int counter = 0;
        for (int i = 1; i<rleData.length; i++){
            if (i % 2 != 0){
                counter += rleData[i-1];
            }
        }

        return counter;


    }

    //Returns the decoded data set from RLE encoded data. This decompresses RLE data for use. (Inverse of #3)
    public static byte[] decodeRle(byte[] rleData){

        byte[] newArray = new byte[getDecodedLength(rleData)];
        int number = 0;


        for (int i =0;i<rleData.length;i+=2){
            for (int a=0;a< rleData[i];a++){
                newArray[number] = rleData[i+1];
                number++;
            }
        }

        //I thought the below code was an interesting way to solve but idk why it didn't work
        /*for (int i = 1; i<rleData.length; i++){
            if(i-1 % 2 == 0){
                number = rleData[i-1];
                for (a = i-1; a<number; a++){
                    newArray[a] = rleData[i];
                }
            }
        }
        newArray[a] = rleData[number];
        newArray[a+1] = rleData[rleData.length-1];*/




        return newArray;
    }

    //Translates a string in hexadecimal format into byte data (can be raw or RLE). (Inverse of #1)
    public static byte[] stringToData(String dataString){

        byte[] data = new byte[dataString.length()];
        int index = 0;
        for (int i = 1; i<=dataString.length(); i++) {

            switch (dataString.charAt(i-1)) {
//utilized method logic from numConversion lab
                case '1':
                    data[i-1] = 1;
                    break;
                case '2':
                    data[i-1] = 2;
                    break;
                case '3':
                    data[i-1] = 3;
                    break;
                case '4':
                    data[i-1] = 4;
                    break;
                case '5':
                    data[i-1] = 5;
                    break;
                case '6':
                    data[i-1] = 6;
                    break;
                case '7':
                    data[i-1] = 7;
                    break;
                case '8':
                    data[i-1] = 8;
                    break;
                case '9':
                    data[i-1] = 9;
                    break;
                case 'A':
                    data[i-1] = 10;
                    break;
                case 'B':
                    data[i-1] = 11;
                    break;
                case 'C':
                    data[i-1] = 12;
                    break;
                case 'D':
                    data[i-1] = 13;
                    break;
                case 'E':
                    data[i-1] = 14;
                    break;
                case 'F':
                    data[i-1] = 15;
                    break;
                case '0':
                    data[i-1] = 0;
                    break;
                case 'a':
                    data[i-1] = 10;
                    break;
                case 'b':
                    data[i-1] = 11;
                    break;
                case 'c':
                    data[i-1] = 12;
                    break;
                case 'd':
                    data[i-1] = 13;
                    break;
                case 'e':
                    data[i-1] = 14;
                    break;
                case 'f':
                    data[i-1] = 15;
                    break;


            }
            if(i>15){
                switch (dataString.charAt(i-1)) {
//utilized method logic from numConversion lab
                    case '1':
                        data[i-1] = 1;
                        break;
                    case '2':
                        data[i-1] = 2;
                        break;
                    case '3':
                        data[i-1] = 3;
                        break;
                    case '4':
                        data[i-1] = 4;
                        break;
                    case '5':
                        data[i-1] = 5;
                        break;
                    case '6':
                        data[i-1] = 6;
                        break;
                    case '7':
                        data[i-1] = 7;
                        break;
                    case '8':
                        data[i-1] = 8;
                        break;
                    case '9':
                        data[i-1] = 9;
                        break;
                    case 'A':
                        data[i-1] = 10;
                        break;
                    case 'B':
                        data[i-1] = 11;
                        break;
                    case 'C':
                        data[i-1] = 12;
                        break;
                    case 'D':
                        data[i-1] = 13;
                        break;
                    case 'E':
                        data[i-1] = 14;
                        break;
                    case 'F':
                        data[i-1] = 15;
                        break;
                    case '0':
                        data[i-1] = 0;
                        break;
                    case 'a':
                        data[i-1] = 10;
                        break;
                    case 'b':
                        data[i-1] = 11;
                        break;
                    case 'c':
                        data[i-1] = 12;
                        break;
                    case 'd':
                        data[i-1] = 13;
                        break;
                    case 'e':
                        data[i-1] = 14;
                        break;
                    case 'f':
                        data[i-1] = 15;
                        break;


                }

            }
        }

        return data;
    }

    /*Translates RLE data into a human-readable representation. For each run, in order, it should display the run
    length in decimal (1-2 digits); the run value in hexadecimal (1 digit); and a delimiter, ‘:’, between runs. */
    public static String toRleString(byte[] rleData){

        String hex = "";
        for (int i = 0; i<rleData.length;i++){

            if (i % 2 == 0){
                hex += rleData[i];

                if ((int)rleData[i+1] == 10){
                    hex += "a";
                }
                else if ((int)rleData[i+1] == 11){
                    hex += "b";
                }
                else if ((int)rleData[i+1] == 12){
                    hex += "c";
                }
                else if ((int)rleData[i+1] == 13){
                    hex += "d";
                }
                else if ((int)rleData[i+1] == 14){
                    hex += "e";
                }
                else if ((int)rleData[i+1] == 15){
                    hex += "f";
                }
                else {
                    hex += rleData[i+1];
                }
                if (rleData.length - i != 2) {
                    hex += ":";
                }
            }
//taking every odd index and converting from decimal to hex for the even index that follows
        }
return hex;
    }

    //Translates a string in human-readable RLE format (with delimiters) into RLE byte data. (Inverse of #7)
    public static byte[] stringToRle(String rleString){


        int count = 0;

        for(int i=0; i < rleString.length(); i++) {
            {
                if (rleString.charAt(i) == ':')
                    count++;
            }
        }
       int size = (2*count) + 2;


        byte[] rle = new byte[size];



        int place = 0;
        String semi = "";
        rleString += ":";
//this solution definitely is not optimal... I would have liked to use substrings instead
        for (int i = 0; i<rleString.length(); i++){
            if (rleString.charAt(i) != ':') {
                semi = semi + rleString.charAt(i);
            }
            else {
                if (semi.length() == 3) {

                    switch (semi.charAt(1)) {
                        case '0':
                            rle[place] = (byte) 10;
                            break;
                        case '1':
                            rle[place] = (byte) 11;
                            break;
                        case '2':
                            rle[place] = (byte) 12;
                            break;
                        case '3':
                            rle[place] = (byte) 13;
                            break;
                        case '4':
                            rle[place] = (byte) 14;
                            break;
                        default:
                            rle[place] = (byte) 15;
                    }
                    place++;
                }
//essentially adding bytes to array dependent on whether there are 3 or 2 numbers before each colon
                else { //length 2
                  switch (semi.charAt(0)){
                        case '1':
                            rle[place] = (byte) 1;
                            break;
                        case '2':
                            rle[place] = (byte) 2;
                            break;
                        case '3':
                            rle[place] = (byte) 3;
                            break;
                        case '4':
                            rle[place] = (byte) 4;
                            break;
                        case '5':
                            rle[place] = (byte) 5;
                            break;
                        case '6':
                            rle[place] = (byte) 6;
                            break;
                        case '7':
                            rle[place] = (byte) 7;
                            break;
                        case '8':
                            rle[place] = (byte) 8;
                            break;
                        default:
                            rle[place] = (byte) 9;
                    }
                    place++;
                }
                switch (semi.charAt(semi.length()-1)){
                    case '0':
                        rle[place] = (byte) 0;
                        break;
                    case '1':
                        rle[place] = (byte) 1;
                        break;
                    case '2':
                        rle[place] = (byte) 2;
                        break;
                    case '3':
                        rle[place] = (byte) 3;
                        break;
                    case '4':
                        rle[place] = (byte) 4;
                        break;
                    case '5':
                        rle[place] = (byte) 5;
                        break;
                    case '6':
                        rle[place] = (byte) 6;
                        break;
                    case '7':
                        rle[place] = (byte) 7;
                        break;
                    case '8':
                        rle[place] = (byte) 8;
                        break;
                    case '9':
                        rle[place] = (byte) 9;
                        break;
                    case 'a':
                        rle[place] = (byte) 10;
                        break;
                    case 'b':
                        rle[place] = (byte) 11;
                        break;
                    case 'c':
                        rle[place] = (byte) 12;
                        break;
                    case 'd':
                        rle[place] = (byte) 13;
                        break;
                    case 'e':
                        rle[place] = (byte) 14;
                        break;
                    default:
                        rle[place] = (byte) 15;
                }
                place++;
                semi = "";
            }
        }



        return rle;
    }






    public static void main(String[] args) {

        boolean status = true;


        // 1. Display Welcome Message
        System.out.println("Welcome to the RLE image encoder!");
        System.out.println("\nDisplaying Spectrum Image:");

        // 2. Display color test with the message
            ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        byte[] imageData = null; // it's like int playerHandValue = 0;

        // 3. Display Menu (either use while loop or if-else chains)
        Scanner input = new Scanner(System.in);

while (true) {

    System.out.println("RLE Menu");
    System.out.println("--------");
    System.out.println("0. Exit");
    System.out.println("1. Load File");
    System.out.println("2. Load Test Image");
    System.out.println("3. Read RLE String");
    System.out.println("4. Read RLE Hex String");
    System.out.println("5. Read Data Hex String");
    System.out.println("6. Display Image");
    System.out.println("7. Display RLE String");
    System.out.println("8. Display Hex RLE Data");
    System.out.println("9. Display Hex Flat Data");
    System.out.print("\nSelect a Menu Option: ");



    int choice = input.nextInt();


    if (choice == 1){

        // load file using ConsoleGFX.loadFile(userInput); and stores the return byte array into the imageData

        System.out.print("Enter name of file to load: ");
        String userInput = input.next();
        imageData = ConsoleGfx.loadFile(userInput);
        System.out.println();

    } //works perfectly
    else if (choice == 2){

        // stores ConsoleGFX.testImage to the imageData array

//        ConsoleGfx.displayImage(ConsoleGfx.testImage);
        imageData = ConsoleGfx.testImage;
        System.out.println("Test image data loaded.\n");

    } //works perfectly
    else if (choice == 3){
        System.out.print("Enter an RLE string to be decoded: ");
        String userInput = input.next();
        imageData = decodeRle(stringToRle(userInput));
        System.out.println();

    } //works perfectly
    else if (choice == 4){
        System.out.print("Enter the hex string holding RLE data: ");
        String userInput = input.next();
        imageData = decodeRle(stringToData(userInput));
    } //works perfectly
    else if (choice == 5){
        System.out.print("Enter the hex string holding flat data: ");
        String userInput = input.next();
        imageData = decodeRle(encodeRle(stringToData(userInput)));

    } //works perfectly
    else if (choice == 6){


        // displays image stored inside imageData array
        System.out.println("Displaying image...");
        ConsoleGfx.displayImage(imageData);
        System.out.println();

    } //works perfectly
    else if (choice == 7){
        System.out.println("RLE representation: " + (toRleString(encodeRle(imageData))));
    } //adding an extra "00:00:00" meaning there's an issue with toRleString
    else if (choice == 8){
        System.out.println("RLE hex values: " + (toHexString(encodeRle(imageData))));

    } //also adding a bunch of extra zeroes meaning issue with toHexString
    else if (choice == 9){

        System.out.println("Flat hex values: " + (toHexString(decodeRle(imageData))));


    } //also adding a bunch of zeroes (issue with toHexString)
    else if (choice == 0){
        break;

    }



}









            // user might first enter 1->6 or 2->6

            // complete all the other options later

        //4. Prompt for user input
    }

}
