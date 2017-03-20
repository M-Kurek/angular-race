package com.springapp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.model.TrainingEvent;
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

    public boolean saveNewEvent(TrainingEvent eventInJson) {
        File target;
        try {
            File targetFolder = getFileStorage();

            int nextId = getNextId(targetFolder);
            target = new File(targetFolder, nextId + JSON_EXT);
            target.createNewFile();
            target.setWritable(true);
            LOG.info("next event is : " + target.getAbsolutePath() +
                    ", canWrite : " + target.canWrite());
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(target, eventInJson);

            return nextId > 0;
        } catch (IOException e) {
            LOG.error("problem saving event:\n" + eventInJson, e);
            return false;
        }
    }

    private File getFileStorage() throws IOException {
        File targetFolder = ResourceUtils.getFile("classpath:" + THE_PATH);
        if (!targetFolder.exists()) {
            targetFolder.createNewFile();
            LOG.warn("new output folder : " + targetFolder.getAbsolutePath());
        }
        return targetFolder;
    }

    int getNextId(File targetFolder) {
        File[] files = targetFolder.listFiles();
        //only one type remains
        int jsonCounter = 1;
        for (File file : files) {
            if (isJsonExtension(file)) {
                jsonCounter++;
            }
        }
        return jsonCounter;
    }

    public List<TrainingEvent> getAllEvents() {

        List<TrainingEvent> events = new ArrayList<>();

        try {
            File targetFolder = getFileStorage();
            File[] files = targetFolder.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (isJsonExtension(file)) {
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    LOG.info("(all) reading from " + file);
                    ObjectMapper mapper = new ObjectMapper();
                    TrainingEvent event = mapper.readValue(input, TrainingEvent.class);
                    events.add(event);
                }
            }
        } catch (IOException e) {
            LOG.error("no place for file storage : ", e);
        } finally {
            return events;
        }
    }

    private boolean isJsonExtension(File file) {
        return file.getName().endsWith(JSON_EXT);
    }
}
