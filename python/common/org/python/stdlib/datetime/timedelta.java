package org.python.stdlib.datetime;

public class timedelta extends org.python.types.Object {
    @org.python.Attribute
    public final org.python.types.Int days;
    @org.python.Attribute
    public final org.python.types.Int seconds;
    @org.python.Attribute
    public final org.python.types.Int microseconds;

    @org.python.Method(
            __doc__ = "",
            default_args = {"days", "seconds", "microseconds"}//, "minutes", "hours", "weeks"}
    )
    public timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        if (args[0] != null) {
            if (args[0] instanceof org.python.types.Int) {
                this.days = (org.python.types.Int) args[0];
            }
            else
            {
                this.days = null;
            }
        }
        else
        {
            this.days = null;
        }
        this.seconds = null;
        this.microseconds = null;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __str__() {
        return new org.python.types.Str("timedelta object");
    }
}
