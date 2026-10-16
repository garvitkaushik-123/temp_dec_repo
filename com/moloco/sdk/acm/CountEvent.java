package com.moloco.sdk.acm;

import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/moloco/sdk/acm/CountEvent;", "Lcom/moloco/sdk/acm/c;", "", C3040d4.h.j0, "<init>", "(Ljava/lang/String;)V", "", "count", "withCount", "(I)Lcom/moloco/sdk/acm/CountEvent;", C3040d4.h.W, "value", "withTag", "(Ljava/lang/String;Ljava/lang/String;)Lcom/moloco/sdk/acm/CountEvent;", "", "Lcom/moloco/sdk/acm/EventTag;", "eventTags", "Ljava/util/List;", "getEventTags", "()Ljava/util/List;", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "countValue", "I", "getCountValue", "()I", "setCountValue", "(I)V", "Companion", "a", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class CountEvent implements c {
    private static final int MAX_TAGS_PER_EVENT = 10;
    private static final int MAX_TAG_CHAR_LEN = 50;
    private int countValue;
    private final List<EventTag> eventTags;
    private final String name;

    public CountEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventTags = new ArrayList();
        this.name = eventName;
        this.countValue = 1;
    }

    public final int getCountValue() {
        return this.countValue;
    }

    @Override // com.moloco.sdk.acm.c
    public List<EventTag> getEventTags() {
        return this.eventTags;
    }

    @Override // com.moloco.sdk.acm.c
    public String getName() {
        return this.name;
    }

    public final void setCountValue(int i) {
        this.countValue = i;
    }

    public final CountEvent withCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative".toString());
        }
        this.countValue = count;
        return this;
    }

    @Override // com.moloco.sdk.acm.c
    public CountEvent withTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (getEventTags().size() < 10 && key.length() <= 50 && value.length() <= 50) {
            getEventTags().add(new EventTag(key, value));
        }
        return this;
    }
}
