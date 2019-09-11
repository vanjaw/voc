import os
import sys
import math

from unittest import expectedFailure
from ..utils import TranspileTestCase, NotImplementedToExpectedFailure


class test_math(NotImplementedToExpectedFailure, TranspileTestCase):
    
    #@expectedFailure
    def test_number(self):
        #import math
        self.assertCodeExecution("""
            import math
            print(math.sqrt(16))
            print(math.sqrt(3))
            """)
    
    #@expectedFailure
    def test_letter(self):
        self.assertCodeExecution("""
            import math
            try:
                print(math.sqrt(a))
            except Exception as e:
                print(e)
            """)
    
    #@expectedFailure
    def test_negative(self):
        self.assertCodeExecution("""
            import math
            try:
                print(math.sqrt(-2))
            except Exception as e:
                print(e)
            """)
