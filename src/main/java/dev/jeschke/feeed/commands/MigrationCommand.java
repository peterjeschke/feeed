package dev.jeschke.feeed.commands;

import org.flywaydb.core.Flyway;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Objects;

@CommandLine.Command(name = "migrate", subcommands = {MigrationValidateCommand.class, MigrationRepairCommand.class})
public class MigrationCommand implements Runnable {

    private final Flyway flyway;

    @Inject
    public MigrationCommand(@SuppressWarnings("CdiInjectionPointsInspection") Flyway flyway) {
        this.flyway = Objects.requireNonNull(flyway);
    }

    @Override
    public void run() {
        flyway.migrate();
    }
}
