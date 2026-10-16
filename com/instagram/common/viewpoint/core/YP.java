package com.instagram.common.viewpoint.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class YP {
    public static final int A00 = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService A01 = Executors.newFixedThreadPool(A00);
    public static volatile boolean A02 = true;
}
