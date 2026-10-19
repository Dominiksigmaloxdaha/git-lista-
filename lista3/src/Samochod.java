public class Samochod {
    private String marka;
    private String model;
    private int rok_produkcji;
    private int predkosc;

    public Samochod(String marka, String model, int rok_produkcji, int predkosc) {
        this.marka = marka;
        this.model = model;
        this.rok_produkcji = rok_produkcji;
        this.predkosc = 0;
    }
    public void przyspiesz(int wartosc) {
        if (wartosc > 0) {
            this.predkosc += wartosc;
        }
    }
        public void hamuj(int hamowanie) {
            if (hamowanie > 0) {
                this.predkosc -= hamowanie;
            }
    }
    public void pokazInfo() {
            System.out.println(marka + "Toyota" + model + " " + rok_produkcji + " " + predkosc);
        }
    public static void main(String[] args) {
        Samochod autoPierwsze = new Samochod("Toyota", "Corolla", 2022, 0);
        autoPierwsze.przyspiesz(50);
        autoPierwsze.hamuj(20);
        autoPierwsze.pokazInfo();
    }


    }
