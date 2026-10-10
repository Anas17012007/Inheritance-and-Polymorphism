public class Main {
    public static void main(String[] args) {
       
        BujurSangkar bs = new BujurSangkar(5, "merah");
        bs.printInfo();

        
        Lingkaran l = new Lingkaran(7, "biru");
        l.printInfo();

        Silinder s = new Silinder(10, 7, "hijau");
        s.printInfo();
    }
}