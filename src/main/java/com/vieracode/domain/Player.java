package com.vieracode.domain;

import com.vieracode.enums.Position;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Player implements Serializable {
    private int number;
    private String name;
    private Position position;
    private LocalDate date;

    public Player() {
    }

    public Player(int number) {
        this.number = number;
    }

    public Player(int number, String name, Position position, LocalDate date) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long ageCalculate() {
        return ChronoUnit.YEARS.between(this.date, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", date=" + date +
                '}';
    }
}
