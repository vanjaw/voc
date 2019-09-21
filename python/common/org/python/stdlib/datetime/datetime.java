package org.python.stdlib.datetime;

import java.time.LocalDateTime;
import java.time.LocalDate;
import org.python.types.Int;


// TZINFO ???
import org.python.types.Object;
import org.python.types.Str;
import org.python.types.NoneType;
// TZINFO ???


public class datetime extends org.python.types.Object {

    @org.python.Attribute
    private static Int MIN_YEAR = Int.getInt(1);
    @org.python.Attribute
    private static Int MAX_YEAR = Int.getInt(9999);
    @org.python.Attribute
    private static Int MIN_MONTH = Int.getInt(1);
    @org.python.Attribute
    private static Int MAX_MONTH = Int.getInt(12);
    @org.python.Attribute
    private static Int MIN_DAY = Int.getInt(1);
    @org.python.Attribute
    private static Int MAX_DAY = Int.getInt(31);
    @org.python.Attribute
    private static Int MIN_HOUR = Int.getInt(0);
    @org.python.Attribute
    private static Int MAX_HOUR = Int.getInt(24);
    @org.python.Attribute
    private static Int MIN_MINUTE = Int.getInt(0);
    @org.python.Attribute
    private static Int MAX_MINUTE = Int.getInt(60);
    @org.python.Attribute
    private static Int MIN_SECOND = Int.getInt(0);
    @org.python.Attribute
    private static Int MAX_SECOND = Int.getInt(60);
    @org.python.Attribute
    private static Int MIN_MICROSECOND = Int.getInt(0);
    @org.python.Attribute
    private static Int MAX_MICROSECOND = Int.getInt(1000000);




    @org.python.Attribute
    public final org.python.types.Int year;
    @org.python.Attribute
    public final org.python.types.Int month;
    @org.python.Attribute
    public final org.python.types.Int day;
    @org.python.Attribute
    public final org.python.types.Int hour;
    @org.python.Attribute
    public final org.python.types.Int minute;
    @org.python.Attribute
    public final org.python.types.Int second;
    @org.python.Attribute
    public final org.python.types.Int microsecond;

    // TZINFO
    @org.python.Attribute
    //public final org.python.types.Object tzinfo;
    //public final org.python.types.Str tzinfo;
    public final org.python.types.NoneType tzinfo;
    // TZINFO

    @org.python.Attribute
    public final org.python.types.Int fold;


    @org.python.Method(
            __doc__ = "Datetime constructor ",
            default_args = {}
    )

