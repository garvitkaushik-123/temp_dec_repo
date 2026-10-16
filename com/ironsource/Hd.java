package com.ironsource;

/* loaded from: classes6.dex */
public interface Hd extends InterfaceC3317tb<Integer, Integer> {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2901a = new a();
        public static final int b = 1201;
        public static final int c = 1202;
        public static final int d = 1005;
        public static final int e = 1206;
        public static final int f = 1006;
        public static final int g = 1203;
        public static final int h = 1507;
        public static final int i = 1010;
        public static final int j = 1210;
        public static final int k = 1211;

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f2902a = new b();

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f2903a = new c();
        public static final int b = 1001;
        public static final int c = 1002;
        public static final int d = 1200;
        public static final int e = 1301;
        public static final int f = 1503;
        public static final int g = 1504;

        private c() {
        }
    }

    public static final class d implements Hd {
        @Override // com.ironsource.InterfaceC3317tb
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }

        public Integer a(int i) throws IllegalArgumentException {
            int i2;
            if (i == 206) {
                i2 = c.f;
            } else if (i == 207) {
                i2 = c.g;
            } else if (i != 401) {
                switch (i) {
                    case 101:
                        i2 = e.b;
                        break;
                    case 102:
                        i2 = e.c;
                        break;
                    case 103:
                        i2 = e.d;
                        break;
                    case 104:
                        i2 = e.e;
                        break;
                    case 105:
                        i2 = e.f;
                        break;
                    default:
                        switch (i) {
                            case 109:
                                i2 = 88002;
                                break;
                            case 110:
                                i2 = e.h;
                                break;
                            case 111:
                                i2 = e.i;
                                break;
                            case 112:
                                i2 = e.j;
                                break;
                            default:
                                switch (i) {
                                    case 201:
                                        i2 = 1001;
                                        break;
                                    case 202:
                                        i2 = 1002;
                                        break;
                                    case 203:
                                        i2 = c.d;
                                        break;
                                    case 204:
                                        i2 = c.e;
                                        break;
                                    default:
                                        switch (i) {
                                            case 403:
                                                i2 = a.c;
                                                break;
                                            case 404:
                                                i2 = 1005;
                                                break;
                                            case 405:
                                                i2 = a.e;
                                                break;
                                            case 406:
                                                i2 = 1006;
                                                break;
                                            case 407:
                                                i2 = a.g;
                                                break;
                                            case 408:
                                                i2 = a.h;
                                                break;
                                            case 409:
                                                i2 = 1010;
                                                break;
                                            case 410:
                                                i2 = a.j;
                                                break;
                                            case 411:
                                                i2 = a.k;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Unknown event code: " + i);
                                        }
                                }
                        }
                }
            } else {
                i2 = a.b;
            }
            return Integer.valueOf(i2);
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f2904a = new e();
        public static final int b = 81500;
        public static final int c = 81510;
        public static final int d = 81301;
        public static final int e = 81300;
        public static final int f = 81002;
        public static final int g = 88002;
        public static final int h = 83003;
        public static final int i = 81302;
        public static final int j = 81077;

        private e() {
        }
    }
}
