/*
 * The feeed project
 * Copyright (C) 2020
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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
