public class ControleRemoto implements Controlador {
    @Override
    public void ligar() {
        if(ligado== false){
           ligado=true;
        }else{
            System.out.println("Erro dispositivo ligado!");
        }
    }

    @Override
    public void desligar() {
        if(ligado == true){
            ligado=false;
        }else{
            System.out.println("Erro dispositovo desligado!");
        }
    }

    @Override
    public void abrirMenu() {
        System.out.println("");
        System.out.println("______MENU______");
        System.out.println("Esta ligado = " + ligado);
        System.out.print("Volume:");
        for (int i = 0; i < getVolume(); i+=5) {
            System.out.print("|");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");

    }

    @Override
    public void maisVolume() {
        if(ligado == true){
            if(volume >=100){
                System.out.print("Volume excedido!\nVolume maximo:100");
            }else{
                setVolume(volume+5);
                System.out.println("");
                System.out.print("Volume:");
                for (int i = 0; i < getVolume(); i+=5) {
                    System.out.print("|");
                }
            }
        }else{
            System.out.println("Erro!Dispositivo desligado!Ligue o primeiro!");
        }
    }

    @Override
    public void menosVolume() {
        if(ligado == true){
            if(volume <=0){
                this.setVolume(volume-=5);
                for (int i = 0; i < getVolume(); i+=5) {
                    System.out.print("|");
                }
            }else{
                System.out.println("Erro!Dispositivo ja esta no volume minimo!");
            }
        }else{
            System.out.println("Erro!Dispositivo desligado!");
        }
    }

    @Override
    public void ligarMudo() {
        if(ligado == true) {
            if (volume > 0) {
                setVolume(0);
                for (int i = 0; i < getVolume(); i += 5) {
                    System.out.print("|");
                }
            } else {
                System.out.println("O dispositivo ja esta mudo!");
            }
        }else{}
        System.out.println("Erro!Dispositivo desligado!");
    }

    @Override
    public void desligarMudo() {
    if (ligado == true) {
        if (volume == 0){
            setVolume(10);
            System.out.println("Desmutando...");
            for (int i = 0; i < getVolume(); i += 5) {
                System.out.print("|");
            }
        }else{
            System.out.println("Erro!Dispositivo ja esta desmutado!");
        }
    }else{
        System.out.println("Erro!Dispositivo desligado!");
    }
    }

    @Override
    public void play() {
    if (ligado == true) {
        setTocando(true);
        System.out.println("Tocando...");
    }else{
        System.out.println("Erro!Dispositivo desligado!");
    }
    }

    @Override
    public void pause() {
        if (ligado == true) {
            if (tocando == true) {
                setTocando(false);
                System.out.println("Pausando...");
            }else{
                System.out.println("Dispositivo ja esta pausado!");
        }
        }else{
            System.out.println("Erro!Dispositivo desligado!");
        }

    }

    private int volume;
    private boolean ligado;
    private boolean tocando;

    public ControleRemoto() {
        this.setVolume(20);
        this.setLigado(true);
        this.setTocando(false);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    public int getVolume() {
        return volume;
    }

    public boolean getLigado() {
        return ligado;
    }

    public boolean getTocando() {
        return tocando;
    }


}
