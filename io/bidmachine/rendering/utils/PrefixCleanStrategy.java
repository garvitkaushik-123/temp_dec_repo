package io.bidmachine.rendering.utils;

import java.io.File;

/* loaded from: classes8.dex */
public class PrefixCleanStrategy extends CleanStrategy {

    /* renamed from: a, reason: collision with root package name */
    private final String f7196a;

    public PrefixCleanStrategy(String prefix) {
        this.f7196a = prefix;
    }

    @Override // io.bidmachine.rendering.utils.CleanStrategy
    protected boolean a(File file) {
        return FileUtils.startWith(file, this.f7196a);
    }
}
