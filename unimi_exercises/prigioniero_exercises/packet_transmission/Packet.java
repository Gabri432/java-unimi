package unimi_exercises.prigioniero_exercises.packet_transmission;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * DESCRIPTION: This class will be part of a set of classes to replicate how 'Packet Transmission' works.
 * NOTE: For more details check https://en.wikipedia.org/wiki/Network_packet.
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/trasmissione_a_pacchetti_pacchetto/Testo.md
 * 
 */

public class Packet {
    
    public final int id, total, progressive;
    public final String text;

    public Packet(int id, int total, int progressive, String text) {
        this.id = id;
        this.total = total;
        this.progressive = progressive;
        this.text = text;
    }

    /**
     * Given a string, it will convert it to its relative Packet, provided with the adequate information.
     * @param packet a <code>string</code> containing information about a packet.
     * @return the corresponding packet.
     */
    public static Packet parsePacket(String packet) {
        int id = Integer.parseInt(packet.subSequence(0, 4).toString());
        int total = Integer.parseInt(packet.subSequence(5, 6).toString());
        int progressive = Integer.parseInt(packet.subSequence(7, 8).toString());
        String text = packet.substring(9);
        return new Packet(id, total, progressive, text);
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.total + "\t" + this.progressive + "\t" + this.text;
    }

    public static void main(String[] args) {
        try {
          File myObj = new File("./unimi_exercises/prigioniero_exercises/packet_transmission/packet.txt");
          Scanner myReader = new Scanner(myObj,  "UTF-8");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(parsePacket(data));
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("Could not find the file.");
          e.printStackTrace();
        }
      }
    
}
