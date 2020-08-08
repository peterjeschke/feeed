package dev.jeschke.feeed.commands;

import io.quarkus.runtime.Quarkus;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Objects;

@CommandLine.Command(name="verify", description = "verifies that the database is in a correct state")
public class MigrationValidateCommand implements Runnable {

    private final Flyway flyway;

    @Inject
    public MigrationValidateCommand(@SuppressWarnings("CdiInjectionPointsInspection") Flyway flyway) {
        this.flyway = Objects.requireNonNull(flyway);
    }

    @Override
    public void run() {
        try {
            flyway.validate();
        } catch (FlywayException exc) {
            Quarkus.asyncExit(1);
        }
    }
}
