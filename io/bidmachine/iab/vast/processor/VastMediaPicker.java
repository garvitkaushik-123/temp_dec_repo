package io.bidmachine.iab.vast.processor;

import android.util.Pair;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class VastMediaPicker<T extends MediaFileTag> implements Serializable {
    abstract Pair<LinearCreativeTag, T> pickVideo(List<Pair<LinearCreativeTag, T>> list);
}
