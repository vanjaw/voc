package org.python.stdlib.datetime;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.python.types.Int;
import org.python.types.Object;

public class datetime extends org.python.types.Object {
    // should these really be attributes too?
    private static Int MIN_YEAR = Int.getInt(1);
    private static Int MAX_YEAR = Int.getInt(9999);
    private static Int MIN_MONTH = Int.getInt(1);
    private static Int MAX_MONTH = Int.getInt(12);
    private static Int MIN_DAY = Int.getInt(1);
    private static Int MAX_DAY = Int.getInt(31);
    private static Int MIN_HOUR = Int.getInt(0);
    private static Int MAX_HOUR = Int.getInt(23);
    private static Int MIN_MINUTE = Int.getInt(0);
    private static Int MAX_MINUTE = Int.getInt(59);
    private static Int MIN_SECOND = Int.getInt(0);
    private static Int MAX_SECOND = Int.getInt(59);
    private static Int MIN_MICROSECOND = Int.getInt(0);
    private static Int MAX_MICROSECOND = Int.getInt(999999);
    private static Int MIN_FOLD = Int.getInt(0);
    private static Int MAX_FOLD = Int.getInt(1);
    @org.python.Attribute public org.python.types.Int year;
    @org.python.Attribute public org.python.types.Int month;
    @org.python.Attribute public org.python.types.Int day;
    @org.python.Attribute public org.python.types.Int hour;
    @org.python.Attribute public org.python.types.Int minute;
    @org.python.Attribute public org.python.types.Int second;
    @org.python.Attribute public org.python.types.Int microsecond;
    @org.python.Attribute public org.python.types.Object tzinfo;
    @org.python.Attribute public org.python.types.Int fold;

    @org.python.Attribute public static final org.python.stdlib.datetime.datetime min = new datetime(MIN_YEAR, MIN_MONTH, MIN_DAY);

    @org.python.Method(
            __doc__ = "Datetime constructor",
            default_args = {}
    )

    public datetime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
      int nrOfArguments = args.length + kwargs.size();
      if(nrOfArguments < 1){
        throw new org.python.exceptions.TypeError("function missing required argument 'year' (pos 1)");
      }
      if(nrOfArguments < 2){
        throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");
      }
      if(nrOfArguments < 3){
        throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
      }
      if(nrOfArguments > 9){
        throw new org.python.exceptions.TypeError("function takes at most 9 arguments (" + nrOfArguments + " given)");
      }
      if((args.length) > 8){

        throw new org.python.exceptions.TypeError("function takes at most 8 positional arguments (" + args.length  + " given)");
      }

      // assign default values
      Int yearDefault = null;
      Int monthDefault = null;
      Int dayDefault = null;

      Int hourDefault = Int.getInt(0);
      Int minuteDefault = Int.getInt(0);
      Int secondDefault = Int.getInt(0);
      Int microsecondDefault = Int.getInt(0);

      Object tzinfoDefault = null;
      Int foldDefault = Int.getInt(0);


