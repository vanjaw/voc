# import os
# import sys
# 
# from unittest import expectedFailure
# from .. utils import TranspileTestCase, NotImplementedToExpectedFailure
# 
# 
# class DatetimeTests(TranspileTestCase, NotImplementedToExpectedFailure):
#     def test_date(self):
#         self.assertCodeExecution("""
#             from datetime import date
#             test = date(1994,12,8)
#             print(test)
#         """)

#    @expectedFailure
#    def test_incorrect_abs_call(self):
#        self.assertCodeExecution("""
#            x = 1
#            print(x.abs())
#            """)
