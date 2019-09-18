package python;

@org.python.Module(
        __doc__ = ""
)
public class datetime extends org.python.types.Module {
    public datetime() {
        super();
    }

    static {
        timedelta = org.python.types.Type.pythonType(org.python.stdlib.datetime.timedelta.class);
    }

    @org.python.Attribute
    public static org.python.Object timedelta;


    // private static class timedelta implements org.python.Class {
    //     public timedelta() {
    //         super();
    //     }

    //     public java.lang.String __doc__() {
    //         return "";
    //     }
    // }
}
