package com.obsidian.knightsmp.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

public class UUIDTypeAdapter extends TypeAdapter<UUID> {

    @Override
    public void write(JsonWriter out, UUID value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toString());
        }
    }

    @Override
    public UUID read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        String uuidStr = in.nextString();
        return UUID.fromString(uuidStr);
    }
}