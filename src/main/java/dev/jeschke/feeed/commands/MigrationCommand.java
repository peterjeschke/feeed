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
