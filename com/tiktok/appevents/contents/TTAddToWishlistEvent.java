package com.tiktok.appevents.contents;

import com.tiktok.appevents.contents.TTContentsEvent;
import com.tiktok.appevents.contents.TTContentsEventConstants;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTAddToWishlistEvent extends TTContentsEvent {
    TTAddToWishlistEvent(String eventName, JSONObject properties, String eventId) {
        super(eventName, properties, eventId);
    }

    public static TTContentsEvent.Builder newBuilder() {
        return new TTContentsEvent.Builder(TTContentsEventConstants.ContentsEventName.EVENT_NAME_ADD_TO_WISHLIST, "");
    }

    public static TTContentsEvent.Builder newBuilder(String eventId) {
        return new TTContentsEvent.Builder(TTContentsEventConstants.ContentsEventName.EVENT_NAME_ADD_TO_WISHLIST, eventId);
    }
}
