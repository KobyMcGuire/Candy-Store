package com.techelevator.filereader;

import com.techelevator.items.Candy;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private String fileName = "Log.txt";

    public LogFileWriter() {

    }

    public void writeDeposit(BigDecimal deposit, BigDecimal totalBalance) {

        LocalDateTime now = LocalDateTime.now();
        File logFile  = new File(fileName);

        try(FileWriter writer = new FileWriter(logFile, true)) {

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(dtf.format(now) + " MONEY RECEIVED $" + deposit + " $" + totalBalance);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeCandyPurchased(Candy candy, int quantity, BigDecimal totalBalance) {

        LocalDateTime now = LocalDateTime.now();
        File logFile  = new File(fileName);

        try(FileWriter writer = new FileWriter(logFile, true)) {

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(dtf.format(now) + " " + quantity + " " + candy.getName() + " " + candy.getInventoryId() + " $" + candy.getPrice().multiply(BigDecimal.valueOf(quantity)) + " $" + totalBalance);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeChange(BigDecimal changeGiven, BigDecimal totalBalance) {

        LocalDateTime now = LocalDateTime.now();
        File logFile  = new File(fileName);

        try(FileWriter writer = new FileWriter(logFile, true)) {

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(dtf.format(now) + " Change Given: $" + changeGiven + " $" + totalBalance);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
