package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3337ue;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import java.io.File;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a {
    public static final int f = 8;

    /* renamed from: a, reason: collision with root package name */
    public final l f5852a;
    public final u b;
    public final com.moloco.sdk.internal.error.b c;
    public final HttpClient d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 1, 1, 1}, l = {293, 293}, m = "downloadFullFile", n = {"this", "dstFile", C3337ue.n, "this", "dstFile", C3337ue.n}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5853a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.a((File) null, (HttpResponse) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl$downloadMedia$2", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {MBSupportMuteAdType.REWARD_VIDEO, 105, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 148}, m = "invokeSuspend", n = {"previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "hasMoreData", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk"}, s = {"L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "I$0", "I$1", "J$0", "I$2"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$b, reason: collision with other inner class name */
    public static final class C0478b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5854a;
        public int b;
        public int c;
        public int d;
        public long e;
        public Object f;
        public int g;
        public final /* synthetic */ String i;
        public final /* synthetic */ File j;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a k;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0478b(String str, File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, String str2, Continuation<? super C0478b> continuation) {
            super(2, continuation);
            this.i = str;
            this.j = file;
            this.k = aVar;
            this.l = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((C0478b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0478b(this.i, this.j, this.k, this.l, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0167 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x018d A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x019e A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01fa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01fb A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0363 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0381 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0397 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x037a  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0420 A[Catch: Exception -> 0x042b, TRY_LEAVE, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0104 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0138 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0156 A[Catch: Exception -> 0x042b, TryCatch #0 {Exception -> 0x042b, blocks: (B:9:0x002d, B:14:0x0167, B:17:0x0185, B:19:0x018d, B:21:0x0191, B:22:0x019b, B:25:0x019e, B:30:0x01ea, B:33:0x01fb, B:35:0x025a, B:37:0x02b5, B:38:0x02bc, B:41:0x0303, B:44:0x033e, B:48:0x035f, B:50:0x0363, B:52:0x0381, B:54:0x0397, B:60:0x02e5, B:61:0x03b7, B:62:0x03bc, B:64:0x03bd, B:68:0x0420, B:73:0x0050, B:76:0x006f, B:79:0x0085, B:82:0x0093, B:84:0x00b5, B:86:0x00bf, B:88:0x00d3, B:90:0x00db, B:91:0x0100, B:93:0x0104, B:94:0x010d, B:96:0x0138, B:98:0x0156, B:103:0x00e3), top: B:2:0x0017, inners: #1 }] */
        /* JADX WARN: Type inference failed for: r14v18 */
        /* JADX WARN: Type inference failed for: r14v21 */
        /* JADX WARN: Type inference failed for: r14v7, types: [boolean] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0414 -> B:11:0x0415). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar;
            long length;
            String d;
            long j;
            int i2;
            int i3;
            int i4;
            int i5;
            String e;
            List split$default;
            String str;
            int i6;
            int i7;
            String str2;
            int i8;
            int i9;
            long j2;
            int i10;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar2;
            int i11;
            long j3;
            int i12;
            int i13;
            Object obj2;
            i.a a2;
            int parseInt;
            Object obj3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i14 = this.g;
            String str3 = RemoteSettings.FORWARD_SLASH_STRING;
            int i15 = 2;
            int i16 = 0;
            ?? r14 = 0;
            int i17 = 0;
            int i18 = 1;
            try {
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.e, "Fetching asset from network: " + this.i, null, false, 12, null);
                    try {
                        e = b.this.e(this.j);
                    } catch (NumberFormatException e2) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.e, "Failed to read range file", e2, false, 8, null);
                        b.this.h(this.j);
                    }
                    if (e != null && (split$default = StringsKt.split$default((CharSequence) e, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null)) != null && (str = (String) CollectionsKt.last(split$default)) != null) {
                        i = Integer.parseInt(str);
                        aVar = this.k;
                        if (aVar != null) {
                            aVar.a(this.j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
                        }
                        length = this.j.length();
                        b bVar = b.this;
                        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                        MolocoLogger.info$default(molocoLogger, bVar.e, "Previous tmpfile bytes: " + length, null, false, 12, null);
                        if (i != length) {
                            MolocoLogger.info$default(molocoLogger, b.this.e, "File already downloaded, skipping download", null, false, 12, null);
                            return b.this.a(this.j, this.k);
                        }
                        d = b.this.d(this.j);
                        j = length;
                        i2 = -1;
                        i3 = 1;
                        i4 = i;
                        i5 = 0;
                        if (i3 != 0) {
                        }
                    }
                    i = Integer.MAX_VALUE;
                    aVar = this.k;
                    if (aVar != null) {
                    }
                    length = this.j.length();
                    b bVar2 = b.this;
                    MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
                    MolocoLogger.info$default(molocoLogger2, bVar2.e, "Previous tmpfile bytes: " + length, null, false, 12, null);
                    if (i != length) {
                    }
                } else if (i14 == 1) {
                    i5 = this.c;
                    j = this.e;
                    i2 = this.b;
                    i4 = this.f5854a;
                    d = (String) this.f;
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj;
                    str2 = RemoteSettings.FORWARD_SLASH_STRING;
                    int i19 = i2;
                    long j4 = j;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                } else if (i14 == 2) {
                    int i20 = this.c;
                    j = this.e;
                    i2 = this.b;
                    i4 = this.f5854a;
                    d = (String) this.f;
                    ResultKt.throwOnFailure(obj);
                    i13 = i20;
                    str2 = RemoteSettings.FORWARD_SLASH_STRING;
                    obj2 = obj;
                    HttpResponse httpResponse = (HttpResponse) obj2;
                    a2 = b.this.a(this.j, httpResponse, this.k);
                    if (!(a2 instanceof i.a.AbstractC0479a)) {
                    }
                } else if (i14 == 3) {
                    i10 = this.d;
                    j2 = this.e;
                    i9 = this.c;
                    int i21 = this.b;
                    int i22 = this.f5854a;
                    String str4 = (String) this.f;
                    ResultKt.throwOnFailure(obj);
                    i3 = i21;
                    i4 = i22;
                    d = str4;
                    str2 = RemoteSettings.FORWARD_SLASH_STRING;
                    i7 = 0;
                    i6 = 1;
                    i8 = 2;
                    aVar2 = this.k;
                    if (aVar2 == null) {
                    }
                    if (i3 == 0) {
                    }
                    i18 = i6;
                    i16 = r14;
                    if (i3 != 0) {
                    }
                } else {
                    if (i14 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5 = this.c;
                    j = this.e;
                    i2 = this.b;
                    i4 = this.f5854a;
                    d = (String) this.f;
                    ResultKt.throwOnFailure(obj);
                    str2 = RemoteSettings.FORWARD_SLASH_STRING;
                    int i23 = 0;
                    i6 = 1;
                    int i24 = 2;
                    i15 = i24;
                    str3 = str2;
                    i3 = i23;
                    int i25 = i3;
                    i18 = i6;
                    i16 = i25;
                    if (i3 != 0) {
                        u uVar = b.this.b;
                        this.f = d;
                        this.f5854a = i4;
                        this.b = i2;
                        this.e = j;
                        this.c = i5;
                        this.g = i18;
                        str2 = str3;
                        obj3 = uVar.a(5000L, this);
                        i17 = i16;
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i192 = i2;
                        long j42 = j;
                        if (((Boolean) obj3).booleanValue()) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar3 = this.k;
                            if (aVar3 != null) {
                                aVar3.a(new c.b(i.a.AbstractC0479a.n.c));
                            }
                            return i.a.AbstractC0479a.n.c;
                        }
                        i13 = i5 + 1;
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.e, "Making request to fetch chunk: " + i13 + " for remainingBytes: " + i192, null, false, 12, null);
                        b bVar3 = b.this;
                        String str5 = this.i;
                        this.f = d;
                        this.f5854a = i4;
                        this.b = i192;
                        this.e = j42;
                        this.c = i13;
                        this.g = i15;
                        obj2 = bVar3.a(str5, j42, i4, d, this);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j = j42;
                        i2 = i192;
                        r14 = i17;
                        HttpResponse httpResponse2 = (HttpResponse) obj2;
                        a2 = b.this.a(this.j, httpResponse2, this.k);
                        if (!(a2 instanceof i.a.AbstractC0479a)) {
                            return a2;
                        }
                        b.this.a(this.j, httpResponse2);
                        MolocoLogger molocoLogger3 = MolocoLogger.INSTANCE;
                        String str6 = b.this.e;
                        StringBuilder append = new StringBuilder().append("ResponseCode: ").append(httpResponse2.getStatus().getValue()).append(", ");
                        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                        MolocoLogger.info$default(molocoLogger3, str6, append.append(httpHeaders.getContentLength()).append(": ").append(HttpMessagePropertiesKt.contentLength(httpResponse2)).toString(), null, false, 12, null);
                        String str7 = httpResponse2.getHeaders().get(httpHeaders.getContentRange());
                        if (str7 != null) {
                            MolocoLogger.info$default(molocoLogger3, b.this.e, "Content range header is available, " + httpHeaders.getContentRange() + ": " + str7, null, false, 12, null);
                            b.this.a(this.j, str7);
                            String[] strArr = new String[i18];
                            strArr[r14] = str2;
                            int parseInt2 = Integer.parseInt((String) CollectionsKt.last(StringsKt.split$default((CharSequence) str7, strArr, false, 0, 6, (Object) null)));
                            Long contentLength = HttpMessagePropertiesKt.contentLength(httpResponse2);
                            long longValue = contentLength != null ? contentLength.longValue() : 0L;
                            String[] strArr2 = new String[i18];
                            strArr2[r14] = str2;
                            String str8 = (String) CollectionsKt.first(StringsKt.split$default((CharSequence) str7, strArr2, false, 0, 6, (Object) null));
                            i8 = 2;
                            boolean contains$default = StringsKt.contains$default(str8, "-", (boolean) r14, 2, (Object) null);
                            if (contains$default) {
                                i7 = r14;
                                if (!contains$default) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                String[] strArr3 = new String[1];
                                strArr3[i7] = "-";
                                parseInt = Integer.parseInt((String) CollectionsKt.last(StringsKt.split$default((CharSequence) str8, strArr3, false, 0, 6, (Object) null)));
                            } else {
                                parseInt = parseInt2;
                                i7 = r14;
                            }
                            i6 = 1;
                            int i26 = (parseInt2 - parseInt) - 1;
                            MolocoLogger.info$default(molocoLogger3, b.this.e, "maxRange: " + parseInt2 + ", Response contentLength: " + longValue, null, false, 12, null);
                            int i27 = i26 > 0 ? 1 : i7;
                            j2 = j + longValue;
                            b bVar4 = b.this;
                            File file = this.j;
                            this.f = d;
                            this.f5854a = parseInt2;
                            this.b = i27;
                            this.c = i26;
                            this.e = j2;
                            this.d = i13;
                            this.g = 3;
                            if (bVar4.b(file, httpResponse2, this) != coroutine_suspended) {
                                i4 = parseInt2;
                                i9 = i26;
                                i10 = i13;
                                i3 = i27;
                                aVar2 = this.k;
                                if (aVar2 == null) {
                                    i11 = i10;
                                    j3 = j2;
                                    i12 = i9;
                                    aVar2.a(this.j, new c.d(this.j.length(), i4));
                                } else {
                                    i11 = i10;
                                    j3 = j2;
                                    i12 = i9;
                                }
                                if (i3 == 0) {
                                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.e, "Server has more data", null, false, 12, null);
                                    i5 = i11;
                                    i2 = i12;
                                    i15 = i8;
                                    str3 = str2;
                                    i25 = i7;
                                    j = j3;
                                } else {
                                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.e, "Server does not have more data to send", null, false, 12, null);
                                    i5 = i11;
                                    i2 = i12;
                                    i15 = i8;
                                    str3 = str2;
                                    i25 = i7;
                                    j = j3;
                                }
                                i18 = i6;
                                i16 = i25;
                                if (i3 != 0) {
                                    return b.this.a(this.j, this.k);
                                }
                            }
                        } else {
                            i23 = r14;
                            i6 = i18;
                            i24 = 2;
                            MolocoLogger.warn$default(molocoLogger3, b.this.e, httpHeaders.getContentRange() + " is not available", null, false, 12, null);
                            b.this.c.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c.c, new com.moloco.sdk.internal.error.a(this.l));
                            b bVar5 = b.this;
                            File file2 = this.j;
                            this.f = d;
                            this.f5854a = i4;
                            this.b = i2;
                            this.e = j;
                            this.c = i13;
                            this.g = 4;
                            if (bVar5.a(file2, httpResponse2, this) != coroutine_suspended) {
                                i5 = i13;
                                i15 = i24;
                                str3 = str2;
                                i3 = i23;
                                int i252 = i3;
                                i18 = i6;
                                i16 = i252;
                                if (i3 != 0) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            } catch (Exception e3) {
                i.a.AbstractC0479a a3 = o.a(e3);
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.e, "Failed to fetch media from url: " + this.i + " due to error: " + a3, e3, false, 8, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar4 = this.k;
                if (aVar4 == null) {
                    return a3;
                }
                aVar4.a(new c.b(a3));
                return a3;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 1, 1, 1}, l = {275, 277}, m = "writeChunkToFile", n = {"this", "dstFile", "this", "dstFile", "channel"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5855a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.b(null, null, this);
        }
    }

    public b(l mediaConfig, u connectivityService, com.moloco.sdk.internal.error.b errorReportingService, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f5852a = mediaConfig;
        this.b = connectivityService;
        this.c = errorReportingService;
        this.d = httpClient;
        this.e = "ChunkedMediaDownloader";
    }

    public static final long a(HttpRequestRetry.DelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        return 100L;
    }

    public final String d(File file) {
        File c2 = c(file);
        if (c2.exists()) {
            return FilesKt.readText$default(c2, null, 1, null);
        }
        return null;
    }

    public final String e(File file) {
        File f2 = f(file);
        if (f2.exists()) {
            return FilesKt.readText$default(f2, null, 1, null);
        }
        return null;
    }

    public final File f(File file) {
        return new File(file.getParent(), file.getName() + ".range");
    }

    public final void g(File file) {
        c(file).delete();
    }

    public final void h(File file) {
        f(file).delete();
    }

    public final File c(File file) {
        return new File(file.getParent(), file.getName() + ".etag");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean b(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && !f(file).exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
    
        if (r1 == r3) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008a -> B:11:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(File file, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        c cVar;
        int i;
        File file2;
        Object bodyAsChannel;
        b bVar;
        ByteReadChannel byteReadChannel;
        b bVar2;
        File file3;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.f = i2 - Integer.MIN_VALUE;
                Object obj = cVar.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    cVar.f5855a = this;
                    file2 = file;
                    cVar.b = file2;
                    cVar.f = 1;
                    bodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse, cVar);
                    if (bodyAsChannel != coroutine_suspended) {
                        bVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    File file4 = (File) cVar.b;
                    bVar = (b) cVar.f5855a;
                    ResultKt.throwOnFailure(obj);
                    bodyAsChannel = obj;
                    file2 = file4;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteReadChannel = (ByteReadChannel) cVar.c;
                    file3 = (File) cVar.b;
                    bVar2 = (b) cVar.f5855a;
                    ResultKt.throwOnFailure(obj);
                    ByteReadPacket byteReadPacket = (ByteReadPacket) obj;
                    while (!byteReadPacket.getEndOfInput()) {
                        FilesKt.appendBytes(file3, io.ktor.utils.io.core.StringsKt.readBytes$default(byteReadPacket, 0, 1, null));
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar2.e, "dst file length: " + file3.length() + " bytes", null, false, 12, null);
                    }
                    if (!byteReadChannel.isClosedForRead()) {
                        cVar.f5855a = bVar2;
                        cVar.b = file3;
                        cVar.c = byteReadChannel;
                        cVar.f = 2;
                        obj = byteReadChannel.readRemaining(bVar2.f5852a.e() * 2, cVar);
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                byteReadChannel = (ByteReadChannel) bodyAsChannel;
                bVar2 = bVar;
                file3 = file2;
                if (!byteReadChannel.isClosedForRead()) {
                }
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.f;
        if (i != 0) {
        }
        byteReadChannel = (ByteReadChannel) bodyAsChannel;
        bVar2 = bVar;
        file3 = file2;
        if (!byteReadChannel.isClosedForRead()) {
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && f(file).exists();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public Object a(String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new C0478b(str, file, aVar, str2, null), continuation);
    }

    public final i.a a(File file, HttpResponse httpResponse, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        int value = httpResponse.getStatus().getValue();
        if (400 <= value && value < 500) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new c.b(i.a.AbstractC0479a.e.c));
            }
            return i.a.AbstractC0479a.e.c;
        }
        if (500 <= value && value < 600) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new c.b(i.a.AbstractC0479a.h.c));
            }
            return i.a.AbstractC0479a.h.c;
        }
        return new i.a.b(file);
    }

    public final i.a a(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        g(file);
        h(file);
        if (aVar != null) {
            aVar.a(new c.a(file));
        }
        return new i.a.b(file);
    }

    public final Object a(String str, final long j, final int i, final String str2, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.d;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestRetryKt.retry(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return b.a(b.this, (HttpRequestRetry.Configuration) obj);
            }
        });
        HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return b.a(j, this, i, str2, (HeadersBuilder) obj);
            }
        });
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Unit a(final b bVar, HttpRequestRetry.Configuration retry) {
        Intrinsics.checkNotNullParameter(retry, "$this$retry");
        retry.setMaxRetries(10);
        HttpRequestRetry.Configuration.delayMillis$default(retry, false, new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(b.a((HttpRequestRetry.DelayContext) obj, ((Integer) obj2).intValue()));
            }
        }, 1, null);
        retry.retryOnException(10, true);
        retry.retryOnServerErrors(10);
        retry.modifyRequest(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return b.a(b.this, (HttpRequestRetry.ModifyRequestContext) obj, (HttpRequestBuilder) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(b bVar, HttpRequestRetry.ModifyRequestContext modifyRequest, HttpRequestBuilder it) {
        Intrinsics.checkNotNullParameter(modifyRequest, "$this$modifyRequest");
        Intrinsics.checkNotNullParameter(it, "it");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar.e, "Retry attempt #" + modifyRequest.getRetryCount() + " for " + modifyRequest.getRequest().getUrl(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public static final Unit a(long j, b bVar, int i, String str, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        String str2 = "bytes=" + j + '-' + Math.min(j + bVar.f5852a.e(), i);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str3 = bVar.e;
        StringBuilder sb = new StringBuilder("Adding ");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        MolocoLogger.info$default(molocoLogger, str3, sb.append(httpHeaders.getRange()).append(" header: ").append(str2).toString(), null, false, 12, null);
        headers.append(httpHeaders.getRange(), str2);
        if (str != null) {
            MolocoLogger.info$default(molocoLogger, bVar.e, "Adding " + httpHeaders.getIfRange() + " header: " + str, null, false, 12, null);
            headers.append(httpHeaders.getIfRange(), str);
            MolocoLogger.info$default(molocoLogger, bVar.e, "Adding " + httpHeaders.getETag() + " header: " + str, null, false, 12, null);
            headers.append(httpHeaders.getETag(), str);
        }
        return Unit.INSTANCE;
    }

    public final void a(File file, String str) {
        FilesKt.writeText$default(f(file), str, null, 2, null);
    }

    public final void a(File file, HttpResponse httpResponse) {
        Headers headers = httpResponse.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headers.get(httpHeaders.getETag());
        if (str != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, httpHeaders.getETag() + ": " + str, null, false, 12, null);
            FilesKt.writeText$default(c(file), str, null, 2, null);
        } else {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.e, "No " + httpHeaders.getETag() + " in header", null, false, 12, null);
            g(file);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(File file, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        a aVar;
        Object coroutine_suspended;
        int i;
        File file2;
        Object bodyAsChannel;
        b bVar;
        Object copyAndClose$default;
        File file3;
        b bVar2;
        HttpResponse httpResponse2 = httpResponse;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.f = i2 - Integer.MIN_VALUE;
                a aVar2 = aVar;
                Object obj = aVar2.d;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar2.f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    MolocoLogger.info$default(molocoLogger, this.e, "Range header not supported, downloading full file", null, false, 12, null);
                    if (file.exists()) {
                        MolocoLogger.info$default(molocoLogger, this.e, "Deleting existing file and fully re-downloading it", null, false, 12, null);
                        file.delete();
                    }
                    aVar2.f5853a = this;
                    file2 = file;
                    aVar2.b = file2;
                    aVar2.c = httpResponse2;
                    aVar2.f = 1;
                    bodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse2, aVar2);
                    if (bodyAsChannel != coroutine_suspended) {
                        bVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    httpResponse2 = (HttpResponse) aVar2.c;
                    file3 = (File) aVar2.b;
                    bVar2 = (b) aVar2.f5853a;
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar2.e, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj).longValue() + " bytes, file size: " + file3.length(), null, false, 12, null);
                    return Unit.INSTANCE;
                }
                httpResponse2 = (HttpResponse) aVar2.c;
                File file4 = (File) aVar2.b;
                b bVar3 = (b) aVar2.f5853a;
                ResultKt.throwOnFailure(obj);
                bodyAsChannel = obj;
                file2 = file4;
                bVar = bVar3;
                ByteWriteChannel writeChannel$default = FileChannelsKt.writeChannel$default(file2, null, 1, null);
                aVar2.f5853a = bVar;
                aVar2.b = file2;
                aVar2.c = httpResponse2;
                aVar2.f = 2;
                copyAndClose$default = ByteReadChannelKt.copyAndClose$default((ByteReadChannel) bodyAsChannel, writeChannel$default, 0L, aVar2, 2, null);
                if (copyAndClose$default != coroutine_suspended) {
                    file3 = file2;
                    obj = copyAndClose$default;
                    bVar2 = bVar;
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar2.e, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) obj).longValue() + " bytes, file size: " + file3.length(), null, false, 12, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        aVar = new a(continuation);
        a aVar22 = aVar;
        Object obj2 = aVar22.d;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar22.f;
        if (i != 0) {
        }
        ByteWriteChannel writeChannel$default2 = FileChannelsKt.writeChannel$default(file2, null, 1, null);
        aVar22.f5853a = bVar;
        aVar22.b = file2;
        aVar22.c = httpResponse2;
        aVar22.f = 2;
        copyAndClose$default = ByteReadChannelKt.copyAndClose$default((ByteReadChannel) bodyAsChannel, writeChannel$default2, 0L, aVar22, 2, null);
        if (copyAndClose$default != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
