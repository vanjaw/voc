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
            default_args = {"days", "seconds", "microseconds", "minutes", "hours", "weeks"}
    )
    public timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        org.python.Object days         = args[0];
        org.python.Object seconds      = args[1];
        org.python.Object microseconds = args[2];
        org.python.Object minutes      = args[3];
        org.python.Object hours        = args[4];
        org.python.Object weeks        = args[5];

        if (days != null && kwargs.containsKey("days")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('days') and position (1)");
        }

        if (seconds != null && kwargs.containsKey("seconds")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('seconds') and position (2)");
        }

        if (microseconds != null && kwargs.containsKey("microseconds")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('microseconds') and position (3)");
        }

        if (minutes != null && kwargs.containsKey("minutes")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('minutes') and position (4)");
        }

        if (hours != null && kwargs.containsKey("hours")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('hours') and position (5)");
        }

        if (weeks != null && kwargs.containsKey("weeks")) {
            throw new org.python.exceptions.TypeError("argument for __new__() given by name ('weeks') and position (6)");
        }

        for (String key : kwargs.keySet()) {
            switch (key) {
                case "days":
                case "seconds":
                case "microseconds":
                case "minutes":
                case "hours":
                case "weeks":
                    break;
                default:
                    throw new org.python.exceptions.TypeError("'" + key + "' is an invalid keyword argument for __new__()");
            }
        }

        if (days != null) {
            if (!(days instanceof org.python.types.Int) && !(days instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta days component: " + org.Python.typeName(((org.python.types.Type) days.type()).klass));
            }
        }

        if (seconds != null) {
            if (!(seconds instanceof org.python.types.Int) && !(seconds instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta seconds component: " + org.Python.typeName(((org.python.types.Type) seconds.type()).klass));
            }
        }

        if (microseconds != null) {
            if (!(microseconds instanceof org.python.types.Int) && !(microseconds instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta microseconds component: " + org.Python.typeName(((org.python.types.Type) microseconds.type()).klass));
            }
        }

        if (minutes != null) {
            if (!(minutes instanceof org.python.types.Int) && !(minutes instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta minutes component: " + org.Python.typeName(((org.python.types.Type) minutes.type()).klass));
            }
        }

        if (hours != null) {
            if (!(hours instanceof org.python.types.Int) && !(hours instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta hours component: " + org.Python.typeName(((org.python.types.Type) hours.type()).klass));
            }
        }

        if (weeks != null) {
            if (!(weeks instanceof org.python.types.Int) && !(weeks instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError("unsupported type for timedelta weeks component: " + org.Python.typeName(((org.python.types.Type) weeks.type()).klass));
            }
        }

        org.python.types.Int zero = org.python.types.Int.getInt(0);
        org.python.types.Int secondsPerDay = org.python.types.Int.getInt(24 * 60 * 60);
        org.python.types.Int microsPerSecond = org.python.types.Int.getInt(1000 * 1000);

        org.python.types.Object daysValue = zero;
        org.python.types.Object secondsValue = zero;
        org.python.types.Object microsecondsValue = zero;

        if (days != null) {
            daysValue = (org.python.types.Object) days;
        }
        if (weeks != null) {
            daysValue = (org.python.types.Object) daysValue.__add__(weeks.__mul__(org.python.types.Int.getInt(7)));
        }
        if (seconds != null) {
            secondsValue = (org.python.types.Object) seconds;
        }
        if (minutes != null) {
            secondsValue = (org.python.types.Object) secondsValue.__add__(minutes.__mul__(org.python.types.Int.getInt(60)));
        }
        if (hours != null) {
            secondsValue = (org.python.types.Object) secondsValue.__add__(hours.__mul__(org.python.types.Int.getInt(60 * 60)));
        }
        if (microseconds != null) {
            microsecondsValue = (org.python.types.Object) microsecondsValue;
        }

        // De-floating

        if (daysValue instanceof org.python.types.Float) {
            org.python.types.Int whole = (org.python.types.Int) daysValue.__int__();
            org.python.types.Float part = (org.python.types.Float) daysValue.__sub__(whole);

            daysValue = whole;
            secondsValue = (org.python.types.Object) secondsValue.__add__(part.__mul__(secondsPerDay));
        }

        if (secondsValue instanceof org.python.types.Float) {
            org.python.types.Int whole = (org.python.types.Int) secondsValue.__int__();
            org.python.types.Float part = (org.python.types.Float) secondsValue.__sub__(whole);

            secondsValue = whole;
            microsecondsValue = (org.python.types.Object) microsecondsValue.__add__(part.__mul__(microsPerSecond));
        }

        if (microsecondsValue instanceof org.python.types.Float) {
            microsecondsValue = (org.python.types.Object) microsecondsValue.__round__(zero).__int__();
        }

        // Normalization

        if (
            ((org.python.types.Bool) microsecondsValue.__lt__(zero)).value
            || ((org.python.types.Bool) microsecondsValue.__ge__(microsPerSecond)).value
        ) {
            org.python.types.Int adjust = (org.python.types.Int) microsecondsValue.__floordiv__(microsPerSecond).__int__();

            secondsValue = (org.python.types.Int) secondsValue.__add__(adjust);
            microsecondsValue = (org.python.types.Object) microsecondsValue.__sub__(adjust.__mul__(microsPerSecond));
        }

        if (
            ((org.python.types.Bool) secondsValue.__lt__(zero)).value
            || ((org.python.types.Bool) secondsValue.__ge__(secondsPerDay)).value
        ) {
            org.python.types.Int adjust = (org.python.types.Int) secondsValue.__floordiv__(secondsPerDay);

            daysValue = (org.python.types.Int) daysValue.__add__(adjust);
            secondsValue = (org.python.types.Int) secondsValue.__sub__(adjust.__mul__(secondsPerDay));
        }

        this.days = (org.python.types.Int) daysValue;
        this.seconds = (org.python.types.Int) secondsValue;
        this.microseconds = (org.python.types.Int) microsecondsValue;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __str__() {
        return this.__repr__();
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __repr__() {
        return new org.python.types.Str(
            "datetime.timedelta(days=" +
            ((org.python.types.Str) this.days.__repr__()).value +
            ", seconds=" +
            ((org.python.types.Str) this.seconds.__repr__()).value +
            ", microseconds=" +
            ((org.python.types.Str) this.microseconds.__repr__()).value +
            ")"
        );
    }
}
