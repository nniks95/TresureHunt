import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Unesi koliko elemenata ima kovceg");
        int broj = s.nextInt();
        s.nextLine();
        String[] myTreasure = new String[broj];
        for(int i = 0 ; i<myTreasure.length;i++){
            System.out.println("Unesi item u kovceg");
            String st = s.nextLine();
            myTreasure[i] = st;
        }
        String spo = String.join("|",myTreasure);
        System.out.println(spo);

        String [] loot = myTreasure;


        while(true){
            System.out.println("""
                    You can choose between
                    Loot
                    Drop
                    Steal
                    If you type Yohoho, treasure hunt is over
                    """);
            System.out.print("Izaberi opciju");
            String st = s.nextLine().toLowerCase();
            switch(st){
                case "loot":
                    System.out.println("Unesi koliko elemenata ima chest");
                    int broj1 = s.nextInt();
                    s.nextLine();
                    String[] foundTreasure = new String[broj1];
                    for(int i = 0 ; i<foundTreasure.length;i++){
                        System.out.println("Unesi item u kovceg");
                        String str = s.nextLine();
                        foundTreasure[i] = str;
                    }
                    loot = loot(loot,foundTreasure);
                    String spojeniString1 = String.join("|", loot);
                    System.out.println(spojeniString1);
                    break;
                case "drop":
                    System.out.println("Unesi koji item zelis da izbacis na poslednju poziciju");
                    int br = s.nextInt();
                    s.nextLine();
                    drop(loot,br);
                    spojeniString1 = String.join("|",loot);
                    System.out.println(spojeniString1);
                    break;
                case "steal":
                    System.out.println("Koliko itema zelis da ukrades");
                    int br1 = s.nextInt();
                    s.nextLine();
                    loot = steal(br1,loot);
                    spojeniString1 = String.join("|", loot);
                    System.out.println(spojeniString1);
                    break;
                case "yohoho":
                    double zbir = 0;
                    for(int i = 0;i<loot.length;i++){
                        zbir += loot[i].length();
                    }
                    if(zbir ==0){
                        System.out.println("Failed Tresure Hunt");
                    }else{
                        double avarage = zbir/loot.length;
                        System.out.printf("Prosecan broj je : %.1f%n", avarage);
                        System.out.println("Treasure hunt is over");
                    }
                    return;
                default:
                    throw new IllegalStateException("Uneta pogresna opcija: " + st);
            }
        }




    }

    public static int brojac(String[] a,String[] b){
        int brojac = 0;
        for(int i = 0;i<b.length;i++){
            boolean nisuIsti = false;
            for(int j =0;j<a.length;j++){
                if(b[i].equalsIgnoreCase(a[j])){
                    nisuIsti = true;
                    break;
                }
            }
            if(!nisuIsti){
                brojac++;
            }
        }
        return brojac;
    }

    public static String[]loot(String[]a,String[]b) {
        int broj = brojac(a, b);
        String[] noviNiz = new String[broj + a.length];
        int pomocna = 0;

        for (int i = 0; i < b.length; i++) {
            boolean nisuIsti = false;
            for (int j = 0; j < a.length; j++) {
                if (b[i].equalsIgnoreCase(a[j])) {
                    nisuIsti = true;
                    break;
                }
            }
            if(!nisuIsti){
                noviNiz[pomocna] = b[i];
                pomocna++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            noviNiz[broj] = a[i];
            broj++;
        }
        return noviNiz;
    }

    public static void drop(String[] a,int indeks){
        if(indeks>= 0 && indeks<=a.length) {
            String temp = a[indeks];
            for (int i = indeks; i < a.length-1; i++) {
                a[i] = a[i+1];
            }
            a[a.length-1] = temp;
        }
    }

    public static String[] steal(int broj,String[]a){

        String [] niz3 = new String[0];

        if(a==null){
            return null;
        }

        if(broj> a.length){
            return null;
        }
        String[] niz = new String[a.length-broj];
        String[] niz2 = new String[broj];
        for(int i = 0;i < a.length-broj;i++){
            niz[i] = a[i];
        }
        int pomocna = 0;
        for(int i = a.length-1;i>=a.length-broj;i--){
            niz2[pomocna] = a[i];
            pomocna++;
        }
        for(String s : niz2){
            System.out.println("Ukradeno je : "+ s);
        }
        return niz;
    }



}