package com.labuda.gdlunch.parser.zomato;

import com.labuda.gdlunch.entity.DailyMenu;
import com.labuda.gdlunch.tools.WebAddressesConfig;

/**
 * Parses weekly menu from Sborovna restaurant
 */
public class SborovnaParser extends ZomatoParser {

    public SborovnaParser() {
        super(WebAddressesConfig.getInstance().getString("sborovna"));
    }

    @Override
    public DailyMenu parse() {
        DailyMenu result = super.parse();
        result.setRestaurantName("Sborovna");
        return result;
    }
}