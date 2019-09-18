import os
import sys
from unittest import expectedFailure

from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_datetime(NotImplementedToExpectedFailure, TranspileTestCase):
    def test_test(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.timedelta(1))
            """)

    # #@expectedFailure
    # def test_constructor(self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     print(datetime.timedelta(1,2,3))
    #     print(datetime.timedelta(week=-3,day=2))
    #     print(datetime.timedelta(years=-100,microseconds=2))
    #     print(datetime.timedelta(-1,100,321,-100000,20,13,2))
    #     print(datetime.timedelta(days=-2,years=1))
    #      """)


    # def test_constructor_invalid(self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     try:
    #         print(datetime.timedelta("string")
    #     except Exception as e:
    #         print(e)      
    #     """)

    # def test_operation_addition(self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     print(datetime.timedelta(2) + datetime.timedelta(2))
    #     print(datetime.timedelta(-2) + datetime.timedelta(2))
    #     print(datetime.timedelta(weeks=2,days=-2) + datetime.timedelta(years=-1,days=400))
    #     """)
    #     
    # def test_operation_subtraction(self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     print(datetime.timedelta(2) - datetime.timedelta(2))
    #     print(datetime.timedelta(-2) - datetime.timedelta(2))
    #     print(datetime.timedelta(weeks=2,days=-2) - datetime.timedelta(years=-1,days=400))
    #     """)

    # def test_attributes_class (self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     print(datetime.timedelta.min)
    #     print(datetime.timedelta.max)
    #     print(datetime.timedelta.resolution)
    #     """)

    # def test_attributes_instance (self):
    #     self.assertCodeExecution("""
    #     import datetime
    #     print(datetime.timedelta(7).days
    #     print(datetime.timedelta(0,7).seconds
    #     print(datetime.timedelta(0,0,7).microseconds
    #     """)


        

    
