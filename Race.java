public class Race extends Thread {
    public boolean isFinished;
    private Runner[] runners;
    private Mechanic[] mechanics;
    private Viewer[] viewers;
    private Pits[] pits;
    private GasStation[] gasStations;
    private Toilet[] toilets;
    private BufferWindow bufferWindow;
    private long startTime;
    private int finishedRunners;
    private int noRunners;
    public volatile int noViewersWatch = 0, noViewersPee = 0, noRunnersRun = 0, noRunnersPits = 0, noRunnersGas,
            noMechanicsWait = 0, noMechanicsWork = 0;

    public Race(int laps, int noRunners, int noMechanics, int noViewers, int noGasStations, int noToilets) {
        isFinished = false;

        buildRunners(noRunners, laps);
        buildMechanics(noMechanics);
        buildViewers(noViewers);
        buildGasStations(noGasStations);
        buildToilets(noToilets);
        buildBufferWindow();
        this.noRunners = noRunners;
        this.finishedRunners = 0;
        noViewersWatch = noViewers;
        noRunnersRun = noRunners;
        noMechanicsWait = noMechanics;
    }

    @Override
    public void run() {
        startRace();
        for (Runner runner : runners) {
            try {
                runner.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        isFinished = true;
    }

    public synchronized void runToPits() {
        noRunnersRun -= 1;
        noRunnersPits += 1;
    }
    public synchronized void runToGas() {
        noRunnersRun -= 1;
        noRunnersGas += 1;
    }
    public synchronized void pitsToRun() {
        noRunnersPits -= 1;
        noRunnersRun += 1;
    }
    public synchronized void gasToRun() {
        noRunnersGas -= 1;
        noRunnersRun += 1;
    }
    public synchronized void runToEnd() {
        noRunnersRun -= 1;
    }

    public synchronized void waitToWork() {
        noMechanicsWait -= 1;
        noMechanicsWork += 1;
    }
    public synchronized void workToWait() {
        noMechanicsWork -= 1;
        noMechanicsWait += 1;
    }
    public synchronized void waitToEnd() {
        noMechanicsWait -= 1;
    }

    public synchronized void watchToPee() {
        noViewersWatch -= 1;
        noViewersPee += 1;
    }
    public synchronized void peeToWatch() {
        noViewersPee -= 1;
        noViewersWatch += 1;
    }
    public synchronized void watchToEnd() {
        noViewersWatch -= 1;
    }

    public synchronized Toilet getFreeToilet() {
        for (Toilet toilet : toilets) {
            if (!toilet.isOccupied) {
                toilet.isOccupied = true;
                return toilet;
            }
        }
        return null;
    }

    public synchronized Pits getFreePit() {
        for (Pits pit : pits) {
            if (!pit.isOccupied) {
                pit.isOccupied = true;
                return pit;
            }
        }
        return null;
    }

    public synchronized void updateBufferWindow(int n) {
        bufferWindow.updateWindow(n);
    }

    public synchronized GasStation getFreeGasStation() {
        for (GasStation gasStation : gasStations) {
            if (!gasStation.isOccupied) {
                gasStation.isOccupied = true;
                return gasStation;
            }
        }
        return null;
    }

    private void buildRunners(int noRunners, int laps) {
        String[] labelsNames = new String[] { "", "Running", "To pits", "Out of gas", "Crashed", "Finished", "Laps" };
        Table table = new Table("Runner", labelsNames);
        new Window(1000, 300, noRunners, "F1 Runners", table);

        runners = new Runner[noRunners];
        for (int i = 0; i < noRunners; i++) {
            runners[i] = new Runner(this, i, table, laps);
        }
    }

    private void buildMechanics(int noMechanics) {
        String[] labelsNames = new String[] { "", "Waiting", "Working", "Finished" };
        Table table = new Table("Mechanic", labelsNames);
        new Window(400, 300, noMechanics, "F1 Mechanics", table);

        mechanics = new Mechanic[noMechanics];
        pits = new Pits[noMechanics];
        for (int i = 0; i < noMechanics; i++) {
            mechanics[i] = new Mechanic(this, i, table);
            pits[i] = new Pits(mechanics[i]);
        }
    }

    private void buildViewers(int noViewers) {
        String[] labelsNames = new String[] { "", "Watching", "Peeing", "Gone" };
        Table table = new Table("Viewer", labelsNames);
        new Window(400, 300, noViewers, "F1 Viewers", table);

        viewers = new Viewer[noViewers];
        for (int i = 0; i < noViewers; i++) {
            viewers[i] = new Viewer(this, i, table);
        }
    }

    private void buildGasStations(int noGasStations) {
        gasStations = new GasStation[noGasStations];
        for (int i = 0; i < noGasStations; i++) {
            gasStations[i] = new GasStation(this, i);
        }
    }

    private void buildToilets(int noToilets) {
        toilets = new Toilet[noToilets];
        for (int i = 0; i < noToilets; i++) {
            toilets[i] = new Toilet(this, i);
        }
    }

    private void buildBufferWindow() {
        this.bufferWindow = new BufferWindow(getPits(), getGasStations(), getToilets());
    }

    public void startRace() {
        GraphicWindow play = new GraphicWindow(this);
        Thread t = new Thread(play);
        t.start();

        for (int i = 0; i < viewers.length; i++)
            viewers[i].start();
        for (int i = 0; i < mechanics.length; i++)
            mechanics[i].start();
        for (int i = 0; i < runners.length; i++)
            runners[i].start();
        this.startTime = System.currentTimeMillis();
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

    public Pits[] getPits() {
        return pits;
    }

    public GasStation[] getGasStations() {
        return gasStations;
    }

    public Toilet[] getToilets() {
        return toilets;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getNoRunners() {
        return this.noRunners;
    }

    public void setFinishedRunners(int n) {
        this.finishedRunners = n;
    }

    public int getFinishedRunners() {
        return this.finishedRunners;
    }
}
