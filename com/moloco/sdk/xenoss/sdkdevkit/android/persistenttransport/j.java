package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.http.ContentType;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j implements i {
    public static final a c = new a(null);
    public static final String d = "PersistentHttpRequest";
    public static final String e = "contentEncoding";
    public final l b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public j(l worker) {
        Intrinsics.checkNotNullParameter(worker, "worker");
        this.b = worker;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Data a2;
        Intrinsics.checkNotNullParameter(url, "url");
        if (e.a(url) && (a2 = k.a(url)) != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Enqueuing request to " + url, null, false, 12, null);
            this.b.a(new OneTimeWorkRequest.Builder(UrlGetRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(a2).build());
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (e.a(url)) {
            try {
                Pair[] pairArr = {TuplesKt.to("url", url), TuplesKt.to("body", body), TuplesKt.to("contentType", contentType.toString()), TuplesKt.to(e, str)};
                Data.Builder builder = new Data.Builder();
                for (int i = 0; i < 4; i++) {
                    Pair pair = pairArr[i];
                    builder.put((String) pair.getFirst(), pair.getSecond());
                }
                Data build = builder.build();
                Intrinsics.checkNotNullExpressionValue(build, "dataBuilder.build()");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Enqueuing request to " + url, null, false, 12, null);
                this.b.a(new OneTimeWorkRequest.Builder(UrlPostRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(build).build());
            } catch (Exception e2) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d, "Failed to enqueue persistent request for url: " + url, e2, false, 8, null);
            }
        }
    }

    public final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest a(Data data) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(data).build();
    }
}
