package dev.jeschke.feeed.commands;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.Quarkus;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {CommandLine.HelpCommand.class,  MigrationCommand.class})
public class TopLevelCommand implements Runnable {
    @Override
    public void run() {
        Quarkus.waitForExit();
    }
}
