import os
import sys
from unittest import expectedFailure
from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_datetime(NotImplementedToExpectedFailure, TranspileTestCase):
    # Testing for different number of args #
    def test_datetime_args_1(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 2)
            print(date)
        """)

    def test_datetime_args_2(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 28, 4)
            print(date)
        """)

    def test_datetime_args_3(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(2001, 9, 11, 5, 3)
            print(date)
        """)

    def test_datetime_args_4(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1996, 2, 25, 6, 7, 8)
            print(date)
        """)

    def test_datetime_args_5(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1996, 2, 25, 6, 7, 8, 2)
            print(date)
        """)

    # Testing for different number of kwargs #
    def test_datetime_kwargs_1(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1)
            print(date)
        """)

    def test_datetime_kwargs_2(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1, hour=3)
            print(date)
        """)

    def test_datetime_kwargs_3(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=2001, month=9, day=11, hour =3, minute =3)
            print(date)
        """)

    def test_datetime_kwargs_4(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1969, month=2, day=13, hour = 2, minute = 3, second = 3)
            print(date)
        """)

    def test_datetime_kwargs_5(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1, hour = 3, minute = 4, second = 5, microsecond = 18)
            print(date)
        """)

    # Testing for missing mandatory arguments #
    def test_datetime_no_year(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime())
            except Exception as e:
                print(e)
            """)

    def test_datetime_no_month(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(2000))
            except Exception as e:
                print(e)
            """)

    def test_datetime_no_day(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(2000, 1))
            except Exception as e:
                print(e)
            """)

    # Testing for arguments out of range #
    def test_datetime_year_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(0,2,25,6,7,8,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_month_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,0,25,6,7,8,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_day_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,0,6,7,8,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_hour_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,-1,7,8,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_minute_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,-1,8,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_second_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,7,-1,2))
            except Exception as e:
                print(e)
            """)

    def test_datetime_microsecond_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,7,8,-1))
            except Exception as e:
                print(e)
            """)

    def test_datetime_fold_out_of_range(self):
	    self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,7,8,2,fold=2))
            except Exception as e:
                print(e)
            """)

    # Testing for other errormessages #
    def test_datetime_fold_without_keyword(self):
        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,7,8,2,None,1))
            except Exception as e:
                print(e)
            """)

    def test_datetime_too_many_arguments(self):
        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.datetime(1996,2,25,6,7,8,2,1,1,1,1))
            except Exception as e:
                print(e)
            """)

    # Testing for class methods #
    @expectedFailure
    def test_datetime_today(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.today())
            """)

    # Testing for class attributes #
    @expectedFailure
    def test_datetime_min(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.min)
            """)

    # Testing for instance attributes #
    def test_datetime_year(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 2)
            print(date.year)
            """)

    # Testing for instance methods #
    @expectedFailure
    def test_datetime_time(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 2)
            print(date.time())
            """)

    @expectedFailure
    def test_datetime_date(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 2)
            print(date.date())
            """)
