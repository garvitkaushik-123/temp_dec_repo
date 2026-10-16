package io.bidmachine.rendering.utils;

import java.io.File;
import java.util.Date;

/* loaded from: classes8.dex */
public class DailyCleanStrategy extends CleanStrategy {

    /* renamed from: a, reason: collision with root package name */
    private final Date f7190a;

    public DailyCleanStrategy() {
        this(3);
    }

    @Override // io.bidmachine.rendering.utils.CleanStrategy
    protected boolean a(File file) {
        return FileUtils.isFileOlderThanDate(file, this.f7190a);
    }

    public DailyCleanStrategy(int n) {
        this.f7190a = Utils.getDate(n);
    }
}
