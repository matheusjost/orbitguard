package com.orbitguard.orbitguard.model.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONObjectUtils {
    public static String getStringOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getString(key) : null;
    }

    public static Integer getIntOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getInt(key) : null;
    }

    public static Double getDoubleOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getDouble(key) : null;
    }

    public static Boolean getBooleanOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getBoolean(key) : null;
    }

    public static JSONObject getJSONObjectOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getJSONObject(key) : null;
    }

    public static JSONArray getJSONArrayOrNull(JSONObject obj, String key) {
        if (obj == null) return null;

        return obj.has(key) ? obj.getJSONArray(key) : null;
    }

    public static JSONObject getJSONObjectOrNull(JSONArray arr, int index) {
        if (arr.isEmpty()) return null;

        return arr.length() > index ? arr.getJSONObject(index) : null;
    }
}
