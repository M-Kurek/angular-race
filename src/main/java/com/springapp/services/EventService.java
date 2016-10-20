package com.springapp.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private static final Logger LOG = Logger.getLogger(EventService.class);
    static final String THE_PATH = "data/event/";
    public static final String JSON_EXT = ".json";

    public Object getEventFromJsonFile(int idx) {
        try {
            File file = ResourceUtils.getFile("classpath:" + THE_PATH + idx + ".json");
            BufferedReader input = new BufferedReader(new FileReader(file));
            LOG.info("reading from " + file);

            return readFile(input);
        } catch (IOException e) {
            return "{ idx : " + idx + ", error : " + e.getMessage() + "}";
        }
    }

    private String readFile(BufferedReader input) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = input.readLine();
        while (line != null) {
            builder.append(line);
            line = input.readLine();
        }
        return builder.toString();
    }

    public String saveEventFromJsonFile(Integer idx, String eventInJson) {
        try {
            File target = ResourceUtils.getFile("classpath:" + THE_PATH + idx + JSON_EXT);
            if (!target.exists()) {
                return "no place to save : " + idx;
            }
            target.delete();

            try (BufferedWriter output = new BufferedWriter(new FileWriter(target));) {
                output.write(eventInJson);
                return "saved";
            }
        } catch (IOException e) {
            return "problem saving for " + idx + " : " + e.getMessage();
        }
    }
    public boolean saveNewEventFromJsonFile(String eventInJson) {
        try {
            File targetFolder = ResourceUtils.getFile("classpath:" + THE_PATH);
            if (!targetFolder.exists()) {
                targetFolder.createNewFile();
                LOG.warn("new output folder : " + targetFolder.getAbsolutePath());
            }

            int nextId = getNextId(targetFolder);
            File target = new File(targetFolder, nextId + JSON_EXT);
            target.createNewFile();
            target.setWritable(true);
            LOG.info("next event is : " + target.getAbsolutePath() +
                    ", canWrite : " + target.canWrite());
            try (BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
                output.write(eventInJson);
            }
            return nextId > 0;
        } catch (IOException e) {
            LOG.error("problem saving event:\n" + eventInJson, e);
            return false;
        }
    }

    int getNextId(File targetFolder) {
        File[] files = targetFolder.listFiles();
        //only one type remains
        int jsonCounter = 1;
        for (File file : files) {
            if (file.getName().contains(JSON_EXT)) {
                jsonCounter++;

            }
        }
        return jsonCounter;
    }
}
