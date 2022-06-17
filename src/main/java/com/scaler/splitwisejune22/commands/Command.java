package com.scaler.splitwisejune22.commands;

import com.scaler.splitwisejune22.exceptions.AddingUserNotAdmin;

public interface Command {

    /**
     * Returns true if the commandLine
     * input is relevant for the current command.
     * Else returns false
     * @param commandLine
     * @return
     */
    boolean parse(String commandLine);

    void execute(String commandLine) throws AddingUserNotAdmin;
}
