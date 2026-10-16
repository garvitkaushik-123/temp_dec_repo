package io.bidmachine.rendering.internal.repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.repository.a;
import io.bidmachine.rendering.model.Base64MediaSource;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.model.UrlMediaSource;
import io.bidmachine.rendering.utils.FileUtils;
import io.bidmachine.rendering.utils.NetworkRequest;
import io.bidmachine.util.ImageUtils;
import io.bidmachine.util.Utils;
import io.bidmachine.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0003\u000f\u0017$B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0013J%\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0019J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u001dJ1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u001fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u000f\u0010\"J%\u0010$\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0016¢\u0006\u0004\b$\u0010\u0018J)\u0010$\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0019J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010%J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020 2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010'J)\u0010\u0017\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020 2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010'J\u0019\u0010\u0017\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020 H\u0007¢\u0006\u0004\b\u0017\u0010(J%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020 0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0018J)\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020 0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0019J-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u000f\u0010,J%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020#0+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b\u000f\u0010-J\u0019\u0010\u000f\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020 H\u0007¢\u0006\u0004\b\u000f\u0010.JA\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\u0006\u0010&\u001a\u00020 2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u000f\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00103R\u001c\u00106\u001a\n 4*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lio/bidmachine/rendering/internal/repository/b;", "Lio/bidmachine/rendering/internal/repository/a;", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lio/bidmachine/rendering/internal/h;)V", "T", "Lio/bidmachine/rendering/internal/repository/a$a;", "resultCallback", "result", "", "a", "(Lio/bidmachine/rendering/internal/repository/a$a;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/model/Error;", "error", "(Lio/bidmachine/rendering/internal/repository/a$a;Lio/bidmachine/rendering/model/Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/model/MediaSource;", "mediaSource", "Landroid/graphics/Bitmap;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/model/MediaSource;Lio/bidmachine/rendering/internal/repository/a$a;)V", "(Lio/bidmachine/rendering/model/MediaSource;Lio/bidmachine/rendering/internal/repository/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/model/UrlMediaSource;", "Landroid/graphics/BitmapFactory$Options;", "options", "(Lio/bidmachine/rendering/model/UrlMediaSource;Landroid/graphics/BitmapFactory$Options;Lio/bidmachine/rendering/internal/repository/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/model/Base64MediaSource;", "(Lio/bidmachine/rendering/model/Base64MediaSource;Landroid/graphics/BitmapFactory$Options;Lio/bidmachine/rendering/internal/repository/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "base64", "(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;", "Landroid/net/Uri;", "c", "(Lio/bidmachine/rendering/model/UrlMediaSource;Lio/bidmachine/rendering/internal/repository/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "(Ljava/lang/String;Lio/bidmachine/rendering/internal/repository/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;)Landroid/net/Uri;", "Ljava/io/File;", C3040d4.h.b, "Lio/bidmachine/rendering/utils/NetworkRequest$FileOutputStreamProcessor;", "(Landroid/content/Context;Ljava/io/File;Landroid/graphics/BitmapFactory$Options;)Lio/bidmachine/rendering/utils/NetworkRequest$FileOutputStreamProcessor;", "(Landroid/content/Context;Ljava/io/File;)Lio/bidmachine/rendering/utils/NetworkRequest$FileOutputStreamProcessor;", "(Ljava/lang/String;)Ljava/io/File;", "Lio/bidmachine/rendering/utils/NetworkRequest$ResponseProcessor;", "processor", "(Ljava/lang/String;Lio/bidmachine/rendering/utils/NetworkRequest$ResponseProcessor;Lio/bidmachine/rendering/internal/repository/a$a;Lio/bidmachine/rendering/model/Error;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lio/bidmachine/rendering/internal/h;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "applicationContext", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b implements io.bidmachine.rendering.internal.repository.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* renamed from: b, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.h coroutineDispatchers;

    /* renamed from: c, reason: from kotlin metadata */
    private final Context applicationContext;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/bidmachine/rendering/internal/repository/b$a;", "Lio/bidmachine/rendering/utils/NetworkRequest$FileOutputStreamProcessor;", "Landroid/graphics/Bitmap;", "Landroid/content/Context;", "context", "Ljava/io/File;", C3040d4.h.b, "Landroid/graphics/BitmapFactory$Options;", "options", "<init>", "(Landroid/content/Context;Ljava/io/File;Landroid/graphics/BitmapFactory$Options;)V", "transform", "(Ljava/io/File;)Landroid/graphics/Bitmap;", "c", "Landroid/graphics/BitmapFactory$Options;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a extends NetworkRequest.FileOutputStreamProcessor<Bitmap> {

        /* renamed from: c, reason: from kotlin metadata */
        private final BitmapFactory.Options options;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, File file, BitmapFactory.Options options) {
            super(context, file);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseTransformer
        public Bitmap transform(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return ImageUtils.decodeFileToBitmapSafely(file, this.options);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/bidmachine/rendering/internal/repository/b$b;", "T", "Lio/bidmachine/rendering/utils/NetworkRequest$Listener;", "Lio/bidmachine/rendering/internal/repository/a$a;", "resultCallback", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "<init>", "(Lio/bidmachine/rendering/internal/repository/a$a;Lkotlinx/coroutines/CoroutineScope;Lio/bidmachine/rendering/internal/h;)V", C3337ue.n, "", "onSuccess", "(Ljava/lang/Object;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "a", "()Lio/bidmachine/rendering/model/Error;", "Lio/bidmachine/rendering/internal/repository/a$a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlinx/coroutines/CoroutineScope;", "c", "Lio/bidmachine/rendering/internal/h;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.repository.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0626b<T> implements NetworkRequest.Listener<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final a.InterfaceC0625a<T> resultCallback;

        /* renamed from: b, reason: from kotlin metadata */
        private final CoroutineScope coroutineScope;

        /* renamed from: c, reason: from kotlin metadata */
        private final io.bidmachine.rendering.internal.h coroutineDispatchers;

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$NetworkRequestListener$onError$1", f = "RepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: io.bidmachine.rendering.internal.repository.b$b$a */
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7082a;
            final /* synthetic */ AbstractC0626b<T> b;
            final /* synthetic */ Error c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC0626b<T> abstractC0626b, Error error, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = abstractC0626b;
                this.c = error;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7082a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((AbstractC0626b) this.b).resultCallback.onError(this.c);
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$NetworkRequestListener$onSuccess$1", f = "RepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: io.bidmachine.rendering.internal.repository.b$b$b, reason: collision with other inner class name */
        static final class C0627b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7083a;
            final /* synthetic */ AbstractC0626b<T> b;
            final /* synthetic */ T c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0627b(AbstractC0626b<T> abstractC0626b, T t, Continuation<? super C0627b> continuation) {
                super(2, continuation);
                this.b = abstractC0626b;
                this.c = t;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0627b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0627b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7083a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((AbstractC0626b) this.b).resultCallback.onSuccess(this.c);
                return Unit.INSTANCE;
            }
        }

        public AbstractC0626b(a.InterfaceC0625a<T> resultCallback, CoroutineScope coroutineScope, io.bidmachine.rendering.internal.h coroutineDispatchers) {
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
            this.resultCallback = resultCallback;
            this.coroutineScope = coroutineScope;
            this.coroutineDispatchers = coroutineDispatchers;
        }

        /* renamed from: a */
        public abstract Error getD();

        @Override // io.bidmachine.rendering.utils.NetworkRequest.Listener
        public void onError(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new a(this, error, null), 2, null);
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.Listener
        public void onSuccess(T response) {
            if (response != null) {
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new C0627b(this, response, null), 2, null);
            } else {
                onError(getD());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/internal/repository/b$c;", "Lio/bidmachine/rendering/utils/NetworkRequest$FileOutputStreamProcessor;", "Landroid/net/Uri;", "Landroid/content/Context;", "context", "Ljava/io/File;", C3040d4.h.b, "<init>", "(Landroid/content/Context;Ljava/io/File;)V", "transform", "(Ljava/io/File;)Landroid/net/Uri;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c extends NetworkRequest.FileOutputStreamProcessor<Uri> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, File file) {
            super(context, file);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseTransformer
        public Uri transform(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            if (FileUtils.isEmpty(file)) {
                return null;
            }
            return FileUtils.toUri(file);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaSource.DeliveryType.values().length];
            try {
                iArr[MediaSource.DeliveryType.PRELOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaSource.DeliveryType.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$callError$2", f = "RepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7084a;
        final /* synthetic */ a.InterfaceC0625a<T> b;
        final /* synthetic */ Error c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a.InterfaceC0625a<T> interfaceC0625a, Error error, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = interfaceC0625a;
            this.c = error;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7084a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.onError(this.c);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$callSuccess$2", f = "RepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7085a;
        final /* synthetic */ a.InterfaceC0625a<T> b;
        final /* synthetic */ T c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(a.InterfaceC0625a<T> interfaceC0625a, T t, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = interfaceC0625a;
            this.c = t;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7085a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.onSuccess(this.c);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getImage$1", f = "RepositoryImpl.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7086a;
        final /* synthetic */ MediaSource c;
        final /* synthetic */ a.InterfaceC0625a<Bitmap> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MediaSource mediaSource, a.InterfaceC0625a<Bitmap> interfaceC0625a, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = mediaSource;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new g(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7086a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                MediaSource mediaSource = this.c;
                a.InterfaceC0625a<Bitmap> interfaceC0625a = this.d;
                this.f7086a = 1;
                if (bVar.a(mediaSource, interfaceC0625a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getImageAsync$2", f = "RepositoryImpl.kt", i = {}, l = {49, 50}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7087a;
        final /* synthetic */ MediaSource b;
        final /* synthetic */ b c;
        final /* synthetic */ a.InterfaceC0625a<Bitmap> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(MediaSource mediaSource, b bVar, a.InterfaceC0625a<Bitmap> interfaceC0625a, Continuation<? super h> continuation) {
            super(2, continuation);
            this.b = mediaSource;
            this.c = bVar;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        
            if (r5.c.a((io.bidmachine.rendering.model.UrlMediaSource) r1, r6, r4, r5) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        
            if (r5.c.a((io.bidmachine.rendering.model.Base64MediaSource) r1, r6, r4, r5) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7087a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BitmapFactory.Options createDefaultBitmapFactoryOptions = ImageUtils.createDefaultBitmapFactoryOptions();
                createDefaultBitmapFactoryOptions.inJustDecodeBounds = false;
                MediaSource mediaSource = this.b;
                if (mediaSource instanceof UrlMediaSource) {
                    a.InterfaceC0625a<Bitmap> interfaceC0625a = this.d;
                    this.f7087a = 1;
                } else if (mediaSource instanceof Base64MediaSource) {
                    a.InterfaceC0625a<Bitmap> interfaceC0625a2 = this.d;
                    this.f7087a = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getString$1", f = "RepositoryImpl.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7088a;
        final /* synthetic */ MediaSource c;
        final /* synthetic */ a.InterfaceC0625a<String> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(MediaSource mediaSource, a.InterfaceC0625a<String> interfaceC0625a, Continuation<? super i> continuation) {
            super(2, continuation);
            this.c = mediaSource;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new i(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7088a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                MediaSource mediaSource = this.c;
                a.InterfaceC0625a<String> interfaceC0625a = this.d;
                this.f7088a = 1;
                if (bVar.b(mediaSource, interfaceC0625a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getStringAsync$2", f = "RepositoryImpl.kt", i = {}, l = {195, 197}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7089a;
        final /* synthetic */ MediaSource b;
        final /* synthetic */ b c;
        final /* synthetic */ a.InterfaceC0625a<String> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(MediaSource mediaSource, b bVar, a.InterfaceC0625a<String> interfaceC0625a, Continuation<? super j> continuation) {
            super(2, continuation);
            this.b = mediaSource;
            this.c = bVar;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        
            if (r1.a((io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<java.lang.String>>) r3, (io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<java.lang.String>) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        
            if (r6.a((io.bidmachine.rendering.internal.repository.a.InterfaceC0625a) r1, r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7089a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MediaSource mediaSource = this.b;
                if (mediaSource instanceof UrlMediaSource) {
                    this.c.a(((UrlMediaSource) mediaSource).getUrl(), new NetworkRequest.StringProcessor(), this.d, new Error("Uri is null"));
                } else if (mediaSource instanceof Base64MediaSource) {
                    String decodeBase64ToString$default = Utils.decodeBase64ToString$default(((Base64MediaSource) mediaSource).getBase64(), 0, 2, (Object) null);
                    if (decodeBase64ToString$default != null) {
                        b bVar = this.c;
                        a.InterfaceC0625a<String> interfaceC0625a = this.d;
                        this.f7089a = 1;
                    } else {
                        b bVar2 = this.c;
                        a.InterfaceC0625a<String> interfaceC0625a2 = this.d;
                        Error error = new Error("Can't decode string from base64");
                        this.f7089a = 2;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getVideo$1", f = "RepositoryImpl.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7090a;
        final /* synthetic */ MediaSource c;
        final /* synthetic */ a.InterfaceC0625a<Uri> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(MediaSource mediaSource, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super k> continuation) {
            super(2, continuation);
            this.c = mediaSource;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new k(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7090a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                MediaSource mediaSource = this.c;
                a.InterfaceC0625a<Uri> interfaceC0625a = this.d;
                this.f7090a = 1;
                if (bVar.c(mediaSource, interfaceC0625a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getVideoAsync$2", f = "RepositoryImpl.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7091a;
        final /* synthetic */ MediaSource b;
        final /* synthetic */ b c;
        final /* synthetic */ a.InterfaceC0625a<Uri> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(MediaSource mediaSource, b bVar, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super l> continuation) {
            super(2, continuation);
            this.b = mediaSource;
            this.c = bVar;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new l(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7091a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MediaSource mediaSource = this.b;
                if (mediaSource instanceof UrlMediaSource) {
                    a.InterfaceC0625a<Uri> interfaceC0625a = this.d;
                    this.f7091a = 1;
                    if (this.c.a((UrlMediaSource) mediaSource, interfaceC0625a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.d.onError(new Error("Unsupported media source type: " + this.b));
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.repository.RepositoryImpl$getVideoFromStream$2", f = "RepositoryImpl.kt", i = {}, l = {156, 158}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7092a;
        final /* synthetic */ String c;
        final /* synthetic */ a.InterfaceC0625a<Uri> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super m> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = interfaceC0625a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new m(this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        
            if (r1.a((io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<android.net.Uri>>) r2, (io.bidmachine.rendering.internal.repository.a.InterfaceC0625a<android.net.Uri>) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            if (r7.a((io.bidmachine.rendering.internal.repository.a.InterfaceC0625a) r1, r3, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7092a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Uri b = b.this.b(this.c);
                if (b != null) {
                    b bVar = b.this;
                    a.InterfaceC0625a<Uri> interfaceC0625a = this.d;
                    this.f7092a = 1;
                } else {
                    b bVar2 = b.this;
                    a.InterfaceC0625a<Uri> interfaceC0625a2 = this.d;
                    Error error = new Error("Can't parse video stream url - " + this.c);
                    this.f7092a = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"io/bidmachine/rendering/internal/repository/b$n", "Lio/bidmachine/rendering/internal/repository/b$b;", "Lio/bidmachine/rendering/model/Error;", "a", "()Lio/bidmachine/rendering/model/Error;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class n<T> extends AbstractC0626b<T> {
        final /* synthetic */ Error d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(a.InterfaceC0625a<T> interfaceC0625a, Error error, CoroutineScope coroutineScope, io.bidmachine.rendering.internal.h hVar) {
            super(interfaceC0625a, coroutineScope, hVar);
            this.d = error;
        }

        @Override // io.bidmachine.rendering.internal.repository.b.AbstractC0626b
        /* renamed from: a, reason: from getter */
        public Error getD() {
            return this.d;
        }
    }

    public b(Context context, CoroutineScope coroutineScope, io.bidmachine.rendering.internal.h coroutineDispatchers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
        this.coroutineScope = coroutineScope;
        this.coroutineDispatchers = coroutineDispatchers;
        this.applicationContext = context.getApplicationContext();
    }

    @Override // io.bidmachine.rendering.internal.repository.a
    public void b(MediaSource mediaSource, a.InterfaceC0625a<Bitmap> resultCallback) {
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new g(mediaSource, resultCallback, null), 3, null);
    }

    @Override // io.bidmachine.rendering.internal.repository.a
    public void c(MediaSource mediaSource, a.InterfaceC0625a<Uri> resultCallback) {
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new k(mediaSource, resultCallback, null), 3, null);
    }

    public final Object b(String str, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.c(), new m(str, interfaceC0625a, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object c(MediaSource mediaSource, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.c(), new l(mediaSource, this, interfaceC0625a, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object a(MediaSource mediaSource, a.InterfaceC0625a<Bitmap> interfaceC0625a, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.c(), new h(mediaSource, this, interfaceC0625a, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Uri b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return Utils.getValidUri(url);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Object a(UrlMediaSource urlMediaSource, BitmapFactory.Options options, a.InterfaceC0625a<Bitmap> interfaceC0625a, Continuation<? super Unit> continuation) {
        String url = urlMediaSource.getUrl();
        File a2 = a(url);
        if (a2 == null) {
            Object a3 = a((a.InterfaceC0625a) interfaceC0625a, new Error("Can't create file for image by url (" + url + ')'), continuation);
            return a3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a3 : Unit.INSTANCE;
        }
        Context applicationContext = this.applicationContext;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        NetworkRequest.FileOutputStreamProcessor<Bitmap> a4 = a(applicationContext, a2, options);
        Bitmap transform = a4.transform(a2);
        if (transform != null) {
            Object a5 = a((a.InterfaceC0625a<a.InterfaceC0625a<Bitmap>>) interfaceC0625a, (a.InterfaceC0625a<Bitmap>) transform, continuation);
            return a5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a5 : Unit.INSTANCE;
        }
        a(url, a4, interfaceC0625a, new Error("Failed to load image from url (" + url + ')'));
        return Unit.INSTANCE;
    }

    public final Object b(MediaSource mediaSource, a.InterfaceC0625a<String> interfaceC0625a, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.c(), new j(mediaSource, this, interfaceC0625a, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object a(Base64MediaSource base64MediaSource, BitmapFactory.Options options, a.InterfaceC0625a<Bitmap> interfaceC0625a, Continuation<? super Unit> continuation) {
        Bitmap a2 = a(base64MediaSource.getBase64(), options);
        if (a2 != null) {
            Object a3 = a((a.InterfaceC0625a<a.InterfaceC0625a<Bitmap>>) interfaceC0625a, (a.InterfaceC0625a<Bitmap>) a2, continuation);
            return a3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a3 : Unit.INSTANCE;
        }
        Object a4 = a((a.InterfaceC0625a) interfaceC0625a, new Error("Can't decode image from base64"), continuation);
        return a4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a4 : Unit.INSTANCE;
    }

    public final Bitmap a(String base64, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        Intrinsics.checkNotNullParameter(options, "options");
        byte[] decodeBase64$default = UtilsKt.decodeBase64$default(base64, 0, 1, (Object) null);
        if (decodeBase64$default != null) {
            return ImageUtils.decodeBytesToBitmapSafely(decodeBase64$default, options);
        }
        return null;
    }

    public final Object a(UrlMediaSource urlMediaSource, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super Unit> continuation) {
        String url = urlMediaSource.getUrl();
        int i2 = d.$EnumSwitchMapping$0[urlMediaSource.getDeliveryType().ordinal()];
        if (i2 == 1) {
            Object a2 = a(url, interfaceC0625a, continuation);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
        }
        if (i2 != 2) {
            return Unit.INSTANCE;
        }
        Object b = b(url, interfaceC0625a, continuation);
        return b == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b : Unit.INSTANCE;
    }

    public final Object a(String str, a.InterfaceC0625a<Uri> interfaceC0625a, Continuation<? super Unit> continuation) {
        File a2 = a(str);
        if (a2 == null) {
            Object a3 = a((a.InterfaceC0625a) interfaceC0625a, new Error("Can't create file for video by url (" + str + ')'), continuation);
            return a3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a3 : Unit.INSTANCE;
        }
        Context applicationContext = this.applicationContext;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        NetworkRequest.FileOutputStreamProcessor<Uri> a4 = a(applicationContext, a2);
        Uri transform = a4.transform(a2);
        if (transform != null) {
            Object a5 = a((a.InterfaceC0625a<a.InterfaceC0625a<Uri>>) interfaceC0625a, (a.InterfaceC0625a<Uri>) transform, continuation);
            return a5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a5 : Unit.INSTANCE;
        }
        a(str, a4, interfaceC0625a, new Error("Uri is null"));
        return Unit.INSTANCE;
    }

    @Override // io.bidmachine.rendering.internal.repository.a
    public void a(MediaSource mediaSource, a.InterfaceC0625a<String> resultCallback) {
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new i(mediaSource, resultCallback, null), 3, null);
    }

    public final NetworkRequest.FileOutputStreamProcessor<Bitmap> a(Context context, File file, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        return new a(context, file, options);
    }

    public final NetworkRequest.FileOutputStreamProcessor<Uri> a(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return new c(context, file);
    }

    public final File a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return FileUtils.getFileByUrl(this.applicationContext, url);
    }

    public final <T> void a(String url, NetworkRequest.ResponseProcessor<T> processor, a.InterfaceC0625a<T> resultCallback, Error error) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        Intrinsics.checkNotNullParameter(error, "error");
        new NetworkRequest.Builder(url, NetworkRequest.Method.Get).setResponseTransformer(processor).setListener(new n(resultCallback, error, this.coroutineScope, this.coroutineDispatchers)).send();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object a(a.InterfaceC0625a<T> interfaceC0625a, T t, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.d(), new f(interfaceC0625a, t, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object a(a.InterfaceC0625a<T> interfaceC0625a, Error error, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchers.d(), new e(interfaceC0625a, error, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
