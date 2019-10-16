package org.python.types;

import org.Python;
import org.python.Object;
import org.python.types.Int;
import org.python.types.List;
import org.python.types.Slice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

public class ListWorkloadSlice {
    public static void workload() {
        List testList = new List(
            new Object[] {
                Python.range(
                    Int.getInt(8000),
                    null,
                    null
                )
            },
            new HashMap()
        );

        for (int i = 0; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    Int.getInt(i),
                    null,
                    null
                )
            );
        }

        for (int i = 0; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    Int.getInt(-i),
                    null,
                    null
                )
            );
        }

        for (int i = 0; i < 4000; i++) {
            testList.__getitem__(
                Python.slice(
                    Int.getInt(i),
                    Int.getInt(-i),
                    null
                )
            );
        }

        for (int i = 0; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    Int.getInt(i),
                    null,
                    Int.getInt(-1)
                )
            );
        }

        for (int i = 0; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    null,
                    Int.getInt(-i),
                    Int.getInt(-1)
                )
            );
        }

        for (int i = 1; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    null,
                    null,
                    Int.getInt(i)
                )
            );
        }

        for (int i = 1; i < 8000; i++) {
            testList.__getitem__(
                Python.slice(
                    null,
                    null,
                    Int.getInt(-i)
                )
            );
        }
    }
}