    public datetime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {

      if((args.length + kwargs.size()) < 1){
        throw new org.python.exceptions.TypeError("Required argument 'year' (pos 1) not found");
      }
      if((args.length + kwargs.size()) < 2){
        throw new org.python.exceptions.TypeError("Required argument 'month' (pos 2) not found");
      }
      if((args.length + kwargs.size()) < 3){
        throw new org.python.exceptions.TypeError("Required argument 'day' (pos 3) not found");
      }
      if((args.length + kwargs.size()) > 9){
        throw new org.python.exceptions.TypeError("function takes at 9 arguments");
      }
      if((args.length) > 8){
        throw new org.python.exceptions.TypeError("function takes at most 8 positional arguments");
      }

      // check if positional argument follows keyword argument 

      // at least 3 arguments :

      // "Variable might already have been assigned"

      Int yearDefault = null;
      Int monthDefault = null;
      Int dayDefault = null;

      Int hourDefault = Int.getInt(0);;
      Int minuteDefault = Int.getInt(0);;
      Int secondDefault = Int.getInt(0);;
      Int microsecondDefault = Int.getInt(0);;

      NoneType tzinfoDefault = null; // hmmmm
      Int foldDefault = Int.getInt(0);


      if (args.length > 0) {
                  validateInput((org.python.types.Int) args[0], MIN_YEAR, MAX_YEAR);
                  yearDefault = (org.python.types.Int) args[0];
                  if (args.length > 1) {
                      validateInput((org.python.types.Int) args[1], MIN_MONTH, MAX_MONTH);
                      monthDefault = (org.python.types.Int) args[1];
                      if (args.length > 2) {
                          validateInput((org.python.types.Int) args[2], MIN_DAY, MAX_DAY);
                          dayDefault = (org.python.types.Int) args[2];
                          if (args.length > 3) {
                              validateInput((org.python.types.Int) args[3], MIN_HOUR, MAX_HOUR);
                              hourDefault = (org.python.types.Int) args[3];
                              if (args.length > 4) {
                                  validateInput((org.python.types.Int) args[4], MIN_MINUTE, MAX_MINUTE);
                                  minuteDefault = (org.python.types.Int) args[4];
                                  if (args.length > 5) {
                                      validateInput((org.python.types.Int) args[5], MIN_SECOND, MAX_SECOND);
                                      secondDefault = (org.python.types.Int) args[5];
                                      if (args.length > 6) {
                                          validateInput((org.python.types.Int) args[6], MIN_MICROSECOND, MAX_MICROSECOND);
                                          microsecondDefault = (org.python.types.Int) args[6];
                                          if (args.length > 7) {
                                              if ((org.python.types.NoneType) args[7] == null ) {
                                                  tzinfoDefault = (org.python.types.NoneType) args[7];
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




      // at least 3 arguments  -> check for kwargs

      // no year, month, day from args
      if(args.length<1){
        if(kwargs.get("year") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'year' (pos 1)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("year"), MIN_YEAR, MAX_YEAR);
          yearDefault = (org.python.types.Int) kwargs.get("year");
        }
        if(kwargs.get("month") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("month"), MIN_MONTH, MAX_MONTH);
          monthDefault = (org.python.types.Int) kwargs.get("month");
        }
        if(kwargs.get("year") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("day"), MIN_DAY, MAX_DAY);
          dayDefault = (org.python.types.Int) kwargs.get("day");
        }

      }



      // year from args, no month, day from args
      if(args.length<2){
        if(kwargs.get("month") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("month"), MIN_MONTH, MAX_MONTH);
          monthDefault = (org.python.types.Int) kwargs.get("month");
        }
        if(kwargs.get("day") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("day"), MIN_DAY, MAX_DAY);
          dayDefault = (org.python.types.Int) kwargs.get("day");
        }
      }


      // year, month from args, no day from args
      if(args.length<3){
        if(kwargs.get("day") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
        }else{
          validateInput((org.python.types.Int) kwargs.get("day"), MIN_DAY, MAX_DAY);
          dayDefault = (org.python.types.Int) kwargs.get("day");
        }
      }


      // check for remaining arguments knowing that args has been checked
      // and that all 3 required arguments are valid

      if((args.length + kwargs.size()) >= 4){
        if(kwargs.get("hour") != null){
          validateInput((org.python.types.Int) kwargs.get("hour"), MIN_HOUR, MAX_HOUR);
          hourDefault = (org.python.types.Int) kwargs.get("hour");
        }
        if(kwargs.get("minute") != null){
          validateInput((org.python.types.Int) kwargs.get("minute"), MIN_MINUTE, MAX_MINUTE);
          minuteDefault = (org.python.types.Int) kwargs.get("minute");
        }
        if(kwargs.get("second") != null){
          validateInput((org.python.types.Int) kwargs.get("second"), MIN_SECOND, MAX_SECOND);
          secondDefault = (org.python.types.Int) kwargs.get("second");
        }
        if(kwargs.get("microsecond") != null){
          validateInput((org.python.types.Int) kwargs.get("microsecond"), MIN_MICROSECOND, MAX_MICROSECOND);
          microsecondDefault = (org.python.types.Int) kwargs.get("microsecond");
        }
        // check for tzinfo

        // check for fold

      }

      validateDate(yearDefault,monthDefault,dayDefault);


      // "Variable might already have been assigned --> set last"

      this.year = yearDefault;
      this.month = monthDefault;
      this.day = dayDefault;
      this.hour = hourDefault;
      this.minute = minuteDefault;
      this.second = secondDefault;
      this.microsecond = microsecondDefault;
      this.tzinfo = null;
      this.fold = foldDefault;

    }

    @org.python.Method(
            __doc__ = "datetime constructor int ",
            default_args = {}
    )

    public datetime(int year, int month, int day, int hour, int minute, int second, int microsecond){
      // check if valid date
      try{
        LocalDate date = LocalDate.of(year,month,day);
      } catch(java.time.DateTimeException e){
        throw new org.python.exceptions.ValueError("day is out of range for month");
      }

      this.year = org.python.types.Int.getInt(year);
      this.month = org.python.types.Int.getInt(month);
      this.day = org.python.types.Int.getInt(day);
      this.hour = org.python.types.Int.getInt(hour);
      this.minute = org.python.types.Int.getInt(minute);
      this.second = org.python.types.Int.getInt(second);
      this.microsecond = org.python.types.Int.getInt(microsecond);
      this.tzinfo = null;
      this.fold = Int.getInt(0);

    }



    @org.python.Method(
            __doc__ = "Validate input "
    )

    private static void validateInput( org.python.types.Int attribute, org.python.types.Int minValue, org.python.types.Int maxValue){
        if(attribute instanceof org.python.types.Int){
          if( attribute.value < minValue.value || attribute.value > maxValue.value){
            throw new org.python.exceptions.ValueError("Value is out of range");
          }
        } else{
            throw new org.python.exceptions.NameError("Name is not defined");
        }

    }


    @org.python.Method(
            __doc__ = "Validate date "

    )

    private static void validateDate(org.python.types.Int year, org.python.types.Int month, org.python.types.Int day){
      try{
        LocalDate date = LocalDate.of((int) year.value,(int) month.value,(int)day.value);
      } catch(java.time.DateTimeException e){
        throw new org.python.exceptions.ValueError("day is out of range for month");
      }
    }



    /*
    // class attribute datetime.min

    @org.python.Attribute
    public final static org.python.Object min = new datetime(1,1,1,0,0,0,0);

    // class methods datetime.today()

    @org.python.Method(
        __doc__ = "Return the current local datetime, with tzinfo None "
    )
    // does not work

    public datetime today(){
      LocalDateTime localDate = LocalDateTime.now();

      int year = localDate.getYear();
      int month = localDate.getMonthValue();
      int day = localDate.getDayOfMonth();
      int hour = localDate.getHour();
      int minute = localDate.getMinute();
      int second = localDate.getSecond();
      int microsecond = localDate.getNano()/1000;

      return new datetime(year,month,day,hour,minute,second,microsecond);
    }


    // instance attribute datetime.year()




    // instance method datetime.time




    // instance method datetime.date

    */

}
