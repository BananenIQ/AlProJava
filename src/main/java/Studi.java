import java.util.ArrayList;

public class Studi {
    private String name = null;
    private int alter = 0;
    private String matrikelnummer = null;
    private final ArrayList<Kurs> kurs = new ArrayList<Kurs>();

    public Studi(String name, int alter, String matrikelnummer){
        this.name = name;
        this.alter = alter;
        this.matrikelnummer = matrikelnummer;
    }
    public void print(){
        System.out.println("Name: " + this.name + ", Alter: " + this.alter + ", Matrikelnummer: " + this.matrikelnummer + "Kurse:" + kurs);
    }
    public void einschreiben(Kurs kurs){
        if(kurs.einschreiben()) {
            this.kurs.add(kurs);
        }else{
            System.out.println("Sorry " + this.name +  ", Kurs: " + kurs + " ist voll.");
        }
    }
    public void einschreiben(Kurs[] kurs){
        for(Kurs k : kurs) {
            if (k.einschreiben()) {
                this.kurs.add(k);
            } else {
                System.out.println("Sorry " + this.name + "," + k + " ist voll.");
            }
        }
    }

}
