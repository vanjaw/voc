import os
import sys
from unittest import expectedFailure

from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_datetime(NotImplementedToExpectedFailure, TranspileTestCase):
    def test_test(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.timedelta(1, 2, 3))
            """)

    #@expectedFailure
    def test_constructor(self):
        self.assertCodeExecution("""
        import datetime
        print(datetime.timedelta(1,2,3))
        print(datetime.timedelta(weeks=-3,days=2))
        print(datetime.timedelta(weeks=-100,microseconds=2))
        print(datetime.timedelta(-1,100,321,-100000,20,13,2))
        print(datetime.timedelta(days=-2,weeks=1))
        """)


    def test_constructor_invalid(self):
        self.assertCodeExecution("""
        import datetime
        try:
            print(datetime.timedelta("string"))
            print(datetime.timedelta(1, day=1))
            print(datetime.timedelta(a=1))
        except Exception as e:
            print(e)      
        """)

    def test_attributes_class (self):
        self.assertCodeExecution("""
        import datetime
        print(datetime.timedelta.min)
        print(datetime.timedelta.max)
        print(datetime.timedelta.resolution)
        """)

    def test_attributes_instance (self):
        self.assertCodeExecution("""
        import datetime
        print(datetime.timedelta(7).days)
        print(datetime.timedelta(0,7).seconds)
        print(datetime.timedelta(0,0,7).microseconds)
        """)


        

    
