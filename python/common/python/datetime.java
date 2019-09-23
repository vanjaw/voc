package python;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.python.Module(
        __doc__ = ""
)
public class datetime extends org.python.types.Module {
    public datetime() {
        super();
    }

    static {
        timedelta = org.python.types.Type.pythonType(org.python.stdlib.datetime.timedelta.class);
        date = org.python.types.Type.pythonType(org.python.stdlib.datetime.date.class);
    }

    @org.python.Attribute
    public static org.python.Object timedelta;
    @org.python.Attribute
    public static org.python.Object date;
}
