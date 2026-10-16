package io.ktor.client.plugins.cookies;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: AcceptAllCookiesStorage.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0019B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0002J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "<init>", "()V", "Lio/ktor/http/Url;", IronSourceConstants.REQUEST_URL, "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timestamp", "cleanup", "(J)V", "close", "", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "container", "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "ktor-client-core", "Lio/ktor/client/plugins/cookies/CookiesStorage;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final List<Cookie> container = new ArrayList();
    private volatile /* synthetic */ long oldestCookie = 0;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[Catch: all -> 0x008f, TryCatch #0 {all -> 0x008f, blocks: (B:11:0x0056, B:13:0x0060, B:14:0x0063, B:15:0x0072, B:17:0x0078, B:20:0x0085, B:25:0x0089), top: B:10:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[Catch: all -> 0x008f, TryCatch #0 {all -> 0x008f, blocks: (B:11:0x0056, B:13:0x0060, B:14:0x0063, B:15:0x0072, B:17:0x0078, B:20:0x0085, B:25:0x0089), top: B:10:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(Url url, Continuation<? super List<Cookie>> continuation) {
        AcceptAllCookiesStorage$get$1 acceptAllCookiesStorage$get$1;
        int i;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        Url url2;
        Mutex mutex;
        long timeMillis;
        try {
            if (continuation instanceof AcceptAllCookiesStorage$get$1) {
                acceptAllCookiesStorage$get$1 = (AcceptAllCookiesStorage$get$1) continuation;
                if ((acceptAllCookiesStorage$get$1.label & Integer.MIN_VALUE) != 0) {
                    acceptAllCookiesStorage$get$1.label -= Integer.MIN_VALUE;
                    Object obj = acceptAllCookiesStorage$get$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = acceptAllCookiesStorage$get$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.mutex;
                        acceptAllCookiesStorage$get$1.L$0 = this;
                        acceptAllCookiesStorage$get$1.L$1 = url;
                        acceptAllCookiesStorage$get$1.L$2 = mutex2;
                        acceptAllCookiesStorage$get$1.label = 1;
                        if (mutex2.lock(null, acceptAllCookiesStorage$get$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        acceptAllCookiesStorage = this;
                        url2 = url;
                        mutex = mutex2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex = (Mutex) acceptAllCookiesStorage$get$1.L$2;
                        url2 = (Url) acceptAllCookiesStorage$get$1.L$1;
                        acceptAllCookiesStorage = (AcceptAllCookiesStorage) acceptAllCookiesStorage$get$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    timeMillis = DateJvmKt.getTimeMillis();
                    if (timeMillis >= acceptAllCookiesStorage.oldestCookie) {
                        acceptAllCookiesStorage.cleanup(timeMillis);
                    }
                    List<Cookie> list = acceptAllCookiesStorage.container;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (CookiesStorageKt.matches((Cookie) obj2, url2)) {
                            arrayList.add(obj2);
                        }
                    }
                    return arrayList;
                }
            }
            timeMillis = DateJvmKt.getTimeMillis();
            if (timeMillis >= acceptAllCookiesStorage.oldestCookie) {
            }
            List<Cookie> list2 = acceptAllCookiesStorage.container;
            ArrayList arrayList2 = new ArrayList();
            while (r10.hasNext()) {
            }
            return arrayList2;
        } finally {
            mutex.unlock(null);
        }
        acceptAllCookiesStorage$get$1 = new AcceptAllCookiesStorage$get$1(this, continuation);
        Object obj3 = acceptAllCookiesStorage$get$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = acceptAllCookiesStorage$get$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:11:0x005c, B:13:0x0068, B:15:0x0083, B:17:0x008d, B:18:0x008f), top: B:10:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addCookie(final Url url, final Cookie cookie, Continuation<? super Unit> continuation) {
        AcceptAllCookiesStorage$addCookie$1 acceptAllCookiesStorage$addCookie$1;
        int i;
        Mutex mutex;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        try {
            if (continuation instanceof AcceptAllCookiesStorage$addCookie$1) {
                acceptAllCookiesStorage$addCookie$1 = (AcceptAllCookiesStorage$addCookie$1) continuation;
                if ((acceptAllCookiesStorage$addCookie$1.label & Integer.MIN_VALUE) != 0) {
                    acceptAllCookiesStorage$addCookie$1.label -= Integer.MIN_VALUE;
                    Object obj = acceptAllCookiesStorage$addCookie$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = acceptAllCookiesStorage$addCookie$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        acceptAllCookiesStorage$addCookie$1.L$0 = this;
                        acceptAllCookiesStorage$addCookie$1.L$1 = url;
                        acceptAllCookiesStorage$addCookie$1.L$2 = cookie;
                        acceptAllCookiesStorage$addCookie$1.L$3 = mutex;
                        acceptAllCookiesStorage$addCookie$1.label = 1;
                        if (mutex.lock(null, acceptAllCookiesStorage$addCookie$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        acceptAllCookiesStorage = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) acceptAllCookiesStorage$addCookie$1.L$3;
                        cookie = (Cookie) acceptAllCookiesStorage$addCookie$1.L$2;
                        Url url2 = (Url) acceptAllCookiesStorage$addCookie$1.L$1;
                        acceptAllCookiesStorage = (AcceptAllCookiesStorage) acceptAllCookiesStorage$addCookie$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        url = url2;
                    }
                    if (!StringsKt.isBlank(cookie.getName())) {
                        CollectionsKt.removeAll((List) acceptAllCookiesStorage.container, (Function1) new Function1<Cookie, Boolean>() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(Cookie it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return Boolean.valueOf(Intrinsics.areEqual(it.getName(), Cookie.this.getName()) && CookiesStorageKt.matches(it, url));
                            }
                        });
                        acceptAllCookiesStorage.container.add(CookiesStorageKt.fillDefaults(cookie, url));
                        GMTDate expires = cookie.getExpires();
                        if (expires != null) {
                            long timestamp = expires.getTimestamp();
                            if (acceptAllCookiesStorage.oldestCookie > timestamp) {
                                acceptAllCookiesStorage.oldestCookie = timestamp;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            if (!StringsKt.isBlank(cookie.getName())) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
        acceptAllCookiesStorage$addCookie$1 = new AcceptAllCookiesStorage$addCookie$1(this, continuation);
        Object obj2 = acceptAllCookiesStorage$addCookie$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = acceptAllCookiesStorage$addCookie$1.label;
        if (i != 0) {
        }
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt.removeAll((List) this.container, (Function1) new Function1<Cookie, Boolean>() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$cleanup$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Cookie cookie) {
                Intrinsics.checkNotNullParameter(cookie, "cookie");
                GMTDate expires = cookie.getExpires();
                if (expires != null) {
                    return Boolean.valueOf(expires.getTimestamp() < timestamp);
                }
                return false;
            }
        });
        Iterator<T> it = this.container.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            GMTDate expires = ((Cookie) it.next()).getExpires();
            if (expires != null) {
                j = Math.min(j, expires.getTimestamp());
            }
        }
        this.oldestCookie = j;
    }
}