      if (args.length > 0) {
                  validateInput("year", (org.python.types.Int) args[0], MIN_YEAR, MAX_YEAR);
                  yearDefault = (org.python.types.Int) args[0];
                  if (args.length > 1) {
                      validateInput("month", (org.python.types.Int) args[1], MIN_MONTH, MAX_MONTH);
                      monthDefault = (org.python.types.Int) args[1];
                      if (args.length > 2) {
                          validateInput("day", (org.python.types.Int) args[2], MIN_DAY, MAX_DAY);
                          dayDefault = (org.python.types.Int) args[2];
                          if (args.length > 3) {
                              validateInput("hour", (org.python.types.Int) args[3], MIN_HOUR, MAX_HOUR);
                              hourDefault = (org.python.types.Int) args[3];
                              if (args.length > 4) {
                                  validateInput("minute", (org.python.types.Int) args[4], MIN_MINUTE, MAX_MINUTE);
                                  minuteDefault = (org.python.types.Int) args[4];
                                  if (args.length > 5) {
                                      validateInput("second", (org.python.types.Int) args[5], MIN_SECOND, MAX_SECOND);
                                      secondDefault = (org.python.types.Int) args[5];
                                      if (args.length > 6) {
                                          validateInput("microsecond", (org.python.types.Int) args[6], MIN_MICROSECOND, MAX_MICROSECOND);
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



      // check for mandatory year, month, day
      if(args.length<1){
        if(kwargs.get("year") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'year' (pos 1)");
        }else{
          validateInput("year", (org.python.types.Int) kwargs.get("year"), MIN_YEAR, MAX_YEAR);
          yearDefault = (org.python.types.Int) kwargs.get("year");
        }
      }
      if(args.length<2){
        if(kwargs.get("month") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");
        }else{
          validateInput("month", (org.python.types.Int) kwargs.get("month"), MIN_MONTH, MAX_MONTH);
          monthDefault = (org.python.types.Int) kwargs.get("month");
        }
      }
      if(args.length<3){
        if(kwargs.get("day") == null){
          throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
        }else{
          validateInput("day", (org.python.types.Int) kwargs.get("day"), MIN_DAY, MAX_DAY);
          dayDefault = (org.python.types.Int) kwargs.get("day");
        }
      }

      // make sure that the date (combiantion of year, month and day) is valid
      validateDate(yearDefault,monthDefault,dayDefault);


      // check for remaining optional arguments knowing that args
      // has been checked and that all 3 required arguments are valid
      if((args.length + kwargs.size()) >= 4){
        if(kwargs.get("hour") != null){
          validateInput("hour",(org.python.types.Int) kwargs.get("hour"), MIN_HOUR, MAX_HOUR);
          hourDefault = (org.python.types.Int) kwargs.get("hour");
        }
        if(kwargs.get("minute") != null){
          validateInput("minute", (org.python.types.Int) kwargs.get("minute"), MIN_MINUTE, MAX_MINUTE);
          minuteDefault = (org.python.types.Int) kwargs.get("minute");
        }
        if(kwargs.get("second") != null){
          validateInput("second", (org.python.types.Int) kwargs.get("second"), MIN_SECOND, MAX_SECOND);
          secondDefault = (org.python.types.Int) kwargs.get("second");
        }
        if(kwargs.get("microsecond") != null){
          validateInput("microsecond", (org.python.types.Int) kwargs.get("microsecond"), MIN_MICROSECOND, MAX_MICROSECOND);
          microsecondDefault = (org.python.types.Int) kwargs.get("microsecond");
        }
        if(kwargs.get("fold") != null){
          validateInput("fold", (org.python.types.Int) kwargs.get("fold"), MIN_FOLD, MAX_FOLD);
          foldDefault = (org.python.types.Int) kwargs.get("fold");
        }
        // check tzinfo ?
      }

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
            __doc__ = "Datetime constructor 2",
            default_args = {}
    )

    public datetime(org.python.types.Int year, org.python.types.Int month, org.python.types.Int day) {
    validateDate(year, month, day);
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = Int.getInt(0);
    this.minute = Int.getInt(0);
    this.second = Int.getInt(0);
    this.microsecond = Int.getInt(0);
    this.tzinfo = null;
    this.fold = Int.getInt(0);
    }

    @org.python.Method(
            __doc__ = "Validate input "
    )

    private static void validateInput(String attributeName, org.python.types.Int attribute, org.python.types.Int minValue, org.python.types.Int maxValue){
        if(attribute instanceof org.python.types.Int){
          if(attribute.value < minValue.value || attribute.value > maxValue.value){
            valueOutOfRange(attributeName, attribute, minValue, maxValue);
          }
        } else{
            throw new org.python.exceptions.NameError("Name is not defined");
        }

    }

    private static void valueOutOfRange(String attributeName, org.python.types.Int attribute, org.python.types.Int minValue, org.python.types.Int maxValue){
        String result = new String();
        if(attributeName == "year"){
          result = "year " + attribute.toString() + " is out of range";
        } else if(attributeName == "day"){
          result = "day is out of range for month";
        } else if(attributeName == "fold"){
          result = "fold must be either 0 or 1";
        } else {
          result = attributeName + " must be in " + minValue.toString() + ".." + maxValue.toString();
        }
    throw new org.python.exceptions.ValueError(result);
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

    @org.python.Method(
            __doc__ = "This method builds the string to be printed out of date and time"
    )

    public org.python.types.Str __str__() {
        String result = new String();
        if (this.year.value < 1000){
            result = result + "0";
            if (this.year.value < 100){
                result = result + "0";
                if (this.year.value < 10){
                    result = result + "0";
                }
            }
        }
        result = result + this.year.toString() + "-";

        if (this.month.value < 10){
            result = result + "0";
        }
        result = result + this.month.toString() + "-";

        if (this.day.value < 10){
            result = result + "0";
        }
        result = result + this.day.toString() + " ";

        if (this.hour.value < 10){
            result = result + "0";
        }
        result = result + this.hour.value + ":";

        if (this.minute.value < 10){
            result = result + "0";
        }
        result = result + this.minute.value + ":";

        if (this.second.value < 10){
            result = result + "0";
        }
        result = result + this.second.value;

        if (this.microsecond.value != 0){
            result = result + ".";
            if (this.microsecond.value < 100000){
                result = result + "0";
                if (this.microsecond.value < 10000){
                    result = result + "0";
                    if (this.microsecond.value < 1000){
                        result = result + "0";
                        if (this.microsecond.value < 100){
                            result = result + "0";
                            if (this.microsecond.value < 10){
                                result = result + "0";
                            }
                        }
                    }
                }
            }
            result = result + this.microsecond.value;
        }
        return new org.python.types.Str(result);
    }

    // it's about 0,12 sec off  - use timedeltas implementation?
    @org.python.Method(
            __doc__ = "Class method - today"
    )
    public static String today(){
    LocalDateTime today = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    return formatter.format(today);
    }

    // works as long as microsec != 0
    // find another class method
    @org.python.Method(
            __doc__ = "Instance method - time"
    )
    public LocalTime time(){
    LocalTime time = LocalTime.of((int)this.hour.value, (int)this.minute.value, (int)this.second.value, (int)this.microsecond.value);
    return time;

    /*
    LocalTime time = LocalTime.of((int)this.hour.value, (int)this.minute.value, (int)this.second.value, (int)this.microsecond.value);
    String timeStr = time.toString();
    if (this.microsecond.value == 0){
      timeStr = timeStr + ":00"
    }
    return timeStr;
    */
    }

    @org.python.Method(
            __doc__ = "Instance method - date"
    )
    public LocalDate date(){
    LocalDate date = LocalDate.of((int)this.year.value, (int)this.month.value, (int)this.day.value);
    return date;
    }

}
