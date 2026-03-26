package com.embold.backup;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BackupScheduler {

    public static void main(String[] args) {
        if (args.length != 8) {
            printInvalidOptionMessage(args, false);
            System.exit(1);
        }

        String baseUrl = args[0];
        String dailyHour = args[1];
        String dailyMinute = args[2];
        String dailyMeridian = args[3];
        String backupPath = args[4];
        String bearerToken = args[5];
        String scheduleType = args[6];
        String mappedPath = args[7];

        BackupScheduler scheduler = new BackupScheduler();
        boolean success = scheduler.scheduleBackup(baseUrl, dailyHour, dailyMinute, dailyMeridian, backupPath, bearerToken, scheduleType);

        if (success) {
            System.out.println("Backup schedule set successfully.");

            scheduler.waitForBackup(dailyHour, dailyMinute, dailyMeridian);

            scheduler.checkBackupFiles(mappedPath);
            System.exit(0);
        } else {
            System.out.println("Failed to set the backup schedule.");
            System.exit(-1);
        }
    }

    public void waitForBackup(String hour, String minute, String meridian) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime scheduledTime = LocalTime.parse(hour + ":" + minute + " " + meridian.toUpperCase(), formatter);

        LocalTime timeToCheck = scheduledTime.plusMinutes(1);

        LocalTime now = LocalTime.now();

        long delay;
        if (now.isBefore(scheduledTime)) {
            delay = now.until(timeToCheck, ChronoUnit.MILLIS);
        } else {
            delay = 0;
        }
        try {
            System.out.println("Waiting for " + delay + " milliseconds before checking backup files.");
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkBackupFiles(String mappedPath) {
        File backupDir = new File(mappedPath);

        if (backupDir.exists() && backupDir.isDirectory()) {
            File[] backupFiles = backupDir.listFiles((dir, name) -> name.endsWith(".sql"));
            if (backupFiles != null && backupFiles.length > 0) {
                for (File file : backupFiles) {
                    System.out.println("Backup file: " + file.getName() + " Size: " + file.length() + " bytes");
                }
            } else {
                System.out.println("No backup files found.");
            }
        } else {
            System.out.println("Backup directory does not exist or is not a directory.");
        }
    }

    public boolean scheduleBackup(String baseUrl, String dailyHour, String dailyMinute, String dailyMeridian, String backupPath, String bearerToken, String scheduleType) {

        LocalTime time = LocalTime.parse(dailyHour + ":" + dailyMinute + " " + dailyMeridian.toUpperCase(), DateTimeFormatter.ofPattern("hh:mm a"));
        String hour24 = String.format("%02d", time.getHour());
        String minute24 = String.format("%02d", time.getMinute());

        String apiUrl = baseUrl + "/api/v1/tenants/backup";

        RequestSpecification request = RestAssured.given();

        request.formParam("schedule[daily][daily_hour]", hour24);
        request.formParam("schedule[daily][daily_minute]", minute24);
        request.formParam("schedule[daily][daily_meridian]", ""); // Meridian is irrelevant in 24-hour format
        request.formParam("schedule[daily][days][]", "Sunday");
        request.formParam("schedule[daily][days][]", "Monday");
        request.formParam("schedule[daily][days][]", "Tuesday");
        request.formParam("schedule[daily][days][]", "Wednesday");
        request.formParam("schedule[daily][days][]", "Thursday");
        request.formParam("schedule[daily][days][]", "Friday");
        request.formParam("schedule[daily][days][]", "Saturday");
        request.formParam("schedule[monthly][months][]", "January");
        request.formParam("schedule[monthly][months][]", "February");
        request.formParam("schedule[monthly][months][]", "March");
        request.formParam("schedule[monthly][months][]", "April");
        request.formParam("schedule[monthly][months][]", "May");
        request.formParam("schedule[monthly][months][]", "June");
        request.formParam("schedule[monthly][months][]", "July");
        request.formParam("schedule[monthly][months][]", "August");
        request.formParam("schedule[monthly][months][]", "September");
        request.formParam("schedule[monthly][months][]", "October");
        request.formParam("schedule[monthly][months][]", "November");
        request.formParam("schedule[monthly][months][]", "December");
        request.formParam("backup_path", backupPath);
        request.formParam("schedule_type", scheduleType);
        request.formParam("backup_enable", true);
        request.formParam("purge_enable", false);
        request.formParam("backup_limit", 10);

        // Add headers
        request.header("Authorization", "Bearer " + bearerToken);
        request.header("Accept", "application/json, text/javascript, */*; q=0.01");
        request.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        request.header("Cache-Control", "no-cache");
        request.header("Connection", "keep-alive");
        request.header("Origin", baseUrl);
        request.header("Referer", baseUrl + "/gamma/");
        request.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");
        request.header("X-Requested-With", "XMLHttpRequest");

        request.log().all();

        // Capture response
        Response response = request.post(apiUrl);

        // Log the response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Check if request is successful
        return response.getStatusCode() == 200;
    }

    public static void printInvalidOptionMessage(String args[], boolean invalidOption) {
        if (invalidOption) {
            if (args.length > 0) {
                System.out.println("Invalid option : " + args[0]);
            }
        } else {
            System.out.println("Invalid number of parameters for option : " + args[0]);
        }
        printUsage();
    }

    public static void printUsage() {
        System.out.println("Usage : java -jar BackupScheduler.jar <baseUrl> <dailyHour> <dailyMinute> <dailyMeridian> <backupPath> <bearerToken> <scheduleType> <mappedPath>");
        System.out.println("Example: java -jar BackupScheduler.jar http://3.72.41.7:4044 04 39 am /opt/gamma_data/ <token> daily /home/user/BrowserStackCodeQuality/gamma_data");
    }
}
