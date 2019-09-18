package org.python.stdlib.datetime;

public class datetime extends org.python.types.Object {
    @org.python.Method(
            __doc__ = "\nDatetime.datetime\n",
            default_args = {"year, month, day"}
    )
    public datetime(org.python.Object year, org.python.Object month, org.python.Object day, org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs){

        // if more than 7 arguments
        if (args.length > 7) {
            throw new org.python.exceptions.TypeError("datetime() takes at most 10 arguments (" + args.length + " given)");
        }

        // checks

        if(!validYear(year)|| !validMonth(month) || !validDay(day)){
          throw new org.python.exceptions.ValueError("invalid arguments");
        }

        // create array of org.python.objects??
        org.python.Object[] argArray = new org.python.Object[args.length];

        // return datetime object
        super(new org.python.Object[]{args[1]}, kwargs);
        // return something
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
