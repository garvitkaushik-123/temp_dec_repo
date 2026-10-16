package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes6.dex */
public final class EventBus {
    private static volatile EventBus o;
    private boolean k;
    static ExecutorService n = Executors.newCachedThreadPool();
    public static String TAG = "Event";
    private static final Map<Class<?>, List<Class<?>>> p = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f4155a = new HashMap();
    private final Map<Object, List<Class<?>>> b = new HashMap();
    private final Map<Class<?>, Object> c = new ConcurrentHashMap();
    private final ThreadLocal<List<Object>> d = new ThreadLocal<List<Object>>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Object> initialValue() {
            return new ArrayList();
        }
    };
    private final ThreadLocal<BooleanWrapper> e = new ThreadLocal<BooleanWrapper>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BooleanWrapper initialValue() {
            return new BooleanWrapper();
        }
    };
    private String f = "onEvent";
    private final HandlerPoster g = new HandlerPoster(this, Looper.getMainLooper(), 10);
    private final BackgroundPoster h = new BackgroundPoster(this);
    private final AsyncPoster i = new AsyncPoster(this);
    private final SubscriberMethodFinder j = new SubscriberMethodFinder();
    private boolean l = true;
    private Map<String, Object> m = new ConcurrentHashMap();

    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4158a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f4158a = iArr;
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4158a[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4158a[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4158a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class BooleanWrapper {

        /* renamed from: a, reason: collision with root package name */
        boolean f4159a;

        BooleanWrapper() {
        }
    }

    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private void a(Object obj, String str, boolean z) {
        Iterator<SubscriberMethod> it = this.j.a(obj.getClass(), str).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z);
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        p.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (o == null) {
            synchronized (EventBus.class) {
                if (o == null) {
                    o = new EventBus();
                }
            }
        }
        return o;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public void configureLogSubscriberExceptions(boolean z) {
        if (this.k) {
            throw new EventBusException("This method must be called before any registration");
        }
        this.l = z;
    }

    public Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.c) {
            obj = this.c.get(cls);
        }
        return obj;
    }

    public void post(Object obj) {
        List<Object> list = this.d.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.e.get();
        if (booleanWrapper.f4159a) {
            return;
        }
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        booleanWrapper.f4159a = true;
        while (!list.isEmpty()) {
            try {
                a(list.remove(0), z);
            } finally {
                booleanWrapper.f4159a = false;
            }
        }
    }

    public void postSticky(Object obj) {
        post(obj);
        synchronized (this.c) {
            this.c.put(obj.getClass(), obj);
        }
    }

    public void register(Object obj) {
        a(obj, this.f, false);
    }

    public void registerSticky(Object obj) {
        a(obj, this.f, true);
    }

    public void release() {
        if (o != null) {
            o = null;
            n = null;
            Map<Class<?>, List<Class<?>>> map = p;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f4155a;
            if (map2 != null && map2.size() > 0) {
                this.f4155a.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.b;
            if (map3 != null && map3.size() > 0) {
                this.b.clear();
            }
            Map<Class<?>, Object> map4 = this.c;
            if (map4 != null && map4.size() > 0) {
                this.c.clear();
            }
            Map<String, Object> map5 = this.m;
            if (map5 == null || map5.size() <= 0) {
                return;
            }
            this.m.clear();
        }
    }

    public Object removeStickyEvent(Class<?> cls) {
        Object remove;
        synchronized (this.c) {
            remove = this.c.remove(cls);
        }
        return remove;
    }

    public synchronized void unregister(Object obj, Class<?>... clsArr) {
        if (clsArr.length == 0) {
            throw new IllegalArgumentException("Provide at least one event class");
        }
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : clsArr) {
                a(obj, cls);
                list.remove(cls);
            }
            if (list.isEmpty()) {
                this.b.remove(obj);
            }
        } else {
            Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void register(String str, Object obj) {
        Map<String, Object> map = this.m;
        if (map != null && map.containsKey(str)) {
            unregister(this.m.get(str));
        }
        this.m.put(str, obj);
        a(obj, this.f, false);
    }

    public void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    public void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f, true, cls, clsArr);
    }

    public synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, true, cls, clsArr);
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.c.get(cls))) {
                return false;
            }
            this.c.remove(cls);
            return true;
        }
    }

    private synchronized void a(Object obj, String str, boolean z, Class<?> cls, Class<?>... clsArr) {
        for (SubscriberMethod subscriberMethod : this.j.a(obj.getClass(), str)) {
            if (cls == subscriberMethod.c) {
                a(obj, subscriberMethod, z);
            } else if (clsArr != null) {
                int length = clsArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (clsArr[i] == subscriberMethod.c) {
                        a(obj, subscriberMethod, z);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public void register(Object obj, String str) {
        a(obj, str, false);
    }

    public void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f, false, cls, clsArr);
    }

    public synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, false, cls, clsArr);
    }

    public synchronized void unregister(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.b.remove(obj);
        } else {
            Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z) {
        Object obj2;
        this.k = true;
        Class<?> cls = subscriberMethod.c;
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f4155a.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f4155a.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<Subscription> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f4163a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.c) {
                obj2 = this.c.get(cls);
            }
            if (obj2 != null) {
                a(subscription, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    public synchronized void unregister(String str) {
        Map<String, Object> map = this.m;
        if (map != null && map.containsKey(str)) {
            Object remove = this.m.remove(str);
            List<Class<?>> list = this.b.get(remove);
            if (list != null) {
                Iterator<Class<?>> it = list.iterator();
                while (it.hasNext()) {
                    a(remove, it.next());
                }
                this.b.remove(remove);
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + remove.getClass());
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f4155a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                if (copyOnWriteArrayList.get(i).f4165a == obj) {
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void a(Object obj, boolean z) throws Error {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                List<Class<?>> a2 = a(cls);
                int size = a2.size();
                boolean z2 = false;
                for (int i = 0; i < size; i++) {
                    Class<?> cls2 = a2.get(i);
                    synchronized (this) {
                        copyOnWriteArrayList = this.f4155a.get(cls2);
                    }
                    if (copyOnWriteArrayList != null) {
                        Iterator<Subscription> it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            a(it.next(), obj, z);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                Log.d(TAG, "No subscripers registered for event " + cls);
                if (cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class) {
                    return;
                }
                post(new NoSubscriberEvent(this, obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Subscription subscription, Object obj, boolean z) {
        int i = AnonymousClass3.f4158a[subscription.b.b.ordinal()];
        if (i == 1) {
            a(subscription, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                a(subscription, obj);
                return;
            } else {
                this.g.a(subscription, obj);
                return;
            }
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException("Unknown thread mode: " + subscription.b.b);
            }
            this.i.enqueue(subscription, obj);
        } else if (z) {
            this.h.enqueue(subscription, obj);
        } else {
            a(subscription, obj);
        }
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = p;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                p.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    void a(PendingPost pendingPost) {
        Object obj = pendingPost.f4161a;
        Subscription subscription = pendingPost.b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.b.f4163a.invoke(subscription.f4165a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof SubscriberExceptionEvent) {
                Log.e(TAG, "SubscriberExceptionEvent subscriber " + subscription.f4165a.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                Log.e(TAG, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
            } else {
                if (this.l) {
                    Log.e(TAG, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f4165a.getClass(), cause);
                }
                post(new SubscriberExceptionEvent(this, cause, obj, subscription.f4165a));
            }
        }
    }
}
