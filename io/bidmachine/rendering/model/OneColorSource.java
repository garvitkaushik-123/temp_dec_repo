package io.bidmachine.rendering.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/bidmachine/rendering/model/OneColorSource;", "Lio/bidmachine/rendering/model/ColorSource;", "", "color", "<init>", "(I)V", "a", "I", "getColor", "()I", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class OneColorSource implements ColorSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int color;

    public OneColorSource(int i) {
        this.color = i;
    }

    public final int getColor() {
        return this.color;
    }
}
