import os
import sys
from unittest import expectedFailure
from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_datetime(NotImplementedToExpectedFailure, TranspileTestCase):

    def test_datetime_args_1(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 28)
        """)

    def test_datetime_args_2(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(2001, 9, 11)
        """)

    def test_datetime_args_3(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1996,2,25)
        """)

    def test_datetime_args_4(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1969, 2, 28, 4)
        """)

    def test_datetime_args_5(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(2001, 9, 11, 5, 3)
        """)

    def test_datetime_args_6(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1996,2,25,6,7,8)
        """)

    def test_datetime_args_7(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(1996,2,25,6,7,8,2)
        """)


    def test_datetime_kwargs_1(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1)
        """)

    def test_datetime_kwargs_2(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=2001, month=9, day=11)
        """)

    def test_datetime_kwargs_3(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1969, month=2, day=13)
        """)

    def test_datetime_kwargs_4(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1, hour=3)
        """)

    def test_datetime_kwargs_5(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=2001, month=9, day=11, hour =3, minute =3)
        """)

    def test_datetime_kwargs_6(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1969, month=2, day=13, hour = 2, minute = 3, second = 3)
        """)

    def test_datetime_kwargs_7(self):
        self.assertCodeExecution("""
            import datetime
            date = datetime.datetime(year=1996, month=10, day=1, hour = 3, minute = 4, second = 5, microsecond = 8)
        """)
