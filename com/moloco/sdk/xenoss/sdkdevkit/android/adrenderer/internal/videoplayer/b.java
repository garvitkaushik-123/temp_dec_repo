package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class b implements DataSource {
    public static final int h = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f6310a;
    public final i b;
    public final String c;
    public RandomAccessFile d;
    public long e;
    public boolean f;
    public boolean g;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$open$1", f = "ProgressiveMediaFileDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6311a;
        public final /* synthetic */ DataSpec c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DataSpec dataSpec, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = dataSpec;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            File c;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6311a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                b bVar = b.this;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a2 = bVar.a(bVar.f6310a);
                if (a2 instanceof c.a) {
                    c = ((c.a) a2).b();
                } else {
                    if (!(a2 instanceof c.C0482c)) {
                        b.this.g = true;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.c, "Failed to download file: " + b.this.f6310a, null, false, 12, null);
                        throw new IOException("Cannot read file: " + b.this.f6310a);
                    }
                    c = ((c.C0482c) a2).c();
                }
                if (!c.exists()) {
                    throw new IOException("Cannot read file, does not exist yet: " + b.this.f6310a);
                }
                b bVar2 = b.this;
                RandomAccessFile randomAccessFile = new RandomAccessFile(c, "r");
                randomAccessFile.seek(this.c.position);
                bVar2.a(randomAccessFile);
                b bVar3 = b.this;
                long j = this.c.length;
                if (j == -1) {
                    j = c.length() - this.c.position;
                }
                bVar3.e = j;
                if (b.this.e == 0 && b.this.a(a2)) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.c, "Streaming error likely detected", null, false, 12, null);
                    b.this.g = true;
                }
                return Boxing.boxLong(b.this.e);
            } catch (IOException e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.c, "Failed to open file: " + b.this.f6310a, e, false, 8, null);
                throw e;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$streamingStatus$1", f = "ProgressiveMediaFileDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b$b, reason: collision with other inner class name */
    public static final class C0561b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6312a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0561b(String str, Continuation<? super C0561b> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((C0561b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0561b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6312a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return b.this.b.a(this.c);
        }
    }

    public b(String url, i mediaCacheRepository) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        this.f6310a = url;
        this.b = mediaCacheRepository;
        this.c = "ProgressiveMediaFileDataSource";
    }

    public static /* synthetic */ void c() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "addTransferListener", null, false, 12, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } finally {
            this.d = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return Uri.parse(this.f6310a);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new a(dataSpec, null), 1, null);
        return ((Number) runBlocking$default).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] buffer, int i, int i2) {
        IOException iOException;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            if (i2 == 0) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "Read length is 0", null, false, 12, null);
                return 0;
            }
            if (this.e == 0 && (a(this.f6310a) instanceof c.a)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "Media stream is complete", null, false, 12, null);
                return -1;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a2 = a(this.f6310a);
            if (a2 instanceof c.b) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Streaming failed: " + this.f6310a, null, false, 12, null);
                this.g = true;
                return 0;
            }
            if (a2 instanceof c.a) {
                RandomAccessFile randomAccessFile = this.d;
                r1 = randomAccessFile != null ? randomAccessFile.read(buffer, i, i2) : 0;
                if (r1 > 0) {
                    this.f = true;
                    this.e -= r1;
                }
                return r1;
            }
            loop0: while (true) {
                i3 = 0;
                while (i3 <= 0) {
                    try {
                        if (!(a(this.f6310a) instanceof c.C0482c)) {
                            break loop0;
                        }
                        RandomAccessFile randomAccessFile2 = this.d;
                        if (randomAccessFile2 != null) {
                            i3 = randomAccessFile2.read(buffer, i, i2);
                        }
                    } catch (IOException e) {
                        iOException = e;
                        r1 = i3;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Waiting for more data", iOException, false, 8, null);
                        return r1;
                    }
                }
            }
            if (i3 > 0) {
                this.f = true;
                this.e -= i3;
            }
            return i3;
        } catch (IOException e2) {
            iOException = e2;
        }
    }

    public final RandomAccessFile b() {
        return this.d;
    }

    public final void a(RandomAccessFile randomAccessFile) {
        this.d = randomAccessFile;
    }

    public final boolean a() {
        return this.g;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(String str) {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C0561b(str, null), 1, null);
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) runBlocking$default;
    }

    public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar) {
        return this.f && (cVar instanceof c.C0482c) && Intrinsics.areEqual(((c.C0482c) cVar).d(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
    }
}
