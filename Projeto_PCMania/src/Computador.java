public class Computador {
    float preco;
    class ComputadorNew {
        String marca;
        public ComputadorNew(String marca) {
            this.marca = marca;
        }
        public String getMarca() {
            return this.marca;
        }
    }
    void mostraPCConfigs() {

        System.out.println("\nPromoção 1:");
        //Computador 01:
        ComputadorNew pc1 = new ComputadorNew("Positivo");
        String marca1 = pc1.getMarca();
        System.out.println("\nMarca: " + marca1);

        //Hardware Básico - processador:
        HardwareBasico pro1 = new HardwareBasico("Pentium Core i3 ", 1200);
        String processador1 = pro1.getNome();
        float mhz1 = pro1.getCapacidade();
        System.out.println(processador1 + " (" + mhz1 + " Mhz)");

        //Hardware Básico - Memoria RAM:
        HardwareBasico ram1 = new HardwareBasico("Memoria RAM", 4);
        String memoria1 = ram1.getNome();
        float gb1 = ram1.getCapacidade();
        System.out.println(gb1 + " Gb de " + memoria1);

        //Hardware Básico - HD:
        HardwareBasico hd1 = new HardwareBasico("HD", 500);
        String hard_disk1 = hd1.getNome();
        float capacidade1 = hd1.getCapacidade();
        System.out.println(capacidade1 + "Gb de " + hard_disk1);

        //Sistema Operacional:
        SistemaOperacional so1 = new SistemaOperacional("Linux Ubuntu", 32);
        String sistema1 = so1.getNome();
        int tipo1 = so1.getTipo();
        System.out.println("Sistema Operacional " + sistema1 + " (" + tipo1 + " bits)");

        //Memoria USB:
        MemoriaUSB usb1 = new MemoriaUSB("Pen-drive", 16);
        String memoriausb1 = usb1.getNome();
        float cap1 = usb1.getCapacidade();
        System.out.println("Acompanha " + memoriausb1 + " de " + cap1 + "Gb");

        System.out.println("\nPromoção 2:");

        //Computador 02:
        ComputadorNew pc2 = new ComputadorNew("Acer");
        String marca2 = pc2.getMarca();
        System.out.println("\nMarca: " + marca2);

        //Hardware Básico - processador:
        HardwareBasico pro2 = new HardwareBasico("Pentium Core i5 ", 2260);
        String processador2 = pro2.getNome();
        float mhz2 = pro2.getCapacidade();
        System.out.println(processador2 + " (" + mhz2 + " Mhz)");

        //Hardware Básico - Memoria RAM:
        HardwareBasico ram2 = new HardwareBasico("Memoria RAM", 8);
        String memoria2 = ram2.getNome();
        float gb2 = ram2.getCapacidade();
        System.out.println(gb2 + " Gb de " + memoria2);

        //Hardware Básico - HD:
        HardwareBasico hd2 = new HardwareBasico("HD", 1);
        String hard_disk2 = hd2.getNome();
        float capacidade2 = hd2.getCapacidade();
        System.out.println(capacidade2 + "Tb de " + hard_disk2);

        //Sistema Operacional:
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        String sistema2 = so2.getNome();
        int tipo2 = so2.getTipo();
        System.out.println("Sistema Operacional " + sistema2 + " (" + tipo2 + " bits)");

        //Memoria USB:
        MemoriaUSB usb2 = new MemoriaUSB("Pen-drive", 32);
        String memoriausb2 = usb2.getNome();
        float cap2 = usb2.getCapacidade();
        System.out.println("Acompanha " + memoriausb2 + " de " + cap2 + "Gb");

        System.out.println("\nPromoção 3:");

        //Computador 03:
        ComputadorNew pc3 = new ComputadorNew ("Vaio");
        String marca3 = pc3.getMarca();
        System.out.println("\nMarca: " + marca3);

        //Hardware Básico - processador:
        HardwareBasico pro3 = new HardwareBasico("Pentium Core i7 ", 3500);
        String processador3 = pro3.getNome();
        float mhz3 = pro3.getCapacidade();
        System.out.println(processador3 + " (" + mhz3 + " Mhz)");

        //Hardware Básico - Memoria RAM:
        HardwareBasico ram3 = new HardwareBasico("Memoria RAM", 16);
        String memoria3 = ram3.getNome();
        float gb3 = ram3.getCapacidade();
        System.out.println(gb3 + " Gb de " + memoria3);

        //Hardware Básico - HD:
        HardwareBasico hd3 = new HardwareBasico("HD", 2);
        String hard_disk3 = hd3.getNome();
        float capacidade3 = hd3.getCapacidade();
        System.out.println(capacidade3 + "Tb de " + hard_disk3);

        //Sistema Operacional:
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        String sistema3 = so3.getNome();
        int tipo3 = so3.getTipo();
        System.out.println("Sistema Operacional " + sistema3 + " (" + tipo3 + " bits)");

        //Memoria USB:
        MemoriaUSB usb3 = new MemoriaUSB("HD Externo", 1);
        String memoriausb3 = usb3.getNome();
        float cap3 = usb3.getCapacidade();
        System.out.println("Acompanha " + memoriausb3 + " de " + cap3 + "Tb");
    }

    MemoriaUSB[] memoria = new MemoriaUSB[3];

    void addMemoriaUSB(MemoriaUSB newMemoria){
        for(int i = 0; i < memoria.length; i++){
            if(memoria[i] == null){
                memoria[i] = newMemoria;
                break;
            }
        }
    }
}
