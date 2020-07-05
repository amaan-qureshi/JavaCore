package com.algoexpert;

import java.util.*;

public class CalendarMatching {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        StringMeeting m1 = new StringMeeting("9:00", "10:30");
        StringMeeting m2 = new StringMeeting("12:00", "13:00");
        StringMeeting m3 = new StringMeeting("16:00", "18:00");
        calendar1.add(m1);
        calendar1.add(m2);
        calendar1.add(m3);

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");

        List<StringMeeting> calendar2 = new ArrayList<>();
        StringMeeting m4 = new StringMeeting("10:00", "11:30");
        StringMeeting m5 = new StringMeeting("12:30", "14:30");
        StringMeeting m6 = new StringMeeting("14:30", "15:00");
        StringMeeting m7 = new StringMeeting("16:00", "17:00");
        calendar2.add(m4);
        calendar2.add(m5);
        calendar2.add(m6);
        calendar2.add(m7);

        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        System.out.println(calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, 30));
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.

        List<StringMeeting> updatedCal1 = updateCalendar(calendar1, dailyBounds1);
        List<StringMeeting> updatedCal2 = updateCalendar(calendar2, dailyBounds2);

        List<Meeting> cal1 = convertToIntMeeting(updatedCal1);
        List<Meeting> cal2 = convertToIntMeeting(updatedCal2);

        List<Meeting> mergedCalendar = mergeCalendars(cal1, cal2);

        List<Meeting> busyCalendar = flatenCalendar(mergedCalendar);

        List<Meeting> freeSlots = createFreeSlots(busyCalendar, meetingDuration);

        return convertToStringMeeting(freeSlots);
    }

    private static List<StringMeeting> convertToStringMeeting(List<Meeting> freeSlots) {

        List<StringMeeting> meeting = new ArrayList<>();
        for (Meeting slots : freeSlots){
            meeting.add(new StringMeeting(convertToString(slots.start),convertToString(slots.end)));
        }

        return meeting;
    }

    private static String convertToString(int slot) {

        int hour = slot/60;
        int min = slot%60;
        String mins = min < 10 ? "0"+min : min+"";
        return ""+hour+":"+mins;
    }

    private static List<Meeting> createFreeSlots(List<Meeting> busyCalendar, int duration) {

        List<Meeting> freeSlots = new ArrayList<>();
        for (int i = 0; i < busyCalendar.size() - 1; i++) {

            if (busyCalendar.get(i + 1).start - busyCalendar.get(i).end >= duration) {

                Meeting meeting = new Meeting(busyCalendar.get(i).end, busyCalendar.get(i + 1).start);
                freeSlots.add(meeting);
            }
        }
        return freeSlots;
    }

    private static List<Meeting> flatenCalendar(List<Meeting> mergedCalendar) {

        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(mergedCalendar.get(0).start, mergedCalendar.get(0).end));

        for (int i = 1; i < mergedCalendar.size(); i++) {

            Meeting previous = meetings.get(meetings.size() - 1);
            Meeting current = mergedCalendar.get(i);

            if (current.start >= previous.start && current.end <= previous.end) {
                continue;
            } else if (current.start >= previous.start && current.start <= previous.end && current.end > previous.end) {
                previous.end = current.end;
            } else if (current.start > previous.end) {
                meetings.add(new Meeting(current.start, current.end));
            }
        }

        return meetings;
    }

    private static List<Meeting> mergeCalendars(List<Meeting> updatedCal1, List<Meeting> updatedCal2) {

        List<Meeting> mergedCal = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < updatedCal1.size() && p2 < updatedCal2.size()) {
            if (updatedCal1.get(p1).start < updatedCal2.get(p2).start) {
                mergedCal.add(updatedCal1.get(p1));
                p1++;
            } else {
                mergedCal.add(updatedCal2.get(p2));
                p2++;
            }
        }

        while (p1 < updatedCal1.size()) {
            mergedCal.add(updatedCal1.get(p1));
            p1++;
        }
        while (p2 < updatedCal2.size()) {
            mergedCal.add(updatedCal2.get(p2));
            p2++;
        }

        return mergedCal;
    }

    private static List<Meeting> convertToIntMeeting(List<StringMeeting> updatedCal1) {

        List<Meeting> meetings = new ArrayList<>();
        for (StringMeeting sm : updatedCal1) {
            meetings.add(new Meeting(convertToInt(sm.start), convertToInt(sm.end)));
        }
        return meetings;
    }

    private static int convertToInt(String time) {
        String hour = time.substring(0, time.indexOf(":"));
        String minutes = time.substring(time.indexOf(":") + 1);
        int hoursToMin = Integer.parseInt(hour) * 60;
        return hoursToMin + Integer.parseInt(minutes);
    }

    private static List<StringMeeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {

        List<StringMeeting> updatedMeeting = new ArrayList<>();
        updatedMeeting.add(new StringMeeting("00:00", dailyBounds.start));
        updatedMeeting.addAll(calendar);
        updatedMeeting.add(new StringMeeting(dailyBounds.end, "23:59"));
        return updatedMeeting;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "StringMeeting{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
