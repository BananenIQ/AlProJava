public class Kurs {
    private String name = null;
    private String nummer = null;
    private int eingeschrieben = 0;
    private int maxEingeschrieben = 0;

    public Kurs(String name, String nummer, int maxEingeschrieben){
        this.name = name;
        this.nummer = nummer;
        this.maxEingeschrieben = maxEingeschrieben;
    }
    public void print(){
        System.out.println("Kurs: " + this.name + ", mit der Nummer: " + this.nummer);
    }

    @Override
    public String toString() {
        return "Kurs=" + name + " -> Nummer=" + nummer;
    }
    public boolean einschreiben(){
        if(maxEingeschrieben >= eingeschrieben){
            eingeschrieben++;
            return true;
        }else{
            return false;
        }
    }
}
