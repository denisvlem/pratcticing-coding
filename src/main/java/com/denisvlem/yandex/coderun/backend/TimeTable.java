package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TimeTable {

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            var lines = new LinkedList<String>();
            for (int i = 0; i < n; ++i) {
                var line = reader.readLine();
                lines.add(line);
            }

            for (var line : lines) {
                if (line.startsWith("APPOINT ")) {
                    var arguments = line.split(" ");
                    var day = Integer.parseInt(arguments[1]);
                    var time = LocalTime.parse(arguments[2] + ":00");
                    var duration = Duration.ofMinutes(Integer.parseInt(arguments[3]));
                    var names = Arrays.stream(arguments).skip(5).collect(Collectors.toList());
                    var addResult = tryToAdd(day, time, duration, names);
                    System.out.println(addResult);
                } else if (line.startsWith("PRINT ")) {
                    var arguments = line.split(" ");
                    var name = arguments[2];
                    var day = Integer.parseInt(arguments[1]);
                    System.out.print(print(name, day));
                }
            }
        }
    }

    public static class AppointData {
        final Set<String> attendants;
        final LocalTime time;
        final Duration duration;

        public AppointData(List<String> attendants, LocalTime time, Duration duration) {
            this.time = time;
            this.duration = duration;
            this.attendants = new LinkedHashSet<>(attendants);
        }
    }

    public static class AddResult {
        String result;
        List<String> cannotAttendNames;

        public void ok() {
            result = "OK";
        }

        public void fail(List<String> names) {
            result = "FAIL";
            cannotAttendNames = new ArrayList<>(names);
        }

        @Override
        public String toString() {
            if ("OK".equals(result)) {
                return result;
            } else {
                return result + "\n" + cannotAttendNames.stream().reduce(
                        (left, right) -> left + " " + right
                    ).orElse("")
                    .trim();
            }
        }
    }

    private static final Map<String, TreeMap<Integer, List<AppointData>>> appointStore = new HashMap<>();

    public static AddResult tryToAdd(int day, LocalTime time, Duration duration, List<String> names) {
        List<String> cannonAttendNames = new LinkedList<>();
        for (var name : names) {
            if (!canAttend(name, day, time, duration)) {
                cannonAttendNames.add(name);
            }
        }

        var result = new AddResult();
        if (cannonAttendNames.isEmpty()) {
            result.ok();
            for (var name : names) {
                add(name, day, time, duration, names);
            }
        } else {
            result.fail(cannonAttendNames);
        }
        return result;
    }

    public static String print(String name, int dayTo) {

        TreeMap<Integer, List<AppointData>> byName = appointStore.get(name);
        if (byName == null) {
            return "";
        }

        var appointOnDay = byName.get(dayTo);
        if (appointOnDay == null) {
            return "";
        }

        appointOnDay.sort(Comparator.comparing(app -> app.time));

        var builder = new StringBuilder();
        for (AppointData appointData : appointOnDay) {
            builder.append(appointData.time.format(DateTimeFormatter.ofPattern("HH:mm")))
                .append(" ")
                .append(appointData.duration.toMinutes()).append(" ");

            String attendants = appointData.attendants.stream().reduce((left, right) -> left + " " + right).orElse("");
            builder.append(attendants.trim()).append("\n");
        }

        return builder.toString();
    }

    public static void add(String name, int day, LocalTime start, Duration duration, List<String> names) {
        TreeMap<Integer, List<AppointData>> byName = appointStore.get(name);
        if (byName == null) {
            byName = new TreeMap<>();
        }

        var byDay = byName.get(day);
        if (byDay == null) {
            byDay = new ArrayList<>();
        }

        byDay.add(new AppointData(names, start, duration));
        byName.put(day, byDay);
        appointStore.put(name, byName);
    }

    public static boolean canAttend(String name, int day, LocalTime start, Duration duration) {

        TreeMap<Integer, List<AppointData>> byName = appointStore.get(name);
        if (byName == null || byName.isEmpty()) {
            return true;
        }

        List<AppointData> byDay = byName.get(day);
        if (byDay == null || byDay.isEmpty()) {
            return true;
        }

        return byDay.stream().allMatch(appoint -> {
            var end = start.plus(duration);

            return
                appointIsPossible(start, end, appoint);
        });
    }

    private static boolean appointIsPossible(LocalTime start, LocalTime end, AppointData appoint) {
        return ((end.isBefore(appoint.time) || end.equals(appoint.time)) && (start.isBefore(appoint.time)))
            || ((start.isAfter(appoint.time.plus(appoint.duration)) || start.equals(appoint.time.plus(appoint.duration)))
            && end.isAfter(appoint.time.plus(appoint.duration)));
    }

    public static void clearTimeTable() {
        appointStore.clear();
    }
}
