package com.sourcepoint.cmplibrary.core;

import android.content.Context;
import android.os.Handler;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExecutorManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/ExecutorManagerImpl;", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "singleThreadExecutor", "dispose", "", "executeOnMain", "block", "Lkotlin/Function0;", "executeOnSingleThread", "executeOnWorkerThread", "getNumCores", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutorManagerImpl implements ExecutorManager {
    private final Context context;
    private final ExecutorService executor;
    private final ExecutorService singleThreadExecutor;

    public ExecutorManagerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.executor = Executors.newFixedThreadPool(getNumCores());
        this.singleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.sourcepoint.cmplibrary.core.ExecutorManager
    public void executeOnMain(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        new Handler(this.context.getMainLooper()).post(new Runnable() { // from class: com.sourcepoint.cmplibrary.core.ExecutorManagerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ExecutorManagerImpl.executeOnMain$lambda$0(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeOnMain$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.sourcepoint.cmplibrary.core.ExecutorManager
    public void executeOnWorkerThread(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FunctionalUtilsKt.check(new ExecutorManagerImpl$executeOnWorkerThread$1(this, block));
    }

    @Override // com.sourcepoint.cmplibrary.core.ExecutorManager
    public void dispose() {
        this.executor.shutdown();
        this.singleThreadExecutor.shutdown();
    }

    @Override // com.sourcepoint.cmplibrary.core.ExecutorManager
    public void executeOnSingleThread(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FunctionalUtilsKt.check(new ExecutorManagerImpl$executeOnSingleThread$1(this, block));
    }

    private final int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.sourcepoint.cmplibrary.core.ExecutorManagerImpl$$ExternalSyntheticLambda0
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean numCores$lambda$1;
                    numCores$lambda$1 = ExecutorManagerImpl.getNumCores$lambda$1(file);
                    return numCores$lambda$1;
                }
            });
            Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
            return listFiles.length;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getNumCores$lambda$1(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
