package com.ironsource;

/* renamed from: com.ironsource.x9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3383x9 extends InterfaceC3317tb<Integer, Integer> {

    /* renamed from: com.ironsource.x9$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3933a = new a();
        public static final int b = 2201;
        public static final int c = 2203;
        public static final int d = 2005;
        public static final int e = 2210;
        public static final int f = 2006;
        public static final int g = 2204;
        public static final int h = 2507;
        public static final int i = 2211;
        public static final int j = 2212;

        private a() {
        }
    }

    /* renamed from: com.ironsource.x9$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3934a = new b();
        public static final int b = 2002;
        public static final int c = 2003;
        public static final int d = 2200;
        public static final int e = 2503;
        public static final int f = 2504;
        public static final int g = 2300;

        private b() {
        }
    }

    /* renamed from: com.ironsource.x9$c */
    public static final class c implements InterfaceC3383x9 {
        @Override // com.ironsource.InterfaceC3317tb
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }

        public Integer a(int i) throws IllegalArgumentException {
            int i2;
            if (i == 206) {
                i2 = b.e;
            } else if (i == 207) {
                i2 = b.f;
            } else if (i == 401) {
                i2 = 2201;
            } else if (i == 410) {
                i2 = a.i;
            } else if (i != 411) {
                switch (i) {
                    case 101:
                        i2 = d.b;
                        break;
                    case 102:
                        i2 = d.c;
                        break;
                    case 103:
                        i2 = d.h;
                        break;
                    case 104:
                        i2 = d.d;
                        break;
                    case 105:
                        i2 = d.e;
                        break;
                    default:
                        switch (i) {
                            case 109:
                                i2 = 88002;
                                break;
                            case 110:
                                i2 = 83004;
                                break;
                            case 111:
                                i2 = d.i;
                                break;
                            case 112:
                                i2 = d.j;
                                break;
                            default:
                                switch (i) {
                                    case 201:
                                        i2 = 2002;
                                        break;
                                    case 202:
                                        i2 = 2003;
                                        break;
                                    case 203:
                                        i2 = 2200;
                                        break;
                                    case 204:
                                        i2 = b.g;
                                        break;
                                    default:
                                        switch (i) {
                                            case 403:
                                                i2 = 2203;
                                                break;
                                            case 404:
                                                i2 = 2005;
                                                break;
                                            case 405:
                                                i2 = a.e;
                                                break;
                                            case 406:
                                                i2 = 2006;
                                                break;
                                            case 407:
                                                i2 = a.g;
                                                break;
                                            case 408:
                                                i2 = a.h;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Unknown event code: " + i);
                                        }
                                }
                        }
                }
            } else {
                i2 = a.j;
            }
            return Integer.valueOf(i2);
        }
    }

    /* renamed from: com.ironsource.x9$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3935a = new d();
        public static final int b = 82500;
        public static final int c = 82510;
        public static final int d = 82300;
        public static final int e = 82002;
        public static final int f = 83004;
        public static final int g = 88002;
        public static final int h = 82301;
        public static final int i = 82302;
        public static final int j = 82076;

        private d() {
        }
    }
}
