package com.ganesh.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ScheduleUser {

    private final UserService userService;

    @Scheduled(cron = "0 */2 * * * *")
    public void scheduleBackupUser() throws InterruptedException{
        userService.getEvenUser();
        log.info("::::::::SCHEDULE BACKUP::::::::"+ "COMPLETE");
        Thread.sleep(120000);
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void scheduleDeleteUser() throws InterruptedException{
        userService.removeOddUser();
        log.info("::::::::SCHEDULE REMOVE::::::::"+ "COMPLETE");
        Thread.sleep(2000);
    }


}
