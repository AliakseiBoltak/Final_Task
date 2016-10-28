package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

import java.util.List;

import by.epam.tc.test.entity.Test;

public class ShowAllTestsResponse extends Response{
	
	private List <Test> tests = null;

    public List <Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

}
