import os
import sys
import math

from unittest import expectedFailure
from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_math(NotImplementedToExpectedFailure, TranspileTestCase):

    #@expectedFailure
    def test_sqrt_number(self):
        self.assertCodeExecution("""
            import math
            print(math.sqrt(16))
            print(math.sqrt(3))
            """)

    #@expectedFailure
    def test_sqrt_letter(self):
        self.assertCodeExecution("""
            import math
            try:
                print(math.sqrt(a))
            except Exception as e:
                print(e)
            """)

    #@expectedFailure
    def test_sqrt_negative(self):
        self.assertCodeExecution("""
            import math
            try:
                print(math.sqrt(-2))
            except Exception as e:
                print(e)
            """)

    #@expectedFailure
    def test_exp_number(self):
        self.assertCodeExecution("""
            import math
            print(math.exp(2))
            print(math.exp(-2))
            """)

    #@expectedFailure
    def test_exp_letter(self):
        self.assertCodeExecution("""
            import math
            try:
                print(math.exp(a))
            except Exception as e:
                print(e)
            """)
