package com.springapp.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Service
public class EventService {

    private static final String THE_PATH = "data/event/";
    private static final Logger LOG = Logger.getLogger(EventService.class);

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
            File target = ResourceUtils.getFile("classpath:" + THE_PATH + idx + ".json");
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
}
