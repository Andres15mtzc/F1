public class Race {
    public boolean isFinished;
    private Runner[] runners;
    private Mechanic[] mechanics;
    private Viewer[] viewers;

    public Race(int noRunners, int noMechanics, int noViewers) {
        isFinished = false;
        
        buildRunners(noRunners);
        buildMechanics(noMechanics);
        buildViewers(noViewers);
    }
    
    private void buildRunners(int noRunners) {
        runners = new Runner[noRunners];
        for (int i = 0; i < noRunners; i++) {
            runners[i] = new Runner(i);
        }
    }

    private void buildMechanics(int noMechanics) {
        mechanics = new Mechanic[noMechanics];
        for (int i = 0; i < noMechanics; i++) {
            mechanics[i] = new Mechanic(i);
        }
    }

    private void buildViewers(int noViewers) {
        viewers = new Viewer[noViewers];
        for (int i = 0; i < noViewers; i++) {
            viewers[i] = new Viewer(i);
        }
    }

    public void startRace(){
        for (int i = 0; i < viewers.length; i++) viewers[i].start();
        for (int i = 0; i < mechanics.length; i++) mechanics[i].start();
        for (int i = 0; i < runners.length; i++) runners[i].start();
    }

    public Runner[] getRunners() {
        return runners;
    }

    public Mechanic[] getMechanics() {
        return mechanics;
    }

    public Viewer[] getViewers() {
        return viewers;
    }
}
