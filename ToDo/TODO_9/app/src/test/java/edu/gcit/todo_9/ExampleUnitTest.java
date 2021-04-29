package edu.gcit.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalc;

    @Before
    public void setUp(){
        mCalc = new Calculator();
    }

    @Test
    public void addTwoNo(){
        double result = mCalc.add(2d,2d);
        assertThat(result, is(equalTo(4d)));
    }

    @Test
    public void addTwoNegNos(){
        double result = mCalc.add(-1d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void addFloatDouble(){
        double result = mCalc.add(1.111f, 1.111d);
        assertThat(result, is(closeTo(2.222d, 0.01)));
    }

    //subtraction
    @Test
    public void subtractTwoNos(){
        double result = mCalc.subtract(2d,1d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void subNegativeResult(){
        double result = mCalc.subtract(3d, 5d);
        assertThat(result, is(equalTo(-2d)));
    }

    //Multiplication
    @Test
    public void mulTwoNos(){
        double result = mCalc.multiply(2d, 4d);
        assertThat(result, is(equalTo(8d)));
    }

    @Test
    public void mulResultZero(){
        double result = mCalc.multiply(0d, 1d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public void divTwoNos(){
       double result = mCalc.division(4d, 2d);
       assertThat(result, is(equalTo(2d)));
    }

    @Test
    public void divZero(){
        double result = mCalc.division(4d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}