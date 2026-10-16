package io.bidmachine.iab.vast.processor;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public class DefaultMediaPicker extends VastMediaPicker<MediaFileTag> {

    /* renamed from: a, reason: collision with root package name */
    private int f6919a;
    private boolean b;

    private class b implements Comparator<Pair<LinearCreativeTag, MediaFileTag>> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<LinearCreativeTag, MediaFileTag> obj1, Pair<LinearCreativeTag, MediaFileTag> obj2) {
            int width = ((MediaFileTag) obj1.second).getWidth() * ((MediaFileTag) obj1.second).getHeight();
            int width2 = ((MediaFileTag) obj2.second).getWidth() * ((MediaFileTag) obj2.second).getHeight();
            int abs = Math.abs(width - DefaultMediaPicker.this.f6919a);
            int abs2 = Math.abs(width2 - DefaultMediaPicker.this.f6919a);
            VastLog.d("DefaultMediaPicker", "AreaComparator: obj1 - %d, obj2 - %d", Integer.valueOf(abs), Integer.valueOf(abs2));
            if (abs < abs2) {
                return -1;
            }
            return abs > abs2 ? 1 : 0;
        }
    }

    public DefaultMediaPicker(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.b = Utils.isLandscapeOrientation(context);
    }

    protected boolean b(MediaFileTag mediaFileTag) {
        return (mediaFileTag.getWidth() > mediaFileTag.getHeight()) == this.b;
    }

    @Override // io.bidmachine.iab.vast.processor.VastMediaPicker
    public Pair<LinearCreativeTag, MediaFileTag> pickVideo(List<Pair<LinearCreativeTag, MediaFileTag>> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new b());
        return a(list);
    }

    private void a(int width, int height) {
        this.f6919a = width * height;
    }

    protected boolean a(MediaFileTag mediaFileTag) {
        String type = mediaFileTag.getType();
        return type != null && type.matches("video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)");
    }

    public DefaultMediaPicker(int width, int height) {
        a(width, height);
    }

    private Pair<LinearCreativeTag, MediaFileTag> a(List<Pair<LinearCreativeTag, MediaFileTag>> pairList) {
        VastLog.d("DefaultMediaPicker", "getBestMatch", new Object[0]);
        Pair<LinearCreativeTag, MediaFileTag> pair = null;
        for (Pair<LinearCreativeTag, MediaFileTag> pair2 : pairList) {
            if (a((MediaFileTag) pair2.second)) {
                if (b((MediaFileTag) pair2.second)) {
                    return pair2;
                }
                if (pair == null) {
                    pair = pair2;
                }
            }
        }
        return pair;
    }
}
