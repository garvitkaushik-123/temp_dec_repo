package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.FileImageSource;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 22\u00020\u0001:\u000223B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J.\u0010#\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010%J6\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J0\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0081@¢\u0006\u0004\b0\u00101R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "options", "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", AdActivity.REQUEST_KEY_EXTRA, "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    private final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ImageLoader imageLoader, SystemCallbacks systemCallbacks, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        EngineInterceptor$intercept$1 engineInterceptor$intercept$1;
        int i;
        Throwable th;
        EngineInterceptor engineInterceptor;
        MemoryCache.Value cacheValue;
        if (continuation instanceof EngineInterceptor$intercept$1) {
            engineInterceptor$intercept$1 = (EngineInterceptor$intercept$1) continuation;
            if ((engineInterceptor$intercept$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$intercept$1.label -= Integer.MIN_VALUE;
                Object obj = engineInterceptor$intercept$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$intercept$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ImageRequest request = chain.getRequest();
                        Object data = request.getData();
                        Size size = chain.getSize();
                        EventListener eventListener = Utils.getEventListener(chain);
                        Options options = this.requestService.options(request, size);
                        Scale scale = options.getScale();
                        eventListener.mapStart(request, data);
                        Object map = this.imageLoader.getComponents().map(data, options);
                        eventListener.mapEnd(request, map);
                        MemoryCache.Key newCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                        if (newCacheKey != null) {
                            try {
                                cacheValue = this.memoryCacheService.getCacheValue(request, newCacheKey, size, scale);
                            } catch (Throwable th2) {
                                th = th2;
                                engineInterceptor = this;
                            }
                        } else {
                            cacheValue = null;
                        }
                        if (cacheValue != null) {
                            return this.memoryCacheService.newResult(chain, request, newCacheKey, cacheValue);
                        }
                        CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
                        try {
                            EngineInterceptor$intercept$2 engineInterceptor$intercept$2 = new EngineInterceptor$intercept$2(this, request, map, options, eventListener, newCacheKey, chain, null);
                            engineInterceptor$intercept$1.L$0 = this;
                            engineInterceptor$intercept$1.L$1 = chain;
                            engineInterceptor$intercept$1.label = 1;
                            Object withContext = BuildersKt.withContext(fetcherDispatcher, engineInterceptor$intercept$2, engineInterceptor$intercept$1);
                            return withContext == coroutine_suspended ? coroutine_suspended : withContext;
                        } catch (Throwable th3) {
                            th = th3;
                            engineInterceptor = this;
                            chain = chain;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        engineInterceptor = this;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    chain = (Interceptor.Chain) engineInterceptor$intercept$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$intercept$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                if (!(th instanceof CancellationException)) {
                    throw th;
                }
                return engineInterceptor.requestService.errorResult(chain.getRequest(), th);
            }
        }
        engineInterceptor$intercept$1 = new EngineInterceptor$intercept$1(this, continuation);
        Object obj2 = engineInterceptor$intercept$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$intercept$1.label;
        if (i != 0) {
        }
        if (!(th instanceof CancellationException)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01d2, code lost:
    
        if (r0 == r9) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #2 {all -> 0x0089, blocks: (B:41:0x0079, B:43:0x0127, B:45:0x0131), top: B:40:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0173 A[Catch: all -> 0x0058, TryCatch #1 {all -> 0x0058, blocks: (B:25:0x0053, B:26:0x0165, B:50:0x0148, B:66:0x0173, B:68:0x017e, B:69:0x01ee, B:70:0x01f3), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r2v11, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$execute$1 engineInterceptor$execute$1;
        Ref.ObjectRef objectRef;
        SourceResult sourceResult;
        ImageSource source;
        EngineInterceptor engineInterceptor;
        ImageRequest imageRequest2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef2;
        T t;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        FetchResult fetchResult;
        Ref.ObjectRef objectRef6;
        ImageRequest imageRequest3;
        Ref.ObjectRef objectRef7;
        EventListener eventListener3;
        ExecuteResult executeResult;
        EngineInterceptor engineInterceptor2;
        SourceResult sourceResult2;
        ImageSource source2;
        Object obj3;
        Object obj4;
        Bitmap bitmap;
        try {
            if (continuation instanceof EngineInterceptor$execute$1) {
                engineInterceptor$execute$1 = (EngineInterceptor$execute$1) continuation;
                if ((engineInterceptor$execute$1.label & Integer.MIN_VALUE) != 0) {
                    engineInterceptor$execute$1.label -= Integer.MIN_VALUE;
                    EngineInterceptor$execute$1 engineInterceptor$execute$12 = engineInterceptor$execute$1;
                    Object obj5 = engineInterceptor$execute$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    objectRef = engineInterceptor$execute$12.label;
                    if (objectRef != 0) {
                        ResultKt.throwOnFailure(obj5);
                        Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                        objectRef8.element = options;
                        Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                        objectRef9.element = this.imageLoader.getComponents();
                        Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                        try {
                            objectRef8.element = this.requestService.updateOptionsOnWorkerThread((Options) objectRef8.element);
                            if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                                ComponentRegistry.Builder newBuilder = ((ComponentRegistry) objectRef9.element).newBuilder();
                                Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = imageRequest.getFetcherFactory();
                                if (fetcherFactory != null) {
                                    newBuilder.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                                }
                                Decoder.Factory decoderFactory = imageRequest.getDecoderFactory();
                                if (decoderFactory != null) {
                                    newBuilder.getDecoderFactories$coil_base_release().add(0, decoderFactory);
                                }
                                objectRef9.element = newBuilder.build();
                            }
                            ComponentRegistry componentRegistry = (ComponentRegistry) objectRef9.element;
                            Options options2 = (Options) objectRef8.element;
                            engineInterceptor$execute$12.L$0 = this;
                            engineInterceptor$execute$12.L$1 = imageRequest;
                            engineInterceptor$execute$12.L$2 = obj;
                            engineInterceptor$execute$12.L$3 = eventListener;
                            engineInterceptor$execute$12.L$4 = objectRef8;
                            engineInterceptor$execute$12.L$5 = objectRef9;
                            engineInterceptor$execute$12.L$6 = objectRef10;
                            engineInterceptor$execute$12.L$7 = objectRef10;
                            engineInterceptor$execute$12.label = 1;
                            Object fetch = fetch(componentRegistry, imageRequest, obj, options2, eventListener, engineInterceptor$execute$12);
                            if (fetch != coroutine_suspended) {
                                engineInterceptor = this;
                                imageRequest2 = imageRequest;
                                obj2 = obj;
                                eventListener2 = eventListener;
                                objectRef2 = objectRef8;
                                t = fetch;
                                objectRef3 = objectRef9;
                                objectRef4 = objectRef10;
                                objectRef5 = objectRef4;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            objectRef = objectRef10;
                            T t2 = objectRef.element;
                            sourceResult = t2 instanceof SourceResult ? (SourceResult) t2 : null;
                            if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                                Utils.closeQuietly(source);
                            }
                            throw th;
                        }
                    }
                    if (objectRef == 1) {
                        objectRef4 = (Ref.ObjectRef) engineInterceptor$execute$12.L$7;
                        objectRef5 = (Ref.ObjectRef) engineInterceptor$execute$12.L$6;
                        Ref.ObjectRef objectRef11 = (Ref.ObjectRef) engineInterceptor$execute$12.L$5;
                        Ref.ObjectRef objectRef12 = (Ref.ObjectRef) engineInterceptor$execute$12.L$4;
                        EventListener eventListener4 = (EventListener) engineInterceptor$execute$12.L$3;
                        Object obj6 = engineInterceptor$execute$12.L$2;
                        ImageRequest imageRequest4 = (ImageRequest) engineInterceptor$execute$12.L$1;
                        EngineInterceptor engineInterceptor3 = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj5);
                            objectRef3 = objectRef11;
                            objectRef2 = objectRef12;
                            eventListener2 = eventListener4;
                            obj2 = obj6;
                            imageRequest2 = imageRequest4;
                            engineInterceptor = engineInterceptor3;
                            t = obj5;
                        } catch (Throwable th2) {
                            th = th2;
                            objectRef = objectRef5;
                            T t22 = objectRef.element;
                            if (t22 instanceof SourceResult) {
                            }
                            if (sourceResult != null) {
                                Utils.closeQuietly(source);
                            }
                            throw th;
                        }
                    } else {
                        if (objectRef != 2) {
                            if (objectRef != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj5);
                            obj4 = obj5;
                            ExecuteResult executeResult2 = (ExecuteResult) obj4;
                            Drawable drawable = executeResult2.getDrawable();
                            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                                bitmap.prepareToDraw();
                            }
                            return executeResult2;
                        }
                        objectRef6 = (Ref.ObjectRef) engineInterceptor$execute$12.L$4;
                        objectRef7 = (Ref.ObjectRef) engineInterceptor$execute$12.L$3;
                        eventListener3 = (EventListener) engineInterceptor$execute$12.L$2;
                        imageRequest3 = (ImageRequest) engineInterceptor$execute$12.L$1;
                        engineInterceptor2 = (EngineInterceptor) engineInterceptor$execute$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        obj3 = obj5;
                        executeResult = (ExecuteResult) obj3;
                        engineInterceptor = engineInterceptor2;
                        EventListener eventListener5 = eventListener3;
                        ExecuteResult executeResult3 = executeResult;
                        Ref.ObjectRef objectRef13 = objectRef7;
                        T t3 = objectRef6.element;
                        sourceResult2 = t3 instanceof SourceResult ? (SourceResult) t3 : null;
                        if (sourceResult2 != null && (source2 = sourceResult2.getSource()) != null) {
                            Utils.closeQuietly(source2);
                        }
                        Options options3 = (Options) objectRef13.element;
                        engineInterceptor$execute$12.L$0 = null;
                        engineInterceptor$execute$12.L$1 = null;
                        engineInterceptor$execute$12.L$2 = null;
                        engineInterceptor$execute$12.L$3 = null;
                        engineInterceptor$execute$12.L$4 = null;
                        engineInterceptor$execute$12.L$5 = null;
                        engineInterceptor$execute$12.L$6 = null;
                        engineInterceptor$execute$12.L$7 = null;
                        engineInterceptor$execute$12.label = 3;
                        Object transform$coil_base_release = engineInterceptor.transform$coil_base_release(executeResult3, imageRequest3, options3, eventListener5, engineInterceptor$execute$12);
                        obj4 = transform$coil_base_release;
                    }
                    objectRef4.element = t;
                    fetchResult = (FetchResult) objectRef5.element;
                    if (fetchResult instanceof SourceResult) {
                        objectRef6 = objectRef5;
                        imageRequest3 = imageRequest2;
                        objectRef7 = objectRef2;
                        eventListener3 = eventListener2;
                        if (fetchResult instanceof DrawableResult) {
                            executeResult = new ExecuteResult(((DrawableResult) objectRef6.element).getDrawable(), ((DrawableResult) objectRef6.element).getIsSampled(), ((DrawableResult) objectRef6.element).getDataSource(), null);
                            EventListener eventListener52 = eventListener3;
                            ExecuteResult executeResult32 = executeResult;
                            Ref.ObjectRef objectRef132 = objectRef7;
                            T t32 = objectRef6.element;
                            if (t32 instanceof SourceResult) {
                            }
                            if (sourceResult2 != null) {
                            }
                            Options options32 = (Options) objectRef132.element;
                            engineInterceptor$execute$12.L$0 = null;
                            engineInterceptor$execute$12.L$1 = null;
                            engineInterceptor$execute$12.L$2 = null;
                            engineInterceptor$execute$12.L$3 = null;
                            engineInterceptor$execute$12.L$4 = null;
                            engineInterceptor$execute$12.L$5 = null;
                            engineInterceptor$execute$12.L$6 = null;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 3;
                            Object transform$coil_base_release2 = engineInterceptor.transform$coil_base_release(executeResult32, imageRequest3, options32, eventListener52, engineInterceptor$execute$12);
                            obj4 = transform$coil_base_release2;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        CoroutineDispatcher decoderDispatcher = imageRequest2.getDecoderDispatcher();
                        Ref.ObjectRef objectRef14 = objectRef5;
                        try {
                            objectRef6 = objectRef14;
                            imageRequest3 = imageRequest2;
                            objectRef7 = objectRef2;
                            eventListener3 = eventListener2;
                            EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef14, objectRef3, imageRequest2, obj2, objectRef2, eventListener2, null);
                            engineInterceptor$execute$12.L$0 = engineInterceptor;
                            engineInterceptor$execute$12.L$1 = imageRequest3;
                            engineInterceptor$execute$12.L$2 = eventListener3;
                            engineInterceptor$execute$12.L$3 = objectRef7;
                            engineInterceptor$execute$12.L$4 = objectRef6;
                            engineInterceptor$execute$12.L$5 = null;
                            engineInterceptor$execute$12.L$6 = null;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 2;
                            Object withContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, engineInterceptor$execute$12);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            engineInterceptor2 = engineInterceptor;
                            obj3 = withContext;
                            executeResult = (ExecuteResult) obj3;
                            engineInterceptor = engineInterceptor2;
                            EventListener eventListener522 = eventListener3;
                            ExecuteResult executeResult322 = executeResult;
                            Ref.ObjectRef objectRef1322 = objectRef7;
                            T t322 = objectRef6.element;
                            if (t322 instanceof SourceResult) {
                            }
                            if (sourceResult2 != null) {
                                Utils.closeQuietly(source2);
                            }
                            Options options322 = (Options) objectRef1322.element;
                            engineInterceptor$execute$12.L$0 = null;
                            engineInterceptor$execute$12.L$1 = null;
                            engineInterceptor$execute$12.L$2 = null;
                            engineInterceptor$execute$12.L$3 = null;
                            engineInterceptor$execute$12.L$4 = null;
                            engineInterceptor$execute$12.L$5 = null;
                            engineInterceptor$execute$12.L$6 = null;
                            engineInterceptor$execute$12.L$7 = null;
                            engineInterceptor$execute$12.label = 3;
                            Object transform$coil_base_release22 = engineInterceptor.transform$coil_base_release(executeResult322, imageRequest3, options322, eventListener522, engineInterceptor$execute$12);
                            obj4 = transform$coil_base_release22;
                        } catch (Throwable th3) {
                            th = th3;
                            objectRef = objectRef14;
                            T t222 = objectRef.element;
                            if (t222 instanceof SourceResult) {
                            }
                            if (sourceResult != null) {
                            }
                            throw th;
                        }
                    }
                }
            }
            if (objectRef != 0) {
            }
            objectRef4.element = t;
            fetchResult = (FetchResult) objectRef5.element;
            if (fetchResult instanceof SourceResult) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        engineInterceptor$execute$1 = new EngineInterceptor$execute$1(this, continuation);
        EngineInterceptor$execute$1 engineInterceptor$execute$122 = engineInterceptor$execute$1;
        Object obj52 = engineInterceptor$execute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        objectRef = engineInterceptor$execute$122.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0092 -> B:10:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        EngineInterceptor$fetch$1 engineInterceptor$fetch$1;
        int i;
        int i2;
        EngineInterceptor engineInterceptor;
        Pair<Fetcher, Integer> newFetcher;
        ImageSource source;
        if (continuation instanceof EngineInterceptor$fetch$1) {
            engineInterceptor$fetch$1 = (EngineInterceptor$fetch$1) continuation;
            if ((engineInterceptor$fetch$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$fetch$1.label -= Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$fetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    engineInterceptor = this;
                    newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i2);
                    if (newFetcher != null) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = engineInterceptor$fetch$1.I$0;
                    Fetcher fetcher = (Fetcher) engineInterceptor$fetch$1.L$6;
                    EventListener eventListener2 = (EventListener) engineInterceptor$fetch$1.L$5;
                    options = (Options) engineInterceptor$fetch$1.L$4;
                    Object obj3 = engineInterceptor$fetch$1.L$3;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$fetch$1.L$2;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$fetch$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$12 = engineInterceptor$fetch$1;
                    int i4 = i3;
                    componentRegistry = componentRegistry2;
                    EngineInterceptor$fetch$1 engineInterceptor$fetch$13 = engineInterceptor$fetch$12;
                    Fetcher first = fetcher;
                    imageRequest = imageRequest2;
                    eventListener = eventListener2;
                    obj = obj3;
                    FetchResult fetchResult = (FetchResult) obj2;
                    try {
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult);
                        if (fetchResult == null) {
                            return fetchResult;
                        }
                        i2 = i4;
                        engineInterceptor$fetch$1 = engineInterceptor$fetch$13;
                        newFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i2);
                        if (newFetcher != null) {
                            throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                        }
                        first = newFetcher.getFirst();
                        int intValue = newFetcher.getSecond().intValue() + 1;
                        eventListener.fetchStart(imageRequest, first, options);
                        engineInterceptor$fetch$1.L$0 = engineInterceptor;
                        engineInterceptor$fetch$1.L$1 = componentRegistry;
                        engineInterceptor$fetch$1.L$2 = imageRequest;
                        engineInterceptor$fetch$1.L$3 = obj;
                        engineInterceptor$fetch$1.L$4 = options;
                        engineInterceptor$fetch$1.L$5 = eventListener;
                        engineInterceptor$fetch$1.L$6 = first;
                        engineInterceptor$fetch$1.I$0 = intValue;
                        engineInterceptor$fetch$1.label = 1;
                        Object fetch = first.fetch(engineInterceptor$fetch$1);
                        if (fetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        EngineInterceptor$fetch$1 engineInterceptor$fetch$14 = engineInterceptor$fetch$1;
                        i4 = intValue;
                        obj2 = fetch;
                        engineInterceptor$fetch$13 = engineInterceptor$fetch$14;
                        FetchResult fetchResult2 = (FetchResult) obj2;
                        eventListener.fetchEnd(imageRequest, first, options, fetchResult2);
                        if (fetchResult2 == null) {
                        }
                    } catch (Throwable th) {
                        SourceResult sourceResult = fetchResult2 instanceof SourceResult ? (SourceResult) fetchResult2 : null;
                        if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                            Utils.closeQuietly(source);
                        }
                        throw th;
                    }
                }
            }
        }
        engineInterceptor$fetch$1 = new EngineInterceptor$fetch$1(this, continuation);
        Object obj22 = engineInterceptor$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$fetch$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:10:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceResult sourceResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        EngineInterceptor$decode$1 engineInterceptor$decode$1;
        int i;
        int i2;
        EngineInterceptor engineInterceptor;
        Pair<Decoder, Integer> newDecoder;
        if (continuation instanceof EngineInterceptor$decode$1) {
            engineInterceptor$decode$1 = (EngineInterceptor$decode$1) continuation;
            if ((engineInterceptor$decode$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptor$decode$1.label -= Integer.MIN_VALUE;
                Object obj2 = engineInterceptor$decode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptor$decode$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    engineInterceptor = this;
                    newDecoder = componentRegistry.newDecoder(sourceResult, options, engineInterceptor.imageLoader, i2);
                    if (newDecoder != null) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = engineInterceptor$decode$1.I$0;
                    Decoder decoder = (Decoder) engineInterceptor$decode$1.L$7;
                    EventListener eventListener2 = (EventListener) engineInterceptor$decode$1.L$6;
                    Options options2 = (Options) engineInterceptor$decode$1.L$5;
                    Object obj3 = engineInterceptor$decode$1.L$4;
                    ImageRequest imageRequest2 = (ImageRequest) engineInterceptor$decode$1.L$3;
                    ComponentRegistry componentRegistry2 = (ComponentRegistry) engineInterceptor$decode$1.L$2;
                    SourceResult sourceResult2 = (SourceResult) engineInterceptor$decode$1.L$1;
                    engineInterceptor = (EngineInterceptor) engineInterceptor$decode$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    EngineInterceptor$decode$1 engineInterceptor$decode$12 = engineInterceptor$decode$1;
                    int i4 = i3;
                    sourceResult = sourceResult2;
                    EngineInterceptor$decode$1 engineInterceptor$decode$13 = engineInterceptor$decode$12;
                    eventListener = eventListener2;
                    imageRequest = imageRequest2;
                    options = options2;
                    obj = obj3;
                    DecodeResult decodeResult = (DecodeResult) obj2;
                    eventListener.decodeEnd(imageRequest, decoder, options, decodeResult);
                    if (decodeResult != null) {
                        i2 = i4;
                        componentRegistry = componentRegistry2;
                        engineInterceptor$decode$1 = engineInterceptor$decode$13;
                        newDecoder = componentRegistry.newDecoder(sourceResult, options, engineInterceptor.imageLoader, i2);
                        if (newDecoder != null) {
                            throw new IllegalStateException(("Unable to create a decoder that supports: " + obj).toString());
                        }
                        Decoder first = newDecoder.getFirst();
                        int intValue = newDecoder.getSecond().intValue() + 1;
                        eventListener.decodeStart(imageRequest, first, options);
                        engineInterceptor$decode$1.L$0 = engineInterceptor;
                        engineInterceptor$decode$1.L$1 = sourceResult;
                        engineInterceptor$decode$1.L$2 = componentRegistry;
                        engineInterceptor$decode$1.L$3 = imageRequest;
                        engineInterceptor$decode$1.L$4 = obj;
                        engineInterceptor$decode$1.L$5 = options;
                        engineInterceptor$decode$1.L$6 = eventListener;
                        engineInterceptor$decode$1.L$7 = first;
                        engineInterceptor$decode$1.I$0 = intValue;
                        engineInterceptor$decode$1.label = 1;
                        Object decode = first.decode(engineInterceptor$decode$1);
                        if (decode == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        componentRegistry2 = componentRegistry;
                        decoder = first;
                        EngineInterceptor$decode$1 engineInterceptor$decode$14 = engineInterceptor$decode$1;
                        i4 = intValue;
                        obj2 = decode;
                        engineInterceptor$decode$13 = engineInterceptor$decode$14;
                        DecodeResult decodeResult2 = (DecodeResult) obj2;
                        eventListener.decodeEnd(imageRequest, decoder, options, decodeResult2);
                        if (decodeResult2 != null) {
                        }
                    } else {
                        Drawable drawable = decodeResult2.getDrawable();
                        boolean isSampled = decodeResult2.getIsSampled();
                        DataSource dataSource = sourceResult.getDataSource();
                        ImageSource source = sourceResult.getSource();
                        FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                        return new ExecuteResult(drawable, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey() : null);
                    }
                }
            }
        }
        engineInterceptor$decode$1 = new EngineInterceptor$decode$1(this, continuation);
        Object obj22 = engineInterceptor$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptor$decode$1.label;
        if (i != 0) {
        }
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (!transformations.isEmpty()) {
            if (!(executeResult.getDrawable() instanceof BitmapDrawable) && !imageRequest.getAllowConversionToBitmap()) {
                Logger logger = this.logger;
                if (logger != null && logger.getLevel() <= 4) {
                    logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', null);
                }
            } else {
                return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
            }
        }
        return executeResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + '.', null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }
    }
}
