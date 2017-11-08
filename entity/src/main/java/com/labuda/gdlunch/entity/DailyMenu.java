package com.labuda.gdlunch.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class represents menu for a single day
 */
@Entity
@Table(name = "dailyMenu")
public class DailyMenu {

    /**
     * Database ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date
     */
    private LocalDate date;

    /**
     * Restaurant name
     */
    private String restaurantName;

    /**
     * List of courses on the menu on specific day
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuItem> menu = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DailyMenu)) {
            return false;
        }

        DailyMenu dailyMenu = (DailyMenu) o;

        if (getDate() != null ? !getDate().equals(dailyMenu.getDate())
                : dailyMenu.getDate() != null) {
            return false;
        }
        return getMenu() != null ? getMenu().equals(dailyMenu.getMenu())
                : dailyMenu.getMenu() == null;
    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getMenu() != null ? getMenu().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DailyMenu{" +
                "date=" + date +
                ", menu=" + menu +
                '}' + System.lineSeparator();
    }
}
