package org.python.stdlib.datetime;

public class datetime extends org.python.types.Object {
    private static final long MIN_YEAR = 1;
    private static final long MAX_YEAR = 9999;
    private static final long MIN_MONTH = 1;
    private static final long MAX_MONTH = 12;
    private static final long MIN_DAY = 1;
    private static final long MAX_DAY = 31;
    private static final long MIN_HOUR = 0;
    private static final long MAX_HOUR = 24;
    private static final long MIN_MINUTE = 0;
    private static final long MAX_MINUTE = 60;
    private static final long MIN_SECOND = 0;
    private static final long MAX_SECOND = 60;
    private static final long MIN_MICROSECOND = 0;
    private static final long MAX_MICROSECOND = 1000000;

    @org.python.Attribute public final org.python.types.Int year;
    @org.python.Attribute public final org.python.types.Int month;
    @org.python.Attribute public final org.python.types.Int day;
    @org.python.Attribute public final org.python.types.Int hour;
    @org.python.Attribute public final org.python.types.Int minute;
    @org.python.Attribute public final org.python.types.Int second;
    @org.python.Attribute public final org.python.types.Int microsecond;
    @org.python.Attribute public final org.python.types.Object tzinfo;
    @org.python.Attribute public final org.python.types.Int fold;

    @org.python.Method(
            __doc__ = "\nDatetime.datetime\n",
            default_args = {"year", "month", "day", "hour", "minute", "second", "microsecond", "tzinfo", "fold"}
    )
    public datetime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs){
        if ((args.length + kwargs.length) < 3){
          throw new org.python.exceptions.TypeError("3 arguments required");
        }

        // make sure that args > 3 or that "year, month, day" exists in kwargs

        this.year = kwargs.get('year');
        this.month = kwargs.get('month');
        this.day = kwargs.get('day');
        this.hour = kwargs.get('hour', 0); // kwargs.get['hour', 0] ??
        this.minute = kwargs.get('minute', 0);
        this.second = kwargs.get('second', 0);
        this.microsecond = kwargs.get('microsecond', 0);
        this.tzinfo = kwargs.get('tzinfo', None);
        this.fold = kwargs.get('fold', 0);

        if args.length > 0 {
            validateInput(args[0], MIN_YEAR, MAX_YEAR);
            this.year = args[0]; // (org.python.types.Int) args[0] ??
            if args.length > 1 {
                validateInput(args[1], MIN_MONTH, MAX_MONTH);
                this.month = args[1];
                if args.length > 2 {
                    validateInput(args[2], MIN_DAY, MAX_DAY);
                    this.day = args[2];
                    if args.length > 3 {
                        validateInput(args[3], MIN_HOUR, MAX_HOUR);
                        this.hour = args[3];
                        if args.length > 4 {
                            validateInput(args[4], MIN_MINUTE, MAX_MINUTE);
                            this.minute = args[4];
                            if args.length > 5 {
                                validateInput(args[5], MIN_SECOND, MAX_SECOND);
                                this.second = args[5];
                                if args.length > 6 {
                                    validateInput(args[0], MIN_MICROSECOND, MAX_MICROSECOND);
                                    this.microsecond = args[6];
                                    if args.length > 7 {
                                        if args[7] == NONE {
                                            this.tzinfo = args[7];
                                            if args.length > 8 {
                                                // error (max 8 args since "fold" can only be in kwargs)
                                            }
                                        }
                                        else {
                                            throw new org.python.exceptions.TypeError("Tzinfo should be set to 'None'");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    private static org.python.types.Bool validateInput(org.python.types.Int attribute, org.python.types.Int minValue, org.python.types.Int maxValue){
        if(attribute instanceof org.python.types.Int){
            if(((org.python.types.Int) args[0]).value < minValue || ((org.python.types.Int) args[0]).value > maxValue){
                throw new org.python.exceptions.ValueError("Value is out of range")
            }
        } else{
            throw new org.python.exceptions.NameError("Name is not defined");
        }
     }



    /*
    To implement :
    class methods -> datetime.today()
    class attribute -> datetime.min
    instance attribute -> datetime.year
    instance method 1 -> datetime.time
    instance method 2 -> datetime.date
    */

}
