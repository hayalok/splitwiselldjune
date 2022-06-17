package com.scaler.splitwisejune22;

import com.scaler.splitwisejune22.commands.AddGroupCommand;
import com.scaler.splitwisejune22.commands.AddMemberCommand;
import com.scaler.splitwisejune22.commands.RegisterUserCommand;
import com.scaler.splitwisejune22.commands.UpdateProfileCommand;
import com.scaler.splitwisejune22.commands.registry.CommandRegistry;
import com.scaler.splitwisejune22.commands.registry.CommandRegistryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseJune22Application implements CommandLineRunner {
    @Autowired
    private CommandRegistry commandRegistry;
    @Autowired
    private RegisterUserCommand registerUserCommand;
    @Autowired
    private UpdateProfileCommand updateProfileCommand;

    @Autowired
    private AddGroupCommand addGroupCommand;
    @Autowired
    private AddMemberCommand addMemberCommand;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseJune22Application.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);
        commandRegistry.registerCommand(addGroupCommand);
        commandRegistry.registerCommand(addMemberCommand);

//        String input = "Register namanbhalla 999 password";
//        String input = "5 UpdateProfile strongpassword";
//        String input = "2 AddGroup New_Group";
        String input = "2 AddMember 1 1";
        commandRegistry.executeCommandLine(input);
//        while (true) {
//            String input = "INPUT FROM COMMAND LINE";
//
//            commandRegistry.executeCommandLine(input);
//        }
    }
}
