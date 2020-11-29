package _4_BarracksWars.core.commands;

import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.UnitFactory;

public class Report extends Command {

    public Report(Repository repository, UnitFactory unitFactory, String[] data) {
        super(repository, unitFactory, data);
    }

    @Override
    public String execute() {
        return reportCommand();
    }

    private String reportCommand() {
        return super.getRepository().getStatistics();
    }
}
