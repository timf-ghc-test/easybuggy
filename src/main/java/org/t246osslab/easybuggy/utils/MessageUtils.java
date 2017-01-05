package org.t246osslab.easybuggy.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.pmw.tinylog.Logger;

/**
 * Utility class to provide message properties.
 */
public class MessageUtils {

    /**
     * Return a message for a given property key.
     * 
     * @return A message for a given property key
     */
    public static String getMsg(String propertyKey, Locale locale) {
        return getMsg(propertyKey, (Object[])null, locale);
    }

    /**
     * Return a message for a given property key, replaced with placeholders.
     * 
     * @return A message for a given property key, replaced with placeholders
     */
    public static String getMsg(String propertyKey, Object[] placeholders, Locale locale) {
        String propertyValue = null;
        try {
            propertyValue = ResourceBundle.getBundle("messages", locale).getString(propertyKey);
            if (placeholders != null) {
                propertyValue = MessageFormat.format(propertyValue, placeholders);
            }
        } catch (Exception e) {
            Logger.error(e);
        }
        return propertyValue;
    }
}
