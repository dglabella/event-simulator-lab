package ar.edu.unsl.fmn.engine;

import ar.edu.unsl.fmn.utils.Statistics;

public interface Engine {

    void execute();

    void stopExecute();

    void generateReport(Statistics statistics);

    Statistics getStatistics();
}
