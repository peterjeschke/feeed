package dev.jeschke.feeed.commands;

import io.quarkus.runtime.Quarkus;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Objects;

@CommandLine.Command(name = "repair", description = "tries to repair a broken database")
public class MigrationRepairCommand implements Runnable {

    private final Flyway flyway;

    @Inject
    public MigrationRepairCommand(@SuppressWarnings("CdiInjectionPointsInspection") Flyway flyway) {
        this.flyway = Objects.requireNonNull(flyway);
    }

    @Override
    public void run() {
        try {
            flyway.repair();
        } catch (FlywayException exc) {
            Quarkus.asyncExit(1);
        }
    }
}
