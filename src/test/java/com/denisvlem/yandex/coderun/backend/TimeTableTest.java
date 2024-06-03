package com.denisvlem.yandex.coderun.backend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TimeTableTest {

    @AfterEach
    public void tearDown() {
        TimeTable.clearTimeTable();
    }
    @Test
    void givenEmptyTimeTable_whenCanAttend_thenReturnTrue() {
        boolean can = TimeTable.canAttend("alex", 1, LocalTime.now(), Duration.ofMinutes(3));
        assertThat(can).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"14:10:00", "14:20:00", "14:29:00", "13:51:00"})
    void givenOverLappingAppoint_whenCanAttend_thenReturnFalse(String time) {
        //given
        TimeTable.add("alex", 1, LocalTime.parse("14:00:00"), Duration.ofMinutes(30), List.of("denis", "alex"));
        boolean can = TimeTable.canAttend("alex", 1, LocalTime.parse(time), Duration.ofMinutes(10));
        assertThat(can).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"14:30:00", "13:50:00"})
    void givenOverLappingAppoint_whenCanAttend_thenReturnTrue(String time) {
        //given
        TimeTable.add("alex", 1, LocalTime.parse("14:00:00"), Duration.ofMinutes(30), List.of("denis", "alex"));
        boolean can = TimeTable.canAttend("alex", 1, LocalTime.parse(time), Duration.ofMinutes(10));
        assertThat(can).isTrue();
    }

    @Test
    void givenEmptyTimeTable_whenPrint_thenReturnEmptyString() {
        assertThat(TimeTable.print("denis", 1)).isEmpty();
    }

    @Test
    void givenOneRecord_whenPrint_thenReturnString() {
        TimeTable.add("alex", 1, LocalTime.parse("14:00:00"), Duration.ofMinutes(30), List.of("denis", "alex"));
        assertThat(TimeTable.print("alex", 1)).isEqualTo("14:00 30 denis alex\n");
    }
}