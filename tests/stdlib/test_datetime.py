import os
import sys

from unittest import expectedFailure
from .. utils import TranspileTestCase, NotImplementedToExpectedFailure


class DatetimeTests(TranspileTestCase, NotImplementedToExpectedFailure):

    def test_min_max(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date(6,6,6)
            print(test.min)
            print(test.max)

        """)

    def test_date(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date(1994,12,8)
            print(test.year)
            print(test.month)
            print(test.day)
            print(test)

            test2 = date(1889,4,20)
            print(test2.year)
            print(test2.month)
            print(test2.day)
            print(test2)
        """)

    def test_date_no_input(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date()
            except TypeError as e:
                print(e)
        """)

    def test_date_1_input(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date(1994)
            except TypeError as e:
                print(e)
        """)

    def test_date_2_input(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date(1994,12)
            except TypeError as e:
                print(e)
        """)


    def test_date_too_many_input(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date(1994,12,12,12)
            except TypeError as e:
                print(e)

            try:
                test = date(1994,12,12,12,3,3,3,3,3)
            except TypeError as e:
                print(e)
        """)

    def test_date_wrong_type(self):
        self.assertCodeExecution("""
            from datetime import date

            try:
                test = date(1994,12,"Hej")
            except TypeError as e:
                print(e)
        """)

    def test_date_year_value(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date(0,1,2)
            except ValueError as e:
                print(e)

            try:
                test = date(150000,1,2)
            except ValueError as e:
                print(e)
        """)

    def test_date_month_value(self):
        self.assertCodeExecution("""
            from datetime import date
            try:
                test = date(1994,0,2)
            except ValueError as e:
                print(e)

            try:
                test = date(3000,13,2)
            except ValueError as e:
                print(e)
        """)

    def test_date_date_value(self):
        self.assertCodeExecution("""
            from datetime import date

            test = date(2020,2,29)
            print(test)
            test = date(2000,2,29)
            print(test)
 
            try:
                test = date(1994,5,0)
            except ValueError as e:
                print(e)

            try:
                test = date(2000,1,32)
            except ValueError as e:
                print(e)

            try:
                test = date(2000,4,31)
            except ValueError as e:
                print(e)

            try:
                test = date(2000,6,31)
            except ValueError as e:
                print(e)
            
            try:
                test = date(2000,9,31)
            except ValueError as e:
                print(e)
            
            try:
                test = date(2000,11,31)
            except ValueError as e:
                print(e)

            # Leap year shenanigans
            try:
                test = date(2020,2,30)
            except ValueError as e:
                print(e)

            try:
                test = date(2001,2,29)
            except ValueError as e:
                print(e)

            try:
                test = date(2100,2,29)
            except ValueError as e:
                print(e)
       """)

    def test_date_today(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date.today()
            print(test)

            print(test.year)
            print(test.month)
            print(test.day)
        """)


    def test_date_weekday(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date(2019,9,23)
            print(test)
            print(test.weekday())

        """)