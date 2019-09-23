import os
import sys

from unittest import expectedFailure
from .. utils import TranspileTestCase, NotImplementedToExpectedFailure


class DatetimeTests(TranspileTestCase, NotImplementedToExpectedFailure):
    def test_date(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date(1994,12,8)
            print(test)
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

    def test_date_today(self):
        self.assertCodeExecution("""
            from datetime import date
            test = date.today()
            print(test)
        """)