package modele;

public class Variables extends Sujet {


    private boolean partiLance;

    public boolean isPartiLance() {
        return partiLance;
    }

    public void setPartiLance(boolean partiLance) {
        if (partiLance) notifier();
        partiLance = partiLance;
    }



}
