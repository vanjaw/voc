package python;

@org.python.Module(
        __doc__ = ""
)
public class datetime extends org.python.types.Module {
    public datetime() {
        super();
    }

    @org.python.Method(
            __doc__ = ""
    )
    public static org.python.types.Object date(org.python.types.Object year, org.python.types.Object month, org.python.types.Object day) {
        // TODO: validera
        // super(year, month, day);
        return new org.python.types.Object(java.util.Date(year, month, day));
    }


    //static {
    //    timedelta = org.python.types.Type.pythonType(org.python.stdlib.datetime.timedelta.class);
    //    date = org.python.types.Type.pythonType(org.python.stdlib.datetime.date.class);
    //}

    //@org.python.Attribute
    //public static org.python.Object timedelta;
    //public static org.python.Object date;


    // private static class timedelta implements org.python.Class {
    //     public timedelta() {
    //         super();
    //     }

    //     public java.lang.String __doc__() {
    //         return "";
    //     }
    // }
}
