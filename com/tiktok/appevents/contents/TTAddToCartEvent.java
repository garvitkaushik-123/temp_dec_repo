package com.tiktok.appevents.contents;

import com.tiktok.appevents.contents.TTContentsEvent;
import com.tiktok.appevents.contents.TTContentsEventConstants;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTAddToCartEvent extends TTContentsEvent {
    TTAddToCartEvent(String eventName, JSONObject properties, String eventId) {
        super(eventName, properties, eventId);
    }

    public static TTContentsEvent.Builder newBuilder() {
        return new TTContentsEvent.Builder(TTContentsEventConstants.ContentsEventName.EVENT_NAME_ADD_TO_CARD, "");
    }

    public static TTContentsEvent.Builder newBuilder(String eventId) {
        return new TTContentsEvent.Builder(TTContentsEventConstants.ContentsEventName.EVENT_NAME_ADD_TO_CARD, eventId);
    }
}
