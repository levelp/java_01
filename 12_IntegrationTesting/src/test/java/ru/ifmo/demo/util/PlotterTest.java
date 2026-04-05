package ru.ifmo.demo.util;

import org.junit.After;
import org.junit.Test;
import ru.ifmo.demo.modules.Expression;
import ru.ifmo.demo.modules.MyExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for Plotter
 */
public class PlotterTest {

    private List<String> filesToCleanup = new ArrayList<>();

    @After
    public void cleanup() {
        for (String filename : filesToCleanup) {
            File file = new File(filename);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void testPlotWithIntervalsList() throws Exception {
        String filename = "test_plot_intervals.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0.0, 1.0, 0.1));

        Plotter.plot(filename, expr, intervals);

        File file = new File(filename);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    public void testPlotWithSingleInterval() throws Exception {
        String filename = "test_plot_single.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 5.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    public void testPlotCreatesValidCSV() throws Exception {
        String filename = "test_plot_valid.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertTrue(lines.size() > 0);

        // Check if lines contain semicolon-separated values
        for (String line : lines) {
            assertTrue(line.contains(";"));
        }
    }

    @Test
    public void testPlotWithMultipleIntervals() throws Exception {
        String filename = "test_plot_multiple.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0.0, 1.0, 0.2));
        intervals.add(new Interval(2.0, 3.0, 0.2));

        Plotter.plot(filename, expr, intervals);

        File file = new File(filename);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    public void testPlotWithNegativeInterval() throws Exception {
        String filename = "test_plot_negative.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, -2.0, 0.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotWithSmallIncrement() throws Exception {
        String filename = "test_plot_small_inc.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 0.5, 0.1);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotWithLargeIncrement() throws Exception {
        String filename = "test_plot_large_inc.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 10.0, 5.0);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotHandlesExceptionsInExpression() throws Exception {
        String filename = "test_plot_exception.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                if (x > 1.0) {
                    throw new RuntimeException("Test exception");
                }
                return x;
            }
        };

        Plotter.plot(filename, expr, 0.0, 5.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotFiltersNaN() throws Exception {
        String filename = "test_plot_nan.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return Double.NaN;
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        // File should be empty or very small since all NaN values are filtered
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(0, lines.size());
    }

    @Test
    public void testPlotFiltersLargeValues() throws Exception {
        String filename = "test_plot_large.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return 100.0; // Values >= 10 should be filtered
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(0, lines.size());
    }

    @Test
    public void testPlotWithEmptyIntervalsList() throws Exception {
        String filename = "test_plot_empty.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        List<Interval> intervals = new ArrayList<>();

        Plotter.plot(filename, expr, intervals);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotWithZeroInterval() throws Exception {
        String filename = "test_plot_zero.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 1.0, 1.0, 0.1);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test(expected = FileNotFoundException.class)
    public void testPlotWithInvalidPath() throws Exception {
        Expression expr = new MyExpression();
        // Try to write to an invalid directory
        Plotter.plot("/invalid/path/test.csv", expr, 0.0, 1.0, 0.1);
    }

    @Test
    public void testPlotOverwritesExistingFile() throws Exception {
        String filename = "test_plot_overwrite.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();

        // Create file first time
        Plotter.plot(filename, expr, 0.0, 1.0, 0.5);
        long firstSize = new File(filename).length();

        // Overwrite with different data
        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);
        long secondSize = new File(filename).length();

        // Second file should exist and likely have different size
        assertTrue(new File(filename).exists());
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testPlotWithValuesExactlyTen() throws Exception {
        String filename = "test_plot_exactly_ten.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return 10.0; // Values >= 10 should be filtered
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(0, lines.size()); // All filtered
    }

    @Test
    public void testPlotWithValuesJustUnderTen() throws Exception {
        String filename = "test_plot_under_ten.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return 9.99; // Values < 10 should be kept
            }
        };

        Plotter.plot(filename, expr, 0.0, 1.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertTrue(lines.size() > 0); // Some lines written
    }

    @Test
    public void testPlotWithNegativeValues() throws Exception {
        String filename = "test_plot_negative_y.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return -5.0; // Negative y values should be kept
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertTrue(lines.size() > 0);
    }

    @Test
    public void testPlotWithNaNXValue() throws Exception {
        String filename = "test_plot_nan_x.csv";
        filesToCleanup.add(filename);

        // This tests the Double.isNaN(x) check in the plot method
        Expression expr = new MyExpression();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(Double.NaN, 1.0, 0.1));

        Plotter.plot(filename, expr, intervals);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotWithInfiniteY() throws Exception {
        String filename = "test_plot_infinite_y.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return Double.POSITIVE_INFINITY;
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        // Infinite values >= 10 should be filtered
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(0, lines.size());
    }

    @Test
    public void testPlotWithNegativeInfiniteY() throws Exception {
        String filename = "test_plot_neg_inf_y.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return Double.NEGATIVE_INFINITY;
            }
        };

        Plotter.plot(filename, expr, 0.0, 2.0, 0.5);

        File file = new File(filename);
        assertTrue(file.exists());
        // Negative infinity < 10, should be written
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertTrue(lines.size() > 0);
    }

    @Test
    public void testPlotWithRealExpression() throws Exception {
        String filename = "test_plot_real.csv";
        filesToCleanup.add(filename);

        MyExpression expr = new MyExpression();
        expr.sin = new ru.ifmo.demo.functions.Sin();
        expr.cos = new ru.ifmo.demo.functions.Cos();
        expr.csc = new ru.ifmo.demo.functions.Cosecant();
        expr.tan = new ru.ifmo.demo.functions.Tg();
        expr.cot = new ru.ifmo.demo.functions.Cot();

        Plotter.plot(filename, expr, 0.1, 1.0, 0.1);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testPlotWithX0GreaterThanX1() throws Exception {
        String filename = "test_plot_reverse.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 2.0, 1.0, 0.1); // x0 > x1

        File file = new File(filename);
        assertTrue(file.exists());
        // No points should be written since x starts at 2.0 which is > x1=1.0
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(0, lines.size());
    }

    @Test
    public void testPlotWithVeryLargeIncrement() throws Exception {
        String filename = "test_plot_very_large_inc.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 1.0, 100.0);

        File file = new File(filename);
        assertTrue(file.exists());
        // Only one point at x=0 should be written
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(1, lines.size());
    }

    @Test
    public void testPlotCSVFormat() throws Exception {
        String filename = "test_plot_csv_format.csv";
        filesToCleanup.add(filename);

        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return 1.0; // Simple constant
            }
        };

        Plotter.plot(filename, expr, 0.0, 0.5, 0.5);

        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertTrue(lines.size() > 0);
        for (String line : lines) {
            // Verify CSV format with semicolon separator
            String[] parts = line.split(";");
            assertEquals(2, parts.length);
        }
    }

    @Test
    public void testPlotWithSinglePoint() throws Exception {
        String filename = "test_plot_single_point.csv";
        filesToCleanup.add(filename);

        Expression expr = new MyExpression();
        Plotter.plot(filename, expr, 0.0, 0.0, 0.1);

        File file = new File(filename);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals(1, lines.size());
    }
}
