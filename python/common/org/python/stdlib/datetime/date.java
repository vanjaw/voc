package org.python.stdlib.datetime;


public class date extends org.python.types.Object {
    private java.util.Date date;
    private String pattern = "yyyy-MM-dd";
    @org.python.Attribute
    public org.python.types.Int year;
    @org.python.Attribute
    public org.python.types.Int month;
    @org.python.Attribute
    public org.python.types.Int day;

    @org.python.Attribute
    public static date min = new date(1,1,1);
    @org.python.Attribute
    public static date max = new date(9999,12,31);
    // TODO: Andreas kolla på
    // @org.python.Attribute
    // static org.python.types.Object resolution;

    @org.python.Method(
            __doc__ = "",
            default_args = {"year", "month", "day"}
    )
    public date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

        org.python.Object year = args[0];
        org.python.Object month = args[1];
        org.python.Object day = args[2];

        // 1. non-null args length + kwargs.size() > 3
        // 2. Kolla args[...] == null
        // 3. kolla datatyper
        // 4. Kolla giltig data

        int nrOfArguments = kwargs.size();
        for (int i = 0; i < args.length; i++) {
            if(args[i] != null) {
                nrOfArguments++;
            }
        }

        if (nrOfArguments > 3) {
            throw new org.python.exceptions.TypeError(
                "function takes at most 3 arguments (" + args.length + " given)"
                );
        }

        /* Testing inputs exist*/
        if (year == null) {
           throw new org.python.exceptions.TypeError(
                "function missing required argument 'year' (pos 1)"
                );
        }

        if (month == null) {
           throw new org.python.exceptions.TypeError(
                "function missing required argument 'month' (pos 2)"
                );
        }

        if (day == null) {
           throw new org.python.exceptions.TypeError(
                "function missing required argument 'day' (pos 3)"
                );
        }

        /* Testing types  */
        if (!(year instanceof org.python.types.Int)) {
            throw new org.python.exceptions.TypeError(
                "an integer is required (got type " + org.Python.typeName(((org.python.types.Type) year.type()).klass) + ")"
            );
        }

        if (!(month instanceof org.python.types.Int)) {
            throw new org.python.exceptions.TypeError(
                "an integer is required (got type " + org.Python.typeName(((org.python.types.Type) month.type()).klass) + ")"
            );
        }

        if (!(day instanceof org.python.types.Int)) {
            throw new org.python.exceptions.TypeError(
                "an integer is required (got type " + org.Python.typeName(((org.python.types.Type) day.type()).klass) + ")"
            );
        }

        /* Testing Valid data*/
        String yeartemp = "" + year;
        int testyear = Integer.parseInt(yeartemp);
        if (testyear < 1 || testyear > 9999) {
            throw new org.python.exceptions.ValueError(
                "year " + testyear + " is out of range"
            );
        }

        String monthtemp = "" + month;
        int testmonth = Integer.parseInt(monthtemp);
        if (testmonth < 1 || testmonth > 12) {
            throw new org.python.exceptions.ValueError(
                "month must be in 1..12"
            );
        }

        String daytemp = "" + day;
        int testday = Integer.parseInt(daytemp);
        if (testday < 1 || testday > 31) {
            throw new org.python.exceptions.ValueError(
                "day is out of range for month"
            );
        }

        if (testday == 31 && (testmonth == 4 || testmonth == 6 || testmonth == 9 || testmonth == 11)) {
            throw new org.python.exceptions.ValueError(
                "day is out of range for month"
            );
        }

        if (testmonth == 2 && (testday > 29 ||
            (testday == 29 && ((testyear % 4 != 0) || ((testyear % 100 == 0) && (testyear % 400 != 0)))))) {
            throw new org.python.exceptions.ValueError(
                "day is out of range for month"
            );
        }

        try {
            this.date = new java.text.SimpleDateFormat(this.pattern).parse(
                year + "-" + month + "-" + day
            );
        } catch (Exception e) {
            this.date = null;
        }
        this.year = (org.python.types.Int) year;
        this.month = (org.python.types.Int) month;
        this.day = (org.python.types.Int) day;
    }

    // hmm
    public date(int year, int month, int day) {
        try {
            this.date = new java.text.SimpleDateFormat(this.pattern).parse(
                year + "-" + month + "-" + day
            );
        } catch (Exception e) {
            this.date = null;
        }
        this.year = org.python.types.Int.getInt(year);
        this.month = org.python.types.Int.getInt(month);
        this.day = org.python.types.Int.getInt(day);
    }

    private date(java.util.Date date) {
        this.date = date;
        this.year = org.python.types.Int.getInt(Integer.parseInt(new java.text.SimpleDateFormat("yyyy").format(date)));
        this.month = org.python.types.Int.getInt(Integer.parseInt(new java.text.SimpleDateFormat("MM").format(date)));
        this.day = org.python.types.Int.getInt(Integer.parseInt(new java.text.SimpleDateFormat("dd").format(date)));
    }


    /* Methods */
    @org.python.Method(
        __doc__ = ""
    )
    public static org.python.types.Object today() {
        return new date(new java.util.Date());
    }

    @org.python.Method(
        __doc__= ""
    )
    public org.python.types.Object weekday() {
        String weekstring = new java.text.SimpleDateFormat("u").format(this.date);
        return org.python.types.Int.getInt(Integer.parseInt(weekstring)-1);
    }

    @org.python.Method(
        __doc__= ""
    )
    public org.python.types.Object isoweekday() {
        String weekstring = new java.text.SimpleDateFormat("u").format(this.date);
        return org.python.types.Int.getInt(Integer.parseInt(weekstring));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __repr__() {
        String dateString = new java.text.SimpleDateFormat(this.pattern).format(this.date);
        return new org.python.types.Str(dateString);
    }


}
